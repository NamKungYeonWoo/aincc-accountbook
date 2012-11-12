package com.aincc.accountbook.ui.scene;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.aincc.accountbook.R;
import com.aincc.accountbook.ui.ABBaseActivity;

/**
 * 
 * <h3><b>SplashActivity</b></h3></br>
 * 
 * <p>
 * Display splash logo
 * </p>
 * 
 * @author aincc@barusoft.com
 * @version 1.0.0
 * @since 1.0.0
 */
public class SplashActivity extends ABBaseActivity
{
	private Handler handler = new Handler()
	{
		@Override
		public void handleMessage(Message msg)
		{
			switch (msg.what)
			{
			case MOVE_TO_MAIN:
				moveToMain();
				break;
			default:
				break;
			}
		}
	};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		mappingViews(this);
		initializeUI();
	}

	@Override
	protected void initializeUI()
	{
		super.initializeUI();
	}

	@Override
	protected void onResume()
	{
		super.onResume();

		// delay 3 secs
		Message msg = handler.obtainMessage(MOVE_TO_MAIN);
		handler.sendMessageDelayed(msg, 3000);
	}

	@Override
	public void onBackPressed()
	{
	}

	private static final int MOVE_TO_MAIN = 0;

	private void moveToMain()
	{
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		finish();
	}
}
