public class App {
    public static void main(String[] args) throws Exception {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter year of birth: ");
        int birthYear = scanner.nextInt();
        System.out.print("Enter current year: ");
        int currentYear = scanner.nextInt();
        System.out.println("You are " + (currentYear - birthYear) + " years old.");
        scanner.close();
    }
}
