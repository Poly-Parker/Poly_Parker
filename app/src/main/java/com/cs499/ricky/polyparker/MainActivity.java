package com.cs499.ricky.polyparker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

// Comment for test
/**
 * Created by Ricky on 4/14/2015.
 */
public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = (Button) findViewById(R.id.login);
        final Intent loginIntent = new Intent(this , TabbedActivity.class);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((EditText)findViewById(R.id.userName)).getText().toString();
                String pass     = ((EditText)findViewById(R.id.password)).getText().toString();

                if (username.length() == 0 || pass.length() == 0){
                    Toast.makeText(MainActivity.this, "Empty Field(s)", Toast.LENGTH_LONG).show();
                    return;
                }

                ParseUser.logInInBackground(username, pass, new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            startActivity(loginIntent);
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "Login Failed, Try Again", Toast.LENGTH_LONG).show();
                            return;
                        }
                    }
                });
            }
        });

        Button signUpButton = (Button) findViewById(R.id.signup);
        final Intent signUpIntent = new Intent(this, SignUpActivity.class);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(signUpIntent);
            }
        });

        TextView recover = (TextView) findViewById(R.id.forgotPW);
        final Intent recoverIntent = new Intent(this, RecoverPassword.class);
        recover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(recoverIntent);
            }
        });


    }
}
