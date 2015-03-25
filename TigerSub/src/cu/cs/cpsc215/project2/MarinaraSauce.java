package cu.cs.cpsc215.project2;

/**
 * Created by Ryan on 3/11/2015.
 */
public class MarinaraSauce extends SandwichDecorator {

    public MarinaraSauce(Item decoratedSandwich){
        super(decoratedSandwich);
    }

    @Override
    public String toString() {
        return super.toString() + ", MarinaraSauce";
    }

}
