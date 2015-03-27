/**
* @author Ryan Becwar and Grace Glenn
* created by Grace March 2015
* CPSC 2150 Project 2
* Order class allows for the creation of a customer ticket
* that keeps track of how many items are ordered from tigerSub Menu.
*/
package cu.cs.cpsc215.project2;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Order {
	
	private String customerName; //name of customer
	private int[] ticket; //contains amount of each item ordered
	private BigDecimal subTotal;
	private static final BigDecimal tax = new BigDecimal("0.07");
	private NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
	private double subTotalDouble;
	
	public static int customerNumber = 0; //customer number, updated as orders are placed
	public static Menu tigerSubMenu = Menu.getMenu();
	
	/**
	 * Default constructor
	 */
	public Order() {
		customerNumber++;
		customerName = "Customer " + customerNumber;		
		ticket = new int[12];
		subTotal = new BigDecimal("0.00");
		subTotal = subTotal.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		subTotalDouble = 0;
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

	public BigDecimal returnSubTotal() {
		return subTotal;
	}

	public double returnSubTotalDouble() {
		return subTotalDouble;
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

		//equivalent statements
		subTotal = subTotal.add(new BigDecimal(tigerSubMenu.getItem(itemNum).getCost()).multiply(new BigDecimal(amountOrdered)));
		subTotalDouble += (tigerSubMenu.getItem(itemNum).getCost() * amountOrdered);
	}

	/**
	 * Prints the Customer number and all items orderd, including subtotal, tax, and total.
	 */
	public void print() {
		System.out.println("-------------------------------");
		System.out.println(getName() + ":");
		for(int i = 0; i < 12; i++) {
			if(ticket[i] > 0) {
				System.out.println(ticket[i] + " " + tigerSubMenu.getItem(i).makeItem());
			}
		}

		String s = n.format(subTotal);
		String sTax = n.format(subTotal.multiply(tax));
		String sTaxSub = n.format(subTotal.add(subTotal.multiply(tax)));

		System.out.println("\nSubtotal: " + s);
		System.out.println("Tax: " + sTax);
		System.out.println("Total: " + sTaxSub + "\n");

		DecimalFormat df = new DecimalFormat("#.00");
		
		System.out.println("\nSubtotal: $" + df.format(subTotalDouble));
		System.out.println("Tax: $" + df.format(subTotalDouble * .07));
		System.out.println("Total: $" + df.format(subTotalDouble * 1.07) + "\n");
	}
}

