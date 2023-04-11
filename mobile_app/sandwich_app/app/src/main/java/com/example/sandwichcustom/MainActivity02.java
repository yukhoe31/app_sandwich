package com.example.sandwichcustom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02_join);//2.회원가입 화면

        //가입 버튼 누르기 -> 가입 축하 화면(3) 으로
        Button button1=findViewById(R.id.join_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity02.this, MainActivity03.class);//?
                startActivity(intent);
            }
        });

        //취소버튼 누르기 -> 회원가입 화면(1)으로
        Button button2=findViewById(R.id.delete);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity02.this, MainActivity01.class);//?
                startActivity(intent);
            }
        });
        
    }
}