package christmas;

import christmas.constant.Message;
import christmas.controller.MainController;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.print(Message.WELCOME.getMessage());
        MainController mainController = new MainController();
        mainController.excute();
    }
}
