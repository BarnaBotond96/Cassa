package hu.ak_akademia.cassa.db.resultsetreader.cassa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.cassa.db.dto.CassaDto;
import hu.ak_akademia.cassa.db.resultsetreader.ResultSetReader;

public class SelectAllColumnsOfCassaResultSetReader implements ResultSetReader<CassaDto> {

	@Override
	public List<CassaDto> read(ResultSet resultSet) throws SQLException {
		List<CassaDto> results = new ArrayList<>();
		while (resultSet.next()) {
			long id = resultSet.getLong("cassa_id");
			String name = resultSet.getString("cassa_name");
			long limit = resultSet.getLong("cassa_limit");
			LocalDateTime lastEdit = resultSet.getTimestamp("last_edit").toLocalDateTime();
			
			CassaDto cassaDto = new CassaDto();
			cassaDto.setId(id);
			cassaDto.setName(name);
			cassaDto.setLimit(limit);
			cassaDto.setLastEdit(lastEdit);
			results.add(cassaDto);
		}
		return results;
	}

}