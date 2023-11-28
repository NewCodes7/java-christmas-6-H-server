package christmas.constant;

public enum Numbers {
    INITIALIZE_ZERO(0),
    CHRISTMAS_DAY(25),
    WEEK_LENGTH(7);

    private final int value;

    Numbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
