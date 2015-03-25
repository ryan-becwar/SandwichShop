package cu.cs.cpsc215.project2;

/**
 * Created by Ryan on 3/11/2015.
 * Follows a standard decorator pattern
 */
public abstract class SandwichDecorator implements Item {

    protected Item decoratedSandwich;

    public SandwichDecorator(Item decoratedSandwich){
        this.decoratedSandwich = decoratedSandwich;
    }

    public String toString() {
        return decoratedSandwich.toString();
    }

    public double getCost() {
            return decoratedSandwich.getCost();
    }
}
