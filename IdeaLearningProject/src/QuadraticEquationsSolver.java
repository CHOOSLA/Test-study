
class QuadraticEquationsSolver {

    public static final String NO_ROOTS = "No roots";

    public double discriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public void solve(double a, double b, double c) {
        double d = discriminant(a, b, c);
        if (d < 0) {
            System.out.println(NO_ROOTS);
        } else if (d > 0) {
            // ctrl + T : 할 수 있는 액션 보기
            // cmd + option + V : 변수로 빼기 ( Variable )
            // cmd + option + M : 메소드로 빼기 ( Method )
            // cmd + option + P : 메서든 매개변수로 빼기 ( Parameter )
            extracted(b, d, 2.0 * a);
        } else {
            System.out.println("x = " + ((-b) / (2.0 * a)));
        }

        // cmd + option + L : 코드 스타일 수정
        if (true) {

        }
    }

    private static void extracted(double b, double d, double v) {
        double doubled = v;
        double x1 = (-b + Math.sqrt(d)) / doubled;
        double x2 = (-b - Math.sqrt(d)) / doubled;
        System.out.println("x1 = " + x1 + ", x2 = " + x2);
    }
}