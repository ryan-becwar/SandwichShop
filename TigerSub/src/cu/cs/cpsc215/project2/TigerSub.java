/** 
 * Grace Glenn and Ryan Becwar
 * created by Grace March 2015
 * Implements sandwhich shop for project2.
 */
package cu.cs.cpsc215.project2;
import java.math.*;
import java.text.*;
import java.util.*;

public class TigerSub {
	
	private static int numCustomers = 0;
	private static boolean simulate = false;	
	private static int randomSeed = 0;
	
	private static Order[] customerOrders;
	private static Menu myMenu = Menu.getMenu(); //singleton Menu
	private static final BigDecimal tax = new BigDecimal("1.07");
	private static NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
	private static double runningTotalDouble = 0;
	
	/**
	 * //@param command line arguments
	 * Takes in 2 to 3 ints verifies each one, then assigns to
	 * numCustomers, simulate and random seed.
	 * 
	 * <b>numCustomers</b> is always determined by first param. Must be >= 0.
	 * <b>simulate</b> always determined by second param. Must be 1 or 0, 1
	 * meaning to simulate and 0 meaning to not. No third argument may be given
	 * if simulation is unrequested.
	 * 
	 * <b>randomSeed</b> is determined by third param if no simulation desired.
	 * It must be >=0
	 * 
	 * A violation of any of these things results in an ImproperParameterException
	 */
	public static void checkParameters(String[] args) throws ImproperParameterException {
		
		if(args.length >= 1) {
			int firstParam = Integer.parseInt(args[0]);
			if(firstParam > 0) {
				numCustomers = firstParam;
			}
			else throw new ImproperParameterException();
		}
		else throw new ImproperParameterException();
		
		if(args.length >= 2) {
			int secondParam = Integer.parseInt(args[1]);
			if(secondParam == 1 || secondParam == 0) {
				simulate = (secondParam == 1); //will only be false if user entered 0
			}
			else throw new ImproperParameterException();
		}
		if(args.length == 3) {
			if(!simulate) throw new ImproperParameterException();
			int thirdParam = Integer.parseInt(args[2]);	
		}
		
		if(args.length > 3) throw new ImproperParameterException();	
	}
	
	/**
	 * Simulates order using numCustomers and random seed provided by user.
	 * All order amounts are pseudo-randomly generated to be between [0,5]
	 */
	public static void simulateOrder() {
		Random numGenerator = new Random((long)randomSeed);
		for(int i = 0; i < numCustomers; i++) {
			customerOrders[i] = new Order();
			for (int j = 0; j < 12; j++) {
				customerOrders[i].addToOrder(j, numGenerator.nextInt(6));
			}
		}
	}
	
	/**
	 * Prompts user to manually enter amounts of all menu items they wish
	 * to in any quantity.
	 * 
	 * If no input is given, number of items ordered is assumed to be 0.
	 * Entering a string results in an InputMismatchException.
	 */
	public static void promptOrder() throws InputMismatchException {
		Scanner scanner = new Scanner(System.in);

		for(int i = 0; i < numCustomers; i++) {
			customerOrders[i] = new Order();

			for(int j = 0; j < 12; j++) {
				System.out.println("Enter how many " +  myMenu.getItem(j).makeItem() + " you want!");
				int numOfItem = 0;
				try {numOfItem = scanner.nextInt();}
				catch (InputMismatchException ime) {
					throw new InputMismatchException();
				}
				catch (NoSuchElementException nse) {}
				finally {customerOrders[i].addToOrder(j, numOfItem);}
			}
		}
		scanner.close();
	}
	
	/**
	 * Main method that takes in parameters, checks them, and then fufills orders and prints total profit.
	 */
    public static void main(String[] args){
		BigDecimal runningTotal = new BigDecimal("0.00");
		runningTotal = runningTotal.setScale(2, BigDecimal.ROUND_HALF_UP);
    	try {
    		//check and establish parameters for number of customers, simulation, and seed
    		checkParameters(args);

    		//fufill orders
    	    customerOrders = new Order[numCustomers];
    	    if(simulate) simulateOrder(); 
    	    else promptOrder();
    	}
    	catch (ImproperParameterException ipe) {
    		System.out.println(ipe.getMessage());
    		return;
    	}
    	catch (NumberFormatException nfe) {
    		System.out.println(nfe.getMessage());
    		return;
    	}
    	catch (InputMismatchException ime) {
    		System.out.println("Input Mismatch - Exiting!");
    		return;
    	}
    	finally { 
    	  //Print all orders
          for(int i = 0; i < customerOrders.length; i++) {

			  runningTotal = runningTotal.add(customerOrders[i].returnSubTotal().multiply(tax).setScale(2, BigDecimal.ROUND_HALF_UP));
  			runningTotalDouble += (customerOrders[i].returnSubTotalDouble() * 1.07);
  			customerOrders[i].print();
          }
          //Print total profit made

			String s = n.format(runningTotal);

    	  DecimalFormat df = new DecimalFormat("#.00");
    	  System.out.println("-------------------------------\n");
    	  System.out.println("We made $" + df.format(runningTotalDouble) + " for the day!");

		}
    }
}








