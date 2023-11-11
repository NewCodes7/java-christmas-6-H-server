package christmas.view;

import static christmas.constant.event.EventMessage.BENEFITS_DETAILS;
import static christmas.constant.event.EventMessage.DECEMBER_EVENT_BADGE;
import static christmas.constant.event.EventMessage.GIFT;
import static christmas.constant.event.EventMessage.ORDER_MENU;
import static christmas.constant.event.EventMessage.TOTAL_BENEFITS_AMOUNTS;
import static christmas.constant.event.EventMessage.TOTAL_ORDER_AMOUNTS;
import static christmas.constant.event.EventMessage.TOTAL_PAYMENTS;

import christmas.constant.event.DiscountType;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;

public class OutputView {

    private static final String ORDER_MENU_FORMAT = "%s %d개";
    private static final String PRICE_FORMAT = "###,###원";
    private static final String LINE_BREAK = "\n";
    private static final String MINUS = "-";
    private static final String NONE = "없음";
    private static final int ZERO = 0;

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

    public static void printGift(String message) {
        printWithNewLine(GIFT.getMessage());
        System.out.println(message);
    }

    public static void printDiscountDetails(Integer[] details) {
        printWithNewLine(BENEFITS_DETAILS.getMessage());
        for (int i = ZERO; i<details.length; i++) {
            if (details[i] != ZERO) {
                System.out.println(DiscountType.values()[i].getDisplayName() + MINUS + formatCurrency(details[i]));
            }
        }
        if (Arrays.stream(details).allMatch(number -> number == ZERO)) {
            System.out.println(NONE);
        }
    }

    public static void printTotalDiscount(int totalDiscount) {
        printWithNewLine(TOTAL_BENEFITS_AMOUNTS.getMessage());
        System.out.println(MINUS + formatCurrency(totalDiscount));
    }

    public static void printFinalPayment(int finalPayment) {
        printWithNewLine(TOTAL_PAYMENTS.getMessage());
        System.out.println(formatCurrency(finalPayment));
    }

    public static void printEventBadge(String badge) {
        printWithNewLine(DECEMBER_EVENT_BADGE.getMessage());
        System.out.println(badge);

    }

    public static void lineBreak() {
        System.out.print(LINE_BREAK);
    }
}
