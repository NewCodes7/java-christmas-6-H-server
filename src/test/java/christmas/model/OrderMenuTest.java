package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.model.customer.OrderMenu;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderMenuTest {

    @Test
    void 주문메뉴_Map_저장_확인() {
        Map<String, Integer> orderedMenu = new OrderMenu().setOrderMenu("타파스-1,크리스마스파스타-2");

        assertThat(orderedMenu.get("타파스")).isEqualTo(1);
        assertThat(orderedMenu.get("크리스마스파스타")).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"타파스1개,크리스마스파스타2개", "양송이스프2,해산물파스타1", "아무거나"})
    void 예외_메뉴_형식이_하이픈으로_구분되지_않은_경우(String menu) {
        assertThatThrownBy(() -> new OrderMenu().setOrderMenu(menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.\n예시 주문 형식을 참고해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"피자-1,크리스마스파스타-1", "양송이스프-2,해산물파스타-1"})
    void 예외_존재하지_않는_메뉴인_경우(String menu) {
        assertThatThrownBy(() -> new OrderMenu().setOrderMenu(menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.\n우테코 식당에 존재하지 않는 메뉴입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"타파스-0,크리스마스파스타-1", "양송이수프-2개,해산물파스타-1개"})
    void 예외_주문_수량이_1_이상의_정수가_아닌_경우(String menu) {
        assertThatThrownBy(() -> new OrderMenu().setOrderMenu(menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.\n주문 수량은 1 이상의 숫자만 입력하셔야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"타파스-4,크리스마스파스타-4,제로콜라-2,바비큐립-11", "양송이수프-22"})
    void 예외_총주문_수량이_20개_초과인_경우(String menu) {
        assertThatThrownBy(() -> new OrderMenu().setOrderMenu(menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.\n총 주문 수량은 20개 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-2", "제로콜라-1,샴페인-1,레드와인-2"})
    void 예외_음료만_주문한_경우(String menu) {
        assertThatThrownBy(() -> new OrderMenu().setOrderMenu(menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.\n음료만 주문할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"타파스-1,타파스-1", "양송이수프-1,바비큐립-2,바비큐립-1,제로콜라-1"})
    void 예외_중복해서_주문한_경우(String menu) {
        assertThatThrownBy(() -> new OrderMenu().setOrderMenu(menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.\n메뉴를 중복해서 입력할 수 없습니다.");
    }
}