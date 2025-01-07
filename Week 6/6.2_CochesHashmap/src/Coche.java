public class Coche {
    
    private String matricula;
    private String marca;
    private String modelo;
    private int anoProd;

    public Coche(String marca, String modelo, int anoProd) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoProd = anoProd;
    }

    public Coche(String matricula, String marca, String modelo, int anoProd) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anoProd = anoProd;
    }

    public int getAnoProd() {
        return anoProd;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setAnoProd(int anoProd) {
        this.anoProd = anoProd;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public String getEstadoComoString() {
        return "Coche[Marca: " + marca + ", Modelo: " + modelo + ", Ano de Produccion: " + anoProd + "]";
    }
}
