package com.stuarthinchliff.fitnessapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ExerciseDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String exerciseID = getIntent().getStringExtra(ExercisesTab.EXERCISE_ID);
        Exercise exercise = ExerciseProvider.exerciseMap.get(exerciseID);

        setTitle(exercise.getName());

        TextView tvName = (TextView) findViewById(R.id.exerciseDetailName);
        TextView tvDescription = (TextView) findViewById(R.id.exerciseDetailDescription);

        tvName.setText(exercise.getName());
        tvDescription.setText(exercise.getDescription());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
