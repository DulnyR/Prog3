public class Person {
    private String name;
    private double height;
    private double weight;

    public Person() {
        this.name = "David";
        this.height = 178;
        this.weight = 75;
    }

    public Person(String name, double height, double weight) {
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
}
