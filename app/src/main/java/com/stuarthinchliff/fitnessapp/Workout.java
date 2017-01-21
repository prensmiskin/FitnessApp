package com.stuarthinchliff.fitnessapp;

import java.util.List;

public class Workout {
    private String workoutID;
    private String name;
    private String description;
    private List<Exercise> exercises;
    private int rounds;

    public int getRounds() {
        return rounds;
    }

    public String getDescription() {
        return description;
    }

    public String getWorkoutID() {
        return workoutID;
    }

    public String getName() {
        return name;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public Workout(String workoutID, String name, String description, List<Exercise> exercises,
                   int rounds){
        this.name = name;
        this.description = description;
        this.workoutID = workoutID;
        this.exercises = exercises;
        this.rounds = rounds;
    }

}
