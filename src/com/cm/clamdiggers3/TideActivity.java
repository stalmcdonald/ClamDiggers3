/*
 * Crystal McDonald
 * Java II
 * 1309
 * Week 3
 * Intents
 */
package com.cm.clamdiggers3;

import com.cm.clamdiggers3.R;
import com.cm.clamdiggers3.SecondActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TideActivity extends Activity implements OnClickListener{
	Button city, predict;
	TextView tidalPrediction;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tide);
		city = (Button) findViewById(R.id.cButton);
		predict = (Button) findViewById(R.id.pButton);
		tidalPrediction = (TextView) findViewById(R.id.textPrediction);
		
		//setup onclick Listener
		city.setOnClickListener(this);
		predict.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tide, menu);
		return true;
	}

	//Explicit Intent
	@Override
	public void onClick(View v) {
		// if city button pressed go to new activity
		/*Intent i = new Intent(this, SecondActivity.class);
		i.putExtra("cityEnter", "city");
		startActivity(i);*/
		
		//Log.i("Entered:", city);
		//Add City to url
		//String baseURL =  "http://api.wunderground.com/api/3e64fa36c4f09bdd/tide/q/FL/"+cities+".json" 
		//string myCity = 
		
		Intent i = new Intent(this, SecondActivity.class);
		switch (v.getId()){
		
		//buttons
		case R.id.cButton:
			
			//city button
			i.putExtra("cityEnter", "city");
			startActivityForResult(i,1);
			break;
		case R.id.pButton:
		
		//predict button
			final String baseURL = "http://api.wunderground.com/api/3e64fa36c4f09bdd/tide/q/";
			String c = city.getText().toString();
			String p = predict.getText().toString();
			String t = tidalPrediction.getText().toString();
		}
		
	}
	
	//Retrieves state from second activity to be added to url
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		if(data.getExtras().containsKey("enteredInfo")){
			city.setText(data.getStringExtra("enteredInfo"));
		}
	}

}//end