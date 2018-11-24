import java.util.function.Function;
import java.util.function.Predicate;

enum YachtCategory {
    YACHT(
            (dice) -> dice.chars().distinct().count() == 1,
            (dice) -> 50
    ),
    ONES(
            (dice) -> dice.contains("1"),
            (dice) -> (int) dice.chars().filter(d -> d == (int) '1').count()
    ),
    TWOS(
            (dice) -> dice.contains("2"),
            (dice) -> (int) dice.chars().filter(d -> d == (int) '2').count() * 2
    ),
    THREES(
            (dice) -> dice.contains("3"),
            (dice) -> (int) dice.chars().filter(d -> d == (int) '3').count() * 3
    ),
    FOURS(
            (dice) -> dice.contains("4"),
            (dice) -> (int) dice.chars().filter(d -> d == (int) '4').count() * 4
    ),
    FIVES(
            (dice) -> dice.contains("5"),
            (dice) -> (int) dice.chars().filter(d -> d == (int) '5').count() * 5
    ),
    SIXES(
            (dice) -> dice.contains("6"),
            (dice) -> (int) dice.chars().filter(d -> d == (int) '6').count() * 6
    ),
    FULL_HOUSE(
            (dice) -> dice.chars().distinct().count() == 2 && dice.chars().filter(d -> d == dice.charAt(2)).count() == 3,
            (dice) -> dice.chars().map(Character::getNumericValue).sum()
    ),
    FOUR_OF_A_KIND(
            (dice) -> dice.chars().distinct().count() <= 2 && dice.chars().filter(d -> d == dice.charAt(2)).count() >= 4,
            (dice) -> dice.chars().filter(d -> d == dice.charAt(2)).limit(4).map(Character::getNumericValue).sum()
    ),
    LITTLE_STRAIGHT(
            (dice) -> dice.equals("12345"),
            (dice) -> 30
    ),
    BIG_STRAIGHT(
            (dice) -> dice.equals("23456"),
            (dice) -> 30
    ),
    CHOICE(
            (dice) -> true,
            (dice) -> dice.chars().map(Character::getNumericValue).sum()
    );

    private final Predicate<String> validator;
    private final Function<String, Integer> score;

    YachtCategory(Predicate<String> validator, Function<String, Integer> score) {
        this.validator = validator;
        this.score = score;
    }

    public boolean validate(String dice) {
        return validator.test(dice);
    }

    public int score(String dice) {
        return score.apply(dice);
    }
}
