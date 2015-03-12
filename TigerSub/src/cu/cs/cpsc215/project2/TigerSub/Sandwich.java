/** 
 * Ryan Becwar and Grace Glenn
 **/
package cu.cs.cpsc215.project2.TigerSub;

public class Sandwich implements Item {

    private String name;
    private double cost;
    private String toppings;

    public Sandwich(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String makeItem(){
        return name;
    }

    public double getCost(){
        return cost;
    }
}
