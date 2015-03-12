/**
* @author Ryan Becwar and Grace Glenn
*/

package cu.cs.cpsc215.project2.TigerSub;

public class Order {
	
	private String customerName; //name of customer
	private int[] ticket; //contains amount of each item ordered
	private double subTotal;
	
	public static int customerNumber = 0; //customer number, updated as orders are placed
	public static Menu tigerSubMenu;
	
	/**
	 * Default constructor
	 */
	public Order() {
		customerName = "Customer " + customerNumber;
		customerNumber++;
		
		ticket = new int[12];
		tigerSubMenu = Menu.getMenu();
		
		subTotal = 0;
	}
	
	/**
	 * returns the name of the customer
	 */
	public String getName() {
		return customerName;
	}
	
	/**
	 * returns the subtotal of the customer
	 * @return subtotal
	 */
	public double returnSubTotal() {
		return subTotal;
	}
	
	/**
	 * Adds a specified amount to a given item on the customer's ticket.
	 * 
	 * @param itemNum is the index of the ticket to be added to
	 * @param amountOrdered is the amount of items added to the ticket
	 */
	public void addToOrder(int itemNum, int amountOrdered) {	
		if((itemNum < 12) && (itemNum >= 0)){
		  ticket[itemNum] += amountOrdered;
	    }
	}
	
	/**
	 * Prints order to standard out, calculates the order simulataneously.
	 */
	public void printOrder() {
		System.out.println("-------------------------------\n" + customerName);
		for(int i = 0; i < 12; i++) {
			if(ticket[i] > 0) {
				System.out.println(ticket[i] + " " + tigerSubMenu.getItem(i).makeItem());
				subTotal += tigerSubMenu.getItem(i).getCost();
			}
		}
		
		System.out.println("Subtotal: $%.2lf", subTotal);
		System.out.println("Tax: $%.2lf", (subTotal * .07));
		System.out.println("Total: %.2lf", (subTotal * 1.07));
		System.out.println();
	}
}
