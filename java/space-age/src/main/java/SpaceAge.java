class SpaceAge {
    private final static double EARTH_YEAR = 60 * 60 * 24 * 365.25;
    private final static double MERCURY_YEAR = EARTH_YEAR * 0.2408467;
    private final static double VENUS_YEAR = EARTH_YEAR * 0.61519726;
    private final static double MARS_YEAR = EARTH_YEAR * 1.8808158;
    private final static double JUPITER_YEAR = EARTH_YEAR * 11.862615;
    private final static double SATURN_YEAR = EARTH_YEAR * 29.447498;
    private final static double URANUS_YEAR = EARTH_YEAR * 84.016846;
    private final static double NEPTUNE_YEAR = EARTH_YEAR * 164.79132;

    private final double seconds;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double onEarth() {
        return calculateSpaceAge(EARTH_YEAR);
    }

    double onMercury() {
        return calculateSpaceAge(MERCURY_YEAR);
    }

    double onVenus() {
        return calculateSpaceAge(VENUS_YEAR);
    }

    double onMars() {
        return calculateSpaceAge(MARS_YEAR);
    }

    double onJupiter() {
        return calculateSpaceAge(JUPITER_YEAR);
    }

    double onSaturn() {
        return calculateSpaceAge(SATURN_YEAR);
    }

    double onUranus() {
        return calculateSpaceAge(URANUS_YEAR);
    }

    double onNeptune() {
        return calculateSpaceAge(NEPTUNE_YEAR);
    }

    private double calculateSpaceAge(double yearLengthInSeconds) {
        return this.seconds / yearLengthInSeconds;
    }
}
