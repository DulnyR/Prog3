import static com.coti.tools.Esdia.*;

public class TiendaCochesArray {
    
    private static final int MAX_SIZE = 5;
    private static Coche[] coches = new Coche[MAX_SIZE];
    private static int cocheCount = 0;

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
        if (cocheCount < MAX_SIZE) {
            String matricula = readString_ne("Ingrese la matricula del coche: ");
            String marca = readString_ne("Ingrese la marca del coche: ");
            String modelo = readString_ne("Ingrese el modelo del coche: ");
            int anoProd = readInt("Ingrese el ano del produccion del coche: ");
            coches[cocheCount++] = new Coche(matricula, marca, modelo, anoProd);
            System.out.println("Coche añadido correctamente.");
        } else {
            System.out.println("Array de coches está lleno.");
        }
    }

    public static void eliminarCoche() {
        String matricula = readString_ne("Ingrese la matricula del coche a eliminar: ");
        boolean encontrado = false;
        for (int i = 0; i < cocheCount; i++) {
            // Para comparar cadenas empleamos equals
            if (coches[i].getMatricula().equals(matricula)) {
                encontrado = true;
                for (int j = i; j < cocheCount - 1; j++) {
                    coches[j] = coches[j + 1];
                }
                cocheCount--;

                System.out.println("Coche eliminado correctamente.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Coche no encontrado.");
        }
    }

    public static void modificarCoche() {

        String matricula = readString_ne("Ingrese la matricula del coche a modificar: ");
        boolean encontrado = false;
        for (int i = 0; i < cocheCount; i++) {
            if (coches[i].getMatricula().equals(matricula)) {
                String nuevaMatricula = readString_ne("Ingrese la matricula del coche: ");
                String nuevaMarca = readString_ne("Ingrese la marca del coche: ");
                String nuevoModelo = readString_ne("Ingrese el modelo del coche: ");
                int nuevoAnoProd = readInt("Ingrese el ano del produccion del coche: ");

                coches[i].setMatricula(nuevaMatricula);
                coches[i].setMarca(nuevaMarca);
                coches[i].setModelo(nuevoModelo);
                coches[i].setAnoProd(nuevoAnoProd);

                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Coche no encontrada.");
        }
    }

    public static void listarCoches() {

        if (cocheCount == 0) {
            System.out.println("No hay coches en el array.");
            return;
        }

        for (int i = 0; i < cocheCount; i++) {
            System.out.println(coches[i].getEstadoComoString());
        }
    }
    
}