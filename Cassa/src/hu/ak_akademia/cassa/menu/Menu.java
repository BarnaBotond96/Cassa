package hu.ak_akademia.cassa.menu;

import java.util.List;

public interface Menu {

	void initMenuOptions(List<MenuOption> options);

	void printMenuOptions();

	int readSelection();

	boolean executeMenuOption(int userChoice);

}