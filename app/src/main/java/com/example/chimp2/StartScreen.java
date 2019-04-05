package com.example.chimp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class StartScreen extends AppCompatActivity {
    int curType = 0;
    int curNum = 1;
    String typeArr[] = new String[3];

    public void start(View v) {
        Intent startGame = new Intent(this, MainActivity.class);
        if(curType == 0)
            startGame = new Intent(this, MainActivity.class);
        else if(curType == 1)
            startGame = new Intent(this, ProgressActivity.class);
        else if(curType == 2)
            startGame = new Intent(this, ProgressActivity.class);



        startGame.putExtra("total", String.valueOf(curNum));
        startActivity(startGame);
    }

    public void typeNext(View v){
        curType = plusLoop(curType, typeArr.length - 1, 0);
        changeType(curType);
    }

    public void typePrev(View v){
        curType = negLoop(curType, 0, typeArr.length - 1);
        changeType(curType);
    }

    public void numNext(View v){
        curNum = plusLoop(curNum, 16, 1);
        changenum(curNum);
    }

    public void numPrev(View v){
        curNum = negLoop(curNum, 1, 16);
        changenum(curNum);
    }

    public void fillArrs() {
        typeArr[0] = "Standard";
        typeArr[1] = "Progressive";
        typeArr[2] = "Timed";
    }

    public void changeType(int set){
        TextView typeText = (TextView)findViewById(R.id.typeText);
        typeText.setText("Game Type: " + typeArr[set]);
    }

    public void changenum(int set){
        TextView typeNum = (TextView)findViewById(R.id.numText);
        typeNum.setText("Total Numbers: " + String.valueOf(set));
    }

    public int plusLoop(int increase, int max, int reset) {
        if(increase < max){
            ++increase;
            return increase;
        }
        else {
            increase = reset;
            return increase;
        }
    }

    public int negLoop(int decrease, int min, int reset) {
        if(decrease > min){
            --decrease;
            return decrease;
        }
        else {
            decrease = reset;
            return decrease;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        fillArrs();
    }
}