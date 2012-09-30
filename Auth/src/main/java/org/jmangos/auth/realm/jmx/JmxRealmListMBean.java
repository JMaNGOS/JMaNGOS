package org.jmangos.auth.realm.jmx;

public interface JmxRealmListMBean {

    /**
     * 
     * @return exists realms.
     */
    public String getRealmCount();

    /** Print realm info. */
    public String printRealmInfo();
}
