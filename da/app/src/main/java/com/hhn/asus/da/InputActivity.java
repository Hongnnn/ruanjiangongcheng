package com.hhn.asus.da;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
 * 项目名： da
 * 包名：   com.hhn.asus.da
 * 文件名： InputActivity
 * 创建者： NA
 * 创建时间：2018/11/1 21:06
 * 描述：   TODO
 */
public class InputActivity extends Activity implements View.OnClickListener {
    private EditText et_num,et_username;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        et_num=(EditText)findViewById(R.id.et_num);
        et_username=(EditText)findViewById(R.id.username);
        btn=(Button)findViewById(R.id.num_btn);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        if((et_num!=null)&&(et_username!=null)){
            int n=Integer.valueOf(et_num.getText().toString());
            String name=et_username.getText().toString();
            Intent intent=new Intent(InputActivity.this,ExpActivity.class);
            if(n==0||n==5){
                Toast.makeText(getApplicationContext(), "请输入1-5的整数！", Toast.LENGTH_SHORT).show();
            }
            if (name==null)
            {
                Toast.makeText(getApplicationContext(), "请输入用户名", Toast.LENGTH_SHORT).show();
            }
            Bundle bd=new Bundle();
            bd.putInt("num",+n);
       bd.putString("name",name);
           intent.putExtras(bd);
            startActivity(intent);
        }
    }



}
