package Calculator.Model;

public class Model {
    
    private int num1 = 0;
    private int num2 = 0;

    private int result = 0;

    public void sumNumbers() {
        this.result = num1 + num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
