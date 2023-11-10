package christmas.view;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {

    public static void printOrderedMenu(Map<String, Integer> orderedMenu) {
        lineBreak();
        System.out.println("<주문 메뉴>");
        for (Map.Entry<String, Integer> entry : orderedMenu.entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();
            String formattedLine = String.format("%s %d개", menuName, quantity);
            System.out.println(formattedLine);
        }
    }

    public static void printTotalOrderAmount(int amount) {
        lineBreak();
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(formatCurrency(amount));
    }

    private static String formatCurrency(int amount) {
        DecimalFormat currencyFormatter = new DecimalFormat("###,###원");
        return currencyFormatter.format(amount);
    }

    public static void printGift(int giftPrice) {
        lineBreak();
        System.out.println("<증정 메뉴>");
        String message = "없음";
        if (giftPrice == 250000) {
            message = "샴페인 1개";
        }
        System.out.println(message);
    }

    public static void lineBreak() {
        System.out.print("\n");
    }
}
