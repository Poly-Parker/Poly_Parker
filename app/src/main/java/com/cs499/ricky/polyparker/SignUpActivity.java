package com.cs499.ricky.polyparker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by Ricky on 5/30/2015.
 */
public class SignUpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button signUpButton = (Button) findViewById(R.id.signup);
        final Intent loginIntent = new Intent(this, TabbedActivity.class);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (((TextView)findViewById(R.id.password)).getText().toString().length() == 0 ||
                        ((TextView)findViewById(R.id.passwordConfirm)).getText().toString().length() == 0 ||
                        ((TextView)findViewById(R.id.userName)).getText().toString().length() == 0 ||
                        ((TextView)findViewById(R.id.email)).getText().toString().length() == 0 ) {

                    Toast.makeText(SignUpActivity.this, "Empty Field(s)", Toast.LENGTH_LONG).show();
                    return;
                }

                String pw1 = ((TextView)findViewById(R.id.password)).getText().toString();
                String pw2 = ((TextView)findViewById(R.id.passwordConfirm)).getText().toString();

                if (!pw1.equals(pw2)){
                    Toast.makeText(SignUpActivity.this, "Password mismatch!", Toast.LENGTH_LONG).show();
                }
                else {
                    ParseUser newUser = new ParseUser();
                    newUser.setUsername(((TextView)findViewById(R.id.userName)).getText().toString());
                    newUser.setPassword(pw1);
                    newUser.setEmail(((TextView)findViewById(R.id.email)).getText().toString());

                    newUser.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(SignUpActivity.this, "Sign Up Successful", Toast.LENGTH_LONG).show();
                                startActivity(loginIntent);
                                Log.i("ParseUser", "SignUp Successful");
                                finish();
                            } else {
                                Toast.makeText(SignUpActivity.this, "Error, Retry Later", Toast.LENGTH_LONG).show();
                                Log.i("ParseUser", e.toString());
                                return;
                            }
                        }
                    });
                }
            }
        });

    }
}
