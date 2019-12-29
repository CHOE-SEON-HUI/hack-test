package com.example.hack_test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {

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

    int imgNum;
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        /* 인텐드 get */
        Intent intent = getIntent();
        imgNum = intent.getIntExtra("ResultImage",0);

        /* image 캐스팅 */
        ImageView resultImage = (ImageView)findViewById(R.id.cv2);
        resultImage.setImageResource(foodlist[imgNum]);

        /* text 캐스팅 */
        TextView tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setText(getName());

    }

    public String getName(){

        String name = "";
        switch (imgNum){
            case 0 : name = "보쌈"; break;
            case 1 : name = "부대찌개"; break;
            case 2 : name = "치킨"; break;
            case 3 : name = "커리"; break;
            case 4 : name = "된장찌개"; break;
            case 5 : name = "이 시국에 돈부리"; break;
            case 6 : name = "곱창"; break;
            case 7 : name = "햄버거"; break;
            case 8 : name = "짜장면"; break;
            case 9 : name = "잔치국수"; break;
            case 10 : name = "짬뽕"; break;
            case 11 : name = "족발"; break;
            case 12 : name = "김치찌개"; break;
            case 13 : name = "마라탕"; break;
            case 14 : name = "냉면"; break;
            case 15: name = "파스타"; break;
            case 16 : name = "피자"; break;
            case 17 : name = "삼겹살"; break;
            case 18 : name = "돈까스"; break;
            case 19 : name = "이 시국에 라멘"; break;
            case 20 : name = "쌀국수"; break;
            case 21 : name = "샌드위치"; break;
            case 22 : name = "초밥"; break;
            case 23 : name = "토스트"; break;
            case 24 : name = "떡볶이"; break;
            case 25 : name = "우동"; break;
        }
        return name;
    }

}
