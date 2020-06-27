package domain.table;

public class TableNumber {
	private final int tableNumber;

	public TableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	@Override
	public String toString() {
		return Integer.toString(tableNumber);
	}
}
