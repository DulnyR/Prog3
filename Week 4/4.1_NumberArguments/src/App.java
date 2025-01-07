public class App {
    public static void main(String[] args) throws Exception {
        if(args.length == 2) {
            try {
                int firstNumber = Integer.parseInt(args[0]);
                System.out.println("The first argument is an integer: " + firstNumber);
                int secondNumber = Integer.parseInt(args[1]);
                System.out.println("The first argument is an integer: " + secondNumber);
                System.err.println("The sum of both arguments is " + (firstNumber + secondNumber));
            } catch (NumberFormatException e) {
                System.out.println("One of the arguments is not an integer");
            }
        } else {
            System.out.println("2 arguments were not given");
        }
    }
}
