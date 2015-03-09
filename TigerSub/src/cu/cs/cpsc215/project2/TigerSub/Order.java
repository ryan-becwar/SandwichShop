/**
*
*/

package cu.cs.cpsc215.project2.TigerSub;

public class Order {
	
	private String customerName; //name of customer, eg Customer1 or John Smith
	private int[] ticket; //contains amount of each item ordered
	
	public Order() {
		
		customerName = "Customer #1";
		//ticket already intitalized!
	}
	
	public String getName() {return customerName;}
	
	public int[] getTicket() {return ticket;}

}
