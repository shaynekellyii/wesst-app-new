package com.skelly.mywesst;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.interceptors.ParseLogInterceptor;
import com.skelly.mywesst.stream.Post;

/**
 * Created by skelly on 10/16/16.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        Parse.enableLocalDatastore(this);

        // Register any ParseObject subclass. Must be done before calling Parse.initialize()
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("G0OYmfAMuI4ORbtWssrYWrwSfEqZbpxafRA8Mo2b")
                .clientKey("Ihk6kg7wyEHOvn914tYJw0ArgYzkzbrHp6TtZVNq")
                .addNetworkInterceptor(new ParseLogInterceptor()).build());
    }
}
