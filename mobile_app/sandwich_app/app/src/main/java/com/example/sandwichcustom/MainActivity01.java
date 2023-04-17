package com.example.sandwichcustom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity01 extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth; //파이어베이스 인증
    private DatabaseReference mDatabaseRef; //실시간 데이터베이스
    private EditText mEtEmail, mEtPwd;// 로그인 입력필드

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01_login);//1. 로그인 화면


        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("sandwich_app");

        mEtEmail = findViewById(R.id.et_email);
        mEtPwd = findViewById(R.id.et_pwd);

        //버튼1: 로그인 버튼 클릭 -> 로그인된 디폴트 화면(0)
        Button button1=findViewById(R.id.btn_login);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //로그인 요청
                String strEmail = mEtEmail.getText().toString();
                String strPwd = mEtPwd.getText().toString();

                mFirebaseAuth.signInWithEmailAndPassword(strEmail,strPwd).addOnCompleteListener(MainActivity01.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            //로그인 성공!!
                            Toast.makeText(MainActivity01.this,"로그인 성공!",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity01.this, MainActivity00.class);
                            startActivity(intent);
                            finish();//현재 activity 파괴
                            
                            
                        }else{
                            Toast.makeText(MainActivity01.this,"로그인 실패..!",Toast.LENGTH_SHORT).show();


                        }
                    }
                });

            }
        });

        //버튼2: 회원가입 버튼 클릭 -> 회원가입 화면(2)
        Button button2=findViewById(R.id.btn_register);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //회원가입화면(activity02)로 이동한다.
                Intent intent=new Intent(MainActivity01.this, MainActivity02.class);
                startActivity(intent);

            }
        });
    }


}