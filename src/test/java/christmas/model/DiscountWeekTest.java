package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.customer.OrderMenu;
import christmas.model.event.DiscountWeek;
import java.util.Map;
import org.junit.jupiter.api.Test;

class DiscountWeekTest {
    @Test
    void 주말_할인_적용() {
        Map<String, Integer> orderedmenu = new OrderMenu().setOrderMenu("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        DiscountWeek discountWeek = new DiscountWeek();
        int quantity = discountWeek.calculateDiscountedOrderQuantity(orderedmenu, 15);

        assertThat(discountWeek.setDiscount(quantity)).isEqualTo(4046);
    }

    @Test
    void 평일_할인_적용() {
        Map<String, Integer> orderedmenu = new OrderMenu().setOrderMenu("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        DiscountWeek discountWeek = new DiscountWeek();
        int quantity = discountWeek.calculateDiscountedOrderQuantity(orderedmenu, 8);

        assertThat(discountWeek.setDiscount(quantity)).isEqualTo(4046);
    }
}