package Model;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Model {
    ArrayList<Bill> bills;
    ArrayList<Bill> filteredBills;
    int minimumValue;

    public Model() {
        bills = new ArrayList<Bill>();
        filteredBills = bills;
    }

    public void addBill(Bill bill) {
        bills.add(bill);
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public ArrayList<Bill> getFilteredBills() {
        return filteredBills;
    }

    public void setMinimumValue(int minimumValue) {
        this.minimumValue = minimumValue;
        filterBills(minimumValue);
    }

    public void filterBills(double value) {
        filteredBills = new ArrayList<Bill>();
        for (Bill bill : bills) {
            if (bill.getMinimumValue() > value) {
                filteredBills.add(bill);
            }
        }
    }

    public void importFile(String fileName) {
        Path path = Paths.get(System.getProperty("user.dir"), fileName);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        }
        catch (Exception e) {
            System.err.println("Error reading file: " + e);
        }
        for (String line: lines) {   
            Bill bill = Bill.getBillFromDelimitedString(line, "\t");
            addBill(bill);
        }
    }


    public void generateHTML() {
        String htmlString = getHTMLString();
        Path path = Paths.get(System.getProperty("user.dir"), "facturas.html");
        try {
            Files.write(path, htmlString.getBytes(StandardCharsets.UTF_8));
        }
        catch (Exception e) {
            System.err.println("Failed to generate HTML file: " + e);
        }
    }

    public String getHTMLString() {
        String htmlSetup = (
            "<!DOCTYPE HTML>\n" + 
            "<HTML>\n\t" + 
                "<HEAD>\n\t\t" +
                    "<meta charset=\"UTF-8\">\n\t\t" +
                    "<H1>Bill List</H1>\n\t" +
                "</HEAD>\n\t" +
                "<BODY>\n\t\t" +
                    "<TABLE BORDER = 1>\n\t\t\t" +
                        "<TR>\n\t\t\t\t" +
                            "<TH>Title</TH>\n\t\t\t\t" + 
                            "<TH>Discount</TH>\n\t\t\t\t" + 
                            "<TH>Date</TH>\n\t\t\t\t" + 
                            "<TH>Price</TH>\n\t\t\t\t" + 
                            "<TH>NIF</TH>\n\t\t\t\t" + 
                            "<TH>Client Name</TH>\n\t\t\t\t" + 
                            "<TH>Address</TH>\n\t\t\t\t" + 
                            "<TH>VAT</TH>\n\t\t\t" + 
                        "</TR>\n\t\t\t"
        );
        for (Bill bill : bills) {
            htmlSetup += (
                        "<TR>\n\t\t\t\t" +
                            "<TD>" + bill.getTitle() + "</TD>\n\t\t\t\t" +
                            "<TD>" + bill.getDiscount() + "</TD>\n\t\t\t\t" + 
                            "<TD>" + bill.getDate() + "</TD>\n\t\t\t\t" +  
                            "<TD>" + bill.getPrice() + "</TD>\n\t\t\t\t" + 
                            "<TD>" + bill.getNif() + "</TD>\n\t\t\t\t" +
                            "<TD>" + bill.getClientName() + "</TD>\n\t\t\t\t" +
                            "<TD>" + bill.getAddress() + "</TD>\n\t\t\t\t" + 
                            "<TD>" + bill.getVat() + "</TD>\n\t\t\t" +   
                        "</TR>\n\t\t"
            );           
        }
        htmlSetup += (
                    "</TABLE>\n\t" +
                "</BODY>\n" +
            "</HTML>"
        );
        return htmlSetup;
    }

    public void generateCSV() {
        String csvString = getCSVString();
        Path path = Paths.get(System.getProperty("user.dir"), "facturas.csv");
        try {
            Files.write(path, csvString.getBytes(StandardCharsets.UTF_8));
        }
        catch (Exception e) {
            System.err.println("Failed to generate CSV file: " + e);
        }
    }

    public String getCSVString() {
        String csvSetup = "Title, Discount, Date, Price, NIF, Client Name, Address, VAT\n";
        for (Bill bill : bills) {
            csvSetup += bill.getInstanceAsDelimitedString(",") + "\n";
        }
        return csvSetup;
    }
}
