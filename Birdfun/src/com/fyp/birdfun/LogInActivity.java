package com.fyp.birdfun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fyp.birdfun.helpers.JSONParser;
import com.fyp.birdfun.helpers.PlayerDetails;
 

public class LogInActivity extends Activity{

    // Progress Dialog
    private ProgressDialog pDialog;
 
    // Creating JSON Parser object
    JSONParser jsonParser = new JSONParser();
 
    ArrayList<HashMap<String, String>> productsList;
    ArrayList<PlayerDetails> playerdata = new ArrayList<PlayerDetails>();
    // url to get all products list
    private static String url_login = "http://10.0.2.2/login_user.php";
 
    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_USER = "users";
    private static final String TAG_PID = "pid";
    private static final String TAG_NAME = "name";
    private static final String  TAG_TOTAL="total";
    // products JSONArray
    JSONArray users = null;
    
    //to read the content of the user input
    EditText inputLogin;
    EditText inputPassword;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_user);
        // Edit Text
        inputLogin = (EditText) findViewById(R.id.inputLogin);
        inputPassword = (EditText) findViewById(R.id.inputPassword);
     // Create button
        Button btnLogin = (Button) findViewById(R.id.btnlogin);
        Button btnCancel = (Button) findViewById(R.id.btncancel);
        // button click event
        btnLogin.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View view) {
                // creating Login check in background thread
                new LoginUser().execute();
               
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
        	 
            @Override
            public void onClick(View view) {
                // cancel and go back to main thread
               
            }
        });
        
        
    }
        /**
         * Background Async Task to Create new product
         * */
        class LoginUser extends AsyncTask<String, String, String> {
     
            /**
             * Before starting background thread Show Progress Dialog
             * */
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                pDialog = new ProgressDialog(LogInActivity.this);
                pDialog.setMessage("Loging in user..");
                pDialog.setIndeterminate(false);
                pDialog.setCancelable(true);
                pDialog.show();
            }
     
            /**
             *Checking for login
             * */
            protected String doInBackground(String... args) {
              
                String login = inputLogin.getText().toString();
                String password = inputPassword.getText().toString();
                
                // Building Parameters
                List<NameValuePair> params = new ArrayList<NameValuePair>();
               
                params.add(new BasicNameValuePair("login", login));
                params.add(new BasicNameValuePair("password", password));
     
                // getting JSON Object
                // Note that Login url accepts POST method
                JSONObject json = jsonParser.makeHttpRequest(url_login,
                        "POST", params);
     
                // check log cat fro response
                Log.d("Create Response", json.toString());
     
                // check for success tag
                try {
                    int success = json.getInt(TAG_SUCCESS);       
                    if (success == 1) {
                    // products found
                    // Getting Array of Products
                    users = json.getJSONArray(TAG_USER);
                	
                    // looping through All Products
                    for (int i = 0; i < users.length(); i++) 
                    {
                    	JSONObject c = users.getJSONObject(i);
                       // Storing each json item in player object
                    	
                    	PlayerDetails player=new PlayerDetails();
                    	
                        player.Pid = c.getInt(TAG_PID);
                        player.Name = c.getString(TAG_NAME);
                        
                        playerdata.add(player);
                       // player.Total=c.getInt(TAG_TOTAL);
                    }
                   
                    Intent playscreen = new Intent(getApplicationContext(), PlayScreenActivity.class);
                    playscreen.putExtra("id","login_intent");
                    playscreen.putExtra("player",playerdata);  
                    startActivity(playscreen);      
                    // closing this screen
                    finish();
                    } 
                    
                } catch (JSONException e) {
                    e.printStackTrace();
                }
     
                return null;
            }
     
            /**
             * After completing background task Dismiss the progress dialog
             * **/
            protected void onPostExecute(String file_url) {
                // dismiss the dialog once done
                pDialog.dismiss();
            }
     
        }
 
 
	
}
