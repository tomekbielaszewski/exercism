class ReverseString {

    String reverse(String inputString) {
        return inputString.chars()
                .mapToObj(c -> (char) c)
                .map(Object::toString)
                .reduce((s1, s2) -> s2 + s1)
                .orElse(inputString);
    }
  
}