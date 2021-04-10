package hu.ak_akademia.cassa.db.sqlbuilder.cassa;

import hu.ak_akademia.cassa.db.sqlbuilder.SqlBuilder;

public class UpdateLastEditSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "UPDATE cassa SET last_edit = NOW() WHERE cassa_id = ?";
	}

}