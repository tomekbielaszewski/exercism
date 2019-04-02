import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

class ResistorColor {
    int colorCode(String color) {
        return Optional.ofNullable(color)
                .map(String::toUpperCase)
                .map(ColorValue::valueOf)
                .map(Enum::ordinal)
                .orElseThrow(() -> new IllegalArgumentException("Unsupported color provided: " + color));
    }

    String[] colors() {
        return Arrays.stream(ColorValue.values())
                .map(Enum::name)
                .map(String::toLowerCase)
                .collect(Collectors.toList())
                .toArray(new String[]{});
    }

    private enum ColorValue {
        BLACK,
        BROWN,
        RED,
        ORANGE,
        YELLOW,
        GREEN,
        BLUE,
        VIOLET,
        GREY,
        WHITE
    }
}
