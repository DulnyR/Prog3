import com.coti.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {
        int number = Esdia.readInt("How many numbers for calculation? ");

        float total = 0;

        for(int i = 0; i < number; i++) {
            total += Esdia.readFloat("Enter number " + (i + 1) + ": ");
        }

        System.out.println("Mean: " + (total / number));
    }
}
