package com.example.businessbuddyv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MakeCard extends AppCompatActivity {

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
    }
}