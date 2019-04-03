import java.util.*;
import java.util.stream.Collectors;

class ProteinTranslator {
    private static final Map<String, Set<String>> PROTEIN_TRANSLATIONS = new HashMap<String, Set<String>>() {{
        put("Methionine", new HashSet<>(Arrays.asList("AUG")));
        put("Phenylalanine", new HashSet<>(Arrays.asList("UUU", "UUC")));
        put("Leucine", new HashSet<>(Arrays.asList("UUA", "UUG")));
        put("Serine", new HashSet<>(Arrays.asList("UCU", "UCC", "UCA", "UCG")));
        put("Tyrosine", new HashSet<>(Arrays.asList("UAU", "UAC")));
        put("Cysteine", new HashSet<>(Arrays.asList("UGU", "UGC")));
        put("Tryptophan", new HashSet<>(Arrays.asList("UGG")));
        put("STOP", new HashSet<>(Arrays.asList("UAA", "UAG", "UGA")));
    }};

    List<String> translate(String rnaSequence) {
        List<String> proteins = toCodons(rnaSequence)
                .stream()
                .map(this::toProtein)
                .collect(Collectors.toList());
        List<String> output = new ArrayList<>();
        for (String protein : proteins) {
            if("STOP".equals(protein)) break;
            output.add(protein);
        }
        return output;
    }

    private List<String> toCodons(String rna) {
        ArrayList<String> codons = new ArrayList<>();
        for (int i = 0; i < rna.length(); i += 3) {
            codons.add(rna.substring(i, Math.min(i + 3, rna.length())));
        }
        return codons;
    }

    private String toProtein(String rna) {
        return PROTEIN_TRANSLATIONS.entrySet()
                .stream()
                .filter(entry -> entry.getValue().contains(rna))
                .findAny()
                .map(Map.Entry::getKey)
                .orElseThrow(RuntimeException::new);
    }
}
