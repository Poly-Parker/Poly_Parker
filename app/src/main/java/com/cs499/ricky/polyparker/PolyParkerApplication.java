package com.cs499.ricky.polyparker;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricky on 4/26/2015.
 */
public class PolyParkerApplication extends Application {

        @Override
        public void onCreate() {
            super.onCreate();

            Parse.enableLocalDatastore(this);
            Parse.initialize(this,
                    "uDZW6fgxe66aoyM44PhFdb63vL2tBAlV4L0VIOjp",
                    "6Tg0ISTCMLiuz0iPJwAtQRR6sn5ellvBkcKZcGq1");

            ParseObject.registerSubclass(LotInfo.class);
        }
}
