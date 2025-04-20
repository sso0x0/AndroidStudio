package com.example.tobaggiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Calendar extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.calendar);
        setTitle("캘린더에 일정 예약하기");

        EditText edtTitle, edtHour, edtMin;
        DatePicker calendarV;
        Button btnBack, btnSubmit;
        TextView txtResult;
        LinearLayout layoutTitle, layoutTime;

        edtTitle = findViewById(R.id.edtTitle);
        edtHour = findViewById(R.id.edtHour);
        edtMin = findViewById(R.id.edtMin);
        calendarV = findViewById(R.id.calendarV);
        btnBack = findViewById(R.id.btnBack);
        btnSubmit = findViewById(R.id.btnSubmit);
        txtResult = findViewById(R.id.txtResult);
        layoutTitle = findViewById(R.id.layoutTitle);
        layoutTime = findViewById(R.id.layoutTime);


        btnBack.setOnClickListener(new View.OnClickListener() { // 뒤로 가기
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calendar.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() { // 예약
            @Override
            public void onClick(View v) {
                String title = edtTitle.getText().toString().trim();
                String hour = edtHour.getText().toString().trim();
                String min = edtMin.getText().toString().trim();

                int year = calendarV.getYear();
                int month = calendarV.getMonth() + 1;
                int day = calendarV.getDayOfMonth();

                if (title.isEmpty()) {
                    Toast.makeText(Calendar.this, "일정 제목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (hour.isEmpty() || min.isEmpty()) {
                    Toast.makeText(Calendar.this, "시간, 분을 모두 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int hourInt = Integer.parseInt(hour);
                        int minInt = Integer.parseInt(min);

                        if (hourInt < 0 || hourInt > 23 || minInt < 0 || minInt > 59) {
                            Toast.makeText(Calendar.this, "시간은 0~23시, 분은 0~59분 사이여야 해요.", Toast.LENGTH_SHORT).show();
                        } else {
                            String result = "* 날짜 : " + year + "년 " + month + "월 " + day + "일 \n* 시간 : " + hourInt + "시 " + minInt + "분\n* 제목 : " + title;
                            layoutTitle.setVisibility(View.GONE);
                            layoutTime.setVisibility(View.GONE);
                            txtResult.setText("예약이 완료되었습니다.\n" + result);
                            txtResult.setVisibility(View.VISIBLE);
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(Calendar.this, "시간과 분은 숫자로 입력해주세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
