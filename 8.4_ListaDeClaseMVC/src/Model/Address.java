package Model;

public class Address {
    String street;
    int number;
    int floor;
    String letter;

    public Address(String street, int number, int floor, String letter) {
        this.street = street;
        this.number = number;
        this.floor = floor;
        this.letter = letter;
    }

    public static Address randomFill() {
        return new Address("Principal", 28, 5, "B");
    }
}
