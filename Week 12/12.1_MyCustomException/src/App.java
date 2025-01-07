public class App {
    public static void main(String[] args) {
        int option = 0;
        if (option == 0) {
            throw new MyCustomExceptionUnchecked();
        } else {
            try {
                throw new MyCustomExceptionChecked();
            } catch (MyCustomExceptionChecked mcec) {
                System.out.println("Exception is checked");
            }    
        }
    }   
}
