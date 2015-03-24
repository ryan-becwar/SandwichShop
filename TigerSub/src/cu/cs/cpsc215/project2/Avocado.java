package cu.cs.cpsc215.project2;

/**
 * Created by Ryan on 3/23/2015.
 */
public class Avocado extends SandwichDecorator {

    public Avocado(Item decoratedSandwich){
        super(decoratedSandwich);
    }

    @Override
    public String makeItem() {
        return super.makeItem() + ", Avocado";
    }

}
