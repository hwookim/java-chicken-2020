package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import domain.menu.Menus;
import domain.Payment;
import domain.table.Table;
import domain.table.Tables;
import view.InputView;
import view.OutputView;

public class Controller {
	private static final int ORDER = 1;
	private static final int PAY = 2;
	private static final int EXIT = 3;
	private final Map<Integer, Consumer<Tables>> function = new HashMap<>();

	private final Tables tables;
	private final Menus menus;

	public Controller(Tables tables, Menus menus) {
		this.tables = tables;
		this.menus = menus;
		setFunctions();
	}

	private void setFunctions() {
		function.put(ORDER, this::order);
		function.put(PAY, this::pay);
		function.put(EXIT, this::exit);
	}

	public void run() {
		try {
			OutputView.printFunctions();
			int number = parseInteger(InputView.inputFunctionNumber());
			function.get(number).accept(tables);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
		}
	}

	private void order(Tables tables) {
		OutputView.printTables(tables.toList());
		int tableNumber = parseInteger(InputView.inputTableNumber());

		OutputView.printMenus(menus.toList());
		int menuNumber = parseInteger(InputView.inputMenuNumber());
		int menuCount = parseInteger(InputView.inputMenuCount());

		tables.get(tableNumber).order(menus.get(menuNumber), menuCount);
	}

	private void pay(Tables tables) {
		OutputView.printTables(tables.toList());
		int tableNumber = parseInteger(InputView.inputTableNumber());
		Table table = tables.get(tableNumber);

		if (!table.isOrdered()) {
			throw new IllegalArgumentException("주문이 없는 테이블입니다.");
		}

		OutputView.printOrderedMenus(table.getOrderedMenus().toMap());

		int paymentNumber = parseInteger(InputView.inputPaymentNumber(tableNumber));
		Payment payment = Payment.of(paymentNumber);

		OutputView.printCost(table.calculateCost(payment));

		table.pay();
	}

	private void exit(Tables tables) {
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
