package com.stuarthinchliff.fitnessapp;

public class Exercise {
    private String exerciseID;
    private String name;
    private String description;
    private int defaultTime;


    public int getDefaultTime() {
        return defaultTime;
    }

    public String getDescription() {
        return description;
    }

    public String getExerciseID() {
        return exerciseID;
    }

    public String getName() {
        return name;
    }

    public Exercise(String exerciseID, String name, String description, int defaultTime){
        this.defaultTime = defaultTime;
        this.name = name;
        this.description = description;
        this.exerciseID = exerciseID;
    }
}
