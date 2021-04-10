package hu.ak_akademia.cassa.menu;

import java.util.List;

import hu.ak_akademia.cassa.db.dao.CassaDao;
import hu.ak_akademia.cassa.db.dao.EntryDao;
import hu.ak_akademia.cassa.db.dto.CassaDto;
import hu.ak_akademia.cassa.db.preparedstatementwriter.cassa.CassaIdPreparedStatementWriter;
import hu.ak_akademia.cassa.db.preparedstatementwriter.entry.DeleteEntriesByCassaIdPreparedStatementWriter;
import hu.ak_akademia.cassa.db.resultsetreader.cassa.SelectAllColumnsOfCassaResultSetReader;
import hu.ak_akademia.cassa.db.sqlbuilder.cassa.DeleteCassaByIdSqlBuilder;
import hu.ak_akademia.cassa.db.sqlbuilder.cassa.SelectCassaByIdSqlBuilder;
import hu.ak_akademia.cassa.db.sqlbuilder.entry.DeleteEntriesByCassaIdSqlBuilder;
import hu.ak_akademia.cassa.userinputmanager.UserInputManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteCassa implements MenuOption {

	private final UserInputManager in;
	private final MainMenu mainMenu;

	@Override
	public int getSequenceNumber() {
		return 3;
	}

	@Override
	public String getDescription() {
		return "Pénztár törlése";
	}

	@Override
	public boolean execute() {
		CassaDto currentlyLoadedCassa = mainMenu.getCurrentlyLoadedCassa();
		List<CassaDto> result;
		CassaDao cassaDao = new CassaDao();
		long id;
		do {
			id = in.readLong("Kérem, adja meg a törlendő kassza azonosítóját: ");
			result = cassaDao.retrieve(new SelectCassaByIdSqlBuilder(), new CassaIdPreparedStatementWriter(id), new SelectAllColumnsOfCassaResultSetReader());
			if (result.isEmpty()) {
				System.out.println("Nem létezik a megadott azonosítóval pénztár.");
			} else if (currentlyLoadedCassa.getId() == id) {
				System.out.println("Az aktuálisan betöltött pénztár nem törölhető.");
			}
		} while (result.isEmpty() || currentlyLoadedCassa.getId() == id);
		String userAnswer;
		do {
			userAnswer = in.readString("Biztos, hogy törölni szeretné a pénztárat és az összes hozzá tartozó bejegyzést? (i/n): ");
		} while (!"i".equals(userAnswer) && !"n".equals(userAnswer));
		if ("i".equals(userAnswer)) {
			EntryDao entryDao = new EntryDao();
			entryDao.delete(new DeleteEntriesByCassaIdSqlBuilder(), new DeleteEntriesByCassaIdPreparedStatementWriter(id));
			cassaDao.delete(new DeleteCassaByIdSqlBuilder(), new CassaIdPreparedStatementWriter(id));
			System.out.println("A megadott kassza és az ahhoz tartozó összes bejegyzés sikeresen törölve.");
		} else {
			System.out.println("Művelet visszavonva, törlés nem történt.");
		}
		return false;
	}

}