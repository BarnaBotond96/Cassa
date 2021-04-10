package hu.ak_akademia.cassa;

import java.util.Scanner;

import hu.ak_akademia.cassa.menu.MainMenu;
import hu.ak_akademia.cassa.userinputmanager.UserInputManager;

public class App {

	public static void main(String[] args) {
		new App().run();
	}

	private void run() {
		System.out.println("Üdvözöllek a pénztár programban.");
		try (Scanner scanner = new Scanner(System.in)) {
			UserInputManager in = new UserInputManager(scanner);
			MainMenu menu = new MainMenu(in);
			boolean exitRequested = false;
			do {
				menu.printMenuOptions();
				int userChoice = menu.readSelection();
				exitRequested = menu.executeMenuOption(userChoice);
			} while (!exitRequested);
		}
		System.out.println("Viszlát!");
	}

}