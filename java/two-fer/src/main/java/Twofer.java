import java.util.Optional;

class Twofer {
    private static final String PATTERN = "One for %s, one for me.";

    String twofer(String name) {
        return String.format(PATTERN, Optional.ofNullable(name)
                .orElse("you"));
    }
}
