package com.example.parstagram;
import androidx.appcompat.app.AppCompatActivity;
import com.parse.ParseException;
import android.widget.EditText;
import com.parse.LogInCallback;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;
import com.parse.ParseUser;
import android.os.Bundle;
import android.view.View;
import android.util.Log;


public class LoginActivity extends AppCompatActivity {
  public static final String TAG = "LoginActivity";
  private EditText etUsername;
  private EditText etPassword;
  private Button btnLogin;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    // If the user is already logged in, go into the main activity
    if (ParseUser.getCurrentUser() != null){
      goMainActivity();
    }
    etUsername = findViewById(R.id.etUsername);
    etPassword = findViewById(R.id.etPassword);
    btnLogin = findViewById(R.id.btnLogin);
    btnLogin.setOnClickListener(new View.OnClickListener(){

    // Handle login button
    @Override
    public void onClick(View v) {
      Log.i(TAG, "Clicked login button");
      String username = etUsername.getText().toString();
      String password = etPassword.getText().toString();
      loginUser(username, password);
    }

    private void loginUser(String username, String password) {
      Log.i(TAG, "Logining in User" + username);
      // TODO
      ParseUser.logInInBackground(username, password, new LogInCallback() {
        @Override
        public void done(ParseUser user, ParseException e) {
          if (e != null){
            Log.e(TAG, "Issue with login", e);
            Toast.makeText(LoginActivity.this, "Issue with Login", Toast.LENGTH_SHORT).show();
            return;
          }
          goMainActivity();
          Toast.makeText(LoginActivity.this, "Success!", Toast.LENGTH_SHORT).show();
        }
      });
    }
    });
  }

  private void goMainActivity() {
    Intent i = new Intent(this, MainActivity.class);
    startActivity(i);
    finish();
  }
}