package christmas.constant.event;

public enum EventNumbers {
    MAX_TOTAL_ORDER_LIMIT(20),
    MIN_ORDER_LIMIT(1),
    D_DAY_MIN_DISCOUNT(1000),
    D_DAY_INCREMENT_AMOUNT(100),
    SPECIAL_DISCOUNT(1000),
    SPECIAL_REFERENCE_DAY(3),
    DISCOUNT_AMOUNT_WEEK_AND_WEEKEND(2023),
    MIN_TOTAL_ORDER_FOR_GIFT(120000);

    private final int value;

    EventNumbers(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
