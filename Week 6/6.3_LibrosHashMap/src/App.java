import com.coti.tools.Esdia;
import modelo.*;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static final int AGREGAR_LIBRO = 1;
    public static final int ELIMINAR_LIBRO = 2;
    public static final int MODIFICAR_LIBRO = 3;
    public static final int LISTAR_LIBROS = 4;
    public static final int SALIR = 5;
    public static final int LINEA_LONGITUD = 150;

    private static HashMap <String, Libro> libros = new HashMap<>();

    public static void main(String[] args) throws Exception {
        int seleccion = 0;

        while (seleccion != 5) {
            seleccion = Esdia.readInt("\n"
                    + "|----------------------------------------------|\n"
                    + "| MIS LIBROS                                   |\n"
                    + "|----------------------------------------------|\n"
                    + "1) Agrega libro\n"
                    + "2) Eliminar libro\n"
                    + "3) Modificar libro\n"
                    + "4) Listar libros\n"
                    + "5) Salir\n"
                    + "|----------------------------------------------|\n\n"
                    + "Seleccione una opción (1-4): ", 1, 5);

            switch (seleccion) {
                case AGREGAR_LIBRO:
                    agregaLibro();
                    break;
                case ELIMINAR_LIBRO:
                    eliminaLibro();
                    break;
                case MODIFICAR_LIBRO:
                    modificaLibro();
                    break;
                case LISTAR_LIBROS:
                    listaLibros();
                    break;
                case SALIR:
                    System.out.println("\nGracias por usar la aplicación.\n");
                    break;
                default:
                    break;
            }
        }
    }

    public static void agregaLibro() {
        String isbn = Esdia.readString_ne("ISBN del libro: ");
        libros.put(isbn, preguntasLibro());
    }

    public static void eliminaLibro() {
        String isbn = Esdia.readString_ne("ISBN del libro: ");
        if (libros.containsKey(isbn)) {
            libros.remove(isbn);
            System.out.println("Libro eliminado");
        }
        else {
            System.out.println("Libro no encontrado");
        }
    }

    public static void modificaLibro() {
        String isbn = Esdia.readString_ne("ISBN del libro: ");
        if (libros.containsKey(isbn)) {
            libros.put(isbn, preguntasLibro());
            System.out.println("Libro modificado");
        }
        else {
            System.out.println("Libro no encontrado");
        }
    }

    public static void listaLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros agregados");
        }
        else {
            for (Map.Entry<String, Libro> entry : libros.entrySet()) {
                Libro libro = entry.getValue();
                System.out.println(entry.getKey() + " : " + libro.getTitulo() + ", " + libro.getAutor().getNombre() + " " + libro.getAutor().getApellidos()[0]);
            }
        }
    }

    public static Libro preguntasLibro() {
        String nombreAutor = Esdia.readString("\nNombre del Autor: ");
        int numeroDeApellidos = Esdia.readInt("Numero de los apellidos del autor: ");
        String[] apellidos = new String[numeroDeApellidos];
        for(int i = 0; i < numeroDeApellidos; i++){
            String apellido = Esdia.readString("Entra el apellido " + (i+1) + ": ");
            apellidos[i] = apellido;
        }
        boolean premioPlaneta = Esdia.yesOrNo("Premio Planeta: ");
        Autor nuevoAutor = new Autor(nombreAutor, apellidos, premioPlaneta);
        String titulo = Esdia.readString("Titulo: ");
        int anoDePublicacion = Esdia.readInt("Ano de publicacion: ");
        int numeroDePaginas = Esdia.readInt("Numero de paginas: ");
        double precio = Esdia.readDouble("Precio: ");
        Libro nuevoLibro = new Libro(nuevoAutor, titulo, anoDePublicacion, numeroDePaginas, precio);
        return nuevoLibro;
    }
}