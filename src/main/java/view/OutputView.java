package view;

import java.util.List;

import domain.Menu;
import domain.Table;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";
	private static final String ORDERED_BOTTOM_LINE = "└ \\ ┘";

	public static void printFunctions() {
		System.out.println("## 메인화면");
		System.out.println("1- 주문등록");
		System.out.println("2- 결제하기");
		System.out.println("3- 프로그램 종료");
	}

	public static void printTables(final List<Table> tables) {
		System.out.println("## 테이블 목록");
		final int size = tables.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tables);
		tables.forEach(OutputView::printBottomLines);
		System.out.println();
	}

	public static void printMenus(final List<Menu> menus) {
		for (final Menu menu : menus) {
			System.out.println(menu);
		}
	}

	private static void printLine(final String line, final int count) {
		for (int index = 0; index < count; index++) {
			System.out.print(line);
		}
		System.out.println();
	}

	private static void printTableNumbers(final List<Table> tables) {
		for (final Table table : tables) {
			System.out.printf(TABLE_FORMAT, table);
		}
		System.out.println();
	}

	private static void printBottomLines(Table table) {
		if (!table.isOrdered()) {
			System.out.print(BOTTOM_LINE);
		}
		if (table.isOrdered()) {
			System.out.print(ORDERED_BOTTOM_LINE);
		}
	}

	public static void printError(String errorMessage) {
		System.out.println(errorMessage);
		System.out.println("초기화면으로 돌아갑니다.");
		System.out.println();
	}

	public static void printOrderedMenu(Table table) {
		System.out.println("## 주문내역");
		System.out.println("메뉴 수량 금액");
	}
}
