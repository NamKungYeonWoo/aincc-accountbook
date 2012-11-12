package com.aincc.accountbook;

import android.app.Application;
import android.content.Context;

import com.aincc.accountbook.util.Logger;

/**
 * 
 * <h3><b>App</b></h3></br>
 * 
 * @author aincc@barusoft.com
 * @version 1.0.0
 * @since 1.0.0
 */
public class App extends Application
{
	private static Context context;

	@Override
	public void onCreate()
	{
		super.onCreate();
		Logger.v("onCreate");

		context = this;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Application#onLowMemory()
	 */
	@Override
	public void onLowMemory()
	{
		super.onLowMemory();
		Logger.v("onLowMemory");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Application#onTerminate()
	 */
	@Override
	public void onTerminate()
	{
		super.onTerminate();
		Logger.v("onTerminate");
	}

	/**
	 * Get application's context
	 * 
	 * @since 1.0.0
	 * @return context
	 */
	public static Context getContext()
	{
		return context;
	}
}
