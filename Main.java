import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
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
import java.net.URL;

public class Main extends Application
{
    FXMLLoader fxmlLoader;
    @Override
    public void start(Stage stage) throws Exception
    {
        URL viewLocation = getClass().getResource("main.fxml");
        fxmlLoader = new FXMLLoader(viewLocation);
        BorderPane root = fxmlLoader.load();

        Scene scene = new Scene(root, 1300, 860);
        stage.setTitle("PROJECT");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}