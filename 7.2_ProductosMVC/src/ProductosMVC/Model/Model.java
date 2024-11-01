package ProductosMVC.Model;

public class Model {
    
    private double[] prices;
    private int[][] sales;

    public void setSales(int storage, int product, int numberOfSales) {
        sales[storage][product] = numberOfSales;
    }

    public void createStorage(int storageNumber, int productNumber) {
        prices = new double[productNumber];
        sales = new int[storageNumber][productNumber];
    }

    public void setPrice(int productNumber, double price) {
        prices[productNumber] = price;
    }

    public double calculateIncome() {
        double total = 0;
        for(int i = 0; i < sales.length; i++) {
            for(int j = 0; j < prices.length; j++) {
                total += sales[i][j] * prices[j];
            }
        }
        return total;
    }

    public int[][] getSales() {
        return sales;
    }

    public double[] getPrices() {
        return prices;
    }

}
