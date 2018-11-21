import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

class Acronym {
    private final String phrase;

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String getAcronym() {
        return Pattern.compile("[\\s\\-]")
                .splitAsStream(phrase)
                .filter(this::notEmptyString)
                .map(this::firstLetter)
                .map(String::toUpperCase)
                .collect(joining());
    }

    private String firstLetter(String s) {
        return s.substring(0, 1);
    }

    private boolean notEmptyString(String s) {
        return s.length() > 0;
    }

}
