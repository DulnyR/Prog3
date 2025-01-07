import com.coti.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {
        int numberOne = Esdia.readInt("Enter first number: ");
        int numberTwo = Esdia.readInt("Enter second number: ");
        System.out.println("Total: " + (numberOne + numberTwo));
    }
}
