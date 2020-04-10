package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TableNumberTest {
	@ParameterizedTest
	@DisplayName("테이블 번호 생성 테스트 성공")
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
	void create_Success(int input) {
		assertThatCode(() -> new TableNumber(input))
			.doesNotThrowAnyException();
	}

	@ParameterizedTest
	@DisplayName("테이블 번호 생성 테스트 실")
	@ValueSource(ints = {0, 9})
	void create_Fail(int input) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new TableNumber(input))
			.withMessage("잘못된 테이블 번호입니다.");
	}
}