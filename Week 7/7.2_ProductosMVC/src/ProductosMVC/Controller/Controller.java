package ProductosMVC.Controller;

import ProductosMVC.Model.Model;
import ProductosMVC.View.View;

public class Controller {

    private View v;
    private Model m;

    public Controller(View v, Model m) {
        this.v = v;
        this.m = m;
    }

    public void setSales(int storage, int product, int numberOfSales) {
        m.setSales(storage, product, numberOfSales);
    }

    public void createStorage(int storageNumber, int productNumber) {
        m.createStorage(storageNumber, productNumber);
    }

    public void setPrice(int productNumber, double price) {
        m.setPrice(productNumber, price);
    }

    public double calculateIncome() {
        return m.calculateIncome();
    }

    public int[][] getSales() {
        return m.getSales();
    }

    public double[] getPrices() {
        return m.getPrices();
    }

    public void run() {
        v.showMenu();
    }
}
