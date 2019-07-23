import java.util.Optional;

class LuhnValidator {

    boolean isValid(String candidate) {
        return Optional.ofNullable(candidate)
                .map(this::removeWhitespaces)
                .filter(this::validCharacters)
                .filter(this::validLength)
                .map(this::doubleEverySecondInteger)
                .map(this::sumDigits)
                .map(this::isDivisibleByTen)
                .orElse(Boolean.FALSE);
    }

    private String removeWhitespaces(String s) {
        return s.replaceAll(" ", "");
    }

    private boolean validCharacters(String s) {
        return s.chars()
                .filter(Character::isDigit)
                .count() == s.length();
    }

    private boolean validLength(String s) {
        return s.length() > 1;
    }

    private String doubleEverySecondInteger(String s) {
        char[] chars = s.toCharArray();
        for (int i = chars.length - 2; i >= 0; i -= 2) {
            char ch = chars[i];
            int num = Character.getNumericValue(ch) * 2;
            num = num > 9 ? num - 9 : num;
            chars[i] = Character.forDigit(num, 10);
        }
        return new String(chars);
    }

    private Integer sumDigits(String s) {
        return s.chars()
                .mapToObj(i -> (char) i)
                .map(String::valueOf)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }

    private boolean isDivisibleByTen(Integer number) {
        return number % 10 == 0;
    }

}
