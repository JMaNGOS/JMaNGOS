package org.jmangos.auth.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.criteria4jpa.criterion.Criterion;
import org.criteria4jpa.criterion.Restrictions;
import org.jmangos.auth.model.AccountDto;
import org.jmangos.auth.services.impl.AccountServiceImpl;
import org.jmangos.auth.utils.AccountUtils;
import org.jmangos.commons.model.Account;
import org.jmangos.commons.model.WoWAuthResponse;
import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.utils.BigNumber;
import org.springframework.stereotype.Component;

@Component
public class AccountController {
    
    @Inject
    AccountServiceImpl accountService;
    
    /**
     * Login.
     * 
     * @param name
     *            the name
     * @param channelHandler
     *            the channel handler
     * @return the wow auth response
     */
    public WoWAuthResponse loadLogin(final String name, final NettyNetworkChannel channelHandler) {
    
        // if
        // (BannedIpController.isBanned(channelHandler.getAddress().getAddress().getHostAddress()))
        // {
        // return WoWAuthResponse.WOW_FAIL_BANNED;
        // }
        
        Account account = new Account();
        
        final Criterion criterion = Restrictions.eq("username", name);
        final List<AccountDto> accountList = accountService.readAccounts(criterion);
        if (accountList != null && !accountList.isEmpty()) {
            AccountDto accountDto = accountList.get(0);
            
            HashMap<String, BigNumber> variable; // calculateVSFields will create it.
            BigNumber s = new BigNumber();
            BigNumber v = new BigNumber();
            
            channelHandler.setChanneledObject(account);
            if ((accountDto.getV().length() != (32 * 2)) || (accountDto.getS().length() != (32 * 2))) {
                variable = AccountUtils.calculateVSFields(accountDto.getShaPasswordHash());
                s = variable.get("s");
                v = variable.get("v");
                accountDto.setS(s.asHexStr());
                accountDto.setV(v.asHexStr());
            } else {
                s.setHexStr(accountDto.getS());
                v.setHexStr(accountDto.getV());
            }
            
            final BigNumber B = AccountUtils.getB(v, channelHandler);
            account.setName(name);
            account.setB_crypto(B);
            account.sets(s);
            account.setV_crypto(v);
            
            accountDto.setLastIp(channelHandler.getAddress().getAddress().getHostAddress());
            
            this.accountService.createOrUpdateAccount(accountDto);
            
            return WoWAuthResponse.WOW_SUCCESS;
        } else {
            return WoWAuthResponse.WOW_FAIL_UNKNOWN_ACCOUNT;
        }
        
    }
    
}
