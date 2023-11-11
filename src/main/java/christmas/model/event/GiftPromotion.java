package christmas.model.event;

import static christmas.constant.event.EventNumbers.MIN_TOTAL_ORDER_FOR_GIFT;

import christmas.constant.MenuInfo;
import christmas.constant.Numbers;

public class GiftPromotion {

    public int setGift(int totalOrderAmount) {
        int giftPrice = Numbers.INITIALIZE_ZERO.getValue();
        if (totalOrderAmount >= MIN_TOTAL_ORDER_FOR_GIFT.getValue()) {
            giftPrice = MenuInfo.CHAMPAGNE.getPrice();
        }
        return giftPrice;
    }
}
