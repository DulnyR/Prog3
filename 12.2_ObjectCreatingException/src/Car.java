public class Car {
    private String make;
    private String model;

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Car(String make, String model) throws MakingCarException {
        try {
            this.make = make;
            this.model = model;
        } catch (RuntimeException re) {
            throw new MakingCarException();
        }
    }
}
