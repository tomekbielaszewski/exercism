import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

class Acronym {
    private final String acronym;

    Acronym(String phrase) {
        this.acronym = Pattern.compile("[\\s\\-]")
                .splitAsStream(phrase)
                .filter(s -> s.length() > 0)
                .map(s -> s.substring(0, 1))
                .map(String::toUpperCase)
                .collect(joining());
    }

    String getAcronym() {
        return this.acronym;
    }
}
