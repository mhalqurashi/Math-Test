package com.muath.mathtest;


import android.app.Activity;
import android.os.Bundle;

import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private boolean phoneDevice = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// determine screen size 
	      int screenSize = getResources().getConfiguration().screenLayout &
	         Configuration.SCREENLAYOUT_SIZE_MASK;

	      // if device is a tablet, set phoneDevice to false
	      if (screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE ||
	         screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE )
	         phoneDevice = false; // not a phone-sized device
	         
	      // if running on phone-sized device, allow only portrait orientation
	      if (phoneDevice) 
	         setRequestedOrientation(
	            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
	 @Override
	   protected void onStart()
	   {
	      super.onStart();
	      TestFragment testFragment = (TestFragment)
	              getFragmentManager().findFragmentById(R.id.testFragment);
	   }
	 
	
	
}
