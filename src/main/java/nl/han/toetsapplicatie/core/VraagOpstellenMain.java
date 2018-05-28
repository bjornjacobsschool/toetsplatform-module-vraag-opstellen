package nl.han.toetsapplicatie.core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import nl.han.toetsapplicatie.core.controllers.VraagOpstelController;
import nl.han.toetsapplicatie.core.data.VraagOpslaanDAO;

import java.io.IOException;

public class VraagOpstellenMain extends Application {

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
        loadVraagEdit(null);
    }


    public Node loadVraagEdit(VraagOpslaanDAO vraagOpslaan){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/vraagOpstel.fxml"));
            Parent toetsMakeParent = loader.load();
            VraagOpstelController controller = loader.getController();
            controller.setVraagOpslaan(vraagOpslaan);
            primaryStage.getScene().setRoot(toetsMakeParent);
            return toetsMakeParent;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
