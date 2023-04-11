package com.example.sandwichcustom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_11_myinfo);//2.회원가입 화면

        //편집버튼 누르기->
        Button button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity11.this, MainActivity12.class);//?
                startActivity(intent);
            }
        });

        //취소버튼 누르기 -> 디폴트화면(00)으로
        Button button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity11.this, MainActivity00.class);//?
                startActivity(intent);
            }
        });

    }
}