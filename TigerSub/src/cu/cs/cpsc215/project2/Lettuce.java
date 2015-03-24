package cu.cs.cpsc215.project2;

/**
 * Created by Ryan on 3/23/2015.
 */
public class Lettuce extends SandwichDecorator {

    public Lettuce(Item decoratedSandwich){
        super(decoratedSandwich);
    }

    @Override
    public String makeItem() {
        return super.makeItem() + ", Lettuce";
    }

}
