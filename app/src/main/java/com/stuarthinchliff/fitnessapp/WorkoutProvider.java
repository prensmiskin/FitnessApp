package com.stuarthinchliff.fitnessapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class WorkoutProvider {
    public static List<Workout> workoutList = new ArrayList<>();
    public static Map<String, Workout> workoutMap = new HashMap<>();

    static {
        addWorkout("1", "5 Minute Core",
                "A brutal five minute workout.",
                ExerciseProvider.getWorkout(new String[]{"situp", "rest","pushup","rest","pullup"}),
                1);
        addWorkout("2", "7 Minute Abs",
                "Create the abs you want.",
                ExerciseProvider.getWorkout(new String[]{"situp", "rest", "situp"}),
                1);
    }

    private static void addWorkout(String id, String name,
                                    String description, List<Exercise> exercises, int rounds) {
        Workout ex = new Workout(id,name,description,exercises,rounds);
        workoutList.add(ex);
        workoutMap.put(id,ex);
    }
}
