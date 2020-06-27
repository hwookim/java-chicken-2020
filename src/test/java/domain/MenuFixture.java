package domain;

import domain.menu.Menu;
import domain.menu.MenuRepository;

public class MenuFixture {
	static final Menu FRIED = MenuRepository.menus().get(0);
	static final Menu SEASONED = MenuRepository.menus().get(1);
	static final Menu COLA = MenuRepository.menus().get(6);
	static final Menu CIDER = MenuRepository.menus().get(7);

}
