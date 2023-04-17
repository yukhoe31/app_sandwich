package com.example.sandwichcustom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity00 extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_00_default);//0.로그인된 디폴트 화면

        mFirebaseAuth = FirebaseAuth.getInstance();


        //버튼1: 내 정보 버튼 클릭 -> 내 정보(activity11)
        Button button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity00.this, MainActivity11.class);
                startActivity(intent);
            }
        });

        //버튼2: 나만의 레시피 버튼 클릭 -> 나만의 레시피(activity21)
        Button button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity00.this, MainActivity21.class);
                startActivity(intent);
            }
        });

        //버튼3: 테스트 버튼 클릭 -> 질문 1(activity 31)
        Button button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity00.this, MainActivity31.class);
                startActivity(intent);
            }
        });

        //버튼3: 로그아웃 버튼 클릭 -> 로그인화면(activity01)
        Button button4=findViewById(R.id.button4);//로그아웃 버튼
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //로그아웃 하기
                mFirebaseAuth.signOut();
                //다시 로그인 activity로 돌아가기.
                Intent intent=new Intent(MainActivity00.this, MainActivity01.class);
                startActivity(intent);
            }
        });

        //회원탈퇴처리
        //mFirebaseAuth.getCurrentUser().delete();
        

    }
}