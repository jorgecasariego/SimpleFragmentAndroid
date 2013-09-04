package com.jc.simplefragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

//Actividad usada para el modo portrait  
public class DetailActivity extends Activity{

	public static final String EXTRA_URL = "url";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//Necesitamos chequear si la actividad ha sido cambiada al modo landscape
		//Si es SI, terminamos y volvemos a la actividad inicial
		if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			finish();
			return;
		}
		
		setContentView(R.layout.activity_detail);
		Bundle extras = getIntent().getExtras();
		if(extras != null) {
			String s = extras.getString(EXTRA_URL);
			TextView view = (TextView)findViewById(R.id.detailsText);
			view.setText(s);
		}
		
	}
	
	
}
