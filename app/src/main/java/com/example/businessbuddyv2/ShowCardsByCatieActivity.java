package com.example.businessbuddyv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;

public class ShowCardsByCatieActivity extends AppCompatActivity {

    private TextView c_tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cards_by_catie);

        c_tv_show = findViewById(R.id.tv_show);

        Context context = getApplicationContext();
        File cardFile = context.getDir("cards", context.MODE_PRIVATE);

        CardRecord record = new CardRecord(cardFile.getAbsolutePath());

        c_tv_show.setText(record.getString());
    }
}