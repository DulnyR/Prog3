import java.util.HashSet;

public class FruitShop {
    private HashSet<Fruit> fruitSet;

    FruitShop() {
        fruitSet = new HashSet<>();
    }

    public void addFruit(Fruit fruit) {
        fruitSet.add(fruit);
    }

    public HashSet<Fruit> getFruitSet() {
        return fruitSet;
    }
}
