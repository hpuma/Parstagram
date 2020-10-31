package com.example.parstagram;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.ParseException;
import android.graphics.Bitmap;
import android.widget.EditText;
import com.parse.SaveCallback;
import android.os.Environment;
import com.parse.FindCallback;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;
import com.parse.ParseQuery;
import com.parse.ParseFile;
import com.parse.ParseUser;
import android.view.View;
import android.os.Bundle;
import android.util.Log;
import android.net.Uri;
import java.util.List;
import java.io.File;


public class MainActivity extends AppCompatActivity {
  public static final String TAG = "MainActivity";

  private BottomNavigationView bottomNavigationView;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    bottomNavigationView = findViewById(R.id.bottomNavigation);

    bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment;
        switch (menuItem.getItemId()) {
          case R.id.action_home:
            Toast.makeText(MainActivity.this, "Home!", Toast.LENGTH_SHORT).show();
            break;
          case R.id.action_compose:
            Toast.makeText(MainActivity.this, "Compose!", Toast.LENGTH_SHORT).show();
            break;
          case R.id.action_profile:
          default:
            Toast.makeText(MainActivity.this, "Profile!", Toast.LENGTH_SHORT).show();
            break;
        }
        return true;
      }
    });



  }

}
