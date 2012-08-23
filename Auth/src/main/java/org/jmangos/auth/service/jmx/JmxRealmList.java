package org.jmangos.auth.service.jmx;

import java.util.Map.Entry;

import javax.inject.Inject;

import org.jmangos.auth.entities.RealmEntity;
import org.jmangos.auth.service.RealmListController;
import org.jmangos.commons.jmx.AbstractJmxBeanService;
import org.springframework.stereotype.Component;

@Component
public class JmxRealmList extends AbstractJmxBeanService implements JmxRealmListMBean {
    
    @Inject
    private RealmListController realmListService;
    
    private static final String BEAN_NAME = "auth.network.realms:name=JMXRealmList";
    
    /**
     * @see org.jmangos.commons.jmx.AbstractJmxBeanService#getBeanName()
     */
    @Override
    protected String getBeanName() {
    
        return BEAN_NAME;
    }
    
    /**
     * @see org.jmangos.auth.service.jmx.JmxRealmListMBean#getRealmCount()
     */
    @Override
    public String getRealmCount() {
    
        return String.valueOf(this.realmListService.getRealmCount());
    }
    
    /**
     * @see org.jmangos.auth.service.jmx.JmxRealmListMBean#printRealmInfo()
     */
    @Override
    public String printRealmInfo() {
    
        final StringBuffer sb = new StringBuffer();
        for (final Entry<Long, RealmEntity> it : this.realmListService.getRealms().entrySet()) {
            sb.append("Realm info for: " + it.getKey() + " realm");
            sb.append("\n\tName: " + it.getValue().getName());
            sb.append("\n\tPopulation: " + it.getValue().getPopulation());
            sb.append("\n");
        }
        return sb.toString();
    }
    
}
