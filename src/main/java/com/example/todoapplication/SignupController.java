package com.example.todoapplication;

import database.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupController
{
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpFirstName;

    @FXML
    private TextField signUpLastName;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private TextField signUpLocation;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField signUpUsername;

    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    void initialize() {


        signUpCheckBoxMale.setOnAction(actionEvent -> {
            if(signUpCheckBoxFemale.isSelected()){
                signUpCheckBoxFemale.setSelected(false);
            }
        });

        signUpCheckBoxFemale.setOnAction(actionEvent -> {
            if(signUpCheckBoxMale.isSelected()){
                signUpCheckBoxMale.setSelected(false);
            }
        });


        signUpButton.setOnAction(actionEvent -> {
            createUser();
        });

    }

    private void createUser(){
        DatabaseHandler databaseHandler = new DatabaseHandler();

        String name = signUpFirstName.getText();
        String lastname = signUpLastName.getText();
        String username = signUpUsername.getText();
        String password = signUpPassword.getText();
        String location = signUpLocation.getText();

        String gender = "";
        if(signUpCheckBoxFemale.isSelected()){
            gender = "Female";
        } else{ gender = "Male"; }

        User user = new User(name, lastname, username, password, location, gender);

        databaseHandler.signUpUser(user);
    }

}
