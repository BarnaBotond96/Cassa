package hu.ak_akademia.cassa.menu;

import java.util.List;

import hu.ak_akademia.cassa.menu.submenu.BackToMainMenu;
import hu.ak_akademia.cassa.menu.submenu.DeleteEntry;
import hu.ak_akademia.cassa.menu.submenu.ListEntries;
import hu.ak_akademia.cassa.menu.submenu.NewEntry;
import hu.ak_akademia.cassa.userinputmanager.UserInputManager;

public class ManageEntries extends AbstractMenu implements MenuOption {

	private final MainMenu mainMenu;

	public ManageEntries(UserInputManager in, MainMenu mainMenu) {
		super(in, "B E J E G Y Z É S E K   K E Z E L É S E");
		this.mainMenu = mainMenu;
		initMenuOptions(List.of(new ListEntries(mainMenu), new NewEntry(in, mainMenu), new DeleteEntry(in, mainMenu), new BackToMainMenu()));
	}

	@Override
	public int getSequenceNumber() {
		return 4;
	}

	@Override
	public String getDescription() {
		return "Bejegyzések kezelése";
	}

	@Override
	public boolean execute() {
		boolean backToMainMenu;
		do {
			printMenuOptions();
			int userChoice = readSelection();
			backToMainMenu = executeMenuOption(userChoice);
		} while (!backToMainMenu);
		return false;
	}

}