package christmas.model;

import java.util.Arrays;

public class VisitDate {
    private static int date;

    public int setVisitDate(String number) {
        validate(number);
        date = Integer.parseInt(number);
        return date;
    }

    private static void validate(String date) {
        validateIsInteger(date);
        validateIsNumberInRange(date);
    }

    private static void validateIsInteger(String date) {
        try{
            Integer.parseInt(date);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private static void validateIsNumberInRange(String date) {
        int number = Integer.parseInt(date);
        if (number < 1 || number > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
