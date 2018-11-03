package com.hhn.asus.da;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by ASUS on 2018/6/27.
 */

public class first extends  AppCompatActivity{
    private Button button1,button2,button3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        button1=(Button)findViewById(R.id.jinru);
        button2=(Button)findViewById(R.id.guize);
        button3=(Button)findViewById(R.id.tuic);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jin=new Intent();
                jin.setClass(first.this,InputActivity.class);
                startActivity(jin);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent guize=new Intent();
                guize.setClass(first.this,dati.class);
                startActivity(guize);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();}   ;


        });

    }
}
