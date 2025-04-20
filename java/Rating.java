package com.example.tobaggiapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Rating extends Activity {

    private String selectedRegion = null;
    private TextView textV;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating);

        Button btnBack, btnRati1, btnRati2, btnRati3, btnRatiFinish;

        btnBack = findViewById(R.id.btnBack);
        btnRati1 = findViewById(R.id.btnRati1); // 서울
        btnRati2 = findViewById(R.id.btnRati2); // 부산
        btnRati3 = findViewById(R.id.btnRati3); // 제주
        btnRatiFinish = findViewById(R.id.btnRatiFinish);
        textV = findViewById(R.id.textV);
        ratingBar = findViewById(R.id.rati);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rating.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

        btnRati1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedRegion = "서울";
                textV.setText("서울에 대한 평점을 남겨주세요!");
                textV.setTextColor(Color.parseColor("#328074"));
            }
        });

        btnRati2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedRegion = "부산";
                textV.setText("부산에 대한 평점을 남겨주세요!");
                textV.setTextColor(Color.parseColor("#328074"));
            }
        });

        btnRati3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedRegion = "제주";
                textV.setText("제주에 대한 평점을 남겨주세요!");
                textV.setTextColor(Color.parseColor("#328074"));
            }
        });

        btnRatiFinish.setOnClickListener(v -> {
            if (selectedRegion == null) {
                Toast.makeText(Rating.this, "지역을 먼저 선택해주세요.", Toast.LENGTH_SHORT).show();
            } else {
                float rating = ratingBar.getRating();
                if (rating == 0) {
                    Toast.makeText(Rating.this, "별점을 선택해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Rating.this,
                            selectedRegion + " 평가 완료! ⭐ " + rating + "점",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
