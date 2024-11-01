package Calculator;

import Calculator.Controller.Controller;
import Calculator.Model.Model;
import Calculator.View.View;

public class App {
    public static void main(String[] args) throws Exception {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(view, model);

        view.setController(controller);

        controller.run();
    }
}
