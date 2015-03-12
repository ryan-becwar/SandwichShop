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
	
	/**
	 * Returns item from menu if valid number is given.
	 * @param itemNum being the number on the menu the item is.
	 */
	public Item getItem(int itemNum) {
		if((itemNum >= 0) && (itemNum <12)) {
			return menuItems[itemNum];
		}
		return null;
	}
	
	
}
