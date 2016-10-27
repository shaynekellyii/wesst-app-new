package com.skelly.mywesst.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.skelly.mywesst.R;
import com.skelly.mywesst.activities.MainActivity;

/**
 * Created by skelly on 10/16/16.
 */

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button btLogin;
    private Button btSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        checkIfLoggedIn();
        setViews();
        setLoginListener();
        setSignupListener();
    }

    private void checkIfLoggedIn() {
        if (ParseUser.getCurrentUser() != null &&
                !ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void setViews() {
        setContentView(R.layout.activity_login);
        etEmail = (EditText)findViewById(R.id.email_text);
        etPassword = (EditText)findViewById(R.id.password_text);
        btLogin = (Button)findViewById(R.id.login_button);
        btSignup = (Button)findViewById(R.id.signup_button);
    }

    private void setLoginListener() {
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                ParseUser.logInInBackground(etEmail.getText().toString(),
                        etPassword.getText().toString(), new LogInCallback() {
                            @Override
                            public void done(ParseUser user, ParseException e) {
                                if (user != null) {
                                    Intent intent = new Intent(LoginActivity.this,
                                            MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else {
                                    Snackbar.make(v, "Incorrect username or password",
                                            Snackbar.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    private void setSignupListener() {
        btSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                ParseUser user = new ParseUser();
                user.setUsername(etEmail.getText().toString());
                user.setPassword(etPassword.getText().toString());
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Snackbar.make(v, "User account created", Snackbar.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Snackbar.make(v, "Failed to create user account", Snackbar.LENGTH_SHORT)
                                    .show();
                        }
                    }
                });
            }
        });
    }
}
