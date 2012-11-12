package com.aincc.accountbook.ui.scene;

import android.os.Bundle;
import android.view.Menu;

import com.aincc.accountbook.R;
import com.aincc.accountbook.ui.ABBaseActivity;
import com.aincc.exchangecount.ExchangeExecutor;
import com.aincc.exchangecount.model.KEBCurrency;
import com.aincc.exchangecount.openapi.OpenKEBExchange;
import com.aincc.network.common.BaseTrans;
import com.aincc.network.common.BaseTransEx;
import com.aincc.util.Logger;

/**
 * 
 * <h3><b>MainActivity</b></h3></br>
 * 
 * <h4>Main Scene</h4>
 * <ul>
 * <li>Initialize Database</li>
 * <li>Update Exchange Information from KEB</li>
 * </ul>
 * 
 * @author aincc@barusoft.com
 * @version 1.0.0
 * @since 1.0.0
 */
public class MainActivity extends ABBaseActivity
{

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mappingViews(this);
		initializeUI();
		ExchangeExecutor.getInstance().getKEBExchange("exchange", listener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void iNetEnabled()
	{
		super.iNetEnabled();
	}

	@Override
	public void iNetDisabled()
	{
		super.iNetDisabled();
	}

	@Override
	public boolean iNetListenedTransaction(BaseTrans tr)
	{
		Logger.i("Transaction OK");
		if (tr.getParam().getRequestKey().equals("exchange"))
		{
			OpenKEBExchange exchange = (OpenKEBExchange) tr;
			for (KEBCurrency currency : exchange.exchange.getCurrency())
			{
				Logger.i("name : " + currency.getHname());
				Logger.i("init : " + currency.getInit());
				Logger.i("cash buy : " + currency.getBuy());
				Logger.i("cash sell : " + currency.getSell());
			}
		}
		return super.iNetListenedTransaction(tr);
	}

	@Override
	public boolean iNetListenedError(BaseTransEx ex)
	{
		Logger.i("Transaction Error");
		return super.iNetListenedError(ex);
	}
}
