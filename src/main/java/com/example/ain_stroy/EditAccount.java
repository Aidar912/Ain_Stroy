package com.example.ain_stroy;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class EditAccount {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private javafx.scene.image.ImageView ImageView;


    @FXML
    private Button choiseImage;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField password;

    @FXML
    private Button save;

    @FXML
    void initialize() {
        save.setOnAction(actionEvent -> {
            try {
                EditProfile(firstname.getText().trim(), lastname.getText().trim(), password.getText().trim());
                firstname.clear();
                lastname.clear();
                password.clear();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        choiseImage.setOnAction(actionEvent -> {
            try {
                Filechooser();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

    }

    public void EditProfile(String firstname, String lastname, String password) throws SQLException, ClassNotFoundException {
        String login = LoginController.login;
        DatebaseHandler dbHabdler = new DatebaseHandler();
        if (firstname.equals("")) {
            firstname = LoginController.name;
        }
        if (lastname.equals("")) {
            lastname = LoginController.lastname;

        }
        if (password.equals("")) {
            password = LoginController.password;
        }

        dbHabdler.UpdateInformation(firstname, lastname, password, login);
        System.out.println("Все обновлено!");
    }

    public void Filechooser() throws SQLException, ClassNotFoundException {
        String login = LoginController.login;
        DatebaseHandler dbHabdler = new DatebaseHandler();
        hrManager hr = new hrManager();
        Stage s = new Stage();
        FileChooser f = new FileChooser();

        f.setTitle("Opening the location..");
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG File", "*png"));
        HBox r = new HBox();
        r.setSpacing(20);
        String file = String.valueOf(f.showOpenDialog(null));
        String replace = file.replace("\\", "\\\\");
        Image im = new Image(file);
        ImageView.setImage(im);

        dbHabdler.UpdatePath(replace, LoginController.login);


    }

}
