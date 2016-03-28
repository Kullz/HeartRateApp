package com.android.apps.heartrateapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DecisionActivity extends AppCompatActivity {

    private ImageButton brainButton;
    private ImageButton distillButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);

        brainButton = (ImageButton) findViewById(R.id.brain_button);
        brainButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(DecisionActivity.this, MainActivity.class);
                startActivity(i);

            }
        });

        distillButton = (ImageButton) findViewById(R.id.distill_button);
        distillButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(DecisionActivity.this, DistillingActivity.class);
                startActivity(i);

            }
        });
    }
}
