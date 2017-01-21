package com.stuarthinchliff.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class ExercisesTab extends Fragment {

    public static final String EXERCISE_ID = "EXERCISE_ID";
    private List<Exercise> exercises = ExerciseProvider.exerciseList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.exercises_tab, container, false);
        Context context = getActivity();

        //String[] items = getResources().getStringArray(R.array.exercises);
        ExerciseTabAdapter adapter = new ExerciseTabAdapter(getActivity(),
                R.layout.exercise_list_item,
                exercises);
        ListView lv = (ListView) rootView.findViewById(R.id.exercise_list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getActivity(), ExerciseDetails.class);
                Exercise exercise = exercises.get(i);
                intent.putExtra(EXERCISE_ID, exercise.getExerciseID());
                startActivity(intent);
            }
        });

        return rootView;
    }


}
