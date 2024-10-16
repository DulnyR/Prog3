package paquete2;
import paquete1.Clase1;
import paquete1.Clase2;

public class App {
    public static void main(String[] args) throws Exception {
        Clase1 clase1 = new Clase1();
        Clase2 clase2 = new Clase2();

        int intVariable;

        intVariable = clase1.publicVariable;
        intVariable = clase1.defaultVariable;
        intVariable = clase1.protectedVariable;
        intVariable = clase1.privateVariable;

        intVariable = clase2.publicVariable;
        intVariable = clase2.defaultVariable;
        intVariable = clase2.protectedVariable;
        intVariable = clase2.privateVariable;

        String stringVariable;

        stringVariable = clase1.publicFunction();
        stringVariable = clase1.defaultFunction();
        stringVariable = clase1.protectedFunction();
        stringVariable = clase1.privateFunction();

        stringVariable = clase2.publicFunction();
        stringVariable = clase2.defaultFunction();
        stringVariable = clase2.protectedFunction();
        stringVariable = clase2.privateFunction();
    }
}
