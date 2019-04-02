class Hamming {
    private final char[] leftStrand;
    private final char[] rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        if(leftStrand.length() != rightStrand.length()) {
            if(rightStrand.isEmpty()) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
            if(leftStrand.isEmpty()) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand.toCharArray();
        this.rightStrand = rightStrand.toCharArray();
    }

    int getHammingDistance() {
        int distance = 0;
        for (int i = 0; i < leftStrand.length; i++) {
            distance += leftStrand[i] == rightStrand[i] ? 0 : 1;
        }
        return distance;
    }

}
