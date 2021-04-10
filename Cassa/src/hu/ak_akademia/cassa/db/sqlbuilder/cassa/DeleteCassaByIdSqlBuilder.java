package hu.ak_akademia.cassa.db.sqlbuilder.cassa;

import hu.ak_akademia.cassa.db.sqlbuilder.SqlBuilder;

public class DeleteCassaByIdSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "DELETE FROM cassa WHERE cassa_id = ?";
	}

}