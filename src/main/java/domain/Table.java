package domain;

public class Table {
    private final TableNumber number;
    private final OrderedMenus orderedMenus;

    public Table(final int number) {
        this.number = new TableNumber(number);
        this.orderedMenus = new OrderedMenus();
    }

    public void order(final Menu menu, final int count) {
        orderedMenus.put(menu, count);
    }

    public boolean isOrdered() {
        return !orderedMenus.isEmpty();
    }

    @Override
    public String toString() {
        return number.toString();
    }

    public int calculateCost() {
        return orderedMenus.calculateCost() - discountChicken();
    }

    private int discountChicken() {
        return orderedMenus.countChicken() / 10 * 10_000;
    }
}
