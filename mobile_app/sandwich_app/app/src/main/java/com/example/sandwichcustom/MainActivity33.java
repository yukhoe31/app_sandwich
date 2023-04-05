package com.example.sandwichcustom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity33 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_33_q3);//질문3

        //1.이전 버튼 누르기 -> 질문2(32)로
        Button button1=findViewById(R.id.button_back);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity33.this, MainActivity32.class);//?
                startActivity(intent);
            }
        });

        //2.다음 버튼 누르기 -> 추천화면(으로
        Button button2=findViewById(R.id.button_next);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity33.this, MainActivity41.class);//?
                startActivity(intent);
            }
        });

    }
}