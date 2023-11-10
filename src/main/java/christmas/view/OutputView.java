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
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(formatCurrency(amount));
    }

    private static String formatCurrency(int amount) {
        DecimalFormat currencyFormatter = new DecimalFormat("###,###원");
        return currencyFormatter.format(amount);
    }

    public static void lineBreak() {
        System.out.print("\n");
    }
}
