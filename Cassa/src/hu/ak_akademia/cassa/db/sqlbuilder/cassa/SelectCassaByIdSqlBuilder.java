package hu.ak_akademia.cassa.db.sqlbuilder.cassa;

import hu.ak_akademia.cassa.db.sqlbuilder.SqlBuilder;

public class SelectCassaByIdSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM cassa WHERE cassa_id = ?";
	}

}