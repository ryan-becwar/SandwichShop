package cu.cs.cpsc215.project2.TigerSub;

/**
 * Created by Ryan on 3/11/2015.
 */
public class MozzarellaCheese extends SandwichDecorator {

    public MozzarellaCheese(Item decoratedSandwich){
        super(decoratedSandwich);
    }

    @Override
    public String makeItem() {
        return super.makeItem() + ", MozzarellaCheese";
    }
}
