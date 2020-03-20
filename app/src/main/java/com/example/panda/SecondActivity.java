package com.example.panda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    Button enterActivityButton;
    EditText UserIDText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        enterActivityButton = (Button) findViewById(R.id.loginButton);
        UserIDText = (EditText) findViewById(R.id.userIdText);
        enterActivityButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String S = UserIDText.getText().toString();
        Intent loginIntent = new Intent( SecondActivity.this, ThirdActivity.class);
        startActivity(loginIntent);

    }
}
