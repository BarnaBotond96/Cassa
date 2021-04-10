package hu.ak_akademia.cassa.db.preparedstatementwriter;

import java.sql.PreparedStatement;

public class EmptyPreparedStatementWriter implements PreparedStatementWriter {

	@Override
	public void write(PreparedStatement preparedStatement) {
	}

}