package paquete1;

public class Clase1 {
    public int publicVariable = 0;
    int defaultVariable = 1;
    protected int protectedVariable = 2;
    private int privateVariable = 3;

    public String publicFunction() {
        return("Public");
    }

    String defaultFunction() {
        return("Default");
    }

    protected String protectedFunction() {
        return ("Protected");
    }

    private String privateFunction() {
        return ("Private");
    }
}
