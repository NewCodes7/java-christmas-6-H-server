package christmas.model.event;

import christmas.constant.MenuInfo;
import christmas.constant.Numbers;

public class GiftPromotion {

    public static final int MIN_TOTAL_ORDER_FOR_GIFT = 120000;

    public int setGift(int totalOrderAmount) {
        int giftPrice = Numbers.INITIALIZE_ZERO.getValue();
        if (totalOrderAmount >= MIN_TOTAL_ORDER_FOR_GIFT) {
            giftPrice = MenuInfo.CHAMPAGNE.getPrice();
        }
        return giftPrice;
    }
}
