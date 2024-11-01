package ProductosMVC.View;

import com.coti.tools.Esdia;

import ProductosMVC.Controller.Controller;

public class View {

    private Controller c;
    final static public int TOTAL_PRODUCTS = 2;
    final static public int TOTAL_STORAGE = 5;

    public void showMenu() {
        c.createStorage(TOTAL_STORAGE, TOTAL_PRODUCTS);
        boolean exit = false;
        boolean salesAdded = false;
        boolean pricesAdded = false;

        while(!exit) {
            System.out.println("1 - Input sales list");
            System.out.println("2 - Input prices");
            System.out.println("3 - Calculate total income");
            System.out.println("4 - Show results");
            System.out.println("5 - Exit");

            int option = Esdia.readInt("Select number: ", 1, 5);

            switch(option) {
                case 1:
                    inputSales();
                    salesAdded = true;
                    break;
                case 2:
                    inputPrices();
                    pricesAdded = true;
                    break;
                case 3:
                    if (salesAdded && pricesAdded) {
                        calculateIncome();
                    }
                    else {
                        System.out.println("\nAdd sales and prices\n");
                    }
                    break;
                case 4:
                    if (salesAdded && pricesAdded) {
                        showResult();
                    }
                    else {
                        System.out.println("\nAdd sales and prices\n");
                    }
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void inputSales() {
        for(int i = 0; i < TOTAL_STORAGE; i++) {
            for(int j = 0; j < TOTAL_PRODUCTS; j++) {
                int numberOfSales = Esdia.readInt("How much of Product " + 
                    (j + 1) + " was sold in Storage " + (i + 1) + "? ");
                c.setSales(i, j, numberOfSales);
            }
        }
    }

    private void inputPrices() {
        for(int i = 0; i < TOTAL_PRODUCTS; i++) {
            double price = Esdia.readDouble("Enter price of Product " + (i + 1) + ": ");
            c.setPrice(i, price);
        }
    }

    private void calculateIncome() {
        System.out.println("Total Income: " + c.calculateIncome());
    }

    private void showResult() {
        int[][] sales = c.getSales();
        double[] prices = c.getPrices();

        for(int i = 0; i < sales.length; i++) {
            for(int j = 0; j < prices.length; j++) {
                System.out.println("Storage " + i + " Product " + j + " Sales: " + sales[i][j] + " at " + prices[j]);
            }
        }
        calculateIncome();
    }


    public void setController(Controller c) {
        this.c = c;
    }
}
