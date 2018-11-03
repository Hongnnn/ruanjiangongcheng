package com.hhn.asus.da;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/*
 * 项目名： da
 * 包名：   com.hhn.asus.da
 * 文件名： ExpActivity
 * 创建者： NA
 * 创建时间：2018/11/1 21:04
 * 描述：   TODO
 */
public class ExpActivity extends Activity implements View.OnClickListener {
    private Exp expclass;
    private TextView tv_exp;
    private EditText et_result;
    private Button next;
    private Button exit;
    private TextView all;
    private TextView completed;
    private TextView wrong;
    private TextView daan;
    private TextView time;
    private TextView username;
    private  int usertime=0;


    private int index = 0;// 当前题目位置
    private int wrong_num = 0;// 答错题目数量
    private  int right_num=0;

    private List<Exp> list;// 题目数组，所有题目
Timer timer=new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp);

        expclass = new Exp();// 随机产生一个2-3项四则运算式子，及式子的结果
        // ---初始控件
        intViews();
           Intent intent2=getIntent();
        Bundle bd=intent2.getExtras();
        int num = bd.getInt("num");
        String name=bd.getString("name");
        if (num != 0) {
            list = new ArrayList<Exp>();
            for (int i = 0; i < num; i++) {
                list.add(new Exp());
            }
            tv_exp.setText(list.get(index).getExp());//
            all.setText("共计："+num);
            completed.setText("答对：");
            wrong.setText("答错：");
            timer.schedule(task,1000,1000);
           username.setText("你好："+name);
        }

    }
TimerTask task=new TimerTask() {
    @Override
    public void run() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
               usertime++;
                time.setText("用时:"+usertime);
                if (usertime==50){
                    Intent intent3=new Intent();
                    intent3.setClass(ExpActivity.this,success.class);
                    startActivity(intent3 );

                }
            }
        });
    }
};
    private void intViews() {
        // TODO Auto-generated method stub
        tv_exp = (TextView) findViewById(R.id.tv_exp);
        et_result = (EditText) findViewById(R.id.et_result);
        next = (Button) findViewById(R.id.next_btn);
        exit = (Button) findViewById(R.id.exit_btn);
        all = (TextView) findViewById(R.id.all);
        completed = (TextView) findViewById(R.id.completed);
        wrong = (TextView) findViewById(R.id.wrong);
        daan=(TextView)findViewById(R.id.daan);
        time=(TextView)findViewById(R.id.timer) ;
        username=(TextView)findViewById(R.id.username);


        next.setOnClickListener(new View.OnClickListener() {// 点击下一题时，判断上一道是否正确，并且显示下一道

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if(et_result.getText().toString()==""){
                   Toast.makeText(getApplicationContext(), "答案不能为空！",
                            Toast.LENGTH_SHORT).show();
                }
                int result = Integer.valueOf(et_result.getText().toString());
                if (index >= list.size()) {
                    Intent intent4=new Intent();
                    intent4.setClass(ExpActivity.this,success.class);

                    startActivity(intent4);

                }

                if (result != list.get(index).getResult()) {
                    wrong_num++;
                    wrong.setText("答错："+wrong_num);
                    daan.setText("回答错误，正确答案："+list.get(index).getResult());



                }
                if (result == list.get(index).getResult()) {
                    right_num++;
                    daan.setText("回答正确");

                    completed.setText("答对："+right_num);



                }
                index++;
              //  completed.setText("已答："+(index));
                if(index==list.size())
                {
                    Intent intent=new Intent();

                    intent.setClass(ExpActivity.this,success.class);
                    startActivity(intent);
                    return;
                }

                tv_exp.setText(list.get(index).getExp());
                et_result.setText("");
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub

    }


}


