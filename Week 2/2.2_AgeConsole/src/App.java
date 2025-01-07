public class App {
    public static void main(String[] args) throws Exception {
        java.io.Console console = System.console();
        String birthYearStr = console.readLine("Enter year of birth: ");
        int birthYear = Integer.parseInt(birthYearStr);
        String currentYearStr = console.readLine("Enter current year: ");
        int currentYear = Integer.parseInt(currentYearStr);
        console.printf("You are %d years old", (currentYear - birthYear));
    }
}
