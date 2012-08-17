package com.pstreets.guice.demo.utils;

import android.content.Context;

import com.google.inject.Inject;

public class ContextInfo {
	final Context context;

	@Inject
	public ContextInfo(Context context) {
		this.context = context;
	}

	public String getPackageName(){
		return context.getApplicationInfo().packageName;
	}
}
