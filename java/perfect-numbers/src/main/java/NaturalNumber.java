import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

class NaturalNumber {
    private final int number;

    public NaturalNumber(int number) {
        this.number = Optional.ofNullable(number)
        .filter(i -> i > 0)
        .orElseThrow(() -> new IllegalArgumentException("You must supply a natural number (positive integer)"));
    }

    public Classification getClassification() {
        return IntStream.range(1, this.number)
                .filter(i -> number % i == 0)
                .boxed()
                .reduce((i, j) -> i + j)
                .map(this::classify)
                .orElse(Classification.DEFICIENT);
    }

    private Classification classify(int aliquotSum) {
        return Arrays.stream(Classification.values())
                .filter(classification -> classification.classifies(this.number, aliquotSum))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("This shouldn't happen"));
    }
}
