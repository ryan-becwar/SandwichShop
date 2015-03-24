package cu.cs.cpsc215.project2;

/**
 * Created by Ryan on 3/11/2015.
 */
public class Meatballs extends SandwichDecorator {

    public Meatballs(Item decoratedSandwich){
        super(decoratedSandwich);
    }

    @Override
    public String makeItem() {
        return super.makeItem() + ", Meatballs";
    }
}
