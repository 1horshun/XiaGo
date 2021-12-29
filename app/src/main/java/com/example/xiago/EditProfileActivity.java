package com.example.xiago;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditProfileActivity extends AppCompatActivity {

    EditText username, mobile, pwd, cfmPwd;
    Button update, delete;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        username = findViewById(R.id.username);
        mobile = findViewById(R.id.mobile);
        pwd = findViewById(R.id.pwd);
        cfmPwd = findViewById(R.id.cfmPwd);
        update = findViewById(R.id.updateBtn);
        delete = findViewById(R.id.deleteBtn);
        DB = new DatabaseHelper(this);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String mobileNo = mobile.getText().toString();
                String password = pwd.getText().toString();
                String cfmPassword = cfmPwd.getText().toString();

                Boolean checkupdatedata = DB.updateData(user,mobileNo, password, cfmPassword);
                if(checkupdatedata == true)
                    Toast.makeText(EditProfileActivity.this,"Profile Updated",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(EditProfileActivity.this,"Profile Not Updated",Toast.LENGTH_SHORT).show();

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                Boolean checkdeletedata = DB.deleteData(user);
                if(checkdeletedata == true){
                    Toast.makeText(EditProfileActivity.this,"User Deleted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(EditProfileActivity.this,"User Not Deleted",Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}