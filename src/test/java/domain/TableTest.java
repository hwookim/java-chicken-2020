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

		assertThat(table.calculateCost(Payment.CARD)).isEqualTo(150_000);
	}

	@Test
	@DisplayName("현금 결제 시 5% 할인")
	void calculateCost_When_PayCash() {
		table.order(FRIED, 1);

		assertThat(table.calculateCost(Payment.CASH)).isEqualTo(15_200);
	}

	@Test
	@DisplayName("치킨 10마리 현금결제")
	void calculateCost_When_ApplyAllDiscount() {
		table.order(FRIED, 4);
		table.order(SEASONED, 6);

		assertThat(table.calculateCost(Payment.CASH)).isEqualTo(142_500);
	}

	@Test
	@DisplayName("결제 후 주문 내역 초기화")
	void pay() {
		table.order(FRIED, 1);
		table.order(CIDER, 2);
		assertThat(table.isOrdered()).isTrue();

		table.pay();
		assertThat(table.isOrdered()).isFalse();
	}
}