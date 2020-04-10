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

    public int calculateCost(Payment payment) {
        int cost = orderedMenus.calculateCost();
        return discountCash(payment, cost - discountChicken());
    }

    private int discountChicken() {
        return orderedMenus.countChicken() / 10 * 10_000;
    }

    private int discountCash(Payment payment, int cost) {
        if (Payment.CARD.equals(payment)) {
            return cost;
        }
        return cost - (int)(cost * 0.05);
    }
}
