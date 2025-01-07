import Controller.Controller;
import Model.BinaryRepository;
import Model.IRepository;
import Model.Model;
import View.View;

public class App {
    public static void main(String[] args) {
        IRepository repo = new BinaryRepository();
        Model model = new Model(repo);
        View view = new View();
        Controller controller = new Controller(model, view);
        view.setController(controller);
        model.setController(controller);

        controller.run();
    }
}
