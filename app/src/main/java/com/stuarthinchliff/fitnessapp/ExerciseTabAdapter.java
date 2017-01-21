package com.stuarthinchliff.fitnessapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class ExerciseTabAdapter extends ArrayAdapter<Exercise> {

    private List<Exercise> exercises;

    public ExerciseTabAdapter(Context context, int resource, List<Exercise> objects) {
        super(context, resource, objects);
        exercises = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.exercise_list_item,parent,false);
        }

        Exercise exercise = exercises.get(position);
        
        TextView nameText = (TextView) convertView.findViewById(R.id.exerciseName);
        nameText.setText(exercise.getName());

        TextView desText = (TextView) convertView.findViewById(R.id.exerciseDescription);
        desText.setText(exercise.getDescription());

        return convertView;
    }
}
