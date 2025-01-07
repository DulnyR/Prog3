package Calculator.View;

import com.coti.tools.Esdia;

import Calculator.Controller.Controller;

public class View {

    private Controller c;

    public void showMenu() {
        boolean exit = false;

        while(!exit) {
            System.out.println("1 - Read numbers");
            System.out.println("2 - Calculate the sum");
            System.out.println("3 - Show Result");
            System.out.println("4 - Exit");

            int option = Esdia.readInt("Select number: ", 1, 4);

            switch(option) {
                case 1:
                    readNumbers();
                    break;
                case 2:
                    sumNumbers();
                    break;
                case 3:
                    showResult();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void readNumbers() {
        int num1 = Esdia.readInt("Enter first number: ", 0, 100);
        int num2 = Esdia.readInt("Enter second number: ", 0, 100);

        c.setNum1(num1);
        c.setNum2(num2);
    }

    private void sumNumbers() {
        c.sumNumbers();
    }

    private void showResult() {
        int num1 = c.getNum1();
        int num2 = c.getNum2();
        int result = c.getResult();

        System.out.println(num1 + " + " + num2 + " = " + result);
    }

    public void setController(Controller c) {
        this.c = c;
    }
}
