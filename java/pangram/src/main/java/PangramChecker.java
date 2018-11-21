public class PangramChecker {

    public boolean isPangram(String input) {
        input = input.toLowerCase()
                .replaceAll(" ", "")
                .replaceAll("[^a-z]+", "");
        return input.matches("[a-z]+") &&
                input.chars().distinct().count() == 26;
    }

}
