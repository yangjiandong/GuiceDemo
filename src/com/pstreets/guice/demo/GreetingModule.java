package com.pstreets.guice.demo;

import roboguice.config.AbstractAndroidModule;

import com.pstreets.guice.demo.service.HelloChina;
import com.pstreets.guice.demo.service.HelloWorld;
import com.pstreets.guice.demo.service.IGreetingService;

public class GreetingModule extends AbstractAndroidModule{

	@Override
	protected void configure() {
		//bind(IGreetingService.class).to(HelloWorld.class);
		bind(IGreetingService.class).to(HelloChina.class);
		
	}

}
