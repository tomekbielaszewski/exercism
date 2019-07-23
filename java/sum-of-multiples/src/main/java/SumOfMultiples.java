import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SumOfMultiples {
    private final int number;
    private final int[] set;

    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    int getSum() {
        return Arrays.stream(set)
                .filter(this::nonZero)
                .mapToObj(divider -> IntStream.range(0, number)
                        .filter(i -> i % divider == 0)
                        .boxed()
                )
                .flatMap(Function.identity())
                .collect(Collectors.toSet())
                .stream()
                .reduce(0, Integer::sum);
    }

    private boolean nonZero(int i) {
        return i != 0;
    }

}
