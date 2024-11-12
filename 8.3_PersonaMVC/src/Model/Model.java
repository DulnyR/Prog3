package Model;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Model {
    ArrayList<Person> people;

    public Model() {
        people = new ArrayList<Person>();
    }

    public void importData(String fileName) {
        Path path = Paths.get(System.getProperty("user.home"), "Desktop", fileName);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        }
        catch (Exception e) {
            System.err.println("Error importing " + fileName + ": " + e);
        }
        for(String line : lines) {
            Person newPerson = getPersonFromDelimitedString(line, "\t");
            addPerson(newPerson);
        }
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public Person getPersonFromDelimitedString(String line, String delimiter) {
        String[] chunks = line.split(delimiter);

        if (chunks.length != 3) {
            System.err.println("Lack of info to create a person");
        } 
        else {
            try {
                String name = chunks[0];
                String telephone = chunks[1];
                Double weight = Double.parseDouble(chunks[2]);
                return new Person(name, telephone, weight);
            }
            catch (Exception e) {
                System.err.println("Error creating person: " + e);
            }
        }

        return null;
    }
}
