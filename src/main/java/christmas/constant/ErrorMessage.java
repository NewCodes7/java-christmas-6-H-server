package christmas.constant;

public enum ErrorMessage {
    OUT_OF_RANGE_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_ORDER_FORMAT("예시 주문 형식을 참고해주세요."),
    INVALID_ORDER_MENU("우테코 식당에 존재하지 않는 메뉴입니다."),
    INVALID_ORDER_QUANTITY("주문 수량은 1 이상의 숫자만 입력하셔야 합니다."),
    INVALID_ORDER_LIMIT("총 주문 수량은 20개 이하여야 합니다."),
    INVALID_ORDER_DRINK("음료만 주문할 수 없습니다.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return "[ERROR] " + message;
    }

    public String getMessage() {
        return "\n" + message;
    }
}
