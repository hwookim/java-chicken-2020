import java.util.List;

import controller.Controller;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;

public class Application {
	// TODO 구현 진행
	public static void main(String[] args) {
		final List<Table> tables = TableRepository.tables();
		final List<Menu> menus = MenuRepository.menus();

		Controller controller = new Controller(tables, menus);

		while (true) {
			controller.run();
		}
	}
}
