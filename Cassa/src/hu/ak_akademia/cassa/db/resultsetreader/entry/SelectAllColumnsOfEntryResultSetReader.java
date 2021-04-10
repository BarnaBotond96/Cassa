package hu.ak_akademia.cassa.db.resultsetreader.entry;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.cassa.db.dto.EntryDto;
import hu.ak_akademia.cassa.db.resultsetreader.ResultSetReader;

public class SelectAllColumnsOfEntryResultSetReader implements ResultSetReader<EntryDto> {

	@Override
	public List<EntryDto> read(ResultSet resultSet) throws SQLException {
		List<EntryDto> results = new ArrayList<>();
		while (resultSet.next()) {
			long entryId = resultSet.getLong("entry_id");
			long cassaId = resultSet.getLong("cassa_id");
			String name = resultSet.getString("entry_name");
			long amount = resultSet.getLong("amount");
			LocalDateTime creationDate = resultSet.getTimestamp("creation_date").toLocalDateTime();
			EntryDto entryDto = new EntryDto();
			entryDto.setEntryId(entryId);
			entryDto.setCassaId(cassaId);
			entryDto.setName(name);
			entryDto.setAmount(amount);
			entryDto.setCreationDate(creationDate);

			results.add(entryDto);
		}

		return results;
	}

}