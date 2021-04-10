package hu.ak_akademia.cassa.menu.submenu;

import hu.ak_akademia.cassa.db.dao.BooleanDao;
import hu.ak_akademia.cassa.db.dao.CassaDao;
import hu.ak_akademia.cassa.db.dao.EntryDao;
import hu.ak_akademia.cassa.db.dto.EntryDto;
import hu.ak_akademia.cassa.db.preparedstatementwriter.cassa.CassaIdPreparedStatementWriter;
import hu.ak_akademia.cassa.db.preparedstatementwriter.cassa.UpdateLastEditPreparedStatementWriter;
import hu.ak_akademia.cassa.db.preparedstatementwriter.entry.InsertEntryPreparedStatementWriter;
import hu.ak_akademia.cassa.db.resultsetreader.BooleanResultSetReader;
import hu.ak_akademia.cassa.db.sqlbuilder.QueryCassaLimit;
import hu.ak_akademia.cassa.db.sqlbuilder.cassa.UpdateLastEditSqlBuilder;
import hu.ak_akademia.cassa.db.sqlbuilder.entry.InsertEntrySqlBuilder;
import hu.ak_akademia.cassa.menu.MainMenu;
import hu.ak_akademia.cassa.menu.MenuOption;
import hu.ak_akademia.cassa.userinputmanager.UserInputManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NewEntry implements MenuOption {

	private final UserInputManager in;
	private final MainMenu mainMenu;

	@Override
	public int getSequenceNumber() {
		return 2;
	}

	@Override
	public String getDescription() {
		return "Új bejegyzés hozzáadása";
	}

	@Override
	public boolean execute() {
		String name = in.readString("Kérem, adja meg a bejegyzés leírását: ");
		long amount = in.readLong("Kérem, adja meg a bejegyzés összegét: ");
		long currentlyLoadedCassaId = mainMenu.getCurrentlyLoadedCassa().getId();

		EntryDto entryDto = new EntryDto();
		entryDto.setName(name);
		entryDto.setAmount(amount);
		entryDto.setCassaId(currentlyLoadedCassaId);

		EntryDao entryDao = new EntryDao();
		entryDao.create(new InsertEntrySqlBuilder(), new InsertEntryPreparedStatementWriter(entryDto));

		CassaDao cassaDao = new CassaDao();
		cassaDao.update(new UpdateLastEditSqlBuilder(), new UpdateLastEditPreparedStatementWriter(currentlyLoadedCassaId));

		System.out.println("Bejegyzés sikeresen beszúrva.");
		Long currentCassaId = this.mainMenu.getCurrentlyLoadedCassa().getId();
		BooleanDao booleanDao = new BooleanDao();
		boolean limitReached = booleanDao.retrieve(new QueryCassaLimit(), new CassaIdPreparedStatementWriter(currentCassaId), new BooleanResultSetReader()).get(0);
		if (limitReached) {
			System.out.println("A pénztár elérte a limitet!");
		}
		return false;
	}

}