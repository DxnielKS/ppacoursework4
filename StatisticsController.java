import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
public class StatisticsController implements Initializable {
    @FXML private Label statistic1;
    @FXML private Label statistic2;
    @FXML private Label statistic3;
    @FXML private Label statistic4;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        statistic1.setText("This is a stats label");
    }
}