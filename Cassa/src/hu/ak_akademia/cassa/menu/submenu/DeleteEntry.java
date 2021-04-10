package hu.ak_akademia.cassa.menu.submenu;

import hu.ak_akademia.cassa.db.dao.EntryDao;
import hu.ak_akademia.cassa.db.preparedstatementwriter.entry.DeleteEntryPreparedStatementWriter;
import hu.ak_akademia.cassa.db.sqlbuilder.entry.DeleteEntrySqlBuilder;
import hu.ak_akademia.cassa.menu.MainMenu;
import hu.ak_akademia.cassa.menu.MenuOption;
import hu.ak_akademia.cassa.userinputmanager.UserInputManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteEntry implements MenuOption {

	private final UserInputManager in;
	private final MainMenu mainMenu;

	@Override
	public int getSequenceNumber() {
		return 3;
	}

	@Override
	public String getDescription() {
		return "Bejegyzés törlése";
	}

	@Override
	public boolean execute() {
		long entryId = in.readLong("Kérem, adja meg a bejegyzés azonosítóját: ");
		long currentlyLoadedCassaId = mainMenu.getCurrentlyLoadedCassa().getId();
		EntryDao dao = new EntryDao();
		dao.delete(new DeleteEntrySqlBuilder(), new DeleteEntryPreparedStatementWriter(entryId, currentlyLoadedCassaId));
		System.out.println("Bejegyzés sikeresen törölve.");
		return false;
	}

}