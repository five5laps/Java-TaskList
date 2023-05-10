package com.example.todoapplication;

import animations.Shaker;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddItemController {

    @FXML
    private AnchorPane rootAnchorPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addButton;

    @FXML
    private Label noTaskLabel;

    @FXML
    void initialize() {

        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            FadeTransition fadeTransition = new FadeTransition(Duration.millis(2000), addButton);
            FadeTransition labelTransition = new FadeTransition(Duration.millis(2000), noTaskLabel);

            addButton.setOpacity(0);
            noTaskLabel.setOpacity(0);

            fadeTransition.setFromValue(1f);
            fadeTransition.setToValue(0f);
            fadeTransition.setCycleCount(1);
            fadeTransition.setAutoReverse(false);


            labelTransition.setFromValue(1f);
            labelTransition.setToValue(0f);
            labelTransition.setCycleCount(1);
            labelTransition.setAutoReverse(false);

            fadeTransition.play();
            labelTransition.play();

            try {
                AnchorPane formPane =
                        FXMLLoader.load(getClass().getResource("addItemForm.fxml"));

                FadeTransition rootTransition = new FadeTransition(Duration.millis(2000), formPane);
                rootTransition.setFromValue(0f);
                rootTransition.setToValue(1f);
                rootTransition.setCycleCount(1);
                rootTransition.setAutoReverse(false);
                rootTransition.play();
                rootAnchorPane.getChildren().setAll(formPane);

            } catch (IOException e) {
                e.printStackTrace();
            }

        });

    }
}
