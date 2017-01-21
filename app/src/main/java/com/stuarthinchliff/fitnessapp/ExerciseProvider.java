package com.stuarthinchliff.fitnessapp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExerciseProvider {
    public static List<Exercise> exerciseList = new ArrayList<>();
    public static Map<String, Exercise> exerciseMap = new HashMap<>();

    static {
        addExercise("pushup", "Pushups",
                "A push-up (or press-up) is a common calisthenics " +
                        "exercise performed in a prone position by " +
                        "raising and lowering the body using the arms.",
                5);

        addExercise("situp", "Situps",
                "The sit-up (or curl-up) is an abdominal endurance " +
                        "training exercise commonly performed to " +
                        "strengthen and tone the abdominal muscles.",
                10);

        addExercise("rest", "Rest",
                "Relax.",
                5);

        addExercise("squat", "Squat",
                "Squats are considered a vital exercise for " +
                        "increasing the strength and size of the " +
                        "legs and buttocks, as well as developing " +
                        "core strength.",
                5);

        addExercise("pullup", "Pullups",
                "A pull-up is an upper-body compound pulling exercise.",
                5);
    }

    private static void addExercise(String id, String name,
                                    String description, int time) {
        Exercise ex = new Exercise(id,name,description,time);
        exerciseList.add(ex);
        exerciseMap.put(id,ex);
    }

    public static List<Exercise> getWorkout(String[] ids) {
        List<Exercise> workoutList = new ArrayList<>();
        for(String id: ids){
            for(Exercise ex: exerciseList){
                if(ex.getExerciseID().contains(id)){
                    workoutList.add(ex);
                }
            }
        }
        return workoutList;

    }
}
