package com.example.ain_stroy;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import  javax.mail.*;

public class hrManager {

    public static String Position = null;

    @FXML
    private TextField ResumeSearch;

    @FXML
    private Button AboutTheProgram;

    @FXML
    private Button DeleteUser;

    @FXML
    private Button EditAccount;

    @FXML
    private Button Exit;

    @FXML
    private Label LabelAccountType;

    @FXML
    private TableColumn<User, String> Lastname;

    @FXML
    private TableColumn<User, String> Firstname;


    @FXML
    private Label LabelUserName;

    @FXML
    private TableColumn<User, String> NameCol;

    @FXML
    private TextField NameTextField;

    @FXML
    private TableView<User> PersChTable;

    @FXML
    private Button PersChang;

    @FXML
    private TableColumn<User, String> PositionCol;

    @FXML
    private ComboBox PositionComBox;

    @FXML
    private AnchorPane AnchorSalaries;

    @FXML
    private ImageView ProfileImage;

    @FXML
    private TableColumn<Vacation, Integer> DaysVacation;

    @FXML
    private Button Resume;

    @FXML
    private Button Salar;

    @FXML
    private Button SaveButton;

    @FXML
    private Button Vacation;

    @FXML
    private AnchorPane AnchorPersonnelChanges;

    @FXML
    private Button SaveSalButton;

    @FXML
    private TextField SalaryTextField;

    @FXML
    private TableView<User> SalaryTable;

    @FXML
    private TableColumn<User, String> Salaries;

    @FXML
    private TableColumn<User, String> LastnameSal;

    @FXML
    private AnchorPane AnchorVacation;

    @FXML
    private TableColumn<User, String> SalaryDismiss;

    @FXML
    private TableColumn<User, String> PositionDismiss;

    @FXML
    private TableColumn<User, String> PasswordDismiss;
    @FXML
    private TableColumn<User, String> NameDismiss;

    @FXML
    private TableColumn<User, String> LoginDismiss;

    @FXML
    private TableColumn<User, String> FirstnameDismiss;

    @FXML
    private TableView<User> DismissTable;

    @FXML
    private TextField DismissName;

    @FXML
    private Button DismissButton;

    @FXML
    private AnchorPane AboutTheProgramPane;

    @FXML
    private TextFlow AboutTheProgrammText;

    @FXML
    private TableColumn<Vacation, String> StatusCol;

    @FXML
    private TableColumn<User, String> FirstnameSal;

    @FXML
    private TextField NameSalTextFiled;


    @FXML
    private Button Allow;

    @FXML
    private Button Disallow;

    @FXML
    private TextField VacationSearchField;

    @FXML
    private TextField SalarSearchField;

    @FXML
    private TextField PCSearchField;

    @FXML
    private TextField DisSearchField;

    @FXML
    private TextField IDUSERS;

    @FXML
    private TableColumn<Vacation, String> LastVacation;

    @FXML
    private TableColumn<Vacation, String> NameVacation;

    @FXML
    private TableView<Vacation> VacationTable;

    @FXML
    private AnchorPane AnchorPaneDismiss;

    @FXML
    private TableColumn<Vacation, Integer> paidVacation;

    @FXML
    private TableColumn<ResumeConstructor, String> ResumeLastname;

    @FXML
    private TableColumn<ResumeConstructor, String> ResumeName;

    @FXML
    private TableColumn<ResumeConstructor, String> ResumeNumber;

    @FXML
    private TableColumn<ResumeConstructor, String> ResumePosition;

    @FXML
    private TableView<ResumeConstructor> ResumeTable;

    @FXML
    private AnchorPane AnchorPaneResume;

    @FXML
    void initialize() {
        ComboBox();
        Image();
        LabelUserName.setText(LoginController.name);
        LabelAccountType.setText(LoginController.type_account);

        AboutTheProgram.setOnAction(actionEvent -> {
            if (AboutTheProgramPane.visibleProperty().get() == false) {
                AboutTheProgramPane.setVisible(true);
            } else {
                AboutTheProgramPane.setVisible(false);
            }
        });


        EditAccount.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();


            loader.setLocation(getClass().getResource("EditAccount.fxml"));
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


        Exit.setOnAction(actionEvent -> {
            Exit.getScene().getWindow().hide();

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

        Vacation.setOnAction(actionEvent -> {
            if (AnchorVacation.visibleProperty().get() == false) {
                AnchorVacation.setVisible(true);
            } else {
                AnchorVacation.setVisible(false);
            }
            try {
                VacationTable();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        PersChang.setOnAction(actionEvent -> {
            if (AnchorPersonnelChanges.visibleProperty().get() == false) {
                AnchorPersonnelChanges.setVisible(true);
            } else {
                AnchorPersonnelChanges.setVisible(false);
            }
            try {
                PersonnelChanges();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        SaveButton.setOnAction(actionEvent -> {
            try {
                UpdateUsers();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        PositionComBox.setOnAction(actionEvent -> {
            PositionsBox();
        });
        Salar.setOnAction(actionEvent -> {
            if (AnchorSalaries.visibleProperty().get() == false) {
                AnchorSalaries.setVisible(true);
            } else {
                AnchorSalaries.setVisible(false);
            }
            try {
                UsersSalaries();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        Resume.setOnAction(actionEvent -> {
            if (AnchorPaneResume.visibleProperty().get() == false) {
                AnchorPaneResume.setVisible(true);
            } else {
                AnchorPaneResume.setVisible(false);
            }
            try {
                ResumeTableView();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        SaveSalButton.setOnAction(actionEvent -> {
            try {
                UpdateSalary();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        Allow.setOnAction(actionEvent -> {
            try {
                VacationAllow();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        Disallow.setOnAction(actionEvent -> {
            try {
                VacationDisallow();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        DeleteUser.setOnAction(actionEvent -> {
            if (AnchorPaneDismiss.visibleProperty().get() == false) {
                AnchorPaneDismiss.setVisible(true);
            } else {
                AnchorPaneDismiss.setVisible(false);
            }
            try {
                DismissTable();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        DismissButton.setOnAction(actionEvent -> {
            try {
                DeleteUsers();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

    }

    public void PersonnelChanges() throws SQLException, ClassNotFoundException {
        ObservableList<User> dslist = FXCollections.observableArrayList();
        DatebaseHandler dbHandler = new DatebaseHandler();
        ResultSet result = dbHandler.PersonnelChange();
        Firstname.setCellValueFactory(new PropertyValueFactory<User, String>("firstname"));
        Lastname.setCellValueFactory(new PropertyValueFactory<User, String>("lastname"));
        PositionCol.setCellValueFactory(new PropertyValueFactory<User, String>("type_account"));
        while (result.next()) {

            if (result.getString("type_account").equals("Supplier")) {
                continue;
            } else {
                dslist.add(new User(result.getString("firstname"), result.getString("lastname"), result.getString("user_login"), result.getString("user_password"), result.getString("type_account"), result.getInt("salary"),result.getString("email")));
            }
        }

        FilteredList<User> Filtered = new FilteredList<>(dslist, b -> true);
        PCSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            Filtered.setPredicate(user -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (user.getFirstname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (user.getLastname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (user.getType_account().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;

            });
        });
        SortedList<User> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(PersChTable.comparatorProperty());
        PersChTable.setItems(sortedList);


    }

    public void UpdateUsers() throws SQLException, ClassNotFoundException {
        String[] Name = NameTextField.getText().split(" ");
        DatebaseHandler dbhandler = new DatebaseHandler();
        dbhandler.UpdatePersonnel(Position, Name[0], Name[1]);
        NameTextField.clear();
        PersonnelChanges();
    }

    public void ComboBox() {
        ObservableList<String> Position = FXCollections.observableArrayList("Director", "Hr", "Architector", "Accountant", "Sales Departament");
        PositionComBox.setItems(Position);
    }

    public void PositionsBox() {
        if (PositionComBox.getValue().equals("Director")) {
            Position = "Director";
        } else {
            if (PositionComBox.getValue().equals("Hr")) {
                Position = "Hr";
            } else {
                if (PositionComBox.getValue().equals("Architector")) {
                    Position = "Architector";
                } else {
                    if (PositionComBox.getValue().equals("Accountant")) {
                        Position = "Accountant";
                    } else {
                        if (PositionComBox.getValue().equals("Sales Departament")) {
                            Position = "Sales Departament";
                        }
                    }

                }
            }
        }
    }

    public void UpdateSalary() throws SQLException, ClassNotFoundException {
        String[] Name = NameSalTextFiled.getText().split(" ");
        DatebaseHandler dbhandler = new DatebaseHandler();
        dbhandler.UpdateSalary(SalaryTextField.getText(), Name[0], Name[1]);
        NameSalTextFiled.clear();
        SalaryTextField.clear();
        UsersSalaries();
    }

    public void UsersSalaries() throws SQLException, ClassNotFoundException {
        ObservableList<User> dslist = FXCollections.observableArrayList();
        DatebaseHandler dbHandler = new DatebaseHandler();
        ResultSet result = dbHandler.PersonnelChange();
        FirstnameSal.setCellValueFactory(new PropertyValueFactory<User, String>("firstname"));
        LastnameSal.setCellValueFactory(new PropertyValueFactory<User, String>("lastname"));
        Salaries.setCellValueFactory(new PropertyValueFactory<User, String>("salary"));
        while (result.next()) {

            if (result.getString("type_account").equals("Supplier")) {
                continue;
            } else {
                dslist.add(new User(result.getString("firstname"), result.getString("lastname"), result.getString("user_login"), result.getString("user_password"), result.getString("type_account"), result.getInt("salary"),result.getString("email")));
            }
        }

        FilteredList<User> Filtered = new FilteredList<>(dslist, b -> true);
        SalarSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            Filtered.setPredicate(user -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (user.getFirstname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (user.getLastname().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;

            });
        });
        SortedList<User> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(SalaryTable.comparatorProperty());
        SalaryTable.setItems(sortedList);


    }

    public void VacationTable() throws SQLException, ClassNotFoundException {
        ObservableList<Vacation> dslist = FXCollections.observableArrayList();
        DatebaseHandler dbHandler = new DatebaseHandler();
        ResultSet result = dbHandler.Vacation();

        NameVacation.setCellValueFactory(new PropertyValueFactory<>("NameUser"));
        LastVacation.setCellValueFactory(new PropertyValueFactory<>("LastVacation"));
        paidVacation.setCellValueFactory(new PropertyValueFactory<>("PaidVacation"));
        DaysVacation.setCellValueFactory(new PropertyValueFactory<>("VacationDays"));
        StatusCol.setCellValueFactory(new PropertyValueFactory<>("Status"));
        while (result.next()) {
            dslist.add(new Vacation(result.getString("UserName"), result.getString("LastVacation"), result.getInt("PaidVacation"), result.getInt("Days"), result.getString("status")));
        }
        FilteredList<Vacation> Filtered = new FilteredList<>(dslist, b -> true);
        VacationSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            Filtered.setPredicate(vacation -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (vacation.getNameUser().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (vacation.getLastVacation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(vacation.getPaidVacation()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(vacation.getVacationDays()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (vacation.getStatus().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else
                    return false;

            });
        });
        SortedList<Vacation> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(VacationTable.comparatorProperty());
        VacationTable.setItems(sortedList);

    }

    public void VacationAllow() throws SQLException, ClassNotFoundException {
        DatebaseHandler dbHandler = new DatebaseHandler();
        dbHandler.VacationStatus("Allowed", IDUSERS.getText());
        IDUSERS.clear();
        VacationTable();
    }

    public void VacationDisallow() throws SQLException, ClassNotFoundException {
        DatebaseHandler dbHandler = new DatebaseHandler();
        dbHandler.VacationStatus("Disallowed", IDUSERS.getText());
        IDUSERS.clear();
        VacationTable();
    }

    public void DismissTable() throws SQLException, ClassNotFoundException {
        ObservableList<User> dslist = FXCollections.observableArrayList();
        DatebaseHandler dbHandler = new DatebaseHandler();
        ResultSet result = dbHandler.PersonnelChange();
        NameDismiss.setCellValueFactory(new PropertyValueFactory<User, String>("firstname"));
        FirstnameDismiss.setCellValueFactory(new PropertyValueFactory<User, String>("lastname"));
        LoginDismiss.setCellValueFactory(new PropertyValueFactory<>("user_login"));
        PasswordDismiss.setCellValueFactory(new PropertyValueFactory<>("user_password"));
        PositionDismiss.setCellValueFactory(new PropertyValueFactory<>("type_account"));
        SalaryDismiss.setCellValueFactory(new PropertyValueFactory<User, String>("salary"));
        while (result.next()) {

            if (result.getString("type_account").equals("Supplier")) {
                continue;
            } else {
                dslist.add(new User(result.getString("firstname"), result.getString("lastname"), result.getString("user_login"), result.getString("user_password"), result.getString("type_account"), result.getInt("salary"),result.getString("email")));
            }
        }

        FilteredList<User> Filtered = new FilteredList<>(dslist, b -> true);
        DisSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            Filtered.setPredicate(user -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (user.getFirstname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (user.getLastname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (user.getUser_login().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (user.getUser_password().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (user.getType_account().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(user.getSalary()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else
                    return false;

            });
        });
        SortedList<User> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(DismissTable.comparatorProperty());
        DismissTable.setItems(sortedList);
    }

    public void DeleteUsers() throws SQLException, ClassNotFoundException {
        DatebaseHandler dbHandler = new DatebaseHandler();
        String[] name = DismissName.getText().split(" ");
        dbHandler.DeleteUser(name[0], name[1]);
        DismissTable();
    }

    public void Image() {
        Image im = new Image(LoginController.image);
        ProfileImage.setImage(im);
    }

    public void ResumeTableView() throws SQLException, ClassNotFoundException {
        ObservableList<ResumeConstructor> resumelist = FXCollections.observableArrayList();
        DatebaseHandler dbHandler = new DatebaseHandler();
        ResultSet result = dbHandler.ResumeUsers();
        while (result.next()) {
            resumelist.add(new ResumeConstructor(
                    result.getString("firstname"),
                    result.getString("lastname"),
                    result.getString("number"),
                    result.getString("position"),
                    result.getString("info")));
        }
        ResumeName.setCellValueFactory(new PropertyValueFactory<>("Lastname"));
        ResumeLastname.setCellValueFactory(new PropertyValueFactory<>("Firstname"));
        ResumePosition.setCellValueFactory(new PropertyValueFactory<>("Position"));
        ResumeNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
        FilteredList<ResumeConstructor> Filtered = new FilteredList<>(resumelist, b -> true);
        ResumeSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            Filtered.setPredicate(resumeConstructor -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (resumeConstructor.getFirstname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (resumeConstructor.getLastname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (resumeConstructor.getPosition().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (resumeConstructor.getNumber().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else
                    return false;

            });
        });
        SortedList<ResumeConstructor> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(ResumeTable.comparatorProperty());
        ResumeTable.setItems(sortedList);
        Click();

    }

    public void Click() {
        ResumeTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (mouseEvent.isPrimaryButtonDown() && mouseEvent.getClickCount() == 2) {
                    TablePosition pos = ResumeTable.getSelectionModel().getSelectedCells().get(0);
                    int row = pos.getRow();
                    ResumeConstructor item = ResumeTable.getItems().get(row);

                    TableColumn col = pos.getTableColumn();
                    String data = (String) col.getCellObservableValue(item).getValue();
                    InfoResume.Username = data;
                    OpenResume();

                }
            }
        });

    }

    public void OpenResume() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("IfoResume.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void SendEmail(){


    }
}
