package com.pstreets.guice.demo.service;

public class HelloWorld implements IGreetingService{

	@Override
	public String getGreetings() {
		return "Hello,World";
	}

}
