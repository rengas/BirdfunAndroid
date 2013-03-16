package com.fyp.birdfun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreenAcitivity extends Activity {
	 	Button btnSaveTheEggs;
	    Button btnFantasticFeathers;
	    Button btntheweapon;
	   	
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main_screen);
	 
	        // Buttons
	        btnSaveTheEggs = (Button) findViewById(R.id.btnsavetheeggs);
	        btnFantasticFeathers = (Button) findViewById(R.id.btnfantasticfeathers);
	        btntheweapon = (Button) findViewById(R.id.btntheweapon);
	        // Save The Eggs  click event
	        btnSaveTheEggs.setOnClickListener(new View.OnClickListener() {
	 
	            
	            public void onClick(View view) {
	                // Launching All products Activity
	                Intent i = new Intent(getApplicationContext(), SaveTheEggsActivity.class);
	                startActivity(i);
	 
	            }
	        });

	        // Fantastic feathers click event
	        btnFantasticFeathers.setOnClickListener(new View.OnClickListener() {
	 
	            
	            public void onClick(View view) {
	                // Launching create new product activity
	                Intent i = new Intent(getApplicationContext(), FantasticFeathersActivity.class);
	                startActivity(i);
	 
	            }
	        });
	       
	        // The weapon click even
	        btntheweapon.setOnClickListener(new View.OnClickListener() {
	       	 
	            
	            public void onClick(View view) {
	                // Launching create new product activity
	                Intent i = new Intent(getApplicationContext(), TheWeaponActivity.class);
	                startActivity(i);
	 
	            }
	        });
	    }
	    
	    //To-do Add exit button
	    //To-do Sign up acitivty to update the score to the server
}
