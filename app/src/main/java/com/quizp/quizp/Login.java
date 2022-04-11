package com.quizp.quizp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

private LinearLayout loginbtn;
private EditText etemail,etpassword;
private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


            }







    public void rgstrclck(View view) {
        Intent intt= new Intent(Login.this,Register.class);
        startActivity(intt);
    }

    public void guestclk(View view) {
        Intent inter= new Intent(Login.this,Dashboard.class);
        startActivity(inter);
    }

    public void forgtpswd(View view) {
        Intent intra=new Intent(Login.this,PasswordReset.class);
        startActivity(intra);
    }

}