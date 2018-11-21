public class PangramChecker {
    private final static int LETTERS_IN_ALPHABET = 26;

    public boolean isPangram(String input) {
        input = input.toLowerCase()
                .replaceAll(" ", "")
                .replaceAll("[^a-z]+", "");
        return input.matches("[a-z]+") &&
                input.chars().distinct().count() == LETTERS_IN_ALPHABET;
    }

}
