package Model;

public class StudentInfo {
    Address address;
    PersonalInfo info;

    public void randomFill() {
        address = Address.randomFill();
        info = PersonalInfo.randomFill();
    }
}
