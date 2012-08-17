package com.pstreets.guice.demo;


import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.google.inject.Inject;

public class InjectContextDemo extends RoboActivity {

    @InjectView (R.id.textview) TextView textView;
    @Inject ContextInfo contextInfo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	 super.onCreate(savedInstanceState);

    	 setContentView(R.layout.injectcontext);
    	 textView.setText(contextInfo.getPackageName());

     }


}

class ContextInfo{

	final Context context;
	@Inject
	//ContextInfo(Context context){
	 ContextInfo(InjectContextDemo context){
	  this.context=context;
	}

	String getPackageName(){
		return context.getApplicationInfo().packageName;
	}
}