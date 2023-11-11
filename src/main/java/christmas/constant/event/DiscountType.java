package christmas.constant.event;

public enum DiscountType {
    CHRISTMAS_DEAL("크리스마스 디데이 할인"),
    WEEKDAY_DEAL("평일 할인"),
    SPECIAL_DEAL("특별 할인"),
    GIFT_EVENT("증정 이벤트");

    private final String displayName;

    // Enum 생성자
    DiscountType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName + ": ";
    }
}
