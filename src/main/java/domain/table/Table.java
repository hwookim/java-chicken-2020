package domain.table;

import domain.Payment;
import domain.menu.Menu;

public class Table {
	private static final int CHICKEN_PIVOT = 10;
	private static final int CHICKEN_DISCOUNT = 10_000;
	private static final double CASH_DISCOUNT_RATE = 0.05;

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

	public int calculateCost(Payment payment) {
		int cost = orderedMenus.calculateCost();
		return discountCash(payment, cost - discountChicken());
	}

	private int discountChicken() {
		return orderedMenus.countChicken() / CHICKEN_PIVOT * CHICKEN_DISCOUNT;
	}

	private int discountCash(Payment payment, int cost) {
		if (Payment.CARD.equals(payment)) {
			return cost;
		}
		return cost - (int)(cost * CASH_DISCOUNT_RATE);
	}

	public void pay() {
		orderedMenus.clear();
	}

	public int getTableNumber() {
		return number.getTableNumber();
	}

	public OrderedMenus getOrderedMenus() {
		return orderedMenus;
	}

	@Override
	public String toString() {
		return number.toString();
	}
}
