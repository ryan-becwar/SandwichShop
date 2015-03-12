package cu.cs.cpsc215.project2.TigerSub;

/**
 * Created by Ryan on 3/11/2015.
 */
public class DecoratorTest {

    public static void main(String args[]){
        Item s = new MozzarellaCheese(new MarinaraSauce(new Meatballs(new Sandwich("Italian Meatball", 4.75))));

        System.out.println("Name: " + s.makeItem() + "Cost: " + s.getCost());
    }
}
