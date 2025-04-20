package com.example.tobaggiapp;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Home extends Activity {
    int ind = 0;
    int[] images = {
            R.drawable.seoul,
            R.drawable.incheon,
            R.drawable.gangneung,
            R.drawable.daejeon,
            R.drawable.jeonju,
            R.drawable.daegu,
            R.drawable.busan,
            R.drawable.jeju
    };
    String[] descriptions = {
            "📍 서울, 대한민국의 수도이자 최대 도시!",
            "📍 인천, 차이나타운부터 바다까지!",
            "📍 강릉, 커피 향 가득한 바다 도시!",
            "📍 대전, 과학과 예술이 공존하는 중심 도시!",
            "📍 전주, 전통이 살아있는 도시!",
            "📍 대구, 뜨거운 정과 먹거리가 넘치는 거리!",
            "📍 부산, 바다와 시장이 함께하는 여행지!",
            "📍 제주, 자연과 힐링의 섬!"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home);

        ImageView imgV;
        TextView textV;
        Button btnGoogle, btnCalendar, btnRating;

        imgV = findViewById(R.id.imgV);
        textV = findViewById(R.id.textV);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnCalendar = findViewById(R.id.btnCalendar);
        btnRating = findViewById(R.id.btnRating);

        imgV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ind = (ind + 1) % images.length;
                imgV.setImageResource(images[ind]);
                textV.setText(descriptions[ind]);
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() { // 구글 맵 검색하기
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "");
                startActivity(intent);
            }
        });

        btnCalendar.setOnClickListener(new View.OnClickListener() { // 캘린더에 일정 예약하기
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Calendar.class);
                startActivity(intent);
            }
        });

        btnRating.setOnClickListener(new View.OnClickListener() { // 평점 남기기
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Rating.class);
                startActivity(intent);
            }
        });

    }
}
