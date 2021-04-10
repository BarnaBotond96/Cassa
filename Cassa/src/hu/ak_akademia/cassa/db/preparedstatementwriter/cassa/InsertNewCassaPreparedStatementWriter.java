package hu.ak_akademia.cassa.db.preparedstatementwriter.cassa;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.cassa.db.dto.CassaDto;
import hu.ak_akademia.cassa.db.preparedstatementwriter.PreparedStatementWriter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InsertNewCassaPreparedStatementWriter implements PreparedStatementWriter {

	private final CassaDto cassaDto;

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setString(i++, cassaDto.getName());
		preparedStatement.setLong(i++, cassaDto.getLimit());
	}

}