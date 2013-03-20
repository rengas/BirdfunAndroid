package com.fyp.birdfun;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fyp.birdfun.helpers.PlayerDetails;

public class PlayScreenActivity extends Activity {
	 	Button btnSaveTheEggs;
	    Button btnFantasticFeathers;
	    Button btntheweapon;
	    ArrayList<PlayerDetails> playerdata = new ArrayList<PlayerDetails>();
	   	
	    TextView newtext;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.play_screen);
	        Intent intent =getIntent();
	        
	        Bundle bundle = intent.getExtras();

	        playerdata =  bundle.getParcelableArrayList("player");
	        
	      
	        for (int count = 0; count < playerdata.size(); count++) {

	        	PlayerDetails cric = (PlayerDetails) playerdata.get(count);
	           String name = cric.Name;
	           newtext =(TextView)findViewById(R.id.nametag);
		       newtext.setText(name);
	           }
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
