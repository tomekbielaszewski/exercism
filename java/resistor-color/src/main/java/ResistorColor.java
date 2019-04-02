import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

class ResistorColor {
    int colorCode(String color) {
        return Optional.ofNullable(color)
                .map(String::toUpperCase)
                .map(ColorValue::valueOf)
                .map(ColorValue::getValue)
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
        BLACK(0),
        BROWN(1),
        RED(2),
        ORANGE(3),
        YELLOW(4),
        GREEN(5),
        BLUE(6),
        VIOLET(7),
        GREY(8),
        WHITE(9);

        final int value;

        ColorValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
