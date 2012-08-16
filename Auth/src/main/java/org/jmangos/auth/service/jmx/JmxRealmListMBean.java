package org.jmangos.auth.service.jmx;

public interface JmxRealmListMBean {
    
    /**
     * 
     * @return exists realms.
     */
    public String getRealmCount();
    
    /** Print realm info. */
    public String printRealmInfo();
}
