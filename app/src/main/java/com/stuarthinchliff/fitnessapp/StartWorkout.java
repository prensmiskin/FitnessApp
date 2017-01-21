package com.stuarthinchliff.fitnessapp;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.StringTokenizer;

public class StartWorkout extends AppCompatActivity {

    private TextView timer;

    private boolean buttonState = true;
    private long start_time;
    private long workoutTimeElapsed = 0;
    private int exerciseNumber = 0;

    private Handler handler = new Handler();

    private Workout workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_workout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        timer = (TextView) findViewById(R.id.workout_timer);

        String workoutID = getIntent().getStringExtra(WorkoutsTab.WORKOUT_ID);
        workout = WorkoutProvider.workoutMap.get(workoutID);

        setTitle(workout.getName());

        ExerciseStartWorkoutAdapter adapter = new ExerciseStartWorkoutAdapter(this,
                R.layout.workout_list_item,
                workout.getExercises());

        ListView lv = (ListView) findViewById(R.id.start_workout_list);
        lv.setAdapter(adapter);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.workout_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttonState){
                    Snackbar.make(view, "Workout started!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    start_time = System.currentTimeMillis();

                    handler.postDelayed(runnable, 10L);
                    buttonState = false;
                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                            android.R.drawable.ic_media_pause));

                    ListView lv = (ListView) findViewById(R.id.start_workout_list);
                    View v = lv.getChildAt(exerciseNumber);
                    v.setBackgroundColor(Color.CYAN);
                } else{
                    Snackbar.make(view, "Workout paused!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    handler.removeCallbacks(runnable);
                    buttonState = true;
                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                            android.R.drawable.ic_media_play));
                }

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(!buttonState) {
                long millis = (System.currentTimeMillis() - start_time);
                long seconds = millis / 1000;
                timer.setText(String.format("%02d:%02d", seconds / 60, seconds % 60));
                int exTime = workout.getExercises().get(exerciseNumber).getDefaultTime();
                if(seconds - workoutTimeElapsed >= exTime){
                    workoutTimeElapsed += exTime;
                    exerciseNumber++;
                    ListView lv = (ListView) findViewById(R.id.start_workout_list);
                    if (workout.getExercises().size() == exerciseNumber) {
                        return;
                    }

                    View v = lv.getChildAt(exerciseNumber);
                    int col = v.getSolidColor();
                    v.setBackgroundColor(Color.CYAN);
                    View v2 = lv.getChildAt(exerciseNumber-1);
                    v2.setBackgroundColor(col);

                }
            }
            handler.postDelayed(runnable,10L);
        }
    };

}
