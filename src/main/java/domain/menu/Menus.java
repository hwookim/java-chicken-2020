package domain.menu;

import java.util.Collections;
import java.util.List;

public class Menus {
	private final List<Menu> menus;

	public Menus(List<Menu> menus) {
		this.menus = menus;
	}

	public Menu get(int number) {
		return menus.stream()
			.filter(menu -> menu.getNumber() == number)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 번호입니다."));
	}

	public List<Menu> toList() {
		return Collections.unmodifiableList(menus);
	}
}
