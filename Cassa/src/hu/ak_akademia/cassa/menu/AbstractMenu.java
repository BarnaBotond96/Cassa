package hu.ak_akademia.cassa.menu;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import hu.ak_akademia.cassa.userinputmanager.UserInputManager;

public abstract class AbstractMenu implements Menu {

	protected final UserInputManager in;
	private Map<Integer, MenuOption> options;
	private final String title;

	protected AbstractMenu(UserInputManager in, String title) {
		this.in = in;
		this.title = title;
	}

	@Override
	public void initMenuOptions(List<MenuOption> options) {
		this.options = options.stream().collect(Collectors.toMap(MenuOption::getSequenceNumber, menuOption -> menuOption, (menuOption1, menuOption2) -> menuOption1, LinkedHashMap::new));
	}

	@Override
	public void printMenuOptions() {
		System.out.println();
		System.out.println(title);
		System.out.println(title.replaceAll(".", "-"));
		for (MenuOption menuOption : options.values()) {
			System.out.printf("%d. %s%n", menuOption.getSequenceNumber(), menuOption.getDescription());
		}
	}

	@Override
	public int readSelection() {
		int choice = in.readInt("\nKérem, válasszon a menüpontok közül: ");
		return choice;
	}

	@Override
	public boolean executeMenuOption(int userChoice) {
		MenuOption selectedMenuOption = options.get(userChoice);
		if (selectedMenuOption == null) {
			System.out.println("Kérem, válasszon a menüpontok közül: ");
			return false;
		}
		System.out.printf("%nÖn a(z) \"%s\" menüpontot választotta.%n", selectedMenuOption.getDescription());
		System.out.println();
		return selectedMenuOption.execute();
	}

}