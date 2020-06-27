package domain.table;

import java.util.Collections;
import java.util.List;

public class Tables {
	private final List<Table> tables;

	public Tables(List<Table> tables) {
		this.tables = tables;
	}

	public Table get(int number) {
		return tables.stream()
			.filter(table -> table.getTableNumber() == number)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("잘못된 테이블 번호입니다."));
	}

	public List<Table> toList() {
		return Collections.unmodifiableList(tables);
	}
}
