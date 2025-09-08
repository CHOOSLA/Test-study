package main;

import java.util.Arrays;

public class Student {
    private final String name;
    private final int[] scores;

    public Student(String name, int[] scores) {
        this.name = name;
        this.scores = Arrays.copyOf(scores, scores.length);
    }

    public String getName() { return name; }
    public int[] getScores() { return Arrays.copyOf(scores, scores.length); }
}