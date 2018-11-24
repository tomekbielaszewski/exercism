import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Yacht {
    private final Integer score;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.score = Optional.of(
                IntStream.of(dice)
                        .mapToObj(String::valueOf)
                        .sorted()
                        .collect(Collectors.joining()))
                .filter(yachtCategory::validate)
                .map(yachtCategory::score)
                .orElse(0);
    }

    int score() {
        return score;
    }
}
