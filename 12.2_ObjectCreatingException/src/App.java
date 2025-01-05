public class App {
    public static void main(String[] args) throws Exception {
        try {
            Car car = new Car("Toyota", null);
            System.out.println("Make: " + car.getMake() + " Model: " + car.getModel());
        } catch (MakingCarException mce) {
            System.out.println("Could not make car");
        }
    }
}
