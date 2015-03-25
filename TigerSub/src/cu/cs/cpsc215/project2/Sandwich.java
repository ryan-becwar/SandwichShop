/** 
 * Ryan Becwar and Grace Glenn
 **/
package cu.cs.cpsc215.project2;

public class Sandwich implements Item {

    private String name;
    private double cost;
    private String nameWithToppings;

    public Sandwich(String name, double cost) {
        this.name = name;
        this.cost = cost;
        this.nameWithToppings = name;
    }

    public String makeItem(){
        return name;
    }

    public String toString() {
        return nameWithToppings;
    }

    public double getCost(){
        return cost;
    }
}
