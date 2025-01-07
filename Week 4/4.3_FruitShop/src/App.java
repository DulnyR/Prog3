import java.util.HashMap;
import java.util.Map.Entry;

import com.coti.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {
        double applePrice = Esdia.readDouble("What is today's apple price?");
        double pearPrice = Esdia.readDouble("What is today's pear price?");

        Fruit apple = new Fruit("Apple", applePrice);
        Fruit pear = new Fruit("Pear", pearPrice);

        FruitShop shop = new FruitShop();

        shop.addFruit(apple);
        shop.addFruit(pear);
        
        HashMap<Fruit, Integer> fruitToQuantityMap = new HashMap<Fruit, Integer>();

        for(Fruit fruit : shop.getFruitSet()) {
            int quantity = Esdia.readInt("How many " + fruit.getType() + "s would you like to buy?");
            fruitToQuantityMap.put(fruit, quantity);
        }

        double total = 0;

        System.out.println("|---------------------------------------------------|");
        System.out.println("| Cliente                                           |");
        System.out.println("|---------------------------------------------------|");

        for(Entry<Fruit, Integer> entry : fruitToQuantityMap.entrySet()) {
            Fruit fruit = entry.getKey();
            int quantity = entry.getValue();
            double price = fruit.getPricePerKGWithVAT() * quantity;
            total += price;
            System.out.println(String.format("| %5ss | %1d kg | precio Kg con IVA %5.2f | %5.2f € |", 
            fruit.getType(), quantity, fruit.getPricePerKGWithVAT(), price));
        }

        System.out.println("|---------------------------------------------------|");
        System.out.println(String.format("| Total price with VAT %6.2f €                     |", total));
        System.out.println("|---------------------------------------------------|");
    }
}
