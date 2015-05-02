package com.example.ricky.polyparker;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by Ricky on 4/26/2015.
 */
public class ParseApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this,
                "uDZW6fgxe66aoyM44PhFdb63vL2tBAlV4L0VIOjp",
                "6Tg0ISTCMLiuz0iPJwAtQRR6sn5ellvBkcKZcGq1");

        ParseObject.registerSubclass(LotInfo.class);
    }
}
