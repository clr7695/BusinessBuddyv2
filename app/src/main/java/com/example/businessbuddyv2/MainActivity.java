package com.example.businessbuddyv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private TextView c_tv_welcome;
    private Button c_btn_show_my_cards;
    private Button c_btn_scan_a_card;
    private Button c_btn_make_a_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c_tv_welcome = findViewById(R.id.tv_welcome);
        c_btn_show_my_cards = findViewById(R.id.btn_show_my_cards);
        c_btn_scan_a_card = findViewById(R.id.btn_scan_a_card);
        c_btn_make_a_card = findViewById(R.id.btn_make_a_card);

        c_btn_make_a_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MakeCardActivity.class);
                startActivity(intent);
            }
        });
    }
}