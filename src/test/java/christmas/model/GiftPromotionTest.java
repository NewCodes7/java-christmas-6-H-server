package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GiftPromotionTest {
    @Test
    void 샴페인_증정_확인() {
        GiftPromotion giftPromotion = new GiftPromotion();
        assertThat(giftPromotion.isSatisfied(1300000)).isEqualTo(true);
    }
}