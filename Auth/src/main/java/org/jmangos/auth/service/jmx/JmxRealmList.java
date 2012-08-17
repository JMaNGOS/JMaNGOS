package org.jmangos.auth.service.jmx;

import java.util.Map.Entry;

import javax.inject.Inject;

import org.jmangos.auth.service.RealmListService;
import org.jmangos.commons.jmx.AbstractJmxBeanService;
import org.jmangos.commons.model.Realm;
import org.springframework.stereotype.Component;

@Component
public class JmxRealmList extends AbstractJmxBeanService implements JmxRealmListMBean {
    
    @Inject
    private RealmListService    realmListService;
    
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
        for (final Entry<Integer, Realm> it : this.realmListService.getRealms().entrySet()) {
            sb.append("Realm info for: " + it.getKey() + " realm");
            sb.append("\n\tName: " + it.getValue().getName());
            sb.append("\n\tPopulation: " + it.getValue().getPopulation());
            sb.append("\n");
        }
        return sb.toString();
    }
    
}
