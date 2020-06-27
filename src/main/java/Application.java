import controller.Controller;
import domain.menu.MenuRepository;
import domain.menu.Menus;
import domain.table.TableRepository;
import domain.table.Tables;

public class Application {
	public static void main(String[] args) {
		final Tables tables = new Tables(TableRepository.tables());
		final Menus menus = new Menus(MenuRepository.menus());

		Controller controller = new Controller(tables, menus);
		while (true) {
			controller.run();
		}
	}
}
