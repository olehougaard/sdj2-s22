package dk.via.calculator;

import dk.via.calculator.model.Model;
import dk.via.calculator.model.ModelManager;
import dk.via.calculator.view.ViewHandler;
import dk.via.calculator.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class CalculatorApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        Model model = new ModelManager();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }
}