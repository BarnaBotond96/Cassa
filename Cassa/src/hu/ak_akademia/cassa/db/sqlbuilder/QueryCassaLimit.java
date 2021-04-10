package hu.ak_akademia.cassa.db.sqlbuilder;

public class QueryCassaLimit implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT SUM(COALESCE(e.amount, 0)) > c.cassa_limit sum FROM cassa c LEFT OUTER JOIN entry e ON c.cassa_id = e.cassa_id WHERE c.cassa_id = ? GROUP BY c.cassa_id";
	}

}