package View;

import java.io.IOException;

import com.coti.tools.Esdia;

import Controller.Controller;
import Model.StudentInfo;

public class View {
    Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        int option = 0;
        while(option != 5) {
            option = Esdia.readInt("1. Generate new student list" +
                        "\n2. Show student table" +
                        "\n3. Export personal info to CSV" +
                        "\n4. Export addresses to CSV" +
                        "\n5. Exit" + 
                        "\nChoose Option: ");
            switch(option) {
                case 1:
                    controller.generateStudents();
                    System.out.println("New student list generated");
                    break;
                case 2:
                    showStudentTable();
                    break;
                case 3:
                    try {
                        controller.exportInfoCSV();
                        System.out.println("Info exported to CSV successfully");
                    } catch (IOException e) {
                        System.out.println("Error exporting CSV: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        controller.exportAddressCSV();
                        System.out.println("Addresses exported to CSV successfully");
                    } catch (IOException e) {
                        System.out.println("Error exporting CSV: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid option, please try again");
            }
        }    
    }

    public void showStudentTable() {
        StudentInfo[] students = controller.getStudents();
        System.out.println("Name\tSurname\tAge\tNIF\t\tStreet\t\tNumber\tFloor\tLetter");
        for(StudentInfo student : students) {
            String name = student.getInfo().getName();
            String surname = student.getInfo().getSurname();
            int age = student.getInfo().getAge();
            String nif = student.getInfo().getNif();
            String street = student.getAddress().getStreet();
            int number = student.getAddress().getNumber();
            int floor = student.getAddress().getFloor();
            String letter = student.getAddress().getLetter();
            System.out.println(name + "\t" + surname + "\t" + age + "\t" + nif + "\t" + street + "\t" + number + "\t" + floor + "\t" + letter);
        }
    }
}
