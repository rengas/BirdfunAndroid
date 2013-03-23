package com.fyp.birdfun;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.fyp.birdfun.helpers.JSONParser;
 
public class RegisterActivity extends Activity {
 
    // Progress Dialog
    private ProgressDialog pDialog;
 
    JSONParser jsonParser = new JSONParser();

	// To hold Editabe Text in this activity 
    EditText inputName;
    EditText inputAge;
    EditText inputSchool;
    EditText inputLogin;
    EditText inputPassword;
    // url to create new product
    private static String url_register_user = "http://10.0.2.2/register_user.php";
 
    // JSON Node names
    private static final String TAG_SUCCESS = "success";
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
       /* getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        
        // Edit Text
        inputName = (EditText) findViewById(R.id.inputName);
        inputAge = (EditText) findViewById(R.id.inputAge);
        inputSchool = (EditText) findViewById(R.id.inputSchool); 
        inputLogin = (EditText) findViewById(R.id.inputLogin);
        inputPassword=(EditText) findViewById(R.id.inputPassword);
        		
        // Create button
        Button btnRegister = (Button) findViewById(R.id.btnregister);
 
        // button click event
        btnRegister.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View view) {
                // creating new product in background thread
                new CreateNewUser().execute();
            }
        });
    }
 
    *//**
     * Background Async Task to Create new product
     * *//*
    class CreateNewUser extends AsyncTask<String, String, String> {
 
        *//**
         * Before starting background thread Show Progress Dialog
         * *//*
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(RegisterActivity.this);
            pDialog.setMessage("Registering user..");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
 
        *//**
         * Creating product
         * *//*
        protected String doInBackground(String... args) {
            String name = inputName.getText().toString();
            String age = inputAge.getText().toString();
            String school = inputSchool.getText().toString();
            String login = inputLogin.getText().toString();
            String password = inputLogin.getText().toString();
            
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("name", name));
            params.add(new BasicNameValuePair("age", age));
            params.add(new BasicNameValuePair("school", school));
            params.add(new BasicNameValuePair("login", login));
            params.add(new BasicNameValuePair("password", password));
 
            // getting JSON Object
            // Note that create product url accepts POST method
            JSONObject json = jsonParser.makeHttpRequest(url_register_user,
                    "POST", params);
 
            // check log cat fro response
            Log.d("Create Response", json.toString());
 
            // check for success tag
            try {
                int success = json.getInt(TAG_SUCCESS);
 
                if (success == 1) {
                    // successfully created product
                    Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                    startActivity(i);      
                    // closing this screen
                    finish();
                } 
                
            } catch (JSONException e) {
                e.printStackTrace();
            }
 
            return null;
        }
 
        *//**
         * After completing background task Dismiss the progress dialog
         * **//*
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
            pDialog.dismiss();
        }
 */
    }
}