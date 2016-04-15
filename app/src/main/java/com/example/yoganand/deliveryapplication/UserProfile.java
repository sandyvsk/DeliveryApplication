package com.example.yoganand.deliveryapplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserProfile extends Activity implements View.OnClickListener {

    private TextView textView,t2,t3,t4,t5;

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        b1=(Button)findViewById(R.id.button2);
        b2=(Button)findViewById(R.id.button3);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        textView = (TextView) findViewById(R.id.textView15);
        t2 = (TextView) findViewById(R.id.textViewUsername);
        t3 = (TextView) findViewById(R.id.textView12);
        t4 = (TextView) findViewById(R.id.textView13);
        t5 = (TextView) findViewById(R.id.textView14);

        Intent intent = getIntent();

        textView.setText("" + intent.getStringExtra(MainActivity.KEY_USERNAME));
        t2.setText("" + intent.getStringExtra(MainActivity.KEY_PASSWORD));
        t3.setText("" + intent.getStringExtra(MainActivity.KEY_EMAIL));
        t4.setText("" + intent.getStringExtra(MainActivity.KEY_ADDRESS));
        t5.setText("" + intent.getStringExtra(MainActivity.KEY_PHONE));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_profile, menu);
        return true;
}

    @Override
    public void onClick(View v) {
        if(v == b1){
            startActivity(new Intent(this,UpdateActivity.class));
        }

        if(v == b2){
            startActivity(new Intent(this,Shopping.class));
        }

    }
}
