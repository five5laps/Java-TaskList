package com.example.todoapplication;

import animations.Shaker;
import database.Const;
import database.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Task;

import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ResourceBundle;

public class AddItemFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField taskField;

    @FXML
    private ImageView saveTaskButton;

    @FXML
    private TextField descriptionField;

    private DatabaseHandler databaseHandler;

    Date currentDate;

    @FXML
    void initialize() {

        currentDate = new Date();
        databaseHandler = new DatabaseHandler();

        saveTaskButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            String taskText = taskField.getText();
            String taskDesc = descriptionField.getText();
            Timestamp Time =  new Timestamp(System.currentTimeMillis());
            int userId = Const.LOGGED_USER_ID;

            Task task = new Task(userId, Time, taskDesc, taskText);

            databaseHandler.saveTask(task);

            Shaker buttonShaker = new Shaker(saveTaskButton);
            buttonShaker.shake();

        });
    }
}

 /*
 taskid should ++ by itself
 userid should be equal to logged userid
 Store taskField into task in database
 Store descriptionField into description in database
 Get current date and store into datecreated
 */