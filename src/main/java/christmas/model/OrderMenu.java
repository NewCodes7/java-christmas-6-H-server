package christmas.model;

import christmas.constant.Menu;
import christmas.view.InputView;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OrderMenu {
    private static Map<Menu, Integer> orderedMenu;
    public Menu(String input) {
        validate(splitByComma(input));

    }

    private String[] splitByComma(String input) {
        return input.split(",");
    }

    private void validate(String[] input) {

    }

    private void validateIs(String[] input) {

    }
}
