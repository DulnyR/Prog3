package ProductosMVC;

import ProductosMVC.Controller.Controller;
import ProductosMVC.Model.Model;
import ProductosMVC.View.View;

public class App {

    public static void main(String[] args) throws Exception {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(view, model);

        view.setController(controller);

        controller.run();
    }
}
