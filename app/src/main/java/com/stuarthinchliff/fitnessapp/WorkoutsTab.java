package com.stuarthinchliff.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class WorkoutsTab extends Fragment{

    public static final String WORKOUT_ID = "WORKOUT_ID";
    private List<Workout> workouts = WorkoutProvider.workoutList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.workouts_tab, container, false);

        final Context context = getActivity();

        String[] items = getResources().getStringArray(R.array.workouts);
        WorkoutTabAdapter adapter = new WorkoutTabAdapter(context,
                R.layout.exercise_list_item,
                workouts);
        ListView lv = (ListView) rootView.findViewById(R.id.workouts_list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context, StartWorkout.class);
                Workout workout = workouts.get(i);
                intent.putExtra(WORKOUT_ID, workout.getWorkoutID());
                startActivity(intent);
            }
        });
        return rootView;
    }
}
