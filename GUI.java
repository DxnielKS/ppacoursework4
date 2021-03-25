import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    public void start(Stage stage)
    {
        BorderPane root = new BorderPane();
        root = create(root);
        Scene scene = new Scene(root, 800,500);
        stage.setTitle("JavaFX Example");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }

    /**
     * Sets up the initial interface
     * @param root
     * @return
     */
    private BorderPane create(BorderPane root) {
        BorderPane top = new BorderPane();
        BorderPane bottom = new BorderPane();

        Button rightArrow = new Button();
        Button leftArrow = new Button();
        Image rightArrowImage = new Image("rightArrowImage.png", 16,16,true,true);
        Image leftArrowImage = new Image("leftArrowImage.png", 16,16,true,true);
        rightArrow.setGraphic(new ImageView(rightArrowImage));
        rightArrow.setPrefSize(40, 40);
        leftArrow.setGraphic(new ImageView(leftArrowImage));
        leftArrow.setPrefSize(40, 40);
        bottom.setRight(rightArrow);
        bottom.setLeft(leftArrow);


        HBox topright = new HBox(10);

        ChoiceBox fromChoiceBox = new ChoiceBox();
        fromChoiceBox.getItems().add("PRICERANGES");

        ChoiceBox toChoiceBox = new ChoiceBox();
        toChoiceBox.getItems().add("PREARRANGES");

        topright.getChildren().addAll(new Label("From:"), fromChoiceBox, new Label("To:"), toChoiceBox);

        top.setPadding(new Insets(15, 20, 10, 10));
        top.setRight(topright);

        bottom.setPadding(new Insets(15, 20, 10, 10));
        //rightArrow.setOnAction(this::buttonClick);
        root.setTop(top);
        root.setBottom(bottom);
        root.setCenter(welcomePane());
        return root;
    }

    /**
     * The welcome pane
     * @return
     */
    private StackPane welcomePane() {
        StackPane stackPane = new StackPane();
        Label label = new Label("Welcome!, Select a price range above and then use arrows to navigate the different panes");
        stackPane.getChildren().addAll(label);
        return stackPane;
    }


}
