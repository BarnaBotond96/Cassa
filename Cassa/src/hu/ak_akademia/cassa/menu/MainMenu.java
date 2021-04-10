package hu.ak_akademia.cassa.menu;

import java.util.List;

import hu.ak_akademia.cassa.db.dto.CassaDto;
import hu.ak_akademia.cassa.userinputmanager.UserInputManager;

public class MainMenu extends AbstractMenu {

	private CassaDto currentlyLoadedCassa;

	public MainMenu(UserInputManager in) {
		super(in, "F Ő M E N Ü");
		initMenuOptions(List.of(new NewCassa(in), new LoadCassa(in, this), new DeleteCassa(in, this), new ManageEntries(in, this), new Exit()));
	}

	public CassaDto getCurrentlyLoadedCassa() {
		return currentlyLoadedCassa;
	}

	public void setCurrentlyLoadedCassa(CassaDto currentlyLoadedCassa) {
		this.currentlyLoadedCassa = currentlyLoadedCassa;
	}

}