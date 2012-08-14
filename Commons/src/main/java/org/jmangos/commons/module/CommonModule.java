package org.jmangos.commons.module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class CommonModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(String.class).annotatedWith(Names.named("packetXSD")).toInstance(
				"./conf/packetData/packets.xsd");
	}

}
