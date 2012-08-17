package com.pstreets.guice.demo;

import com.google.inject.AbstractModule;
import com.pstreets.guice.demo.service.HelloChina;
import com.pstreets.guice.demo.service.IGreetingService;

public class GreetingModule extends AbstractModule{

	@Override
	protected void configure() {
		//bind(IGreetingService.class).to(HelloWorld.class);
		bind(IGreetingService.class).to(HelloChina.class);

	}

}
