public class Menu {
	
	private static final int ITEMS_ON_MENU = 12;
	private static Menu myMenu;
	private Item[] menuItems;

	/** 
	 * Constructor for Menu.
	 */
	private Menu() {
		menuItems = new Menu[ITEMS_ON_MENU];
	}
	
	/**
	 * Returns only one kind of menu (singleton).
	 */
	public static Menu getMenu() {
		if(myMenu == null) {
			myMenu = new Menu();
		}
		return myMenu;
	}
	
	
}
