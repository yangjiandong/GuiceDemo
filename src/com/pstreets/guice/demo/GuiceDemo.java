package com.pstreets.guice.demo;

import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.pstreets.guice.demo.listview.ListViewActivity;
import com.pstreets.guice.demo.service.IGreetingService;
import com.pstreets.guice.demo.utils.ContextInfo;

public class GuiceDemo extends RoboActivity {

    @InjectView(R.id.hello)
    TextView helloLabel;

    // @Inject
    // IGreetingService greetingServce;

    @Inject ContextInfo contextInfo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // 手工绑定
        Injector injector = RoboGuice.getInjector(this);
        IGreetingService greetingServce = injector
                .getInstance(IGreetingService.class);

        helloLabel.setText(greetingServce.getGreetings() + " - " + contextInfo.getPackageName());

        Button bt = (Button) findViewById(R.id.button1);
        bt.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuiceDemo.this, InjectViewDemo2.class));

            }
        });

        Button bt2 = (Button) findViewById(R.id.button2);
        bt2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuiceDemo.this, InjectExtraDemo.class));

            }
        });

        Button bt3 = (Button) findViewById(R.id.button3);
        bt3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuiceDemo.this, ListViewActivity.class));

            }
        });
    }

}