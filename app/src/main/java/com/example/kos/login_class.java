package com.example.kos;


import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;



public class login_class extends AppCompatActivity {

    EditText email;
    EditText password;
    Button btn_login;
    sqllogreg db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        db = new sqllogreg(this);
        initViews();

        TextView register = findViewById(R.id.register);
        register.setOnClickListener(view ->{
            Intent secondActivity = new Intent(login_class.this, register_class.class);
            startActivity(secondActivity);
        });

        btn_login.setOnClickListener(view -> {
                if (validate()) {
                    String Email = email.getText().toString();
                    String Password = password.getText().toString();

                    user currentUser = db.Authenticate(new user(null, null, Email, Password));

                    if (currentUser != null) {
                        Snackbar.make(btn_login, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();
                        String username = currentUser.userName;
                        Intent intent = new Intent(login_class.this, home_class.class);
                        intent.putExtra("Username", username);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Snackbar.make(btn_login, "Failed to log in , please try again", Snackbar.LENGTH_LONG).show();
                    }
                }
        });
    }

    private void initViews() {
        email = (EditText) findViewById(R.id.email_login);
        password = (EditText) findViewById(R.id.password_log);
        btn_login = (Button) findViewById(R.id.btn_login);
    }

    @SuppressWarnings("deprecation")
    public static CharSequence fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        }
        else {
            result = Html.fromHtml(html);
        }
        return result;
    }

    public boolean validate() {
        boolean validuser ;

        String Email = email.getText().toString();
        String Password = password.getText().toString();

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            validuser = false;
            Toast.makeText(getApplication(), "", Toast.LENGTH_LONG).show();
        }
        else {
            validuser = true;
        }

        if (Password.isEmpty()) {
            validuser = false;
            Toast.makeText(getApplication(), "Please enter Password!", Toast.LENGTH_LONG).show();
        }
        else {
            if (Password.length() > 5) {
                validuser = true;
            } else {
                validuser = false;
                Toast.makeText(getApplication(), "Password is too short!", Toast.LENGTH_LONG).show();
            }
        }
        return validuser;
    }
}
