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
        return new Address("Principal", (int) (Math.random() * 99) + 1, (int) (Math.random() * 10) + 1, "B");
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    public String getLetter() {
        return letter;
    }
}
