/** implemented by grace */
package cu.cs.cpsc215.project2;

import java.util.*;

public class TigerSub {
	
	private static int numCustomers = 0;
	private static boolean simulate = false;	
	private static int randomSeed = 0;
	private static Order[] customerOrders;
	private static Menu myMenu = Menu.getMenu();
	
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
	
	public static void simulateOrder() {
		Random numGenerator = new Random((long)randomSeed);
		for(int i = 0; i < numCustomers; i++) {
			customerOrders[i] = new Order();
			for (int j = 0; j < 12; j++) {
				customerOrders[i].addToOrder(j, numGenerator.nextInt(6));
			}
			customerOrders[i].print();
		}
	}
	
	public static void promptOrder() throws InputMismatchException {
		Scanner scanner = new Scanner(System.in);

		for(int i = 0; i < numCustomers; i++) {
			customerOrders[i] = new Order();

			for(int j = 0; j < 12; j++) {
				System.out.println("Enter how many " + "Item " + j + " you want!");
				int numOfItem = 0;
				try {numOfItem = scanner.nextInt();}
				catch (InputMismatchException ime) {
					throw new InputMismatchException();
				}
				catch (NoSuchElementException nse) {}
				finally {customerOrders[i].addToOrder(j, numOfItem);}
			}
			customerOrders[i].print();
		}

		scanner.close();
	}
	
    public static void main(String[] args){
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
    		System.out.println("Input Mismatch - not an int!");
    		return;
    	}
    	finally {   
    	  //print the Orders! 
    	  for(int i = 0; i < numCustomers; i++) {
    	  	customerOrders[i].print();
    	  }
    	  System.out.println("DONE!");		
    	}
    }
}








