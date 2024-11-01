package Calculator.Controller;

import Calculator.Model.Model;
import Calculator.View.View;

public class Controller {

    private View v;
    private Model m;

    public Controller(View v, Model m) {
        this.v = v;
        this.m = m;
    }

    public void setNum1(int num1) {
        m.setNum1(num1);
    }

    public void setNum2(int num2) {
        m.setNum2(num2);
    }

    public void sumNumbers() {
        m.sumNumbers();
    }

    public int getNum1() {
        return m.getNum1();
    }

    public int getNum2() {
        return m.getNum2();
    }

    public int getResult() {
        return m.getResult();
    }

    public void run() {
        v.showMenu();
    }
}
