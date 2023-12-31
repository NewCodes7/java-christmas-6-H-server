package christmas.constant.event;

import christmas.model.customer.VisitDate;

public enum DiscountType {
    CHRISTMAS_DEAL("크리스마스 디데이 할인"),
    WEEK_DEAL("평일 할인"),
    SPECIAL_DEAL("특별 할인"),
    GIFT_EVENT("증정 이벤트");

    private final String displayName;

    // Enum 생성자
    DiscountType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        if (this == WEEK_DEAL && VisitDate.isWeekend()) {
            return "주말 할인" + ": ";
        }
        return displayName + ": ";
    }
}
