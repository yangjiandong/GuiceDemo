package com.pstreets.guice.demo;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.inject.Inject;

public class InjectExtraDemo extends RoboActivity {

    @InjectView (R.id.button) Button button;
    @Inject Context context;


    @Override
    public void onCreate(Bundle savedInstanceState) {
    	 super.onCreate(savedInstanceState);
    	 setContentView(R.layout.injectextra);
    	 button.setOnClickListener(mGoListener);
    }

    private OnClickListener mGoListener = new OnClickListener()
    {
        public void onClick(View v)
        {
        	 Intent di = new Intent();
	         di.setClass(context, InjectExtraReceiver.class) ;
	         di.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
	            		| Intent.FLAG_ACTIVITY_SINGLE_TOP);
	         di.putExtra("Extra1","Message1");
	         di.putExtra("Extra2","Message2");
	         context.startActivity(di);
        }
    };

}

