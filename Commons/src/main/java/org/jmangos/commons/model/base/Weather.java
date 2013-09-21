package org.jmangos.commons.model.base;

import org.jmangos.commons.enums.WeatherState;

public class Weather {

    private long lastUpdateTime = System.currentTimeMillis();
    private float grade = 0f;
    private WeatherState state = WeatherState.FINE;

    /**
     * @return the lastUpdateTime
     */
    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    /**
     * @param lastUpdateTime
     *        the lastUpdateTime to set
     */
    public final void setLastUpdateTime(final long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * @return the grade
     */
    public final float getGrade() {
        return this.grade;
    }

    /**
     * @param grade
     *        the grade to set
     */
    public final void setGrade(final float grade) {
        this.grade = grade;
    }

    /**
     * @return the state
     */
    public final WeatherState getState() {
        return this.state;
    }

    /**
     * @param state
     *        the state to set
     */
    public final void setState(final WeatherState state) {
        this.state = state;
    }

}
