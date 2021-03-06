package domain.table;

import domain.menu.Category;
import domain.menu.Menu;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class OrderedMenus {
	private final Map<Menu, Integer> menus;

	public OrderedMenus() {
		menus = new LinkedHashMap<>();
	}

	public void put(Menu menu, int count) {
		int menuCount = count;
		if (menus.containsKey(menu)) {
			menuCount += menus.get(menu);
		}
		validateMenuCount(menuCount);

		menus.put(menu, menuCount);
	}

	private void validateMenuCount(int menuCount) {
		if (menuCount > 99) {
			throw new IllegalArgumentException("테이블 당 한 가지 메뉴는 99개가 최대입니다.");
		}
	}

	public boolean isEmpty() {
		return menus.isEmpty();
	}

	public int calculateCost() {
		return menus.entrySet()
			.stream()
			.mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
			.sum();
	}

	public int countChicken() {
		return menus.entrySet()
			.stream()
			.filter(entry -> Category.CHICKEN.equals(entry.getKey().getCategory()))
			.mapToInt(Map.Entry::getValue)
			.sum();
	}

	public void clear() {
		menus.clear();
	}

	public Map<Menu, Integer> toMap() {
		return Collections.unmodifiableMap(menus);
	}
}
