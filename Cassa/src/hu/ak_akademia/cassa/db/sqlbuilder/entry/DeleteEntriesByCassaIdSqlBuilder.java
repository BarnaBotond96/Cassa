package hu.ak_akademia.cassa.db.sqlbuilder.entry;

import hu.ak_akademia.cassa.db.sqlbuilder.SqlBuilder;

public class DeleteEntriesByCassaIdSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "DELETE FROM entry WHERE cassa_id = ?";
	}

}