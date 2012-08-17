package com.pstreets.guice.demo;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectExtra;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.widget.TextView;

public class InjectExtraReceiver extends RoboActivity {

	@InjectView(R.id.textview)
	TextView textView;
	@InjectExtra("Extra1")
	String extra1;
	@InjectExtra("Extra2")
	String extra2;
	@InjectExtra(value = "Extra3", optional = true)
	String extra3 = "demo";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.injectextrareceiver);

		textView.setText("Extra1:" + extra1 + "\r\nExtra2:" + extra2
				+ "\r\nExtra3:" + extra3);

	}

}
