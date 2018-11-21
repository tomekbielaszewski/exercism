class RnaTranscription {

    String transcribe(String dnaStrand) {
        return dnaStrand.chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .map(dna -> Transcription.valueOf(dna).rna)
                .reduce((acc, rna) -> acc + rna)
                .orElse("");
    }

    enum Transcription {
        G("C"),
        C("G"),
        T("A"),
        A("U");

        final String rna;

        Transcription(String rna) {
            this.rna = rna;
        }
    }
}
