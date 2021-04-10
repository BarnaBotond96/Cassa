package hu.ak_akademia.cassa.menu.submenu;

import hu.ak_akademia.cassa.menu.MenuOption;

public class BackToMainMenu implements MenuOption {

	@Override
	public int getSequenceNumber() {
		return 4;
	}

	@Override
	public String getDescription() {
		return "Vissza a főmenübe";
	}

	@Override
	public boolean execute() {
		return true;
	}

}