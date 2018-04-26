package com.example.pc.quanlychothuexe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button btnlogin, btnNewACcount;
    EditText use, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnlogin = (Button) findViewById(R.id.btnLogin);
        btnNewACcount = (Button) findViewById(R.id.btnNewAccount);
        use = (EditText) findViewById(R.id.edUseName);
        pass = (EditText) findViewById(R.id.edPass);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserName = use.getText().toString();
                String strPassword = pass.getText().toString();
                if (use.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được bỏ trống tên đăng nhập !", Toast.LENGTH_SHORT).show();
                } else if (pass.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Không được bỏ trống mật khẩu !", Toast.LENGTH_SHORT).show();
                } else {
                    if (strUserName.equalsIgnoreCase("Tuong") &&
                            strPassword.equalsIgnoreCase("Tuong")) {
                        Toast.makeText(getApplicationContext(), "Login successfull", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Login.this, ThongTinKH.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Sai 'User Name' hoac 'Password' !", Toast.LENGTH_SHORT).show();
                    }
                    if (strUserName.equalsIgnoreCase("Hung") &&
                            strPassword.equalsIgnoreCase("Hung")) {
                        Toast.makeText(getApplicationContext(), "Login successfull", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Login.this, ThongTinKH.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Sai 'User Name' hoac 'Password' !", Toast.LENGTH_SHORT).show();
                    }
                    if (strUserName.equalsIgnoreCase("Toai") &&
                            strPassword.equalsIgnoreCase("Toai")) {
                        Toast.makeText(getApplicationContext(), "Login successfull", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Login.this, ThongTinKH.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Sai 'User Name' hoac 'Password' !", Toast.LENGTH_SHORT).show();
                    }
                    if (strUserName.equalsIgnoreCase("Bach") &&
                            strPassword.equalsIgnoreCase("Bach")) {
                        Toast.makeText(getApplicationContext(), "Login successfull", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Login.this, ThongTinKH.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Sai 'User Name' hoac 'Password' !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}
