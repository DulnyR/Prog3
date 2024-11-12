package Model;

public class PersonalInfo {
    String name;
    String surname;
    int age;
    String nif;

    public PersonalInfo(String name, String surname, int age, String nif) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.nif = nif;
    }

    public static PersonalInfo randomFill() {
        return new PersonalInfo("Juan", "Magan", 27, "ABCEF12345");
    }
}
