package com.cm.clamdiggers3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.cm.clamdiggers3.R;

public class SecondActivity extends Activity implements OnClickListener {
	Button goTide;
	Button browse;
	EditText cityEntered;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tide);
		cityEntered = (EditText)findViewById(R.id.cityText);
		goTide = (Button)findViewById(R.id.tideButton);
		
		//set listener for browser button
		browse = (Button)findViewById(R.id.webButton);
		
		goTide.setOnClickListener(this);
		
		//Implicit Intent
		browse.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View interwebs) {
			// sends user to site that shows more information on forecast
			Uri uriUrl = Uri.parse("http://wdfw.wa.gov/fishing/shellfish/razorclams/howto_dig.html");
			
			Intent browse_intent = new Intent(Intent.ACTION_VIEW, uriUrl);
			
			startActivity(browse_intent);
			
		}
	});

	

}

	//Activity 2 takes in a city and displays it on activity 1
	@Override
	public void onClick(View v) {
		// get info from edit text and send back
		String cityInfo = cityEntered.getText().toString();
		//get info from intent that opens the class
		Intent i = getIntent ();
		//looking for i.putExtras
		String msg = i.getStringExtra("cityEnter");
		//Takes the result and closes the page and appends to MainActivity in its' button
		if(msg.contentEquals("city")){
			i.putExtra("enteredInfo", cityInfo);
			setResult(RESULT_OK, i);
			finish();
		}
		
	}
}//end