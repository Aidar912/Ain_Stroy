package com.example.ain_stroy;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Registration {


    @FXML
    private Button BtnRegisLogin;

    @FXML
    private RadioButton RbtnBuilder;

    @FXML
    private RadioButton RbtnSupplier;

    @FXML
    private TextField RegisLogin;

    @FXML
    private TextField RegisName;

    @FXML
    private PasswordField RegisPass;

    @FXML
    private TextField RegisSurname;

    @FXML
    private Label setLabel;

    @FXML
    private Button back;

    @FXML
    private Button ResumeButton;


    @FXML
    void initialize() {

        BtnRegisLogin.setOnAction(event -> SignUpNewUser());
        back.setOnAction(actionEvent -> {
            back.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();


            loader.setLocation(getClass().getResource("FirstWindow.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        ResumeButton.setOnAction(actionEvent -> {
            ResumeButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("Resume.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        });

    }


    private void SignUpNewUser() {
        try {
            DatebaseHandler dbHandler = new DatebaseHandler();
            ToggleGroup group = new ToggleGroup();
            RbtnSupplier.setToggleGroup(group);
            RbtnBuilder.setToggleGroup(group);

            RadioButton selection = (RadioButton) group.getSelectedToggle();

            String firstname = RegisName.getText();
            String lastname = RegisSurname.getText();
            String username = RegisLogin.getText();
            String userpassword = RegisPass.getText();
            String type_account = selection.getText();
            int salary = 0;

            if (type_account.equals("") || firstname.equals("") || lastname.equals("") || username.equals("")
                    || userpassword.equals("")) sText("Fill everything,please");


            User user = new User(firstname, lastname, username, userpassword, type_account, salary,"");
            try {
                dbHandler.signUpUser(user);

                BtnRegisLogin.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();


                loader.setLocation(getClass().getResource(""));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();


            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (NullPointerException e) {
            setLabel.setText("Fill everything,please");
        }
    }

    public void sText(String text) {
        setLabel.setText(text);
    }
}
