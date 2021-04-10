package hu.ak_akademia.cassa.menu;

public class Exit implements MenuOption {

	@Override
	public int getSequenceNumber() {
		return 5;
	}

	@Override
	public String getDescription() {
		return "Kilépés";
	}

	@Override
	public boolean execute() {
		return true;
	}

}