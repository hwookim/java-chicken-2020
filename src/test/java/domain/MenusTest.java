package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenusTest {
	private Menus menus;

	@BeforeEach
	void setUp() {
		menus = new Menus(MenuRepository.menus());
	}

	@Test
	@DisplayName("생성 확인")
	void toList() {
		assertThat(menus.toList()).containsAll(MenuRepository.menus());
	}

	@ParameterizedTest
	@DisplayName("번호에 따른 메뉴 구하기")
	@ValueSource(ints = {1, 2, 3, 4, 5, 6, 21, 22})
	void get_Success(int number) {
		assertThat(menus.get(number).getNumber()).isEqualTo(number);
	}

	@ParameterizedTest
	@DisplayName("없는 메뉴 구해서 실패")
	@ValueSource(ints = {0, 7, 20})
	void get_Fail(int number) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> menus.get(number))
			.withMessage("잘못된 메뉴 번호입니다.");
	}

}