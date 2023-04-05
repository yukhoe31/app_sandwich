package com.example.sandwichcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01_login);//1. 로그인 화면

        //버튼1: 로그인 버튼 클릭 -> 로그인된 디폴트 화면(0)
        Button button1=findViewById(R.id.loginButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity01.this, MainActivity00.class);
                startActivity(intent);
            }
        });

        //버튼2: 회원가입 버튼 클릭 -> 회원가입 화면(2)
        Button button2=findViewById(R.id.signupButton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity01.this, MainActivity02.class);
                startActivity(intent);
            }
        });
    }


}