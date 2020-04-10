package domain;

import java.util.Arrays;

public enum Payment {
	CARD(1),
	CASH(2);

	private final int number;

	Payment(int number) {
		this.number = number;
	}

	public static Payment of(int input) {
		return Arrays.stream(values())
			.filter(payment -> payment.number == input)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."));
	}
}
