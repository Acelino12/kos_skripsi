package com.example.kos;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class register_class extends AppCompatActivity {

    Button back;
    EditText username;
    EditText email;
    EditText password, password2;
    Button btn_register;
    sqllogreg db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);

        db = new sqllogreg(this);
        initViews();

        back = findViewById(R.id.back_regis);
        back.setOnClickListener(view -> {
            Intent secondActivity = new Intent(register_class.this, login_class.class);
            startActivity(secondActivity);
        });

        btn_register.setOnClickListener(view -> {
                if (validate()) {
                    String UserName = username.getText().toString();
                    String Email = email.getText().toString();
                    String Password = password.getText().toString();

                    if (!db.isEmailExists(Email)) {
                        db.addUser(new user(null, UserName, Email, Password));
                        Snackbar.make(btn_register, "User created successfully! Please Login ", Snackbar.LENGTH_LONG).show();
                        new Handler().postDelayed(this::finish, Snackbar.LENGTH_LONG);
                        Intent intent = new Intent(register_class.this, login_class.class);
                        startActivity(intent);
                    }
                    else {
                        Snackbar.make(btn_register, "User already exists with same email ", Snackbar.LENGTH_LONG).show();
                    }
                }

        });
    }

    private void initViews() {
        username = (EditText) findViewById(R.id.username_regis);
        email = (EditText) findViewById(R.id.email_regis);
        password = (EditText) findViewById(R.id.password_reg);
        password2 = (EditText) findViewById(R.id.password_con);
        btn_register = (Button) findViewById(R.id.btn_daftar);
    }

    public boolean validate() {
        boolean valid = false;

        String UserName = username.getText().toString();
        String Email = email.getText().toString();
        String Password = password.getText().toString();
        String Password2 = password2.getText().toString();

        if (UserName.isEmpty()) {
            valid = false;
            Toast.makeText(getApplication(), "Please enter valid username!", Toast.LENGTH_LONG).show();
        }
        else {
            if (UserName.length() > 4) {
                if (UserName.length() < 15) {
                    valid = true;
                }
                else {
                    valid = false;
                    Toast.makeText(getApplication(), "Username is too long!", Toast.LENGTH_LONG).show();
                }
            }
            else {
                valid = false;
                Toast.makeText(getApplication(), "Username is too short!", Toast.LENGTH_LONG).show();
            }
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            Toast.makeText(getApplication(), "", Toast.LENGTH_LONG).show();
        }
        else {
            valid = true;
        }

        if (Password.isEmpty()) {
            valid = false;
            Toast.makeText(getApplication(), "Please enter Password!", Toast.LENGTH_LONG).show();
        }
        else {
            if (Password.length() > 5) {
                valid = true;
            }
            else {
                valid = false;
                Toast.makeText(getApplication(), "Password is too short!", Toast.LENGTH_LONG).show();
            }
        }

        if (Password2.isEmpty()) {
            valid = false;
            Toast.makeText(getApplication(), "Please enter Confirm Password!", Toast.LENGTH_LONG).show();
        }
        else {
            if(!Password.equals(Password2)){
                Toast.makeText(register_class.this,"Password Not matching",Toast.LENGTH_SHORT).show();
                valid=false;
            }
            else {
                valid = true;
            }
        }
        return valid;
    }
}