/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package org.jmangos.commons.module;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The Class HandlerDM.
 */
@Configuration
public class CommonModule {

	@Bean
	public MBeanServer provideMBeanServer() {
		return ManagementFactory.getPlatformMBeanServer();
	}

	// @Bean
	// public LoggingService loggingService() {
	// return new LoggingService();
	// }
	//
	// @Bean
	// public MethodInvokingFactoryBean log4jInitialization() {
	// MethodInvokingFactoryBean methodInvokingFactoryBean = new
	// MethodInvokingFactoryBean();
	// methodInvokingFactoryBean.setTargetClass(Log4jConfigurer.class);
	// methodInvokingFactoryBean.setTargetMethod("initLogging");
	// Object[] arguments = new String[] { "conf/log4j.xml" };
	// methodInvokingFactoryBean.setArguments(arguments);
	// return methodInvokingFactoryBean;
	// }
	//
	// @Bean
	// public PropertyPlaceholderConfigurer propertyConfigurer() {
	// PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new
	// PropertyPlaceholderConfigurer();
	// Resource location = new FileSystemResource(
	// "conf/database/database.properties");
	// propertyPlaceholderConfigurer.setLocation(location);
	// return propertyPlaceholderConfigurer;
	// }
	//
	// @Bean(destroyMethod = "close")
	// public BasicDataSource dataSource() {
	//
	// BasicDataSource basicDataSource = new BasicDataSource();
	// basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	// basicDataSource
	// .setUrl("jdbc:mysql://${database.hostname}/${database.dbname}");
	// basicDataSource.setUsername("${database.username}");
	// basicDataSource.setPassword("${database.password}");
	// return basicDataSource;
	// }

}
