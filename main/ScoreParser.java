package main;

public class ScoreParser {
    public static Student parse(String line) {
        String[] parts = line.split(":");
        String name = parts[0].trim();
        String scoresPart = parts[1].trim();
        String[] tokens = scoresPart.split(",");
        int[] scores = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) { // ⚠️ 오류: <= 사용 (ArrayIndexOutOfBounds 발생)
            scores[i] = Integer.parseInt(tokens[i].trim());
        }
        return new Student(name, scores);
    }
}