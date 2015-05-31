package com.cs499.ricky.polyparker;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

/**
 * Created by Ricky on 5/31/2015.
 */
public class RecoverPassword extends Activity {

    @Override protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);

        final Button recoverButton = (Button) findViewById(R.id.recover);
        recoverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ((TextView)findViewById(R.id.email)).getText().toString();

                if (email.length() == 0) {
                    Toast.makeText(RecoverPassword.this, "Empty E-mail Field", Toast.LENGTH_LONG).show();
                    return;
                }

                ParseUser.requestPasswordResetInBackground(email, new RequestPasswordResetCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(RecoverPassword.this, "An email was successfully sent with reset instructions.", Toast.LENGTH_LONG).show();
                            recoverButton.setEnabled(false);
                            finish();
                            return;
                        } else {
                            Toast.makeText(RecoverPassword.this, e.getMessage(), Toast.LENGTH_LONG).show();
                            Log.i("ParseUser", e.getMessage());
                            return;
                        }
                    }
                });
            }
        });
    }
}
