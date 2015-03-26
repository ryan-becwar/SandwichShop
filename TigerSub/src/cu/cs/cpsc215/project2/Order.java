/**
* @author Ryan Becwar and Grace Glenn
*/
package cu.cs.cpsc215.project2;

import java.text.DecimalFormat;
import java.util.*;

public class Order {
	
	private String customerName; //name of customer
	private int[] ticket; //contains amount of each item ordered
	private double subTotal;
	
	public static int customerNumber = 0; //customer number, updated as orders are placed
	public static Menu tigerSubMenu = Menu.getMenu();
	
	/**
	 * Default constructor
	 */
	public Order() {
		customerNumber++;
		customerName = "Customer " + customerNumber;		
		ticket = new int[12];
		
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
		
		subTotal += (tigerSubMenu.getItem(itemNum).getCost() * amountOrdered);
	}

	public void print() {
		System.out.println("-------------------------------");
		System.out.println(getName() + ":");
		for(int i = 0; i < 12; i++) {
			if(ticket[i] > 0) {
				System.out.println(ticket[i] + " " + tigerSubMenu.getItem(i).makeItem());
			}
		}
		
		DecimalFormat df = new DecimalFormat("#.00");
		
		System.out.println("Subtotal: $" + df.format(subTotal));
		System.out.println("Tax: $" + df.format(subTotal * .07));
		System.out.println("Total: $" + df.format(subTotal * 1.07));
	}
}

