class IsogramChecker {

    boolean isIsogram(String phrase) {
        String token = phrase.chars()
                .filter(this::invalidCharacters)
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .reduce((acc, c) -> acc + c)
                .orElse("")
                .toLowerCase();
        return token.chars().distinct().count() == token.length();
    }

    private boolean invalidCharacters(int character) {
        return character != ' ' && character != '-';
    }

}
