package com.example.chimp2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int TOTAL = 15;
    Button buttons[] = new Button[16];
    int nums[] = new int[TOTAL];
    int current = 0;

    public void run(){
        set_nums();
    }

    public void set_nums(){
        fill_rand(nums);

        for(int i = 0; i < TOTAL; i++){
            buttons[nums[i]].setText(String.valueOf(i + 1));
        }
    }

    public void check_guess(int guess){
        if(guess == nums[current]) {
            if(current == 0)
                clear_buttons();
            buttons[guess].setText(String.valueOf("x"));
            buttons[guess].setBackgroundResource(R.drawable.button_background2);
            if(current < TOTAL - 1)
                current++;
        }
        else{
            buttons[guess].setText(String.valueOf("x"));
            buttons[guess].setBackgroundResource(R.drawable.button_background3);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                check_guess(0);
                break;
            case R.id.button2:
                check_guess(1);
                break;
            case R.id.button3:
                check_guess(2);
                break;
            case R.id.button4:
                check_guess(3);
                break;
            case R.id.button5:
                check_guess(4);
                break;
            case R.id.button6:
                check_guess(5);
                break;
            case R.id.button7:
                check_guess(6);
                break;
            case R.id.button8:
                check_guess(7);
                break;
            case R.id.button9:
                check_guess(8);
                break;
            case R.id.button10:
                check_guess(9);
                break;
            case R.id.button11:
                check_guess(10);
                break;
            case R.id.button12:
                check_guess(11);
                break;
            case R.id.button13:
                check_guess(12);
                break;
            case R.id.button14:
                check_guess(13);
                break;
            case R.id.button15:
                check_guess(14);
                break;
            case R.id.button16:
                check_guess(15);
                break;
        }
    }

    /////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initial_buttons();
        clear_buttons();
        run();
    }

    public void initial_buttons(){
        buttons[0] = (Button)findViewById(R.id.button1);
        buttons[1] = (Button)findViewById(R.id.button2);
        buttons[2] = (Button)findViewById(R.id.button3);
        buttons[3] = (Button)findViewById(R.id.button4);
        buttons[4] = (Button)findViewById(R.id.button5);
        buttons[5] = (Button)findViewById(R.id.button6);
        buttons[6] = (Button)findViewById(R.id.button7);
        buttons[7] = (Button)findViewById(R.id.button8);
        buttons[8] = (Button)findViewById(R.id.button9);
        buttons[9] = (Button)findViewById(R.id.button10);
        buttons[10] = (Button)findViewById(R.id.button11);
        buttons[11] = (Button)findViewById(R.id.button12);
        buttons[12] = (Button)findViewById(R.id.button13);
        buttons[13] = (Button)findViewById(R.id.button14);
        buttons[14] = (Button)findViewById(R.id.button15);
        buttons[15] = (Button)findViewById(R.id.button16);

        /*buttons[0].setBackgroundColor((Color.parseColor("#000000")));
        buttons[1].setBackgroundColor((Color.parseColor("#000000")));
        buttons[2].setBackgroundColor((Color.parseColor("#000000")));
        buttons[3].setBackgroundColor((Color.parseColor("#000000")));
        buttons[4].setBackgroundColor((Color.parseColor("#000000")));
        buttons[5].setBackgroundColor((Color.parseColor("#000000")));
        buttons[6].setBackgroundColor((Color.parseColor("#000000")));
        buttons[7].setBackgroundColor((Color.parseColor("#000000")));
        buttons[8].setBackgroundColor((Color.parseColor("#000000")));
        buttons[9].setBackgroundColor((Color.parseColor("#000000")));
        buttons[10].setBackgroundColor((Color.parseColor("#000000")));
        buttons[11].setBackgroundColor((Color.parseColor("#000000")));
        buttons[12].setBackgroundColor((Color.parseColor("#000000")));
        buttons[13].setBackgroundColor((Color.parseColor("#000000")));
        buttons[14].setBackgroundColor((Color.parseColor("#000000")));
        buttons[15].setBackgroundColor((Color.parseColor("#000000")));*/

        buttons[0].setOnClickListener(this);
        buttons[1].setOnClickListener(this);
        buttons[2].setOnClickListener(this);
        buttons[3].setOnClickListener(this);
        buttons[4].setOnClickListener(this);
        buttons[5].setOnClickListener(this);
        buttons[6].setOnClickListener(this);
        buttons[7].setOnClickListener(this);
        buttons[8].setOnClickListener(this);
        buttons[9].setOnClickListener(this);
        buttons[10].setOnClickListener(this);
        buttons[11].setOnClickListener(this);
        buttons[12].setOnClickListener(this);
        buttons[13].setOnClickListener(this);
        buttons[14].setOnClickListener(this);
        buttons[15].setOnClickListener(this);
    }

    public boolean check_array(int check[], int num){
        for(int i = 0; i < check.length; ++i){
            if(check[i] == num)
                return true;
        }

        return false;
    }

    public void clear_buttons(){
        for(int i = 0; i < 16; ++i){
            buttons[i].setText(" ");
        }
    }

    public void fill_rand(int nums[]){
        Random rand = new Random();
        int num = 0;

        boolean duplicate;
        duplicate = check_array(nums, num);

        for(int i = 0; i < nums.length; ++i){
            num = rand.nextInt(16);

            duplicate = check_array(nums, num);
            if(!duplicate)
                nums[i] = num;
            else
                --i;
        }
    }
}
