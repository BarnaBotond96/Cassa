package hu.ak_akademia.cassa.menu;

public interface MenuOption {

	int getSequenceNumber();

	String getDescription();

	boolean execute();

}