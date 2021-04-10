package hu.ak_akademia.cassa.db.preparedstatementwriter.entry;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.cassa.db.dto.EntryDto;
import hu.ak_akademia.cassa.db.preparedstatementwriter.PreparedStatementWriter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InsertEntryPreparedStatementWriter implements PreparedStatementWriter {

	private final EntryDto entryDto;

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setLong(i++, entryDto.getCassaId());
		preparedStatement.setString(i++, entryDto.getName());
		preparedStatement.setLong(i++, entryDto.getAmount());
	}

}