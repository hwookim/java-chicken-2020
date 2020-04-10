package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import domain.Menu;
import domain.MenuRepository;
import domain.Payment;
import domain.Table;
import view.InputView;
import view.OutputView;

public class Controller {
	private final Map<Integer, Consumer<List<Table>>> function = new HashMap<>();

	private final List<Table> tables;
	private final List<Menu> menus;

	public Controller(List<Table> tables, List<Menu> menus) {
		this.tables = tables;
		this.menus = menus;
		setFunctions();
	}

	private void setFunctions() {
		function.put(1, this::order);
		function.put(2, this::pay);
		function.put(3, this::exit);
	}

	public void run() {
			OutputView.printFunctions();
			int number = parseInteger(InputView.inputFunctionNumber());
			function.get(number).accept(tables);
	}

	private void order(List<Table> tables) {
		OutputView.printTables(tables);
		int tableNumber = parseInteger(InputView.inputTableNumber()) - 1;

		OutputView.printMenus(MenuRepository.menus());
		int menuNumber = parseInteger(InputView.inputMenuNumber()) - 1;
		int menuCount = parseInteger(InputView.inputMenuCount());

		tables.get(tableNumber).order(menus.get(menuNumber), menuCount);
	}

	private void pay(List<Table> tables) {
		OutputView.printTables(tables);
		int tableNumber = parseInteger(InputView.inputTableNumber()) - 1;
		Table table = tables.get(tableNumber);

		OutputView.printOrderedMenus(table.getOrderedMenus().toMap());

		int paymentNumber = parseInteger(InputView.inputPaymentNumber(tableNumber + 1));
		Payment payment = Payment.of(paymentNumber);

		OutputView.printCost(table.calculateCost(payment));

		table.pay();
	}

	private void exit(List<Table> tables) {
		System.exit(0);
	}

	private static int parseInteger(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자를 입력하세요.");
		}
	}
}
