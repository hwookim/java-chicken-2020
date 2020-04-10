package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TableTest {
	@Test
	@DisplayName("주문 여부 확인")
	void isOrdered() {
		Table table = new Table(1);
		assertThat(table.isOrdered()).isFalse();

		table.order(MenuRepository.menus().get(1), 10);
		assertThat(table.isOrdered()).isTrue();
	}
}