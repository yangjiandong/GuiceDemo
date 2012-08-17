package com.pstreets.guice.demo;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class InjectViewDemo extends RoboActivity {

	@InjectView(R.id.button)
	Button goButton;
	@InjectView(R.id.textview1)
	TextView textView1;
	@InjectView(R.id.textview2)
	TextView textView2;
	@InjectView(R.id.textview3)
	TextView textView3;
	@InjectView(R.id.textview4)
	TextView textView4;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.injectview);
		goButton.setOnClickListener(mGoListener);
	}

	private OnClickListener mGoListener = new OnClickListener() {
		public void onClick(View v) {
			textView1.setText("Clicked");
			textView2.setText("Clicked");
			textView3.setText("Clicked");
			textView4.setText("Clicked");
		}
	};

}
