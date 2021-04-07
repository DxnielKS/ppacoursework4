import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.net.URL;

public class App extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        URL viewLocation = getClass().getResource("/fxml/main.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(viewLocation);
        BorderPane root = fxmlLoader.load();

        Scene scene = new Scene(root, 1300, 860);
        stage.setTitle("PPA Coursework");
        stage.setScene(scene);
        stage.show();
    }
}
