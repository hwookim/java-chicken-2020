package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderedMenusTest {
	private OrderedMenus orderedMenus;

	@BeforeEach
	void setUp() {
		orderedMenus = new OrderedMenus();
	}

	@Test
	@DisplayName("주문 성공")
	void order_Success() {
		orderedMenus.put(MenuRepository.menus().get(1), 99);
		assertThat(orderedMenus.toMap()).contains(entry(MenuRepository.menus().get(1), 99));
	}

	@Test
	@DisplayName("한번에 99개 넘게 주문한 경우")
	void order_Fail_When_orderOver99InOnce() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> orderedMenus.put(MenuRepository.menus().get(1), 100))
			.withMessage("테이블 당 한 가지 메뉴는 99개가 최대입니다.");
	}

	@Test
	@DisplayName("추가 주문으로 99개가 넘은 경우")
	void order_Fail_When_totalOrderOver99() {
		orderedMenus.put(MenuRepository.menus().get(1), 98);
		assertThatIllegalArgumentException()
			.isThrownBy(() -> orderedMenus.put(MenuRepository.menus().get(1), 2))
			.withMessage("테이블 당 한 가지 메뉴는 99개가 최대입니다.");
	}
}