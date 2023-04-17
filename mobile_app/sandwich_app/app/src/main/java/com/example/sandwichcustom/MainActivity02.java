package com.example.sandwichcustom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity02 extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth; //파이어베이스 인증
    private DatabaseReference mDatabaseRef; //실시간 데이터베이스
    private EditText mEtEmail, mEtPwd;// 회원가입 입력필드
    private Button mBtnRegister;// 회원가입 버튼



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02_join);//2.회원가입 화면

        //가입 버튼 누르기 -> 가입 축하 화면(3) 으로
        Button button1=findViewById(R.id.join_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent=new Intent(MainActivity02.this, MainActivity03.class);//?
                //startActivity(intent);

                mFirebaseAuth = FirebaseAuth.getInstance();
                mDatabaseRef = FirebaseDatabase.getInstance().getReference("sandwich_app");

                mEtEmail = findViewById(R.id.et_email);
                mEtPwd = findViewById(R.id.et_pwd);
                mBtnRegister = findViewById(R.id.join_button);

                mBtnRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //회원가입 처리 시작
                        String strEmail = mEtEmail.getText().toString();
                        String strPwd = mEtPwd.getText().toString();

                        //Firebase Auth 진행
                        mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(MainActivity02.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                //회원가입이 성공했을때
                                if (task.isSuccessful()){
                                    FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();//가져온다 현재의 유저를

                                    UserAccount account = new UserAccount();
                                    account.setIdToken(firebaseUser.getUid());//getUid는 고유값이다.정도만 알면 된다.
                                    account.setEmailId(firebaseUser.getEmail());
                                    account.setPassword(strPwd);

                                    //setValue : database에 insert (삽입) 행위
                                    mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);

                                    Toast.makeText(MainActivity02.this, "회원가입에 성공하셨습니다.", Toast.LENGTH_SHORT).show();

                                }else{//회원가입에 실패했을때
                                    Toast.makeText(MainActivity02.this, "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                    }
                });



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