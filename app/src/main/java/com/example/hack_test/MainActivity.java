package com.example.hack_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    /* variable */
    Button bt1, bt2, bt3;
    ImageView food;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /* starting */
        switching();

        /* image 캐스팅 */
        food = (ImageView)findViewById(R.id.cv);

        /* start 버튼 캐스팅 */
        bt1 =(Button)findViewById(R.id.bt1);
        click1 ck1 = new click1();
        bt1.setOnClickListener(ck1);

        /* stop 버튼 캐스팅 */
        bt2 =(Button)findViewById(R.id.bt2);
        click2 ck2 = new click2();
        bt2.setOnClickListener(ck2);

        /* ok 버튼 캐스팅 */
        bt3 =(Button)findViewById(R.id.bt3);
        click3 ck3 = new click3();
        bt3.setOnClickListener(ck3);
    }


    /* button1 :: start */
    class click1 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (flag == false){
                flag = true;
            }
            else if(flag == true)
                flag = true;
        }
    }

    /* button2 :: stop */
    class click2 implements  View.OnClickListener{
        @Override
        public void onClick(View v){
            flag = false;
        }
    }

    /* button3 :: ok */
    class click3 implements  View.OnClickListener{
        @Override
        public void onClick(View v){

            Intent intent = new Intent(MainActivity.this, Result.class);

            intent.putExtra("ResultImage", resultNum);
            startActivity(intent);
        }
    }


    int foodlist[] = {
            R.drawable.bossam,
            R.drawable.budaejjigae,
            R.drawable.chicken,
            R.drawable.curry,
            R.drawable.doenjangstew,
            R.drawable.donburi,
            R.drawable.gopchang,
            R.drawable.hamburger,
            R.drawable.jajangmyeon,
            R.drawable.janchiguksu,
            R.drawable.jjamppong,
            R.drawable.jokbal,
            R.drawable.kimchistew,
            R.drawable.malatang,
            R.drawable.naengmyeon,
            R.drawable.pasta,
            R.drawable.pizza,
            R.drawable.porkbelly,
            R.drawable.porkcutlet,
            R.drawable.ramen,
            R.drawable.ricenoodles,
            R.drawable.sandwich,
            R.drawable.sushi,
            R.drawable.toast,
            R.drawable.tteokbokki,
            R.drawable.udon
    };

    int i = 0;
    static int resultNum = 0;

    void switching(){
        final Handler mhandle = new Handler();
        final Timer timer = new Timer();
        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                mhandle.post(new Runnable() {
                    @Override
                    public void run() {
                        if(flag == true) {
                            resultNum = i;
                            food.setImageResource(foodlist[i++]);
                            if (i == foodlist.length)
                                i = 0;
                        }
                        else if(flag == false){
                            mhandle.removeMessages(0);
                        }
                    }
                });
            }
        };
        timer.schedule(task,0,500);
    }


}
