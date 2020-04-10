package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TablesTest {
	private Tables tables;

	@BeforeEach
	void setUp() {
		tables = new Tables(TableRepository.tables());
	}

	@ParameterizedTest
	@DisplayName("번호에 따른 테이블 구하기")
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 8})
	void get_Success(int number) {
		assertThat(tables.get(number).getTableNumber()).isEqualTo(number);
	}

	@ParameterizedTest
	@DisplayName("없는 테이블 구해서 실패")
	@ValueSource(ints = {0, 7, 9})
	void get_Fail(int number) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> tables.get(number))
			.withMessage("잘못된 테이블 번호입니다.");
	}

	@Test
	@DisplayName("생성 확인")
	void toList() {
		assertThat(tables.toList()).containsAll(TableRepository.tables());
	}
}