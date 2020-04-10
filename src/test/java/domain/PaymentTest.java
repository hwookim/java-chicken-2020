package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentTest {
	@Test
	@DisplayName("생성 테스트 성공")
	void of_Success() {
		assertThat(Payment.of(1)).isEqualTo(Payment.CARD);
		assertThat(Payment.of(2)).isEqualTo(Payment.CASH);
	}

	@Test
	@DisplayName("생성 테스트 실패")
	void of_Fail() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Payment.of(3))
			.withMessage("잘못된 입력입니다.");
	}
}