package model;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JSONRepository implements PersistenceRepository {

    Path path = Paths.get(System.getProperty("user.home"), "Desktop", "alumnos.json");

    public ArrayList<Alumno> importarAlumnos() {
        Gson gson = new Gson();
        String json = "";
        try {
            json = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Alumno>>() {}.getType();
        ArrayList<Alumno> students = gson.fromJson(json, listType);
        return students;
    }

    public boolean exportarAlumnos(ArrayList<Alumno> alumnos) {
        Gson gson = new Gson();
        String json = gson.toJson(alumnos);
        try {
            Files.write(path, json.getBytes(StandardCharsets.UTF_8));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    
}
