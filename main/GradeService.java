package main;

public class GradeService {
    public static double findAverage(int[] scores) {
        int sum = 0;
        for (int s : scores) {
            sum += s;
        }
        return sum / scores.length;
    }

    public static String getGrade(double avg) {
        if (avg > 90) {
            return "A";
        } else if (avg > 80) {
            return "B";
        } else if (avg > 70) {
            return "C";
        } else {
            return "D";
        }
    }
}