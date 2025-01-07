import java.util.Arrays;

import com.coti.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {
        int[] array = new int[5];

        for (int i = 0; i < array.length; i++) {
            array[i] = Esdia.readInt("New number: ");
        }

        Arrays.sort(array);

        int randomIndex = (int) (Math.random() * (array.length - 1));
        int randomNumber = array[randomIndex];
        System.out.println("Number to search for: " + randomNumber);

        int index = Arrays.binarySearch(array, randomNumber);
        if (index >= 0) {
            System.out.println("Number found at index: " + index);
        } else {
            System.out.println("Number not found.");
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
