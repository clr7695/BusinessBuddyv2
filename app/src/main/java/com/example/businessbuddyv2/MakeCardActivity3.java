package com.example.businessbuddyv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.util.HashMap;

public class MakeCardActivity3 extends AppCompatActivity {

    private CheckBox c_cb_masters;
    private CheckBox c_cb_doctorate;
    private CheckBox c_cb_bachelors;
    private EditText c_et_associates;
    private EditText c_et_masters;
    private EditText c_et_doctorate;
    private EditText c_et_bachelors;
    private EditText c_et_high_school;
    private TextView c_tv_education_two;
    private TextView c_tv_education;
    private CheckBox c_cb_high_school;
    private CheckBox c_cb_associates;
    private TextView c_tv_make_card_three;
    private Button c_btn_cancel_make_card_three;
    private Button c_btn_finish_make_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_card3);

        c_cb_masters = findViewById(R.id.cb_masters);
        c_cb_doctorate = findViewById(R.id.cb_doctorate);
        c_cb_bachelors = findViewById(R.id.cb_bachelors);
        c_et_associates = findViewById(R.id.et_associates);
        c_et_masters = findViewById(R.id.et_masters);
        c_et_doctorate = findViewById(R.id.et_doctorate);
        c_et_bachelors = findViewById(R.id.et_bachelors);
        c_et_high_school = findViewById(R.id.et_high_school);
        c_tv_education_two = findViewById(R.id.tv_education_two);
        c_tv_education = findViewById(R.id.tv_education);
        c_cb_high_school = findViewById(R.id.cb_high_school);
        c_cb_associates = findViewById(R.id.cb_associates);
        c_tv_make_card_three = findViewById(R.id.tv_make_card_three);
        c_btn_cancel_make_card_three = findViewById(R.id.btn_cancel_make_card_three);
        c_btn_finish_make_card = findViewById(R.id.btn_finish_make_card);

        Context context = getApplicationContext();
        File cardFile = context.getDir("cards", context.MODE_PRIVATE);

        c_btn_finish_make_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, String> education = new HashMap<>();

                if(c_cb_high_school.isChecked()) {
                    education.put("High School", c_et_high_school.getText().toString());
                } else {
                    education.put("High School", "N/A");
                }
                if(c_cb_associates.isChecked()) {
                    education.put("Associate's Degree", c_et_associates.getText().toString());
                } else {
                    education.put("Associate's Degree", "N/A");
                }
                if(c_cb_bachelors.isChecked()) {
                    education.put("Bachelor's Degree", c_et_bachelors.getText().toString());
                } else {
                    education.put("Bachelor's Degree", "N/A");
                }
                if(c_cb_masters.isChecked()) {
                    education.put("Master's Degree", c_et_masters.getText().toString());
                } else {
                    education.put("Master's Degree", "N/A");
                }
                if(c_cb_doctorate.isChecked()) {
                    education.put("Doctorate", c_et_doctorate.getText().toString());
                } else {
                    education.put("Doctorate", "N/A");
                }


                CardRecord record = new CardRecord(cardFile.getAbsolutePath());
                record.finishCard(education);

                Intent intent = new Intent(MakeCardActivity3.this, MainActivity.class);
                startActivity(intent);

            }
        });

        c_btn_cancel_make_card_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MakeCardActivity3.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}