package com.pstreets.guice.demo.service;

public class HelloChina implements IGreetingService{

	@Override
	public String getGreetings() {
		return "Hello,China";
	}

}
