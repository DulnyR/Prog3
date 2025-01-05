import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Damageable> objects = new ArrayList<>();

        objects.add(new Wall(500));
        objects.add(new Character(300));
        objects.add(new Knight(400));

        for (Damageable object : objects) {
            object.applyDamage(100);
        }

        System.out.println("Object: " + objects.get(0).getClass() + ", Health: " + ((Wall) objects.get(0)).getDurability());
        System.out.println("Object: " + objects.get(1).getClass() + ", Health: " + ((Character) objects.get(1)).getHealth());
        System.out.println("Object: " + objects.get(2).getClass() + ", Health: " + ((Character) objects.get(2)).getHealth());
    }
}
