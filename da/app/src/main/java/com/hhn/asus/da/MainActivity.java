package com.hhn.asus.da;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button enterBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        enterBtn = (Button) findViewById(R.id.jinru);
        enterBtn.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        startActivity(intent);
    }
}


