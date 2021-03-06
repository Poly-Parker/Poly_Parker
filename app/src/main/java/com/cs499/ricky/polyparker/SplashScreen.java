package com.cs499.ricky.polyparker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.parse.GetCallback;
import com.parse.ParseSession;
import com.parse.ParseUser;

/**
 * Created by Ricky on 5/6/2015.
 */
public class SplashScreen extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                Intent intent;
                if ( ParseUser.getCurrentUser() == null) {
                    intent = new Intent(SplashScreen.this, MainActivity.class);
                }
                else {
                    intent = new Intent(SplashScreen.this, TabbedActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
