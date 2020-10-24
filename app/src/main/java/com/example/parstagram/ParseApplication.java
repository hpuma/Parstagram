package com.example.parstagram;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    Parse.initialize(new Parse.Configuration.Builder(this)
            .applicationId("lNaW4K36HKyjuX5zwRZdngXYyGZ0Ruf9yB0C3ztp")
            .clientKey("QzyA3CsUX4uau6CZreR4u0j1N5hTexSqm1tVlM6W")
            .server("https://parseapi.back4app.com")
            .build()
    );
  }
}
