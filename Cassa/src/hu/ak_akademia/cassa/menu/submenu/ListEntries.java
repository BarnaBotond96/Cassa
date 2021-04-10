package hu.ak_akademia.cassa.menu.submenu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import hu.ak_akademia.cassa.db.dao.EntryDao;
import hu.ak_akademia.cassa.db.dto.EntryDto;
import hu.ak_akademia.cassa.db.preparedstatementwriter.entry.SelectAllEntriesByCassaIdPreparedStatementWriter;
import hu.ak_akademia.cassa.db.resultsetreader.entry.SelectAllColumnsOfEntryResultSetReader;
import hu.ak_akademia.cassa.db.sqlbuilder.entry.SelectAllEntriesByCassaIdSqlBuilder;
import hu.ak_akademia.cassa.menu.MainMenu;
import hu.ak_akademia.cassa.menu.MenuOption;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ListEntries implements MenuOption {

	private final MainMenu mainMenu;

	@Override
	public int getSequenceNumber() {
		return 1;
	}

	@Override
	public String getDescription() {
		return "Bejegyzések listázása";
	}

	@Override
	public boolean execute() {
		Long cassaId = mainMenu.getCurrentlyLoadedCassa().getId();
		EntryDao dao = new EntryDao();
		List<EntryDto> entries = dao.retrieve(new SelectAllEntriesByCassaIdSqlBuilder(), new SelectAllEntriesByCassaIdPreparedStatementWriter(cassaId), new SelectAllColumnsOfEntryResultSetReader());
		System.out.printf("%6s %20s %10s %23s%n", "ID", "Megnevezés", "Mennyiség", "Időpont");
		for (EntryDto entry : entries) {
			LocalDateTime creationDate = entry.getCreationDate();
			System.out.printf("%6d %20s %10d %23s%n", entry.getEntryId(), entry.getName(), entry.getAmount(), creationDate.format(DateTimeFormatter.ofPattern("yyyy. MM. dd. hh:mm:ss")));
		}
		return false;
	}

}