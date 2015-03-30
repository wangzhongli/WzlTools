package com.momo.myfuncation;

import android.app.Application;

import com.momo.myfuncation.utils.ImageCacheUtil;

public class App extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		ImageCacheUtil.init(this);
	}

}
