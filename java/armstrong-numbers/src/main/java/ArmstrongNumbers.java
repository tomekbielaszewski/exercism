class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        int length = String.valueOf(numberToCheck).length();
        return String.valueOf(numberToCheck)
                .chars()
                .map(Character::getNumericValue)
                .reduce(0, (acc, i) -> acc + (int) Math.pow(i, length)) == numberToCheck;
    }
}
