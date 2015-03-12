package cu.cs.cpsc215.project2.TigerSub;

/**
 * Created by Ryan on 3/11/2015.
 */
public abstract class SandwichDecorator implements Item {

    protected Item decoratedSandwich;

    public SandwichDecorator(Item decoratedSandwich){
        this.decoratedSandwich = decoratedSandwich;
    }

    public String makeItem() {
        return decoratedSandwich.makeItem();
    }

    public double getCost() {
            return decoratedSandwich.getCost();
    }
}
