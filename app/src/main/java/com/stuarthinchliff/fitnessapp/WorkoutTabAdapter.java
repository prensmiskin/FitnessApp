package com.stuarthinchliff.fitnessapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class WorkoutTabAdapter extends ArrayAdapter<Workout> {

    private List<Workout> workouts;

    public WorkoutTabAdapter(Context context, int resource, List<Workout> objects) {
        super(context, resource, objects);
        workouts = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.exercise_list_item,parent,false);
        }

        Workout workout = workouts.get(position);
        
        TextView nameText = (TextView) convertView.findViewById(R.id.exerciseName);
        nameText.setText(workout.getName());

        TextView desText = (TextView) convertView.findViewById(R.id.exerciseDescription);
        desText.setText(workout.getDescription());

        return convertView;
    }
}
