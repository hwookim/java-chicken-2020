package domain;

import static domain.MenuFixture.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TableTest {
	private Table table;

	@BeforeEach
	void setUp() {
		table = new Table(1);
	}

	@Test
	@DisplayName("주문 여부 확인")
	void isOrdered() {
		assertThat(table.isOrdered()).isFalse();

		table.order(FRIED, 10);
		assertThat(table.isOrdered()).isTrue();
	}

	@Test
	@DisplayName("치킨 10개당 10,000원 할인이 적용된 금액 계산")
	void calculateCost_When_Order10Chicken() {
		table.order(FRIED, 4);
		table.order(SEASONED, 6);

		assertThat(table.calculateCost()).isEqualTo(150_000);
	}
}