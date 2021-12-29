package com.example.xiago;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, mobile, pwd, cfmPwd;
    Button signup, signin;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        mobile  = findViewById(R.id.mobileNo);
        pwd = findViewById(R.id.password);
        cfmPwd  = findViewById(R.id.cfmPwd);
        signup = findViewById(R.id.signUpBtn);
        signin = findViewById(R.id.loginBtn);
        DB = new DatabaseHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String mobileNo = mobile.getText().toString();
                String password = pwd.getText().toString();
                String cfmPassword = cfmPwd.getText().toString();

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(mobileNo) || TextUtils.isEmpty(password) || TextUtils.isEmpty(cfmPassword))
                    Toast.makeText(MainActivity.this, "All Fields Required", Toast.LENGTH_SHORT).show();
                else {
                    if (password.equals(cfmPassword)) {
                        Boolean checkUser = DB.checkUsername(user);
                        if (checkUser == false) {
                            Boolean insert = DB.insertData(user, mobileNo, password, cfmPassword);
                            if (insert == true) {
                                Toast.makeText(MainActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Register Failed", Toast.LENGTH_SHORT).show();
                            }
                        }  else{
                            Toast.makeText(MainActivity.this, "User already Exist", Toast.LENGTH_SHORT).show();
                        }
                    } else{
                        Toast.makeText(MainActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}