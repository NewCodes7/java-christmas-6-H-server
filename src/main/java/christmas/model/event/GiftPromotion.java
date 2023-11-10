package christmas.model.event;

import christmas.constant.MenuInfo;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GiftPromotion {
    public boolean isSatisfied(int totalOrderAmount) {
        boolean offerGift = false;
        if (totalOrderAmount >= 120000) {
            offerGift = true;
        }
        return offerGift;
    }
}
