package org.jmangos.commons.controller;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jmangos.commons.model.base.Weather;

public interface WeatherController {
    ChannelBuffer buildWeatherData(final Weather weather);
}
