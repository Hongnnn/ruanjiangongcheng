package com.hhn.asus.da;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by ASUS on 2018/6/27.
 */

public class success extends AppCompatActivity {
    private TextView datisum,shijian,kehu,dadui,dacuo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);
        datisum=(TextView) findViewById(R.id.datisum);
        dadui=(TextView)findViewById(R.id.dadui);
        dacuo=(TextView)findViewById(R.id.dacuo);
        kehu=(TextView)findViewById(R.id.kehu);
        shijian=(TextView)findViewById(R.id.shijian);
  //      Intent intent=getIntent();
 //       Bundle bd=intent.getExtras();
//        int ss=bb.getInt("num");
  //      int dui=bd.getInt("rightti");
  //      int cuo=bd.getInt("wrong");
//        String user=bd.getString("username");
  //   kehu.setText(""+user+"您的答题情况如下：");
     //   datisum.setText("共答题："+ss);
 //       dacuo.setText("答错："+cuo);
 //       dadui.setText("答对："+dui);
    }

}
