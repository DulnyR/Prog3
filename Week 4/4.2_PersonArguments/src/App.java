public class App {
    public static void main(String[] args) throws Exception {
        User user = null;
        if (args.length == 3) {
            user = User.makeUser(args);
        } else {
            System.err.println("The number of arguments is not 3.");
        }
        if (user != null) {
            System.out.println("Name: " + user.getName() +
                                "\nWeight: " + user.getWeight() +
                                "\nHeight: " + user.getHeight() +
                                "\nBMI: " + user.getBMI());
        }
    }
}
