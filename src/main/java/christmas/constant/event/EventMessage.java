package christmas.constant.event;

public enum EventMessage {
    NONE("없음"),
    GIFT_CHAMPAGNE("샴페인 1개"),
    ORDER_MENU("<주문 메뉴>"),
    TOTAL_ORDER_AMOUNTS("<할인 전 총주문 금액>"),
    GIFT("<증정 메뉴>"),
    BENEFITS_DETAILS("<혜택 내역>"),
    TOTAL_BENEFITS_AMOUNTS("<총혜택 금액>"),
    TOTAL_PAYMENTS("<할인 후 예상 결제 금액>"),
    DECEMBER_EVENT_BADGE("<12월 이벤트 배지>");

    private final String message;

    EventMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
