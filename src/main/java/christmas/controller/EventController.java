package christmas.controller;

import static christmas.constant.event.EventBadge.NON;
import static christmas.constant.event.EventBadge.SANTA;
import static christmas.constant.event.EventBadge.STAR;
import static christmas.constant.event.EventBadge.TREE;
import static christmas.constant.Numbers.INITIALIZE_ZERO;

import christmas.constant.event.EventMessage;
import christmas.constant.MenuInfo;
import christmas.model.event.DiscountChristmasDDay;
import christmas.model.event.DiscountSpecial;
import christmas.model.event.DiscountWeek;
import christmas.model.event.GiftPromotion;
import christmas.view.OutputView;

public class EventController {
    private static final int INDEX_DATE = 0;
    private static final int INDEX_TOTAL_ORDER_AMOUNTS = 1;
    private static final int INDEX_DISCOUNT_WEEK_QUANTITY = 2;
    public static final int ACTUAL_DISCOUNT_COUNT = 3;

    public void excute(Integer[] data) {
        Integer[] discountDetails = excuteDiscountResult(data);
        excuteFinalResult(discountDetails, data[INDEX_TOTAL_ORDER_AMOUNTS]);
    }

    private static Integer[] excuteDiscountResult(Integer[] data) {
        int giftPrice = giftPromotionController(data[INDEX_TOTAL_ORDER_AMOUNTS]);
        int discountDDay = discountChristmasDDayConroller(data[INDEX_DATE]);
        int discountWeek = discountWeekConroller(data[INDEX_DISCOUNT_WEEK_QUANTITY]);
        int discountSpecial = discountSpecialController(data[INDEX_DATE]);

        return new Integer[]{discountDDay, discountWeek, discountSpecial, giftPrice};
    }

    private static void excuteFinalResult(Integer[] discountDetails, int totalOrderAmount) {
        OutputView.printDiscountDetails(discountDetails);
        int totalDiscount = calculateTotalDiscounted(discountDetails);
        calculateFinalPayment(totalOrderAmount, discountDetails);
        checkEventBadge(totalDiscount);
    }

    private static int discountChristmasDDayConroller(int date) {
        DiscountChristmasDDay discountChristmasDDay = new DiscountChristmasDDay();
        return discountChristmasDDay.calculate(date);
    }

    private static int discountWeekConroller(int quantity) {
        DiscountWeek discountWeek = new DiscountWeek();
        return discountWeek.setDiscount(quantity);
    }

    private static int discountSpecialController(int date) {
        DiscountSpecial discountSpecial = new DiscountSpecial();
        return discountSpecial.setDiscount(date);
    }

    private static int giftPromotionController(int totalOrderAmount) {
        GiftPromotion giftPromotion = new GiftPromotion();
        int giftPrice = giftPromotion.setGift(totalOrderAmount);
        String message = EventMessage.NONE.getMessage();
        if (giftPrice == MenuInfo.CHAMPAGNE.getPrice()) {
            message = EventMessage.GIFT_CHAMPAGNE.getMessage();
        }
        OutputView.printGift(message);
        return giftPrice;
    }

    private static void checkEventBadge(int totalDiscount) {
        String badge = NON.getBadge();
        if (totalDiscount >= STAR.getMinTotalDiscount() && totalDiscount < TREE.getMinTotalDiscount()) {
            badge = STAR.getBadge();
        }
        if (totalDiscount >= TREE.getMinTotalDiscount() && totalDiscount < SANTA.getMinTotalDiscount()) {
            badge = TREE.getBadge();
        }
        if (totalDiscount >= SANTA.getMinTotalDiscount()) {
            badge = SANTA.getBadge();
        }
        OutputView.printEventBadge(badge);
    }

    private static int calculateTotalDiscounted(Integer[] details) {
        int totalDiscount = INITIALIZE_ZERO.getValue();
        for (int amount : details) {
            totalDiscount += amount;
        }
        OutputView.printTotalDiscount(totalDiscount);
        return totalDiscount;
    }

    private static void calculateFinalPayment(int totalAmount, Integer[] discountAmounts) {
        int finalPayment = totalAmount;
        for (int i = INITIALIZE_ZERO.getValue(); i < ACTUAL_DISCOUNT_COUNT; i++) {
            finalPayment -= discountAmounts[i];
        }
        OutputView.printFinalPayment(finalPayment);
    }
}
