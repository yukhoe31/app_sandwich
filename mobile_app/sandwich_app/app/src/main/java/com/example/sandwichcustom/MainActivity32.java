package com.example.sandwichcustom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity32 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_32_q2);//질문2

        //1.이전 버튼 누르기 -> 질문1(31)로
        Button button1=findViewById(R.id.button_back);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity32.this, MainActivity31.class);//?
                startActivity(intent);
            }
        });

        //2.다음 버튼 누르기 -> 다음 질문(33)으로
        Button button2=findViewById(R.id.button_next);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity32.this, MainActivity33.class);//?
                startActivity(intent);
            }
        });

    }
}