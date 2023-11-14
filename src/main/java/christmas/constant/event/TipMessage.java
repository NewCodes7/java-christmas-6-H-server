package christmas.constant.event;

public enum TipMessage {
    TIP_ORDER_FORMAT("예시 주문 형식을 참고해주세요."),
    TIP_ORDER_MENU("우테코 식당에 존재하지 않는 메뉴입니다."),
    TIP_ORDER_QUANTITY("주문 수량은 1 이상의 숫자만 입력하셔야 합니다."),
    TIP_ORDER_LIMIT("총 주문 수량은 20개 이하여야 합니다."),
    TIP_ORDER_DRINK("음료만 주문할 수 없습니다."),
    TIP_ORDER_UNIQUE_MENU("메뉴를 중복해서 입력할 수 없습니다."),
    TIP_CHAMPAGNE_MESSAGE("고객님께서는 샴페인을 주문하시지 않으셔도 샴페인 1개가 무료로 제공됩니다!"),
    TIP_BADGE_MESSAGE("2024 새해 이벤트에서 해당 배지에 따라 새해 선물을 증정해드립니다!"),
    TIP_MIN_EVENT_APPLIED("총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.");

    private final String message;

    TipMessage(String message) {
        this.message = message;
    }

    public String getTipMessage() {
        return "\n" + "[TIP] " + message;
    }
}
