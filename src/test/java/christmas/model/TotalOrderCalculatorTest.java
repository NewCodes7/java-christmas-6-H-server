package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.Test;

class TotalOrderCalculatorTest {
    @Test
    void 총주문_금액_계산() {
        TotalOrderCalculator totalOrderCalculator = new TotalOrderCalculator();
        OrderMenu orderMenu = new OrderMenu();

        Map<String, Integer> orderedMenu = orderMenu.setOrderMenu("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");

        assertThat(totalOrderCalculator.calculateTotalOrder(orderedMenu)).isEqualTo(142000);
    }
}