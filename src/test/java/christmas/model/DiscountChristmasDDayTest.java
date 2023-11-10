package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DiscountChristmasDDayTest {
    @Test
    void 크리스마스_디데이_할인_미적용() {
        assertThat(new DiscountChristmasDDay(26).calculate()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 11, 25})
    void 크리스마스_디데이_할인_적용(int date) {
        int expectedDiscount = getExpectedDiscount(date);
        int actualDiscount = 0;

        actualDiscount = new DiscountChristmasDDay(date).calculate();

        assertThat(actualDiscount).isEqualTo(expectedDiscount);
    }

    private int getExpectedDiscount(int date) {
        if (date == 1) {
            return 1000;
        }
        if (date == 11) {
            return 2000;
        }
        if (date == 25) {
            return 3400;
        }
        return 0;
    }
}