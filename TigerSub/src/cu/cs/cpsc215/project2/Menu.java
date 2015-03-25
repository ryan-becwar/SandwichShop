package cu.cs.cpsc215.project2;

public class Menu {
	
	private static final int ITEMS_ON_MENU = 12;
	private static Menu myMenu;
	private Item[] menuItems;


	/** 
	 * Constructor for Menu.
	 */
	private Menu() {
		menuItems = new Item[ITEMS_ON_MENU];

		//Item 0: Italian Meatball
		menuItems[0] = new MozzarellaCheese(new MarinaraSauce(new Meatballs(new Sandwich("Italian Meatball", 4.75))));

		//Item 1: Steak & Cheese
		menuItems[1] = new Mayo(new Mustard(new SauteedOnions(new SauteedPeppers(new ProvoloneCheese(new Steak(new Sandwich("Steak & Cheese", 5.00)))))));

		//Item 2: Turkey
		menuItems[2] = new TurkeyBreast(new SwissCheese(new Lettuce(new Tomato(new Ranch(new Sandwich("Turkey", 4.50))))));

		//Item 3: Tuna
		menuItems[3] = new Tuna(new CheddarCheese(new Lettuce(new Tomato(new RedWineVinaigrette(new Sandwich("Tuna", 4.50))))));

		//Item 4: Veggie Lovers
		menuItems[4] = new AmericanCheese(new Lettuce(new Tomato(new Cucumber(new Onions(new Avocado(new Mayo(new Sandwich("Veggie Lovers", 4.25))))))));

		//Item 5: Soda
		menuItems[5] = new Drink("Soda", 1.00);
		
		//Item 6: Sweet Tea
		menuItems[6] = new Drink("Sweet Tea", 1.25);
		
		//Item 7: Lemonade
		menuItems[7] = new Drink("Lemonade", 1.50);
		
		//Item 8: Water
		menuItems[8] = new Drink("Water", 0.00);
		
		//Item 9: Cookie
		menuItems[9] = new Dessert("Cookie", 0.25);
		
		//Item 10: Chips
		menuItems[10] = new Dessert("Chips", 0.75);
		
		//Item 11: Brownie
		menuItems[11] = new Dessert("Brownies", 1.00);
	}
	
	/**
	 * Returns only one kind of menu (singleton).
	 */
	public static Menu getMenu() {
		if(myMenu == null) myMenu = new Menu();
		
		return myMenu;
	}
	
	/**
	 * Returns item from menu if valid number is given.
	 * @param itemNum being the number on the menu the item is.
	 */
	public Item getItem(int itemNum) {
		if((itemNum >= 0) && (itemNum < 12)) return menuItems[itemNum];
		
		return null;
	}
	
	
}
