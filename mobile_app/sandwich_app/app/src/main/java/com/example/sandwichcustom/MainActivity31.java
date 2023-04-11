package com.example.sandwichcustom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity31 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_31_q1);//질문1

        //1.이전 버튼 누르기 -> 디폴트화면(00)으로
        Button button1=findViewById(R.id.button_back);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity31.this, MainActivity00.class);//?
                startActivity(intent);
            }
        });

        //2.다음 버튼 누르기 -> 다음 질문(32)으로
        Button button2=findViewById(R.id.button_next);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity31.this, MainActivity32.class);//?
                startActivity(intent);
            }
        });

    }
}