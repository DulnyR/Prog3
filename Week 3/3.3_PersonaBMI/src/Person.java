public class Person {
    private String name;
    private double height;
    private double weight;

    public Person() {
        this.name = "David";
        this.height = 1.78;
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
        if(this.weight > 0 && this.height > 0) {
            return this.weight / (this.height * this.height);
        }
        return 0;
    }
}
