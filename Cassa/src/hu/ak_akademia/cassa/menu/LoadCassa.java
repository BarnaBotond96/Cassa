package hu.ak_akademia.cassa.menu;

import java.util.List;

import hu.ak_akademia.cassa.db.dao.BooleanDao;
import hu.ak_akademia.cassa.db.dao.CassaDao;
import hu.ak_akademia.cassa.db.dto.CassaDto;
import hu.ak_akademia.cassa.db.preparedstatementwriter.EmptyPreparedStatementWriter;
import hu.ak_akademia.cassa.db.preparedstatementwriter.cassa.CassaIdPreparedStatementWriter;
import hu.ak_akademia.cassa.db.resultsetreader.BooleanResultSetReader;
import hu.ak_akademia.cassa.db.resultsetreader.cassa.SelectAllColumnsOfCassaResultSetReader;
import hu.ak_akademia.cassa.db.sqlbuilder.QueryCassaLimit;
import hu.ak_akademia.cassa.db.sqlbuilder.cassa.SelectCassaByIdSqlBuilder;
import hu.ak_akademia.cassa.db.sqlbuilder.cassa.SelectLastEditedCassaSqlBuilder;
import hu.ak_akademia.cassa.userinputmanager.UserInputManager;

public class LoadCassa implements MenuOption {

	private final UserInputManager in;
	private final MainMenu mainMenu;

	public LoadCassa(UserInputManager in, MainMenu mainMenu) {
		this.in = in;
		this.mainMenu = mainMenu;
		CassaDao dao = new CassaDao();
		List<CassaDto> results = dao.retrieve(new SelectLastEditedCassaSqlBuilder(), new EmptyPreparedStatementWriter(), new SelectAllColumnsOfCassaResultSetReader());
		this.mainMenu.setCurrentlyLoadedCassa(results.get(0));
	}

	@Override
	public int getSequenceNumber() {
		return 2;
	}

	@Override
	public String getDescription() {
		return String.format("Pénztár betöltése (aktuális: %s (%d))", mainMenu.getCurrentlyLoadedCassa().getName(), mainMenu.getCurrentlyLoadedCassa().getId());
	}

	@Override
	public boolean execute() {
		List<CassaDto> results;
		do {
			long id = in.readLong("Kérem, adja meg a betölteni kívánt kassza azonosítóját: ");
			CassaDao dao = new CassaDao();
			results = dao.retrieve(new SelectCassaByIdSqlBuilder(), new CassaIdPreparedStatementWriter(id), new SelectAllColumnsOfCassaResultSetReader());
		} while (results.isEmpty());
		this.mainMenu.setCurrentlyLoadedCassa(results.get(0));
		Long currentCassaId = this.mainMenu.getCurrentlyLoadedCassa().getId();
		BooleanDao booleanDao = new BooleanDao();
		boolean limitReached = booleanDao.retrieve(new QueryCassaLimit(), new CassaIdPreparedStatementWriter(currentCassaId), new BooleanResultSetReader()).get(0);
		if (limitReached) {
			System.out.println("A pénztár elérte a limitet!");
		}
		return false;
	}

}