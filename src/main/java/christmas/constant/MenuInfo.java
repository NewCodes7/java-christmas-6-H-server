package christmas.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum MenuInfo {
    MUSHROOM_SOUP("애피타이저", "양송이수프", 6000),
    TAPAS("애피타이저", "타파스", 5500),
    CAESAR_SALAD("애피타이저", "시저샐러드", 8000),

    T_BONE_STEAK("메인", "티본스테이크", 55000),
    BBQ_RIBS("메인", "바비큐립", 54000),
    SEAFOOD_PASTA("메인", "해산물파스타", 35000),
    CHRISTMAS_PASTA("메인", "크리스마스파스타", 25000),

    CHOCOLATE_CAKE("디저트", "초코케이크", 15000),
    ICE_CREAM("디저트", "아이스크림", 5000),

    ZERO_COLA("음료", "제로콜라", 3000),
    RED_WINE("음료", "레드와인", 60000),
    CHAMPAGNE("음료", "샴페인", 25000);

    private final String category;
    private final String name;
    private final int price;

    MenuInfo(String category, String name, int price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public String getCategory() {
        return this.category;
    }
    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public static boolean contains(String testValue) {
        for (MenuInfo menu : MenuInfo.values()) {
            if (menu.getName().equals(testValue)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> getDrinkNames() {
        List<String> drinks = new ArrayList<>();
        for (MenuInfo menu : MenuInfo.values()) {
            if (menu.getCategory().equals("음료")) {
                drinks.add(menu.getName());
            }
        }
        return drinks;
    }

    public static List<String> getMainNames() {
        List<String> mains = new ArrayList<>();
        for (MenuInfo menu : MenuInfo.values()) {
            if (menu.getCategory().equals("메인")) {
                mains.add(menu.getName());
            }
        }
        return mains;
    }

    public static List<String> getDessertNames() {
        List<String> desserts = new ArrayList<>();
        for (MenuInfo menu : MenuInfo.values()) {
            if (menu.getCategory().equals("디저트")) {
                desserts.add(menu.getName());
            }
        }
        return desserts;
    }

    public static Map<String, Integer> getMenuBoard() {
        Map<String, Integer> menuBoard = new HashMap<>();
        for (MenuInfo menu : MenuInfo.values()) {
            menuBoard.put(menu.getName(), menu.getPrice());
        }
        return menuBoard;
    }
}
