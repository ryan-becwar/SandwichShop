package cu.cs.cpsc215.project2;

/**
 * Created by Ryan on 3/23/2015.
 */
public class CheddarCheese extends SandwichDecorator {

    public CheddarCheese(Item decoratedSandwich){
        super(decoratedSandwich);
    }

    @Override
    public String toString() {
        return super.toString() + ", CheddarCheese";
    }

}
