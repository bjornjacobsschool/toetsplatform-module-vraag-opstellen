package nl.han.toetsapplicatie.core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import nl.han.toetsapplicatie.core.controllers.VraagEditController;
import nl.han.toetsapplicatie.core.model.Toets;
import nl.han.toetsapplicatie.module.model.Vraag;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Scene scene = new Scene(new Label("If you see this something is wrong"), 1024, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HAN - Student Applicatie");
        primaryStage.show();
       // loadVraagEdit();p
    }


    public void loadVraagEdit(Vraag vraag){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vraagEdit.fxml"));
            Parent toetsMakeParent = loader.load();
            VraagEditController controller = loader.getController();
            primaryStage.getScene().setRoot(toetsMakeParent);
            controller.setVraag(vraag);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
