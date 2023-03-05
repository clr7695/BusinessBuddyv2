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

public class MakeCardActivity extends AppCompatActivity {

    private TextView c_tv_make_card;
    private TextView c_tv_first_name;
    private TextView c_tv_email;
    private TextView c_tv_company;
    private TextView c_tv_last_name;
    private TextView c_tv_pronouns;
    private EditText c_et_first_name;
    private EditText c_et_last_name;
    private EditText c_et_email;
    private EditText c_et_company;
    private EditText c_et_other_pronoun;
    private CheckBox c_cb_he_him;
    private CheckBox c_cb_she_her;
    private CheckBox c_cb_they_them;
    private CheckBox c_cb_other_pronoun;
    private Button c_btn_cancel_make_card;
    private Button c_btn_next_make_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_card);

        c_tv_make_card = findViewById(R.id.tv_make_card);
        c_tv_first_name = findViewById(R.id.tv_first_name);
        c_tv_email = findViewById(R.id.tv_email);
        c_tv_company = findViewById(R.id.tv_company);
        c_tv_last_name = findViewById(R.id.tv_last_name);
        c_tv_pronouns = findViewById(R.id.tv_pronouns);
        c_et_first_name = findViewById(R.id.et_first_name);
        c_et_last_name = findViewById(R.id.et_last_name);
        c_et_email = findViewById(R.id.et_email);
        c_et_company = findViewById(R.id.et_company);
        c_et_other_pronoun = findViewById(R.id.et_other_pronoun);
        c_cb_he_him = findViewById(R.id.cb_he_him);
        c_cb_she_her = findViewById(R.id.cb_she_her);
        c_cb_they_them = findViewById(R.id.cb_they_them);
        c_cb_other_pronoun = findViewById(R.id.cb_other_pronoun);
        c_btn_cancel_make_card = findViewById(R.id.btn_cancel_make_card);
        c_btn_next_make_card = findViewById(R.id.btn_next_make_card);

        Context context = getApplicationContext();
        File cardFile = context.getDir("cards", context.MODE_PRIVATE);

        c_btn_next_make_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input_first_name = c_et_first_name.getText().toString();
                String input_last_name = c_et_last_name.getText().toString();
                String input_email = c_et_email.getText().toString();
                String input_company = c_et_company.getText().toString();
                String[] input_pronouns = new String[4];

                //get pronouns and add them to pronouns array
                int current_index = 0;
                if(c_cb_he_him.isChecked()) {
                    input_pronouns[current_index] = "He/Him";
                    current_index++;
                }
                if(c_cb_she_her.isChecked()) {
                    input_pronouns[current_index] = "She/Her";
                    current_index++;
                }
                if(c_cb_they_them.isChecked()) {
                    input_pronouns[current_index] = "They/Them";
                    current_index++;
                }
                if(c_cb_other_pronoun.isChecked()) {
                    input_pronouns[current_index] = c_et_other_pronoun.getText().toString();
                    current_index++;
                }

                BusinessCard newCard = new BusinessCard(input_first_name, input_last_name, input_pronouns, input_email, input_company, true, cardFile.getAbsolutePath());


            }
        });

        c_btn_cancel_make_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MakeCardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}