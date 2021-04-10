package hu.ak_akademia.cassa.db.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooleanResultSetReader implements ResultSetReader<Boolean> {

	@Override
	public List<Boolean> read(ResultSet resultSet) throws SQLException {
		List<Boolean> results = new ArrayList<>();
		while (resultSet.next()) {
			results.add(resultSet.getBoolean(1));
		}
		return results;
	}

}