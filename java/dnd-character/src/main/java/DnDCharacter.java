class DnDCharacter {
    private int strength = 3;
    private int dexterity = 3;
    private int constitution = 3;
    private int intelligence = 3;
    private int wisdom = 3;
    private int charisma = 3;

    int ability() {
        return 3;
    }

    int modifier(int input) {
        return Math.floorDiv(input - 10, 2);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return 10 + modifier(this.constitution);
    }
}
