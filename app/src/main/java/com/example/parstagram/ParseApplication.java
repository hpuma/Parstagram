package com.example.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    // Register your parse models
    ParseObject.registerSubclass(Post.class);
    Parse.initialize(new Parse.Configuration.Builder(this)
            .applicationId("lNaW4K36HKyjuX5zwRZdngXYyGZ0Ruf9yB0C3ztp")
            .clientKey("QzyA3CsUX4uau6CZreR4u0j1N5hTexSqm1tVlM6W")
            .server("https://parseapi.back4app.com")
            .build()
    );
  }
}
