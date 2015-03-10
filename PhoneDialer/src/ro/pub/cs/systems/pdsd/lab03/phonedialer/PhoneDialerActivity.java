package ro.pub.cs.systems.pdsd.lab03.phonedialer;

import java.util.ArrayList;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PhoneDialerActivity extends Activity {
    
	public class Buttons implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(v instanceof ImageButton){
				ImageButton but = (ImageButton)v;
				if( but.getTag().equals("back") ){
					EditText phoneNumberEditText = (EditText)findViewById(R.id.PhoneNumber);
					String str = phoneNumberEditText.getText().toString();
					String phoneNumber = str.substring(0, str.length() - 1);
					Color col = new Color();
					phoneNumberEditText.setTextColor(col.GREEN);
					phoneNumberEditText.setText(phoneNumber);
					
				}
				
				if( but.getTag().equals("rosu") ){
					finish();
				}
				
				if(but.getTag().equals("verde")){
					Intent intent = new Intent(Intent.ACTION_CALL);
					EditText phoneNumberEditText = (EditText)findViewById(R.id.PhoneNumber);
					String phoneNumber = phoneNumberEditText.getText().toString();
					intent.setData(Uri.parse("tel:"+phoneNumber));
					startActivity(intent);
				}
				
			}
			
			if(v instanceof Button){
				Button but1 = (Button) v;
				EditText phoneNumberEditText = (EditText)findViewById(R.id.PhoneNumber);
				String phoneNumber = phoneNumberEditText.getText().toString() + but1.getText();
				Color col = new Color();
				phoneNumberEditText.setTextColor(col.GREEN);
				phoneNumberEditText.setText(phoneNumber);
				
			}
		}
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phone_dialer);
		
		ArrayList<Button> numbersList = new ArrayList<Button>();
		ArrayList<ImageButton> imageList = new ArrayList<ImageButton>();
		
		
		imageList.add((ImageButton)findViewById(R.id.back_space));
		numbersList.add((Button)findViewById(R.id.cinci));
		numbersList.add((Button)findViewById(R.id.diez));
		numbersList.add((Button)findViewById(R.id.doi));
		numbersList.add((Button)findViewById(R.id.noua));
		numbersList.add((Button)findViewById(R.id.opt));
		numbersList.add((Button)findViewById(R.id.patru));
		imageList.add((ImageButton)findViewById(R.id.rosu));
		numbersList.add((Button)findViewById(R.id.sapte));
		numbersList.add((Button)findViewById(R.id.sase));
		numbersList.add((Button)findViewById(R.id.steluta));
		numbersList.add((Button)findViewById(R.id.trei));
		numbersList.add((Button)findViewById(R.id.unu));
		imageList.add((ImageButton)findViewById(R.id.verde));
		numbersList.add((Button)findViewById(R.id.zero));
		
		for(int i = 0; i < numbersList.size(); i++){
			numbersList.get(i).setOnClickListener(new Buttons());
		}
		
		for(int i = 0; i < imageList.size(); i++){
			imageList.get(i).setOnClickListener(new Buttons());
		}
		
		
		
	
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.phone_dialer, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
