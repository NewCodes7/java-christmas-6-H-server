package christmas.controller;

import static christmas.constant.MenuInfo.CHAMPAGNE;
import static christmas.constant.event.EventBadge.NON;
import static christmas.constant.event.EventBadge.SANTA;
import static christmas.constant.event.EventBadge.STAR;
import static christmas.constant.event.EventBadge.TREE;
import static christmas.constant.Numbers.INITIALIZE_ZERO;

import christmas.model.customer.TotalOrderCalculator;
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
    public static final int INDEX_CHAMPAGNE_COUNT = 3;
    public static final int ZERO_DISCOUNT = 0;
    public static final int PECENTAGE_NUMBER = 100;
    public static final int INDEX_GIFT = 3;

    public void excute(Integer[] data) {
        Integer[] discountDetails = excuteEventDiscounts(data);
        OutputView.printGift(discountDetails[INDEX_GIFT]);
        OutputView.printDiscountDetails(discountDetails);
        int totalDiscountedAmount = calculateTotalDiscounted(discountDetails);
        OutputView.printTotalDiscount(totalDiscountedAmount);
        calculateFinalPayment(discountDetails, data[INDEX_TOTAL_ORDER_AMOUNTS], data[INDEX_CHAMPAGNE_COUNT]);
        checkEventBadge(totalDiscountedAmount);
    }

    private static Integer[] excuteEventDiscounts(Integer[] data) {
        if (!TotalOrderCalculator.checkEventApplied()) {
            return new Integer[]{ZERO_DISCOUNT, ZERO_DISCOUNT, ZERO_DISCOUNT, ZERO_DISCOUNT};
        }
        int giftPrice = giftPromotionController(data[INDEX_TOTAL_ORDER_AMOUNTS]);
        int discountDDay = discountChristmasDDayConroller(data[INDEX_DATE]);
        int discountWeek = discountWeekConroller(data[INDEX_DISCOUNT_WEEK_QUANTITY]);
        int discountSpecial = discountSpecialController(data[INDEX_DATE]);
        return new Integer[]{discountDDay, discountWeek, discountSpecial, giftPrice};
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
        int giftPrice = -giftPromotion.setGift(totalOrderAmount);
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
        return totalDiscount;
    }

    private static void calculateFinalPayment(Integer[] discountAmounts, int totalAmount, int champagneCount) {
        int finalPayment = totalAmount;
        for (int i = INITIALIZE_ZERO.getValue(); i < ACTUAL_DISCOUNT_COUNT; i++) {
            finalPayment += discountAmounts[i];
        }
        double discountRate = calculateDiscountRate(totalAmount, finalPayment);
        OutputView.printFinalPayment(finalPayment, discountRate);
        calculateFinalPaymentForChampagne(discountAmounts, finalPayment, champagneCount, totalAmount);
    }

    private static void calculateFinalPaymentForChampagne(Integer[] discountAmounts, int finalPayment, int champagneCount, int totalAmount) {
        if (champagneCount != INITIALIZE_ZERO.getValue() && discountAmounts[INDEX_CHAMPAGNE_COUNT] == CHAMPAGNE.getPrice()) {
            int finalPaymentWithoutChampagne = finalPayment - CHAMPAGNE.getPrice();
            double discountRate = calculateDiscountRate(totalAmount, finalPaymentWithoutChampagne);
            OutputView.printFinalPaymentForChampagne(finalPaymentWithoutChampagne, discountRate);
        }
    }

    private static double calculateDiscountRate(int totalAmount, int finalAmount) {
        return ((double) (totalAmount - finalAmount) / totalAmount) * PECENTAGE_NUMBER;
    }
}
