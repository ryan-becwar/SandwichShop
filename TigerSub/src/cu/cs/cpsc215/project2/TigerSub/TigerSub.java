
package cu.cs.cpsc215.project2;

public class TigerSub {
	
	private static int numCustomers = 0;
	private static boolean simulate = false;	
	private static int randomSeed = 0;
	
	public static void checkParameters(String[] args) throws ImproperParameterException {
		
		if(args.length >= 1) {
			int firstParam = Interger.parseInt(args[0]);
			if(firstPara > 0) {
				numCustomers = firstParam;
			}
			else throw new ImproperParameterException();
		}
		else throw new ImproperParameterException();
		
		if(args.length >= 2) {
			int secondParam = Interger.parseInt(args[1]);
			if(secondParam == 1 || secondParam == 0) {
				simulate = (secondParam == 1);
			}
			else throw new ImproperParameterException();
		}
		if(args.length == 3) {
			int thirdParam = Interger.parseInt(args[2]);	
		}
		
		if(args.length > 3) throw new ImproperParameterException();	
	}
	
    public static void main(String[] args){
    	//Determine which parameters the user gave
    	checkParameters(args);
    	
    	//if no simulation, 
    }
}
