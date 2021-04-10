package hu.ak_akademia.cassa.userinputmanager;

import java.util.Scanner;

public class UserInputManager {

	private final Scanner scanner;

	public UserInputManager(Scanner scanner) {
		this.scanner = scanner;
	}

	public int readInt(String message) {
		System.out.print(message);
		int number = scanner.nextInt();
		scanner.nextLine();
		return number;
	}

	public long readLong(String message) {
		System.out.print(message);
		long number = scanner.nextLong();
		scanner.nextLine();
		return number;
	}

	public String readString(String message) {
		System.out.print(message);
		return scanner.nextLine();
	}

}