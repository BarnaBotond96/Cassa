package hu.ak_akademia.cassa.db.sqlbuilder.cassa;

import hu.ak_akademia.cassa.db.sqlbuilder.SqlBuilder;

public class SelectLastEditedCassaSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM cassa ORDER BY last_edit DESC";
	}

}