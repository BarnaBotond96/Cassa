package hu.ak_akademia.cassa.db.sqlbuilder.entry;

import hu.ak_akademia.cassa.db.sqlbuilder.SqlBuilder;

public class InsertEntrySqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "INSERT INTO entry (entry_id, cassa_id, entry_name, amount, creation_date) VALUES (NEXTVAL('entry_seq'), ?, ?, ?, NOW())";
	}

}