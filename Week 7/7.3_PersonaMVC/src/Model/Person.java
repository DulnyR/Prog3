package Model;

public class Person {
    String name;
    String telephone;
    double weight;

    public Person(String name, String telephone, double weight) {
        this.name = name;
        this.telephone = telephone;
        this.weight = weight;
    }    

    public String toString() {
        return name + "'s telephone number is " + telephone + " and they weigh " + weight;
    }
}
