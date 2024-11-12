package Model;

import java.util.Locale;

public class Bill {
    private String title;
    private double discount;
    private String date;
    private double price;
    private String nif;
    private String clientName;
    private String address;
    private double vat;
    private double minimumValue;
    
    public Bill(String title, double discount, String date, double price, 
                String nif, String clientName, String address, double vat) {
        this.title = title;
        this.discount = discount;
        this.date = date;
        this.price = price;
        this.nif = nif;
        this.clientName = clientName;
        this.address = address;
        this.vat = vat;
    }

    public double getMinimumValue() {
        return price * (1 - discount) * (1 + vat);
    }

    public String getTitle() {
        return title;
    }

    public double getDiscount() {
        return discount;
    }

    public String getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public String getNif() {
        return nif;
    }

    public String getClientName() {
        return clientName;
    }

    public String getAddress() {
        return address;
    }

    public double getVat() {
        return vat;
    }

    public String getInstanceAsDelimitedString(String delimiter) {
        return String.format(
            Locale.ENGLISH,"%s" + delimiter + "%.2f" + delimiter + "%s" + delimiter +
            "%.2f" + delimiter + "%s" + delimiter + "%s" + delimiter + "%s" + delimiter + "%.2f",
            title, discount, date, price, nif, clientName, address, vat
        );
    }

    public static Bill getBillFromDelimitedString(String string, String delimiter) {
        String[] chunks = string.split(delimiter);

        if (chunks.length != 8) {
            System.err.println("Error in input for creating a bill");
        }
        else {
            try {
                String title = chunks[0];
                Double discount = Double.parseDouble(chunks[1]);
                String date = chunks[2];
                Double price = Double.parseDouble(chunks[3]);
                String nif = chunks[4];
                String clientName = chunks[5];
                String address = chunks[6];
                Double vat = Double.parseDouble(chunks[7]);
                Bill bill = new Bill(title, discount, date, price, nif, clientName, address, vat);
                return bill;
            }
            catch (Exception e) {
                System.err.println("Error in factory method creating bill: " + e);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return (
            "\nTitle: " + title +
            "\nDiscount: " + discount +
            "\nDate: " + date +
            "\nPrice: " + price +
            "\nNIF: " + nif +
            "\nClient Name: " + clientName + 
            "\nAddress: " + address +
            "\nVat: " + vat +
            "\nMinimum Value: " + minimumValue
         );
    }
}
