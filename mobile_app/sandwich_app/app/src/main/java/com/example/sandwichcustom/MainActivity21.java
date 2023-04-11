package com.example.sandwichcustom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity21 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_21_myrecipe);//21.내 레시피 화면

        //편집 버튼 누르기 -> activity22로
        Button button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity21.this, MainActivity22.class);//?
                startActivity(intent);
            }
        });

        //홈으로 버튼 누르기 -> 디폴트화면(00)으로
        Button button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity21.this, MainActivity00.class);//?
                startActivity(intent);
            }
        });

    }
}