package Model;

public class StudentInfo {
    Address address;
    PersonalInfo info;

    public StudentInfo() {
        address = Address.randomFill();
        info = PersonalInfo.randomFill();
    }

    public Address getAddress() {
        return address;
    }

    public PersonalInfo getInfo() {
        return info;
    }

    public String getPersonalInfoAsCSV() {
        return info.name + "," + info.surname + "," + info.age + "," + info.nif;
    }

    public String getAddressAsCSV() {
        return address.street + "," + address.number + "," + address.floor + "," + address.letter;
    }
}
