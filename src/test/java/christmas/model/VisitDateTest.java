package christmas.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.view.InputView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VisitDateTest {

    @ParameterizedTest
    @ValueSource(strings = {"1일", "1.1", "아무때나"})
    void 예외_날짜가_정수가_아닌_경우(String date) {
        assertThatThrownBy(() -> new VisitDate().setVisitDate(date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"32", "0", "-3"})
    void 예외_날짜가_범위를_벗어난_경우(String date) {
        assertThatThrownBy(() -> new VisitDate().setVisitDate(date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}