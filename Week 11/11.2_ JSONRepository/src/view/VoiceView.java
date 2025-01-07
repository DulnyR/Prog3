package view;

import java.io.IOException;
import java.util.List;
import static com.coti.tools.Esdia.*;

import io.github.jonelo.jAdapterForNativeTTS.engines.SpeechEngine;
import io.github.jonelo.jAdapterForNativeTTS.engines.SpeechEngineNative;
import io.github.jonelo.jAdapterForNativeTTS.engines.Voice;
import io.github.jonelo.jAdapterForNativeTTS.engines.VoicePreferences;
import io.github.jonelo.jAdapterForNativeTTS.engines.exceptions.SpeechEngineCreationException;
import model.Alumno;

public class VoiceView extends ConsolaListadoView {
    SpeechEngine speechEngine;

    public VoiceView() {
        try {
            this.speechEngine = SpeechEngineNative.getInstance();
            List<Voice> voices = speechEngine.getAvailableVoices();

            VoicePreferences voicePreferences = new VoicePreferences();
            voicePreferences.setLanguage("en");
            voicePreferences.setCountry("GB");
            voicePreferences.setGender(VoicePreferences.Gender.FEMALE);
            Voice voice = speechEngine.findVoiceByPreferences(voicePreferences);

            if (voice == null) {
                System.out.printf("Warning: Voice has not been found by the voice preferences %s%n", voicePreferences);
                voice = voices.get(0); // it is guaranteed that the speechEngine supports at least one voice
                System.out.printf("Using \"%s\" instead.%n", voice);
            }

            this.speechEngine.setVoice(voice.getName());
        } catch (SpeechEngineCreationException e) {
            e.printStackTrace();
        }   
    }

    @Override
    public void mostrarInicio(String msgBienvenida) {
        try {
            speechEngine.say(msgBienvenida);
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.mostrarInicio(msgBienvenida);
    }

    @Override
    public void mostrarMenuPrincipal() {
        try {
            int opcion;
            do {
                speechEngine.say("Student Menu" +
                                "1. Add Student" + 
                                "2. Delete student by DNI" +
                                "3. Import students" +
                                "4. Export students" + 
                                "5. List students" +
                                "6. Exit" +
                                "Enter an option: ");

                System.out.println("\n--- MENU ALUMNOS LISTADO COMPLETO ---");
                System.out.println("1. Agregar Alumno");
                System.out.println("2. Eliminar Alumno por DNI");
                System.out.println("3. Importar alumnos");
                System.out.println("4. Exportar alumnos");
                System.out.println("5. Listar alumnos");
                System.out.println("6. Salir");
                opcion = readInt("Ingrese una opción: ");

                switch (opcion) {
                    case 1:
                        agregarAlumno();
                        break;
                    case 2:
                        eliminarAlumnoPorDNI();
                        break;
                    case 3:
                        importarAlumnos();
                        break;
                    case 4:
                        exportarAlumnos();
                        break;
                    case 5:
                        listarAlumnos();
                        break;
                    case 6:
                        System.out.println("Saliendo...");
                        speechEngine.say("Exiting");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        speechEngine.say("Invalid option");
                }
            } while (opcion != 6);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mostrarFinPrograma(String msgDespedida) {
        try {
            speechEngine.say(msgDespedida);
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.mostrarFinPrograma(msgDespedida);
    }

    private void agregarAlumno() {
        try {
            speechEngine.say("Introduce new student data");
            System.out.println("Introduzca los datos del nuevo alumno:");
            speechEngine.say("DNI");
            String DNI = readString_ne("DNI:");
            speechEngine.say("Name");
            String nombre = readString("Nombre:");
            speechEngine.say("First surname");
            String apellido1 = readString("Primer apellido:");
            speechEngine.say("Second surname");
            String apellido2 = readString("Segundo apellido:");
            if(c.agregarAlumno(new Alumno(DNI, nombre, apellido1, apellido2))){
                speechEngine.say("Student added successfully");
                System.out.println("Alumno agregado con exito");
            }else{
                // Veremos alternativas para dar más información de como modificar esto para ser
                // más informativos.
                speechEngine.say("Could not add student with that data");
                System.out.println("No se pudo agregar el alumno con esos datos.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void eliminarAlumnoPorDNI() {
        try {
            speechEngine.say("Enter the DNI you want to delete");
            System.out.println("Introduzca el DNI que quiere eliminar:");
            speechEngine.say("DNI");
            String DNI = readString_ne("DNI:");
            if(c.eliminarAlumnoPorDNI(DNI)){
                speechEngine.say("Student deleted successfully");
                System.out.println("Alumno eliminado con exito");
            }else{
                // Veremos alternativas para dar más información de como modificar esto para ser
                // más informativos.
                speechEngine.say("Could not delete student with that DNI");
                System.out.println("No se pudo eliminar el alumno con ese DNI.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importarAlumnos() {
        try {
            if(c.importarAlumnos()){
                speechEngine.say("Export done successfully");
                System.out.println("Exportación realizada con exito");
            }else{
                // Veremos alternativas para dar más información de como modificar esto para ser
                // más informativos.
                speechEngine.say("There was an error in the import");
                System.out.println("Hubo un error en la importación");
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportarAlumnos() {
        try {
            if(c.exportarAlumnos()){
                speechEngine.say("Export done successfully");
                System.out.println("Exportación realizada con exito");
            }else{
                // Veremos alternativas para dar más información de como modificar esto para ser
                // más informativos.
                speechEngine.say("There was an error in the export");
                System.out.println("Hubo un error en la exportación");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listarAlumnos() {
        try {
            List<Alumno> alumnos = c.obtenerAlumnosDelModelo();
            speechEngine.say(Alumno.getHeaderTableStringForAlumno());
            System.out.println(Alumno.getHeaderTableStringForAlumno());
            for (Alumno alumno : alumnos) {
                speechEngine.say(alumno.getAsRowString());
                System.out.println(alumno.getAsRowString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
