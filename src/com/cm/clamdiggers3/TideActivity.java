/*
 * 
 * Crystal McDonald
 * Java II
 * 1309
 * Week 3
 */
package com.cm.clamdiggers3;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TideActivity extends Activity implements OnClickListener{
	Button infoButton, tipsButton, browse;
	TextView clammersTip;
	//checks network connection
	 Boolean _connected = false;
	 Context _context;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		_context = this;
		setContentView(R.layout.tide);
		infoButton = (Button) findViewById(R.id.infoButton);
		tipsButton = (Button) findViewById(R.id.tButton);
		browse = (Button)findViewById(R.id.browse);
		clammersTip = (TextView) findViewById(R.id.clamTips);
		
		
		/*
		 * Intent: Launches second activity.
		 */
		infoButton.setOnClickListener(new OnClickListener(){//setup onclick Listener

			@Override
			public void onClick(View v) {
				// second activity launch
				Intent intent = new Intent(TideActivity.this, SecondActivity.class);
				startActivity(intent);
			}
			
		});
		
		/*
		 * Clamming Tips: Randomly selects tips on clamming.
		 */
		tipsButton.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View arg2) {
			//predict button
			String[] tips ={//array to hold data
					"The best time to dig for clams is low tide",
					"Clamming Season begins at the end of this month!",
					"The Department of fish and wildlife offers resources with detailed maps of where to dig at each beach, instructions for digging, guides to identifying clam species, plus links to tide tables.  ",
					"Don't forget your liscense! Shellfish licenses can be purchased online, by mail or fax.",
					"Read the tides, you can find them by clicking 'Get Tidal Information' button above.",
					"Cockies are commonly used in chowders.",
					"Small clams can be used for pasta or chowders",
					"Digging for clams is messy.",
					"Razor clams in the Northwest can reach 6 inches long.",
					"Washington Department of Fish and Wildlife Shellfish Rule Change Hotline, 1-866-880-5431."};
					
			// The button was clicked, so update the answer label with a random tip
			String tip = "";//blank string
			
			//Randomly select a tip
			Random randomGenerator = new Random();  // Construct a new Random number generator and assign it to the variable declared.
			int randomNumber = randomGenerator.nextInt(tips.length);
			tip = tips[randomNumber]; //get elements at index randomNumber
			
			//Update the label with our dynamic answer
			clammersTip.setText(tip);
			
			
		}
		
		});
		
		/*
		 * Implicit Intent: Launches Web browsers to open website.
		 */
		browse.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View interwebs) {
			// sends user to site that shows more information on forecast
			Uri uriUrl = Uri.parse("http://wdfw.wa.gov/fishing/shellfish/razorclams/howto_dig.html");
			
			Intent browse_intent = new Intent(Intent.ACTION_VIEW, uriUrl);
			
			startActivity(browse_intent);
			
		}
	});
		//Detects the network connection
  		_connected = WebFile.getConnectionStatus(_context);
  		if(_connected){
  			Log.i("NETWORK CONNECTION ", WebFile.getConnnectionType(_context));
  		}else{
  			//notified if user isn't connected to the Internet
  			Context context = getApplicationContext();
  			CharSequence text = "No Network Detected";
  			int duration = Toast.LENGTH_SHORT;

  			Toast toast = Toast.makeText(context, text, duration);
  			toast.show();
  		}	
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tide, menu);
		return true;
	}
	
	//Retrieves state from second activity to be added to url
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		if(data.getExtras().containsKey("enteredInfo")){
			infoButton.setText(data.getStringExtra("enteredInfo"));
		}
	}

	@Override
	public void onClick(View v) {
				
	}


}//end
