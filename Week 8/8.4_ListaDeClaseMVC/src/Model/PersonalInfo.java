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
        return new PersonalInfo("John", "Bradley", (int) (Math.random() * (82) + 18) , "ABCEF12345");
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getNif() {
        return nif;
    }
}
