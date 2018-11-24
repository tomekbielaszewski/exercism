import java.util.Arrays;
import java.util.Optional;

import static java.util.stream.Collectors.joining;

class Proverb {
    private static final String FIRST_PART = "For want of a %s ";
    private static final String SECOND_PART = "the %s was lost.\n";
    private static final String LAST_LINE = "And all for the want of a %s.";

    private String poem;

    Proverb(String[] words) {
        //Nasty non-functional side-effects I'm not proud of
        final String[] first = new String[1];
        final String[] previous = new String[1];
        this.poem = Arrays.stream(words)
                .map(current -> Optional.ofNullable(previous[0])
                        .map((prev) -> String.format(FIRST_PART + SECOND_PART, prev, current))
                        .map((line) -> {
                            previous[0] = current;
                            return line;
                        })
                        .orElseGet(() -> {
                            first[0] = current;
                            previous[0] = current;
                            return "";
                        }))
                .collect(joining()) +
                Optional.ofNullable(first[0])
                        .map((f) -> String.format(LAST_LINE, first[0]))
                        .orElse("");
    }

    String recite() {
        return poem;
    }

}
