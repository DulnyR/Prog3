public class Fruit {
    private final double TAX = 0.21;
    private String type;
    private double pricePerKG;

    public Fruit(String type, double pricePerKG) {
        this.type = type;
        this.pricePerKG = pricePerKG;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPricePerKG() {
        return pricePerKG;
    }

    public void setPricePerKG(double pricePerKG) {
        this.pricePerKG = pricePerKG;
    }

    public double getPricePerKGWithVAT() {
        return Math.round(pricePerKG * (1 + TAX) * 100.0) / 100.0;
    }
}
