package hu.ak_akademia.cassa.db.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.cassa.db.dto.EntryDto;

public class SelectAllEntriesResultSetReader implements ResultSetReader<EntryDto> {

	@Override
	public List<EntryDto> read(ResultSet resultSet) throws SQLException {
		List<EntryDto> result = new ArrayList<>();
		while (resultSet.next()) {
			long entryId = resultSet.getLong("entry_id");
			long cassaId = resultSet.getLong("cassa_id");
			String name = resultSet.getString("entry_name");
			long amount = resultSet.getLong("amount");
			Timestamp creationDate = resultSet.getTimestamp("creation_date");

			EntryDto entryDto = new EntryDto();
			entryDto.setEntryId(entryId);
			entryDto.setCassaId(cassaId);
			entryDto.setName(name);
			entryDto.setAmount(amount);
			entryDto.setCreationDate(creationDate.toLocalDateTime());
			result.add(entryDto);
		}
		return result;
	}

}