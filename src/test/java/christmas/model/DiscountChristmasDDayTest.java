package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DiscountChristmasDDayTest {
    @Test
    void 크리스마스_디데이_할인_미적용() {
        VisitDate visitDate = new VisitDate("26");

        assertThat(visitDate.isChristmasDDayDiscountActive()).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "11", "25"})
    void 크리스마스_디데이_할인_적용(String date) {
        int expectedDiscount = getExpectedDiscount(date);
        int actualDiscount = 0;

        VisitDate visitDate = new VisitDate(date);
        if (visitDate.isChristmasDDayDiscountActive()) {
            actualDiscount = visitDate.createDiscountChristmasDDay().calculate();
        }

        assertThat(actualDiscount).isEqualTo(expectedDiscount);
    }

    private int getExpectedDiscount(String date) {
        if (date.equals("1")) {
            return 1000;
        }
        if (date.equals("11")) {
            return 2000;
        }
        if (date.equals("25")) {
            return 3400;
        }
        return 0;
    }
}