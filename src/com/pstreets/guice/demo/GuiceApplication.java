package com.pstreets.guice.demo;

import java.util.List;

//import roboguice.application.RoboApplication;

import com.google.inject.Module;



public class GuiceApplication// extends RoboApplication
{

	protected void addApplicationModules(List<Module> modules) {
        modules.add(new GreetingModule());
    }

}
