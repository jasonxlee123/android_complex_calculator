package com.example.cal_v_1;

//import android.support.v7.app.AppCompatActivity;
//import android.provider.Settings;
import android.os.Bundle;
//import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import function.*;

import androidx.appcompat.app.AppCompatActivity;

public class calActivity extends AppCompatActivity implements View.OnClickListener {
    //output view * 3
    private TextView history;
    private TextView res;
    private TextView input;
    //button * 30
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn10;
    private Button btn11;
    private Button btn12;
    private Button btn13;
    private Button btn14;
    private Button btn15;
    private Button btn16;
    private Button btn17;
    private Button btn18;
    private Button btn19;
    private Button btn20;
    private Button btn21;
    private Button btn22;
    private Button btn23;
    private Button btn24;
    private Button btn25;
    private Button btn26;
    private Button btn27;
    private Button btn28;
    private Button btn29;
    private Button btn30;
    //string to save data * 3
    String str1=""; //history
    String str2=""; //input
    String str3=""; //res


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);
        //initialize the basic view control * 33
        View btn1 = findViewById(R.id.btn1);
        View btn2 = findViewById(R.id.btn2);
        View btn3= findViewById(R.id.btn3);
        View btn4 = findViewById(R.id.btn4);
        View btn5 = findViewById(R.id.btn5);
        View btn6 = findViewById(R.id.btn6);
        View btn7 = findViewById(R.id.btn7);
        View btn8 = findViewById(R.id.btn8);
        View btn9 = findViewById(R.id.btn9);
        View btn10 = findViewById(R.id.btn10);

        View btn11 = findViewById(R.id.btn11);
        View btn12 = findViewById(R.id.btn12);
        View btn13= findViewById(R.id.btn13);
        View btn14 = findViewById(R.id.btn14);
        View btn15 = findViewById(R.id.btn15);
        View btn16 = findViewById(R.id.btn16);
        View btn17 = findViewById(R.id.btn17);
        View btn18 = findViewById(R.id.btn18);
        View btn19 = findViewById(R.id.btn19);
        View btn20 = findViewById(R.id.btn20);

        View btn21 = findViewById(R.id.btn21);
        View btn22 = findViewById(R.id.btn22);
        View btn23 = findViewById(R.id.btn23);
        View btn24 = findViewById(R.id.btn24);
        View btn25 = findViewById(R.id.btn25);
        View btn26 = findViewById(R.id.btn26);
        View btn27 = findViewById(R.id.btn27);
        View btn28 = findViewById(R.id.btn28);
        View btn29 = findViewById(R.id.btn29);
        View btn30 = findViewById(R.id.btn30);
        input = (TextView) findViewById(R.id.input);
        res = (TextView) findViewById(R.id.res);
        history = (TextView) findViewById(R.id.history);

        //添加点击事件

        history.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);

        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);

        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);

        btn16.setOnClickListener(this);
        btn17.setOnClickListener(this);
        btn18.setOnClickListener(this);
        btn19.setOnClickListener(this);
        btn20.setOnClickListener(this);

        btn21.setOnClickListener(this);
        btn22.setOnClickListener(this);
        btn23.setOnClickListener(this);
        btn24.setOnClickListener(this);
        btn25.setOnClickListener(this);

        btn26.setOnClickListener(this);
        btn27.setOnClickListener(this);
        btn28.setOnClickListener(this);
        btn29.setOnClickListener(this);
        btn30.setOnClickListener(this);


    }

    //mark sign
    //int flag1=0;
    int flag2=0; //when get a result : 1

    @Override
    public void onClick(View view) {
        if(flag2==1&&str3!=""){//continue cal the result
            str2 = res.getText().toString();
            flag2=0;
        }
        switch (view.getId()){
            case R.id.btn27://00
            case R.id.btn28://0
            case R.id.btn29://.
            case R.id.btn22://1
            case R.id.btn23://2
            case R.id.btn24://3
            case R.id.btn17://4
            case R.id.btn18://5
            case R.id.btn19://6
            case R.id.btn12://7
            case R.id.btn13://8
            case R.id.btn14://9
                str2=str2 + ((Button)view).getText();
                input.setText(str2);
                Log.d("str2",str2);
                break;
            case R.id.btn1://sin
                str2=str2 + "sin(";
                input.setText(str2);
                Log.d("str2",str2);
                break;
            case R.id.btn2://cos
                str2=str2 + "cos(";
                input.setText(str2);
                Log.d("str2",str2);
                break;
            case R.id.btn3://tan
                str2=str2 + "tan(";
                input.setText(str2);
                Log.d("str2",str2);
                break;
            case R.id.btn4://(
                str2=str2 + "(";
                input.setText(str2);
                Log.d("str2",str2);
                break;
            case R.id.btn5://)
                str2=str2 + ")";
                input.setText(str2);
                Log.d("str2",str2);
                break;
            case R.id.btn6://%
                str2=str2 + "per(";
                input.setText(str2);
                Log.d("str2",str2);
                break;
            case R.id.btn7://AC
                str1=input.getText() + "=" + res.getText();
                if(flag2==1){//save the expression as history
                    flag2=0;
                    history.setText(str1);
                }
                if(str3==""){//get continue click
                    break;
                }
                str2="";
                str3="";
                input.setText(str2);
                res.setText(str3);
                Log.d("str1",str1);
                history.setText(str1);
                break;
            case R.id.btn8://CE
                if(input.getText()==""){
                    break;
                }
                str2="";
                input.setText(str2);
                break;
            case R.id.btn9://backspace
                if(str2.equals(""))break;
                str2=str2.substring(0,str2.length()-1);
                input.setText(str2);
                Log.d("str2",str2);
                break;
            case R.id.btn10://division÷
                str2=str2 + "÷";
                input.setText(str2);
                Log.d("str2",str2);
                break;
            case R.id.btn11://1/x
                str2=str2 + "rec(";
                input.setText(str2);
                Log.d("str2",str2);
                break;
            case R.id.btn16://pi
                str2=str2 + "3.1415";
                input.setText(str2);
                Log.d("str2",str2);
                break;
            case R.id.btn21://extract toot
                str2=str2 + "oot(";
                input.setText(str2);
                Log.d("str2",str2);
                break;
            case R.id.btn26://!
                str2=str2 + "fac(";
                input.setText(str2);
                Log.d("str2",str2);
                break;
            case R.id.btn15://*
                str2=str2 + "×";
                input.setText(str2);
                Log.d("str2",str2);
                break;
            case R.id.btn20://-
                str2=str2 + "－";
                input.setText(str2);
                Log.d("str2",str2);
                break;
            case R.id.btn25://+
                str2=str2 + "＋";
                input.setText(str2);
                Log.d("str2",str2);
                break;
            case R.id.btn30://=
                flag2=1;
                try {
                    str3=counti.cal(str2);
                    Log.d("cal",str3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(str3.equals("ERROR")){
                    res.setText(str3);
                    str3="";
                    Toast toast = Toast.makeText(this, "ERROR", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM, 0, 0);
                    toast.show();
                }
                else{
                    res.setText(str3);
                }
                break;
            case R.id.history://get the history to input
                if(history.getText()==""){
                    break;
                }
                str2="" + history.getText();
                str2 = str2.substring(0, str2.indexOf("="));
                input.setText(str2);//send to input view
                break;
            default:break;
        }
    }
}


/*
＋－×÷√
 */