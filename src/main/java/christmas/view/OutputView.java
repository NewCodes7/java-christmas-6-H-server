package christmas.view;

import static christmas.constant.MenuInfo.CHAMPAGNE;
import static christmas.constant.event.EventMessage.BENEFITS_DETAILS;
import static christmas.constant.event.EventMessage.DECEMBER_EVENT_BADGE;
import static christmas.constant.event.EventMessage.GIFT;
import static christmas.constant.event.EventMessage.ORDER_MENU;
import static christmas.constant.event.EventMessage.TOTAL_BENEFITS_AMOUNTS;
import static christmas.constant.event.EventMessage.TOTAL_ORDER_AMOUNTS;
import static christmas.constant.event.EventMessage.TOTAL_PAYMENTS;
import static christmas.constant.event.TipMessage.TIP_BADGE_MESSAGE;
import static christmas.constant.event.TipMessage.TIP_CHAMPAGNE_MESSAGE;
import static christmas.constant.event.TipMessage.TIP_MIN_EVENT_APPLIED;

import christmas.constant.event.DiscountType;
import christmas.constant.event.EventBadge;
import christmas.constant.event.EventMessage;
import christmas.constant.event.EventNumbers;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;

public class OutputView {

    private static final String ORDER_MENU_FORMAT = "%s %d개";
    private static final String PRICE_FORMAT = "###,###원";
    private static final String LINE_BREAK = "\n";
    private static final String NONE = "없음";
    private static final int ZERO = 0;
    public static final String FINAL_PAYMENT_WIHTOUT_CHAMPAGNE = "샴페인을 별도로 주문하지 않을 경우 가격: ";
    public static final String FORMAT_PERCENT = "%.1f%%";
    public static final String DISCOUNT_RATE_MESSAGE = "%s (적용된 할인율: %s)";

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printWithNewLine(String message) {
        lineBreak();
        System.out.println(message);
    }

    public static void printOrderedMenu(Map<String, Integer> orderedMenu) {
        printWithNewLine(ORDER_MENU.getMessage());
        for (Map.Entry<String, Integer> entry : orderedMenu.entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();
            String formattedLine = String.format(ORDER_MENU_FORMAT, menuName, quantity);
            System.out.println(formattedLine);
        }
    }

    public static void printTotalOrderAmount(int amount) {
        printWithNewLine(TOTAL_ORDER_AMOUNTS.getMessage());
        System.out.println(formatCurrency(amount));
    }

    private static String formatCurrency(int amount) {
        DecimalFormat currencyFormatter = new DecimalFormat(PRICE_FORMAT);
        return currencyFormatter.format(amount);
    }

    public static void printGift(int giftPrice) {
        printWithNewLine(GIFT.getMessage());
        String message = EventMessage.NONE.getMessage();
        if (-giftPrice == CHAMPAGNE.getPrice()) {
            message = EventMessage.GIFT_CHAMPAGNE.getMessage();
        }
        System.out.println(message);
    }

    public static void printDiscountDetails(Integer[] details) {
        printWithNewLine(BENEFITS_DETAILS.getMessage());
        for (int i = ZERO; i<details.length; i++) {
            if (details[i] != ZERO) {
                System.out.println(DiscountType.values()[i].getDisplayName() + formatCurrency(details[i]));
            }
        }
        if (Arrays.stream(details).allMatch(number -> number == ZERO)) {
            System.out.println(NONE);
        }
    }

    public static void printTotalDiscount(int totalDiscount) {
        printWithNewLine(TOTAL_BENEFITS_AMOUNTS.getMessage());
        System.out.println(formatCurrency(totalDiscount));
    }

    public static void printFinalPayment(int finalPayment, double discountRate) {
        printWithNewLine(TOTAL_PAYMENTS.getMessage());
        String formattedDiscountRate = String.format(FORMAT_PERCENT, discountRate);
        String finalPaymentMessage = String.format(DISCOUNT_RATE_MESSAGE, formatCurrency(finalPayment), formattedDiscountRate);
        System.out.println(finalPaymentMessage);
    }

    public static void printFinalPaymentForChampagne(int finalPayment, double discountRate) {
        System.out.print(TIP_CHAMPAGNE_MESSAGE.getTipMessage());
        String formattedDiscountRate = String.format(FORMAT_PERCENT, discountRate);
        String finalPaymentMessage = String.format(DISCOUNT_RATE_MESSAGE, formatCurrency(finalPayment), formattedDiscountRate);
        System.out.println(FINAL_PAYMENT_WIHTOUT_CHAMPAGNE + finalPaymentMessage);
    }

    public static void printEventBadge(String badge) {
        printWithNewLine(DECEMBER_EVENT_BADGE.getMessage());
        System.out.println(badge);
        if (!badge.equals(EventBadge.NON.getBadge())) {
            System.out.print(TIP_BADGE_MESSAGE.getTipMessage());
        }
    }

    public static void printTipMinDiscountApplied(int totalOrderAmount) {
        if (totalOrderAmount < EventNumbers.MIN_PRICE_FOR_DISCOUNT.getValue()) {
            System.out.print(TIP_MIN_EVENT_APPLIED.getTipMessage());
        }
    }

    public static void lineBreak() {
        System.out.print(LINE_BREAK);
    }
}
