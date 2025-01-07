public class User {
    private String name;
    private double height;
    private double weight;

    public User() {
        this.name = "David";
        this.height = 178;
        this.weight = 75;
    }

    public User(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }  

    public double getBMI() {
        return this.weight / (this.height * this.height);
    }

    public static User makeUser(String[] params) {
        try {
            String name = params[0];
            double weight = Double.parseDouble(params[1]);
            double height = Double.parseDouble(params[2]);
            return new User(name, weight, height);
        } catch (NumberFormatException nfe) {
            System.err.println("Incorrect data inputted.");
            return null;
        }
    }
}
