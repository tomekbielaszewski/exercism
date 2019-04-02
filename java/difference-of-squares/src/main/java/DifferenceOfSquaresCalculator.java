import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        return (int) Math.pow(IntStream.range(1, ++input)
                .sum(), 2);
    }

    int computeSumOfSquaresTo(int input) {
        return IntStream.range(1, ++input)
                .map(i -> i * i)
                .sum();
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
