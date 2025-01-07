import com.coti.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {
        int number = Esdia.readInt("Enter number: ");

        Float[] floats = new Float[5];
        float total = 0;

        for(int i = 0; i < number; i++) {
            total += floats[i];
        }

        System.out.println("Mean: " + (total / number));
    }
}
