import static com.coti.tools.Esdia.*;
import java.util.HashMap;
import java.util.Map;

public class TiendaCochesHashMap {
    
    private static HashMap<String, Coche> coches = new HashMap<>();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENU CRUD ---");
            System.out.println("1. Agregar coche");
            System.out.println("2. Eliminar coche");
            System.out.println("3. Modificar coche");
            System.out.println("4. Listar coches");
            System.out.println("5. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1: agregarCoche(); break;
                case 2: eliminarCoche(); break;
                case 3: modificarCoche(); break;
                case 4: listarCoches(); break;
                case 5: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void agregarCoche() {
        String matricula = readString_ne("Ingrese la matricula del coche: ");
        String marca = readString_ne("Ingrese la marca del coche: ");
        String modelo = readString_ne("Ingrese el modelo del coche: ");
        int anoProd = readInt("Ingrese el ano del produccion del coche: ");

        coches.put(matricula, new Coche(marca, modelo, anoProd));
    }

    public static void eliminarCoche() {
        String matricula = readString_ne("Ingrese la matricula del coche a eliminar: ");
        if (coches.containsKey(matricula)) {
            coches.remove(matricula);
            System.out.println("Coche eliminado.");
        } else {
            System.out.println("Coche no encontrado.");
        }
    }

    public static void modificarCoche() {
        String matricula = readString_ne("Ingrese el dni de la persona a modificar: ");

        if (coches.containsKey(matricula)) {

            String nuevaMarca = readString_ne("Ingrese la nuevo marca: ");
            String nuevoModelo =readString_ne("Ingrese el nuevo modelo: ");
            int nuevoAnoProd = readInt("Ingrese el nuevo ano de produccion: ");

            Coche cocheModificado = new Coche(nuevaMarca, nuevoModelo, nuevoAnoProd);
            coches.put(matricula, cocheModificado);

        } else {
            System.out.println("Coche no encontrado.");
        }
    }

    public static void listarCoches() {

        // Si está vacío, no se puede recorrer
        if (coches.isEmpty()) {
            System.out.println("No hay coches para mostrar.");
            return;
        }

        for(Map.Entry<String, Coche> entry : coches.entrySet()) {
            String matricula = entry.getKey();
            Coche coche = entry.getValue();
            System.out.println("Matricula: " + matricula + ", " + coche);
        }
    }
}
