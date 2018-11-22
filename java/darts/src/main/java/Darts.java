import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

class Darts {
    private final Map<Predicate<Double>, Integer> SCORE_RULES = new HashMap<Predicate<Double>, Integer>() {{
        put((distance) -> distance > 10, 0);
        put((distance) -> distance <= 10 && distance > 5, 1);
        put((distance) -> distance <= 5 && distance > 1, 5);
        put((distance) -> distance <= 1, 10);
    }};
    private final Integer score;

    Darts(double x, double y) {
        double distance = calculateDistanceFromCenter(x, y);
        this.score = calculateScore(distance);
    }

    int score() {
        return score;
    }

    private double calculateDistanceFromCenter(double x, double y) {
        return Math.sqrt(x*x + y*y);
    }

    private Integer calculateScore(double distance) {
        return SCORE_RULES.keySet().stream()
                .filter(rule -> rule.test(distance))
                .findFirst()
                .map(SCORE_RULES::get)
                .orElseThrow(RuntimeException::new);
    }
}
