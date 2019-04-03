import java.util.function.BiPredicate;

enum Classification {
    DEFICIENT((number, aliquotSum) -> aliquotSum < number),
    PERFECT((number, aliquotSum) -> aliquotSum.equals(number)),
    ABUNDANT((number, aliquotSum) -> aliquotSum > number);

    private final BiPredicate<Integer, Integer> classificationPredicate;

    Classification(BiPredicate<Integer, Integer> classificationPredicate) {
        this.classificationPredicate = classificationPredicate;
    }

    public boolean classifies(int number, int aliquotSum) {
        return this.classificationPredicate.test(number, aliquotSum);
    }
}
