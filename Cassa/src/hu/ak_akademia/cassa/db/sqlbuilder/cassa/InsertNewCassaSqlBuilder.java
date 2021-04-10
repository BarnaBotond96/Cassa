package hu.ak_akademia.cassa.db.sqlbuilder.cassa;

import hu.ak_akademia.cassa.db.sqlbuilder.SqlBuilder;

public class InsertNewCassaSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "INSERT INTO cassa (cassa_id, cassa_name, cassa_limit, last_edit) VALUES (NEXTVAL('cassa_seq'), ?, ?, NOW())";
	}

}