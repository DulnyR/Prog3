import java.util.Arrays;

import com.coti.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {
        String[] array = new String[5];

        for (int i = 0; i < array.length; i++) {
            array[i] = Esdia.readString("Nueva palabra: ");
        }

        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
