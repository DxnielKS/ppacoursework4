import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;


public class GUI extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
//        BorderPane root = new BorderPane();
//        root = create(root);
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(root, 800,500);
        stage.setTitle("AIRBNB PROJECT");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }
}
