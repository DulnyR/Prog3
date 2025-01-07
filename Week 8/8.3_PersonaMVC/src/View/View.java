package View;

import java.util.ArrayList;

import com.coti.tools.Esdia;

import Controller.Controller;
import Model.Person;

public class View {
    Controller controller;

    public void run() {
        System.out.println("Welcome to person viewer!");
        int option = 0;

        while(option != 4) {
            option = Esdia.readInt(
                "1. Import Data\n" +
                "2. Read TSV File\n" +
                "3. View Imported Data\n" +
                "4. Exit\n" +
                "Choose Option: "
            );

            switch(option) {
                case 1:
                    controller.importData("datos.txt");
                    break;
                case 2:
                    String fileName = Esdia.readString("Enter file name: ");
                    controller.importData(fileName);
                    break;
                case 3:
                    ArrayList<Person> people = controller.getPeople();
                    for(Person person : people) {
                        System.out.println(person.toString());
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Incorrect Input");
                    break;
            }
        }
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
