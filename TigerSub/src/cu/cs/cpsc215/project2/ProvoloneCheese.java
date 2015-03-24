package cu.cs.cpsc215.project2;

/**
 * Created by Ryan on 3/23/2015.
 */
public class ProvoloneCheese extends SandwichDecorator {

    public ProvoloneCheese(Item decoratedSandwich){
        super(decoratedSandwich);
    }

    @Override
    public String makeItem() {
        return super.makeItem() + ", ProvoloneCheese";
    }

}
