package christmas.model.event;

import christmas.constant.MenuInfo;

public class GiftPromotion {
    public int setGift(int totalOrderAmount) {
        int giftPrice = 0;
        if (totalOrderAmount >= 120000) {
            giftPrice = MenuInfo.CHAMPAGNE.getPrice();
        }
        return giftPrice;
    }
}
