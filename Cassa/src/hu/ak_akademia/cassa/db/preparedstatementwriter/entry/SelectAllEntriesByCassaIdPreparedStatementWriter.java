package hu.ak_akademia.cassa.db.preparedstatementwriter.entry;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.cassa.db.preparedstatementwriter.PreparedStatementWriter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SelectAllEntriesByCassaIdPreparedStatementWriter implements PreparedStatementWriter {

	private final long cassaId;

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setLong(1, cassaId);
	}

}