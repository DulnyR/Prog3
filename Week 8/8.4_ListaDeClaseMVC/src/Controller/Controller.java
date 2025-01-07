package Controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import Model.Model;
import Model.StudentInfo;
import View.View;

public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.run();
    }

    public void generateStudents() {
        model = new Model();
    }

    public void exportInfoCSV() throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        StudentInfo[] students = model.getStudents();
        for (StudentInfo student : students) {
            lines.add(student.getPersonalInfoAsCSV());
        }
        Files.write(Paths.get(System.getProperty("user.dir"), "studentInfo.csv"), lines, StandardCharsets.UTF_8);
    }

    public void exportAddressCSV() throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        StudentInfo[] students = model.getStudents();
        for (StudentInfo student : students) {
            lines.add(student.getAddressAsCSV());
        }
        Files.write(Paths.get(System.getProperty("user.dir"), "address.csv"), lines, StandardCharsets.UTF_8);
    }

    public StudentInfo[] getStudents() {
        return model.getStudents();
    }
}
