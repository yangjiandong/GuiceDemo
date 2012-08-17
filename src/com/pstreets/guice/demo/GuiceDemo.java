package com.pstreets.guice.demo;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.widget.TextView;

import com.google.inject.Inject;
import com.pstreets.guice.demo.service.IGreetingService;

public class GuiceDemo extends RoboActivity  {
    
	@InjectView (R.id.hello) TextView helloLabel;
    @Inject IGreetingService greetingServce;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        helloLabel.setText(greetingServce.getGreetings());
    }
    
    
}