package com.haphap.sosialmediaapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haphap.sosialmediaapp.R;

public class SearchResultActivity extends AppCompatActivity {
    private LinearLayout layoutResult;
    private TextView tvName, tvResult;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        layoutResult = findViewById(R.id.layout_result);
        tvName = findViewById(R.id.tv_name);
        tvResult = findViewById(R.id.tv_result);

        name = getIntent().getStringExtra("NAME");

        if (name == null) {
            layoutResult.setVisibility(View.GONE);
            tvResult.setVisibility(View.VISIBLE);
        } else {
            tvName.setText(name);
            tvResult.setVisibility(View.GONE);
            layoutResult.setVisibility(View.VISIBLE);
        }
    }
}
