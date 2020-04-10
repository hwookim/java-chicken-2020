import java.util.List;

import controller.Controller;
import domain.Menu;
import domain.MenuRepository;
import domain.TableRepository;
import domain.Tables;

public class Application {
	public static void main(String[] args) {
		final Tables tables = new Tables(TableRepository.tables());
		final List<Menu> menus = MenuRepository.menus();

		Controller controller = new Controller(tables, menus);
		while (true) {
			controller.run();
		}
	}
}
