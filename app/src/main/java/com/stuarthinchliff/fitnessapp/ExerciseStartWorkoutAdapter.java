package com.stuarthinchliff.fitnessapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;


public class ExerciseStartWorkoutAdapter extends ArrayAdapter<Exercise>  {

    private List<Exercise> exercises;

    public ExerciseStartWorkoutAdapter(Context context, int resource, List<Exercise> objects) {
        super(context, resource, objects);
        exercises = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.workout_list_item,parent,false);
        }

        Exercise exercise = exercises.get(position);

        TextView nameText = (TextView) convertView.findViewById(R.id.exercise_text);
        nameText.setText(exercise.getName());

        TextView timeText = (TextView) convertView.findViewById(R.id.exercise_time);
        timeText.setText(String.format("%02d:%02d", exercise.getDefaultTime()/60,
                exercise.getDefaultTime() % 60));

        return convertView;
    }
}

