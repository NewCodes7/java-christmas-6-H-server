package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.Message;

public class InputView {
    public static String readDate() {
        OutputView.print(Message.EXPECTED_VISIT_DATE.getMessage());
        return readLine();
    }

    public static String readMenu() {
        OutputView.print(Message.ORDER_MENU.getMessage());
        return readLine();
    }

    public static String readLine() {
        return Console.readLine();
    }
}
