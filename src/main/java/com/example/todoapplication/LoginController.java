package com.example.todoapplication;

import animations.Shaker;
import database.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginUsername;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private Button loginSignupButton;

    @FXML
    private Label loginFailLabel;


    private DatabaseHandler databaseHandler;

    @FXML
    void initialize() {

        databaseHandler = new DatabaseHandler();

        loginButton.setOnAction(actionEvent -> {
            String loginText = loginUsername.getText().trim();
            String loginPwd = loginPassword.getText().trim();

            User user = new User();
            user.setUserName(loginText);
            user.setPassword(loginPwd);

            ResultSet userRow = databaseHandler.getUser(user);

            int counter = 0;
            try{
                while (userRow.next()) {
                    counter++;
                }
                if(counter == 1){
                    databaseHandler.getUserId(user.getUserName());
                    showAddItemScreen();
                } else {
                    Shaker shakeLogg = new Shaker(loginUsername);
                    Shaker shakePass = new Shaker(loginPassword);
                    shakeLogg.shake();
                    shakePass.shake();
                    loginFailLabel.setText("An error occurred with log in.");
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        });

        loginSignupButton.setOnAction(actionEvent -> {
            //Take users to sign up screen
            loginSignupButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("signup.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });

    }

    private void showAddItemScreen(){
        //Take users to AddItem screen
        loginSignupButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addItem.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}