package com.example.businessbuddyv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;

public class MakeCardActivity2 extends AppCompatActivity {

    private TextView c_tv_make_card_two;
    private TextView c_tv_skills;
    private EditText c_et_skill_one;
    private EditText c_et_skill_two;
    private EditText c_et_skill_three;
    private EditText c_et_skill_four;
    private EditText c_et_skill_five;
    private TextView c_tv_bio;
    private EditText c_et_bio;
    private Button c_btn_cancel_make_card_two;
    private Button c_btn_next_make_card_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_card2);

        c_tv_make_card_two = findViewById(R.id.tv_make_card_two);
        c_tv_skills = findViewById(R.id.tv_skills);
        c_et_skill_one = findViewById(R.id.et_skill_one);
        c_et_skill_two = findViewById(R.id.et_skill_two);
        c_et_skill_three = findViewById(R.id.et_skill_three);
        c_et_skill_four = findViewById(R.id.et_skill_four);
        c_et_skill_five = findViewById(R.id.et_skill_five);
        c_tv_bio = findViewById(R.id.tv_bio);
        c_et_bio = findViewById(R.id.et_bio);
        c_btn_cancel_make_card_two = findViewById(R.id.btn_cancel_make_card_two);
        c_btn_next_make_card_two = findViewById(R.id.btn_next_make_card_two);

        Context context = getApplicationContext();
        File cardFile = context.getDir("cards", context.MODE_PRIVATE);

        c_btn_next_make_card_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input_bio = c_et_bio.getText().toString();
                String[] skills = new String[5];
                skills[0] = c_et_skill_one.getText().toString();
                skills[1] = c_et_skill_two.getText().toString();
                skills[2] = c_et_skill_three.getText().toString();
                skills[3] = c_et_skill_four.getText().toString();
                skills[4] = c_et_skill_five.getText().toString();


                CardRecord record = new CardRecord(cardFile.getAbsolutePath());
                record.newCardPartial2(skills, input_bio);

                Intent intent = new Intent(MakeCardActivity2.this, MakeCardActivity3.class);
                startActivity(intent);
            }
        });

        c_btn_cancel_make_card_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MakeCardActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}