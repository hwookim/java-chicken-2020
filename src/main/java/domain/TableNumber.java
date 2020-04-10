package domain;

public class TableNumber {
	private final int tableNumber;

	public TableNumber(int tableNumber) {
		validate(tableNumber);
		this.tableNumber = tableNumber;
	}

	private void validate(int tableNumber) {
		if (tableNumber < 1 || tableNumber > 8) {
			throw new IllegalArgumentException("잘못된 테이블 번호입니다.");
		}
	}

	@Override
	public String toString() {
		return Integer.toString(tableNumber);
	}
}
