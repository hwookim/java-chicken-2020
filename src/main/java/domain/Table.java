package domain;

public class Table {
    private final TableNumber number;

    public Table(final int number) {
        this.number = new TableNumber(number);
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
