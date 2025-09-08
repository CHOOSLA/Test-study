package main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] raw = {
            "Alice:80,90,100",
            "Bob:85,90,90",
            "Carol:90,90,90"
        };

        List<Student> students = new ArrayList<>();
        for (String line : raw) {
            students.add(ScoreParser.parse(line)); // 브레이크 포인트 추천 위치
        }

        for (Student s : students) {
            double avg = GradeService.findAverage(s.getScores());
            System.out.println(s.getName() + " 평균: " + avg + ", 학점: " + GradeService.getGrade(avg));
        }

        double total = 0;
        for (int i = 0; i < students.size(); i++) {
            total += GradeService.findAverage(students.get(i).getScores());
        }
        System.out.println("전체 평균: " + total / students.size());
    }
}