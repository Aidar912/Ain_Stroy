package com.example.ain_stroy;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LoginController {
    public static String name = null;
    public static String type_account = null;
    public static String login = null;
    public static String password = null;
    public static String lastname = null;
    public static String image = null;
    public static int Salary = 0;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BtnLogin;


    @FXML
    private TextField SignUpLogin;

    @FXML
    private PasswordField SignUpPassword;

    @FXML
    private Label setLbl;

    @FXML
    private Button back;

    @FXML
    void initialize() {

        BtnLogin.setOnAction(event -> {
            String user_login = SignUpLogin.getText().trim();
            String user_password = SignUpPassword.getText().trim();

            if (!user_login.equals("") && !user_password.equals("")) {
                try {
                    loginUser(user_login, user_password);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Заполните все !");
            }


        });
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


    }

    public void loginUser(String user_login, String user_password) throws SQLException, ClassNotFoundException {
        DatebaseHandler dbHandler = new DatebaseHandler();
        User user = new User();
        user.setUser_login(user_login);
        user.setUser_password(user_password);

        ResultSet result = dbHandler.getUser(user);

        int count = 0;
        while (result.next()) {
            type_account = result.getString("type_account");
            name = result.getString("firstname");
            login = result.getString("user_login");
            lastname = result.getString("lastname");
            password = result.getString("user_password");
            image = result.getString("Image");
            Salary = result.getInt("salary");
            count++;
        }
        if (count >= 1) {
            System.out.println("Success!");
            BtnLogin.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();


            loader.setLocation(getClass().getResource(OpenWindow(type_account)));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        } else {
            setText("Wrong login or password!");
        }

    }

    public static String OpenWindow(String type_account) {
        String open_window = "";
        if (type_account.equals("Director")) {
            open_window = "DirectorMenu.fxml";
        } else {
            if (type_account.equals("Builder")) {
                open_window = "BuilderMenu.fxml";
            } else {
                if (type_account.equals("Supplier")) {
                    open_window = "SupplierMenu.fxml";
                } else {
                    if (type_account.equals("Architector")) {
                        open_window = "architector.fxml";
                    } else {
                        if (type_account.equals("Accountant")) {
                            open_window = "Accountant.fxml";
                        } else {
                            if (type_account.equals("Sales Departament")) {
                                open_window = "SalesDepartment.fxml";
                            } else {
                                if (type_account.equals("Hr")) {
                                    open_window = "hr-manager.fxml";
                                }
                            }
                        }
                    }
                }
            }
        }
        return open_window;
    }

    public void setText(String sText) {
        setLbl.setText(sText);
    }

}