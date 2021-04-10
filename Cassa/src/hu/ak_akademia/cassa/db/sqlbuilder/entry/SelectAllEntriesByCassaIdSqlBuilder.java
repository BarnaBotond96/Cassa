package hu.ak_akademia.cassa.db.sqlbuilder.entry;

import hu.ak_akademia.cassa.db.sqlbuilder.SqlBuilder;

public class SelectAllEntriesByCassaIdSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM entry WHERE cassa_id = ?";
	}

}