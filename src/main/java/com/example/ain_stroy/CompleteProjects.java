package com.example.ain_stroy;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.w3c.dom.Text;

public class CompleteProjects {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane CompleteTable;

    @FXML
    private DatePicker ProjectTime;

    @FXML
    private Label ProjectApartment;

    @FXML
    private Label ProjectBudget;

    @FXML
    private Label ProjectDistrict;

    @FXML
    private Label ProjectsName;

    @FXML
    private Button CompleteButton;


    public static String Name = null;
    public static String District = null;
    public static int Apartment = 0;
    public static int Budget = 0;


    @FXML
    void initialize() {
        Select();
        ProjectsName.setText(Name);
        ProjectDistrict.setText(District);
        ProjectBudget.setText(String.valueOf(Budget));
        ProjectApartment.setText(String.valueOf(Apartment));

        CompleteButton.setOnAction(actionEvent -> {
            CompleteButton.getScene().getWindow().hide();
            DatebaseHandler dbHandler = new DatebaseHandler();
            try {
                dbHandler.UpdateProjectsTable(Name, String.valueOf(ProjectTime.getValue()), "Completed");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

    }

    public void Select() {
        try {
            DatebaseHandler dbHandler = new DatebaseHandler();
            ResultSet result = dbHandler.SelectProject(Name);
            while (result.next()) {
                Name = result.getString("ProjectsName");
                District = result.getString("District");
                Apartment = result.getInt("Apartments");
                Budget = result.getInt("Budget");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
