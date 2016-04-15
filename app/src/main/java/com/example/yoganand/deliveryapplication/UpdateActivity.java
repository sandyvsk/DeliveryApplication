package com.example.yoganand.deliveryapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String REGISTER_URL = "http://192.168.1.104/login/register.php";

    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_ADDRESS= "address";
    public static final String KEY_PHONE= "phone";

    private String username;
    private String password;
    private String email;
    private String address;
    private String phone;



    EditText e1,e2,e3,e4,e5;
    private ImageButton buttonRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        e1=(EditText)findViewById(R.id.editText4);
        e2=(EditText)findViewById(R.id.editText5);
        e3=(EditText)findViewById(R.id.editText6);
        e4=(EditText)findViewById(R.id.editText7);
        e5=(EditText)findViewById(R.id.editText8);

        Intent intent = getIntent();

        e1.setText(""+ intent.getStringExtra(MainActivity.KEY_USERNAME));
        e2.setText(""+ intent.getStringExtra(MainActivity.KEY_PASSWORD));
        e3.setText(""+ intent.getStringExtra(MainActivity.KEY_EMAIL));
        e4.setText(""+ intent.getStringExtra(MainActivity.KEY_ADDRESS));
        e5.setText(""+ intent.getStringExtra(MainActivity.KEY_PHONE));

        buttonRegister = (ImageButton) findViewById(R.id.register_register);

        buttonRegister.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v == buttonRegister){
            registerUser();
        }
    }

    private void registerUser() {

        username = e1.getText().toString().trim();
        password = e2.getText().toString().trim();
        email = e3.getText().toString().trim();
        address= e4.getText().toString().trim();
        phone= e5.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                            Toast.makeText(UpdateActivity.this, response, Toast.LENGTH_LONG).show();
                        }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME,username);
                params.put(KEY_PASSWORD,password);
                params.put(KEY_EMAIL, email);
                params.put(KEY_ADDRESS, address);
                params.put(KEY_PHONE, phone);
                return params;
            }

        };




        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}

