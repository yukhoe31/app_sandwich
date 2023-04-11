package com.example.sandwichcustom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity22 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_22_myrecipe2);//22. 내 레시피 편집 화면

        //취소 버튼 누르기 ->activity21로 (바뀌지 않은 채)
        Button button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity22.this, MainActivity21.class);//?
                startActivity(intent);
            }
        });

        //저장버튼 누르기 -> activity21로 (바뀐채)
        Button button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity22.this, MainActivity21.class);//?
                startActivity(intent);
            }
        });

    }
}