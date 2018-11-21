import java.util.List;
import java.util.stream.Collectors;

public class Anagram {
    private final String tokenPattern;

    public Anagram(String string) {
        this.tokenPattern = anagramToken(string);
    }

    public List<String> match(List<String> possibleAnagrams) {
        return possibleAnagrams.stream()
                .filter(this::matches)
                .collect(Collectors.toList());
    }

    private boolean matches(String possibleAnagram) {
        return this.tokenPattern.equals(anagramToken(possibleAnagram));
    }

    private String anagramToken(String toTokenize) {
        return sortedAscii(decapitalizeFirst(toTokenize));
    }

    private String sortedAscii(String string) {
        return string
                .chars()
                .mapToObj(c -> (char) c)
                .filter(i -> i != ' ')
                .sorted()
                .map(Object::toString)
                .reduce((s1, s2) -> s1 + s2)
                .orElse(string);
    }

    private String decapitalizeFirst(String toCapitalize) {
        return toCapitalize.substring(0,1).toLowerCase() +
                toCapitalize.substring(1);
    }
}
