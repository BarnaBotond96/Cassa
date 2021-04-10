package hu.ak_akademia.cassa.db.sqlbuilder.entry;

import hu.ak_akademia.cassa.db.sqlbuilder.SqlBuilder;

public class DeleteEntrySqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "DELETE FROM entry WHERE entry_id = ? AND cassa_id = ?";
	}

}