import controller.Controller;
import domain.MenuRepository;
import domain.Menus;
import domain.TableRepository;
import domain.Tables;

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
