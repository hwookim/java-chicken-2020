package domain;

public enum Payment {
	CARD(1),
	CASH(2);

	private final int number;

	Payment(int number) {
		this.number = number;
	}
}
