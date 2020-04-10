package domain;

public class Table {
    private final TableNumber number;
    private final OrderedMenus orderedMenus;

    public Table(final int number) {
        this.number = new TableNumber(number);
        this.orderedMenus = new OrderedMenus();
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
