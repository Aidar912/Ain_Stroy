package com.example.ain_stroy;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Resume {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea ResumeInfo;

    @FXML
    private TextField ResumeLastname;

    @FXML
    private TextField ResumeName;

    @FXML
    private TextField ResumeNumber;

    @FXML
    private ComboBox ResumePosition;

    @FXML
    private Button backButton;

    @FXML
    private Button SendButton;

    public static String Position = null;

    @FXML
    void initialize() {
        List();
        ResumePosition.setOnAction(actionEvent -> {
            PositionCH();
        });
        SendButton.setOnAction(actionEvent -> {
            try {
                Resume();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        backButton.setOnAction(actionEvent -> {
            backButton.getScene().getWindow().hide();
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

    public void PositionCH() {
        if (ResumePosition.getValue().equals("Builder")) {
            Position = "Builder";
        } else {
            if (ResumePosition.getValue().equals("Hr")) {
                Position = "Hr";
            } else {
                if (ResumePosition.getValue().equals("Accountant")) {
                    Position = "Accountant";
                } else {
                    if (ResumePosition.getValue().equals("Architector")) {
                        Position = "Architector";
                    } else {
                        if (ResumePosition.getValue().equals("Sales Departament")) {
                            Position = "Sales Departament";
                        }
                    }
                }
            }
        }
    }

    public void List() {
        ObservableList<String> list = FXCollections.observableArrayList("Builder", "Hr", "Accountant", "Architector", "Sales Departament");
        ResumePosition.setItems(list);
    }

    public void Resume() throws SQLException, ClassNotFoundException {
        DatebaseHandler dbHandler = new DatebaseHandler();
        ResumeConstructor resumeC = new ResumeConstructor(ResumeName.getText(), ResumeLastname.getText(), ResumeNumber.getText(), Position, ResumeInfo.getText());
        dbHandler.InsertResume(resumeC);
        ResumeName.clear();
        ResumeLastname.clear();
        ResumeNumber.clear();
        ResumeInfo.clear();
    }

}
