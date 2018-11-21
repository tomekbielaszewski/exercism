import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class RaindropConverter {
    private final List<RaindropWord> DICTIONARY = Arrays.asList(
            new RaindropWord(3, "Pling"),
            new RaindropWord(5, "Plang"),
            new RaindropWord(7, "Plong")
    );

    String convert(int number) {
        return DICTIONARY.stream()
                .filter(wordMatch(number))
                .map(RaindropWord::getWord)
                .reduce((acc, word) -> acc + word)
                .orElse(String.valueOf(number));
    }

    private Predicate<? super RaindropWord> wordMatch(int number) {
        return (t) -> number % t.factor == 0;
    }

    class RaindropWord {
        int factor;
        String word;

        public RaindropWord(int factor, String word) {
            this.factor = factor;
            this.word = word;
        }

        public String getWord() {
            return word;
        }
    }
}
