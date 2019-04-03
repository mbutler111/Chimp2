package com.example.chimp2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int TOTAL;
    int gameType;
    int streak = 0;
    int current = 1;
    int[] rands;
    boolean end = false;
    boolean win = false;
    gamePiece[] pieces = new gamePiece[16];
    TextView streakText;

    public void runStandard(){
        clearButtons();
        resetPieces();
        fillRand(rands, 0, 15);
        setNums(pieces, rands);
    }

    public void checkGuess(gamePiece checkPiece){
        if(checkPiece.num == current && end == false){
            correctGuess(checkPiece);
        }
        else if (end == false){
            wrongGuess(checkPiece);
        }
    }

    public void correctGuess(gamePiece guessPiece){
        if(current == 1)
            clearButtons();

        guessPiece.button.setBackgroundResource(R.drawable.button_background2);
        ++current;

        if(current == TOTAL + 1)
            winRound();
    }

    public void wrongGuess(gamePiece guessPiece){
        guessPiece.button.setBackgroundResource(R.drawable.button_background3);
        guessPiece.button.setText("X");
        end = true;
        win = false;
        streak = 0;
        showButtons();
    }

    public void winRound(){
        end = true;
        win = true;
        ++streak;
        streakText.setText("Streak: " + String.valueOf(streak));
        showButtons();
    }

    public void setNums(gamePiece setArray[], int numArray[]){
        for(int i = 0; i < numArray.length; ++i){
            setArray[numArray[i]].button.setText(String.valueOf(i+1));
            setArray[numArray[i]].num = i+1;
        }
    }

    public void fillRand(int filler[], int min, int max){
        Random rand = new Random();
        int num = 0;
        boolean duplicate;

        for(int i = 0; i < filler.length; ++i){
            filler[i] = -1;
        }

        for(int i = 0; i < filler.length; ++i){
            num = min + rand.nextInt(max-min+1);

            duplicate = checkArray(filler, num);
            if(!duplicate)
                filler[i] = num;
            else
                --i;
        }
    }

    public boolean checkArray(int check[], int num){
        for(int i = 0; i < check.length; ++i){
            if(check[i] == num)
                return true;
        }

        return false;
    }

    public void retry(View v){
        if(win == false)
            streak = 0;
        win = false;
        streakText.setText("Streak: " + String.valueOf(streak));
        current = 1;
        end = false;
        runStandard();
    }

    public void goBack(View v){
        Intent startScreen = new Intent(this, StartScreen.class);
        startActivity(startScreen);
    }

    public void initialPieces(){
        streakText = (TextView)findViewById(R.id.streakText);

        for(int i = 0; i < 16; ++i){
            gamePiece setter = new gamePiece();
            pieces[i] = setter;
        }

        pieces[0].button = findViewById(R.id.button1);
        pieces[1].button = findViewById(R.id.button2);
        pieces[2].button = findViewById(R.id.button3);
        pieces[3].button = findViewById(R.id.button4);
        pieces[4].button = findViewById(R.id.button5);
        pieces[5].button = findViewById(R.id.button6);
        pieces[6].button = findViewById(R.id.button7);
        pieces[7].button = findViewById(R.id.button8);
        pieces[8].button = findViewById(R.id.button9);
        pieces[9].button = findViewById(R.id.button10);
        pieces[10].button = findViewById(R.id.button11);
        pieces[11].button = findViewById(R.id.button12);
        pieces[12].button = findViewById(R.id.button13);
        pieces[13].button = findViewById(R.id.button14);
        pieces[14].button = findViewById(R.id.button15);
        pieces[15].button = findViewById(R.id.button16);

        pieces[0].button.setOnClickListener(this);
        pieces[1].button.setOnClickListener(this);
        pieces[2].button.setOnClickListener(this);
        pieces[3].button.setOnClickListener(this);
        pieces[4].button.setOnClickListener(this);
        pieces[5].button.setOnClickListener(this);
        pieces[6].button.setOnClickListener(this);
        pieces[7].button.setOnClickListener(this);
        pieces[8].button.setOnClickListener(this);
        pieces[9].button.setOnClickListener(this);
        pieces[10].button.setOnClickListener(this);
        pieces[11].button.setOnClickListener(this);
        pieces[12].button.setOnClickListener(this);
        pieces[13].button.setOnClickListener(this);
        pieces[14].button.setOnClickListener(this);
        pieces[15].button.setOnClickListener(this);

        clearButtons();
    }

    public void showButtons(){
        for(int i = 0; i < 16; ++i){
            if(pieces[i].num != -1)
                pieces[i].button.setText(String.valueOf(pieces[i].num));
        }
    }

    public void clearButtons(){
        for(int i = 0; i < 16; i++){
            pieces[i].button.setText(" ");
            pieces[i].button.setBackgroundResource(R.drawable.button_background);
        }
    }

    public void resetPieces(){
        for(int i = 0; i < 16; ++i){
            pieces[i].num = -1;
        }
    }

    public void receiveData(){
        Bundle startData = getIntent().getExtras();
        String receive = startData.getString("total");
        int totes = Integer.parseInt(receive);
        TOTAL = totes;
        receive = startData.getString("type");
        int gotes = Integer.parseInt(receive);
        gameType = gotes;
        rands = new int[TOTAL];
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                checkGuess(pieces[0]);
                break;
            case R.id.button2:
                checkGuess(pieces[1]);
                break;
            case R.id.button3:
                checkGuess(pieces[2]);
                break;
            case R.id.button4:
                checkGuess(pieces[3]);
                break;
            case R.id.button5:
                checkGuess(pieces[4]);
                break;
            case R.id.button6:
                checkGuess(pieces[5]);
                break;
            case R.id.button7:
                checkGuess(pieces[6]);
                break;
            case R.id.button8:
                checkGuess(pieces[7]);
                break;
            case R.id.button9:
                checkGuess(pieces[8]);
                break;
            case R.id.button10:
                checkGuess(pieces[9]);
                break;
            case R.id.button11:
                checkGuess(pieces[10]);
                break;
            case R.id.button12:
                checkGuess(pieces[11]);
                break;
            case R.id.button13:
                checkGuess(pieces[12]);
                break;
            case R.id.button14:
                checkGuess(pieces[13]);
                break;
            case R.id.button15:
                checkGuess(pieces[14]);
                break;
            case R.id.button16:
                checkGuess(pieces[15]);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiveData();
        initialPieces();
        if(gameType == 0){
            runStandard();
        }else if(gameType == 1){

        }
        else if(gameType == 2){

        }
    }
}
