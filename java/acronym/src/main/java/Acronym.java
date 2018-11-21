import java.util.Arrays;

class Acronym {
    private final String phrase;

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String getAcronym() {
        return Arrays.stream(phrase.split("[\\s\\-]"))
                .filter(s -> s.length() > 0)
                .map(s -> s.substring(0,1))
                .map(String::toUpperCase)
                .reduce((acc, str) -> acc + str)
                .orElse("");
    }

}
