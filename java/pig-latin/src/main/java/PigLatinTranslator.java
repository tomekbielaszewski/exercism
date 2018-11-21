import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.joining;

public class PigLatinTranslator {
    private static final Map<String, Function<String, String>> RULES = new LinkedHashMap<String, Function<String, String>>() {{
        put("ch[a-z]+", consonantClusterRule("ch"));
        put("sch[a-z]+", consonantClusterRule("sch"));
        put("qu[a-z]+", consonantClusterRule("qu"));
        put("thr[a-z]+", consonantClusterRule("thr"));
        put("th[a-z]+", consonantClusterRule("th"));
        put("rh[a-z]+", consonantClusterRule("rh"));
        put("[^aeiouxy]qu[a-z]+", consonantRuleWithFirstLetter("qu"));
        put("[aeiou][a-z]+", PigLatinTranslator::vowelRule);
        put("xr[a-z]+", PigLatinTranslator::vowelRule);
        put("yt[a-z]+", PigLatinTranslator::vowelRule);
        put("[^aeiouxy][a-z]+", PigLatinTranslator::consonantRule);
        put("x[a-z&&[^r]]+", PigLatinTranslator::consonantRule);
        put("y[a-z&&[^t]]+", PigLatinTranslator::consonantRule);
    }};

    private static String vowelRule(String word) {
        return word + "ay";
    }

    private static String consonantRule(String word) {
        return word.substring(1) + word.substring(0, 1) + "ay";
    }

    private static Function<String, String> consonantClusterRule(String consonantCluster) {
        return (word) -> word.substring(consonantCluster.length()) + consonantCluster + "ay";
    }

    private static Function<String, String> consonantRuleWithFirstLetter(String consonantCluster) {
        return (word) -> word.substring(consonantCluster.length()+1) + word.charAt(0) + consonantCluster + "ay";
    }

    public String translate(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(String::toLowerCase)
                .map(this::translateWord)
                .collect(joining(" "));
    }

    private String translateWord(String word) {
        return RULES.keySet()
                .stream()
                .filter(word::matches)
                .map(pattern -> RULES.get(pattern).apply(word))
                .findFirst().orElseThrow(RuntimeException::new);
    }
}
