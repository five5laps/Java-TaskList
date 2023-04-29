package com.example.tasklistjfx;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TaskListController {

    @FXML
    private TextArea description_field;

    @FXML
    private TextArea date_textArea;

    @FXML
    private Button removeButton;

    @FXML
    private Button addButton;

    @FXML
    private TextArea title_textArea;

    @FXML
    private TextField taskName_field;

    @FXML
    private TextArea description_textArea;

    String title_text = "";
    String description_text = "";
    String date_text = "";
    int tasks = 1;
    int maxTitle_Len = 10;
    int maxDescription_Len = 50;

    @FXML
    void initialize() {
        taskName_field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() == maxTitle_Len) {
                taskName_field.setText(oldValue);
            }
        });
        description_field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() == maxDescription_Len) {
                description_field.setText(oldValue);
            }
        });

        title_textArea.setEditable(false);
        title_textArea.setMouseTransparent(true);
        title_textArea.setFocusTraversable(false);

        date_textArea.setEditable(false);
        date_textArea.setMouseTransparent(true);
        date_textArea.setFocusTraversable(false);

        description_textArea.setEditable(false);

        addButton.setOnAction(event -> {
            title_text       = title_text + tasks + "." + " " + taskName_field.getText() + "\n";
            description_text = description_text + description_field.getText() + "\n";
            date_text        = date_text + String.valueOf(LocalDate.now()) + "\n";

            title_textArea.setText(title_text);
            description_textArea.setText(description_text);
            date_textArea.setText(date_text);

            tasks++;
        });

        //при добавлении строка возвращается
        removeButton.setOnAction(event -> {
            title_textArea.setText(title_textArea.getText().replaceAll("[^\n]*\n?$", ""));
            description_textArea.setText(description_textArea.getText().replaceAll("[^\n]*\n?$", ""));
            date_textArea.setText(date_textArea.getText().replaceAll("[^\n]*\n?$", ""));

            if(tasks > 0) tasks--;

        });
    }
}

/*TODO
* Сделать более нормальный ремув
* Сделать сохранение тасок
* Считывание тасок
*
*/
