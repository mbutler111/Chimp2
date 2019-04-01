package com.example.chimp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class startScreen extends AppCompatActivity {

    EditText total;

    public void start(View v){
        Intent startGame = new Intent(this, MainActivity.class);
        String sendMsg = total.getText().toString();
        startGame.putExtra("total", sendMsg);
        startActivity(startGame);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        total = (EditText)findViewById(R.id.totalNum);
    }
}
