package christmas.model.customer;

import java.util.Arrays;

public class VisitDate {
    private static int date;

    public int setVisitDate(String number) {
        validate(number);
        date = Integer.parseInt(number);
        return date;
    }

    private static void validate(String date) {
        validateIsInRange(date);
    }

    private static void validateIsInRange(String date) {
        try{
            int number = Integer.parseInt(date);
            if (number < 1 || number > 31) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
