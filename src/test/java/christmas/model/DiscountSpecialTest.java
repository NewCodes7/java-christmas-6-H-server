package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DiscountSpecialTest {
    @Test
    void 특별_할인_미적용() {
        assertThat(new DiscountSpecial().setDiscount(18)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 10, 25})
    void 특별_할인_적용(int date) {
        assertThat(new DiscountSpecial().setDiscount(date)).isEqualTo(1000);
    }
}