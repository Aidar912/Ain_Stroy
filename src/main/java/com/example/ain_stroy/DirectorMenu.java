package com.example.ain_stroy;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import javax.xml.transform.Result;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class DirectorMenu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AboutTheProgramm;

    @FXML
    private Button AllUsersButton;

    @FXML
    private AnchorPane AnchorPaneEditProjects;

    @FXML
    private AnchorPane AnchorPaneFinishProjects;

    @FXML
    private AnchorPane AnchorPaneShowBudget;

    @FXML
    private AnchorPane AnchorPaneShowMaterials;

    @FXML
    private AnchorPane AnchorPaneShowProjects;

    @FXML
    private AnchorPane AnchorPaneStartTheProject;

    @FXML
    private StackedBarChart<String, Integer> BudgetChart;

    @FXML
    private Button BudgetInfoButton;

    @FXML
    private ComboBox<String> ChoiceTableBox;

    @FXML
    private TextField ProjectsSearchField;

    @FXML
    private Button EditAccount;

    @FXML
    private TextField EditApartmentsField;

    @FXML
    private TextField EditBudgetField;

    @FXML
    private TextArea EditDescriptionArea;

    @FXML
    private TextField EditDistrictField;

    @FXML
    private TextField EditNameField;

    @FXML
    private Button EditSaveButton;

    @FXML
    private Button Exit;

    @FXML
    private StackedBarChart<String, Integer> ExpensesChart;

    @FXML
    private Button ExpensesInfoButton;

    @FXML
    private TextField FinishApartmentsField;

    @FXML
    private TextField FinishBudgetField;

    @FXML
    private TextArea FinishDescriptionArea;

    @FXML
    private TextField FinishDistrictField;

    @FXML
    private TextField FinishNameField;

    @FXML
    private Button FinishSaveButton;

    @FXML
    private StackedBarChart<String, Integer> GeneralChart;

    @FXML
    private Button GeneralInfoButton;

    @FXML
    private Label LabelAccountType;

    @FXML
    private Label LabelUserName;

    @FXML
    private Text NotEnoughBalanceText;

    @FXML
    private Text NotEnoughBalanceText1;

    @FXML
    private Text TextForProjects;

    @FXML
    private TableColumn<ProjectsTable, Integer> ProjectsApartments;

    @FXML
    private TableColumn<ProjectsTable, Integer> ProjectsBudget;

    @FXML
    private TableColumn<ProjectsTable, String> ProjectsDistrict;

    @FXML
    private Button ProjectsEditButton;

    @FXML
    private ComboBox<String> ProjectsEditComboBox;

    @FXML
    private Button ProjectsFinishButton;

    @FXML
    private ComboBox<String> ProjectsFinishComboBox;

    @FXML
    private TableColumn<ProjectsTable, String> ProjectsName;

    @FXML
    private TableColumn<ProjectsTable, Integer> ProjectsStatus;

    @FXML
    private TableView<ProjectsTable> ProjectsTable;

    @FXML
    private TableColumn<ProjectsTable, String> ProjectsTime;

    @FXML
    private StackedBarChart<String, Integer> RevenuesChart;

    @FXML
    private Button RevenuesInfoButton;

    @FXML
    private Button ShowBudgetButton;

    @FXML
    private Button ShowMaterialsButton;

    @FXML
    private Button ShowProjectsButton;

    @FXML
    private TextField StartProjectBudget;

    @FXML
    private TextField StartProjectBusiness;

    @FXML
    private TextArea StartProjectDescription;

    @FXML
    private ComboBox<String> StartProjectDistrictBox;

    @FXML
    private TextField StartProjectBusinessPrice;

    @FXML
    private TextField StartProjectEconomyPrice;

    @FXML
    private TextField StartProjectLuxuryPrice;

    @FXML
    private TextField StartProjectEconomy;

    @FXML
    private TextField StartProjectLuxury;

    @FXML
    private TextField StartProjectName;

    @FXML
    private Button StartTheProjectButton;

    @FXML
    private TableColumn<StatusMaterials, String> StatusMaterialsName;

    @FXML
    private PieChart StatusMaterialsPieChart;

    @FXML
    private TableColumn<StatusMaterials, Integer> StatusMaterialsPrice;

    @FXML
    private TableColumn<StatusMaterials, Integer> StatusMaterialsQuantity;

    @FXML
    private TextField StatusMaterialsSearchField;

    @FXML
    private TableColumn<StatusMaterials, String> StatusMaterialsStatus;

    @FXML
    private TableColumn<StatusMaterials, String> StatusMaterialsSupplierName;

    @FXML
    private TableView<StatusMaterials> StatusMaterialsTable;

    @FXML
    private TableColumn<StockOfMaterials, String> StockMaterialsName;

    @FXML
    private TableColumn<StockOfMaterials, Integer> StockMaterialsQuantity;

    @FXML
    private TableView<StockOfMaterials> StockMaterialsTable;

    @FXML
    private Button WithdrawMoneyButton;

    @FXML
    private Button WithdrawMoneyOKButton;

    @FXML
    private TextField WithdrawMoneyField;

    @FXML
    private ImageView image;

    @FXML
    private Button StartButton;

    @FXML
    private DatePicker CompletionDatePicker;

    @FXML
    private AnchorPane AnchorPaneAllUsers;

    @FXML
    private TableColumn<User, String> UsersAccount;

    @FXML
    private ComboBox<String > UsersEditBox;

    @FXML
    private Button UsersEditButton;

    @FXML
    private TableColumn<User, String> UsersEmail;

    @FXML
    private TableColumn<User, String> UsersFirstname;

    @FXML
    private TableColumn<User, String> UsersLastname;

    @FXML
    private TableColumn<User, String> UsersLogin;

    @FXML
    private TableColumn<User, String> UsersPassword;

    @FXML
    private ComboBox<String> UsersRemoveBox;

    @FXML
    private TextField UsersSearchField;

    @FXML
    private Button UsersRemoveButton;

    @FXML
    private TableColumn<User, Integer> UsersSalary;

    @FXML
    private TableView<User> UsersTable;

    @FXML
    private AnchorPane AnchorPaneEditUser;

    @FXML
    private TextField EditUserEmail;

    @FXML
    private TextField EditUserLastname;

    @FXML
    private TextField EditUserLogin;

    @FXML
    private TextField EditUserName;

    @FXML
    private TextField EditUserPassword;

    @FXML
    private ComboBox<String> EditUserPosition;

    @FXML
    private TextField EditUserSalary;

    @FXML
    private Button SaveButton;



    public int budget = 0;
    public int lastBudget = 0;
    DatebaseHandler dbHandler = new DatebaseHandler();
    String ColumnDB = null;

    public int totalrevenues = 0;
    public int totalexpenses = 0;
    int ApartmentsRevenues = 0;
    int ProjectsRevenues = 0;
    int OtherRevenues = 0;

    int SalaryExpenses = 0;
    int MaterialExpenses = 0;
    int OtherExpenses = 0;
    int sum = 0;
    XYChart.Series<String,Integer> ExpensesSalary = new  XYChart.Series<>();
    XYChart.Series<String,Integer> ExpensesMaterial = new  XYChart.Series<>();
    XYChart.Series<String,Integer> ExpensesOther = new  XYChart.Series<>();
    XYChart.Series<String,Integer> Expenses = new  XYChart.Series<>();
    XYChart.Series<String,Integer> Revenues = new  XYChart.Series<>();
    XYChart.Series<String,Integer> RevenuesApartments = new  XYChart.Series<>();
    XYChart.Series<String,Integer> RevenuesProjects = new  XYChart.Series<>();
    XYChart.Series<String,Integer> RevenuesOther = new  XYChart.Series<>();
    XYChart.Series<String,Integer> BudgetJan = new XYChart.Series<>();
    XYChart.Series<String,Integer> BudgetFeb = new XYChart.Series<>();
    XYChart.Series<String,Integer> BudgetMar = new XYChart.Series<>();
    XYChart.Series<String,Integer> BudgetApr = new XYChart.Series<>();
    XYChart.Series<String,Integer> BudgetMay = new XYChart.Series<>();
    XYChart.Series<String,Integer> BudgetJune = new XYChart.Series<>();
    XYChart.Series<String,Integer> BudgetJuly = new XYChart.Series<>();
    XYChart.Series<String,Integer> BudgetAug = new XYChart.Series<>();
    XYChart.Series<String,Integer> BudgetSep = new XYChart.Series<>();
    XYChart.Series<String,Integer> BudgetOkt = new XYChart.Series<>();
    XYChart.Series<String,Integer> BudgetNov = new XYChart.Series<>();
    XYChart.Series<String,Integer> BudgetDec = new XYChart.Series<>();

    ObservableList<String> ProjectsNameComboBox = FXCollections.observableArrayList();
    ObservableList<String> MaterialsTableComboBox = FXCollections.observableArrayList("Stock of materials", "Status materials");
    ObservableList<String> DistrictBox = FXCollections.observableArrayList("Pervomaiskiy","Leninskiy","Oktyabrskiy","Sverdlovskiy");
    ObservableList<String> UserLogin = FXCollections.observableArrayList();
    ObservableList<String> PositionBox = FXCollections.observableArrayList("Director","Builder","Hr","Accountant","Sales Departament");

    @FXML
    void initialize() {
        ChoiceTableBox.setItems(MaterialsTableComboBox);
        StartProjectDistrictBox.setItems(DistrictBox);
        EditUserPosition.setItems(PositionBox);

        try {
            ObProjectsName();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ObUsersLogin();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ProjectsTable.refresh();
        Image();
        LabelUserName.setText(LoginController.name);
        LabelAccountType.setText(LoginController.type_account);

        try {
            PercentageRevAndExpen();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            BudgetInfo();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Budget();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        GeneralInfo();
        ExpensesInfo();
        RevenuesInfo();

        BudgetInfoButton.setOnAction(actionEvent -> {
            ExpensesChart.setVisible(false);
            GeneralChart.setVisible(false);
            RevenuesChart.setVisible(false);
            BudgetChart.setVisible(true);
            WithdrawMoneyField.setVisible(false);
            WithdrawMoneyOKButton.setVisible(false);
            NotEnoughBalanceText1.setVisible(false);
        });

        ShowProjectsButton.setOnAction(actionEvent -> {
            if(AnchorPaneShowProjects.visibleProperty().get() == false){
                AnchorPaneShowBudget.setVisible(false);
                AnchorPaneEditProjects.setVisible(false);
                AnchorPaneFinishProjects.setVisible(false);
                AnchorPaneShowMaterials.setVisible(false);
                AnchorPaneShowProjects.setVisible(true);
                AnchorPaneStartTheProject.setVisible(false);
                AnchorPaneAllUsers.setVisible(false);
                AnchorPaneEditUser.setVisible(false);
            }else{
                AnchorPaneShowProjects.setVisible(false);
            }

            try {
                ShowProjects();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        EditSaveButton.setOnAction(actionEvent -> {

            try {
                SaveEdited();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            EditBudgetField.clear();EditNameField.clear();EditApartmentsField.clear();EditDistrictField.clear();EditDescriptionArea.clear();
        });

        FinishSaveButton.setOnAction(actionEvent -> {
            try {
                SaveFinished();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            FinishNameField.clear();
            FinishDistrictField.clear();
            FinishApartmentsField.clear();
            FinishBudgetField.clear();
            FinishDescriptionArea.clear();

        });

        ShowBudgetButton.setOnAction(actionEvent -> {
            if(AnchorPaneShowBudget.visibleProperty().get() == false){
                AnchorPaneShowBudget.setVisible(true);
                AnchorPaneEditProjects.setVisible(false);
                AnchorPaneFinishProjects.setVisible(false);
                AnchorPaneShowMaterials.setVisible(false);
                AnchorPaneShowProjects.setVisible(false);
                AnchorPaneStartTheProject.setVisible(false);
                AnchorPaneAllUsers.setVisible(false);
            }else{
                AnchorPaneShowBudget.setVisible(false);
            }
        });

        ExpensesInfoButton.setOnAction(actionEvent -> {
            RevenuesChart.setVisible(false);
            GeneralChart.setVisible(false);
            ExpensesChart.setVisible(true);
            BudgetChart.setVisible(false);
            WithdrawMoneyField.setVisible(false);
            WithdrawMoneyOKButton.setVisible(false);
            NotEnoughBalanceText1.setVisible(false);
        });

        RevenuesInfoButton.setOnAction(actionEvent -> {
            ExpensesChart.setVisible(false);
            GeneralChart.setVisible(false);
            RevenuesChart.setVisible(true);
            BudgetChart.setVisible(false);
            WithdrawMoneyField.setVisible(false);
            WithdrawMoneyOKButton.setVisible(false);
            NotEnoughBalanceText1.setVisible(false);
        });
        WithdrawMoneyButton.setOnAction(actionEvent -> {
            ExpensesChart.setVisible(false);
            GeneralChart.setVisible(false);
            RevenuesChart.setVisible(false);
            BudgetChart.setVisible(false);
            WithdrawMoneyField.setVisible(true);
            WithdrawMoneyOKButton.setVisible(true);
        });

        GeneralInfoButton.setOnAction(actionEvent -> {
            RevenuesChart.setVisible(false);
            ExpensesChart.setVisible(false);
            GeneralChart.setVisible(true);
            BudgetChart.setVisible(false);
            WithdrawMoneyField.setVisible(false);
            WithdrawMoneyOKButton.setVisible(false);
            NotEnoughBalanceText1.setVisible(false);
        });

        WithdrawMoneyOKButton.setOnAction(actionEvent -> {
            try {
                WithdrawMoney();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            WithdrawMoneyField.clear();
        });
        ProjectsEditButton.setOnAction(actionEvent -> {
            if(AnchorPaneEditProjects.visibleProperty().get() == false){
                AnchorPaneShowBudget.setVisible(false);
                AnchorPaneEditProjects.setVisible(true);
                AnchorPaneFinishProjects.setVisible(false);
                AnchorPaneShowMaterials.setVisible(false);
                AnchorPaneShowProjects.setVisible(false);
                AnchorPaneStartTheProject.setVisible(false);
                AnchorPaneAllUsers.setVisible(false);
                AnchorPaneEditUser.setVisible(false);
            }else{
                AnchorPaneEditProjects.setVisible(false);
            }
            try {
                EditProjects();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        ProjectsFinishButton.setOnAction(actionEvent -> {
            if(AnchorPaneFinishProjects.visibleProperty().get() == false){
                AnchorPaneShowBudget.setVisible(false);
                AnchorPaneEditProjects.setVisible(false);
                AnchorPaneFinishProjects.setVisible(true);
                AnchorPaneShowMaterials.setVisible(false);
                AnchorPaneShowProjects.setVisible(false);
                AnchorPaneStartTheProject.setVisible(false);
                AnchorPaneAllUsers.setVisible(false);
                AnchorPaneEditUser.setVisible(false);
            }else{
                AnchorPaneFinishProjects.setVisible(false);
            }
            try {
                FinishProjects();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

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

        ShowMaterialsButton.setOnAction(actionEvent -> {
            if(AnchorPaneShowMaterials.visibleProperty().get() == false){
                AnchorPaneShowBudget.setVisible(false);
                AnchorPaneEditProjects.setVisible(false);
                AnchorPaneFinishProjects.setVisible(false);
                AnchorPaneShowMaterials.setVisible(true);
                AnchorPaneShowProjects.setVisible(false);
                AnchorPaneStartTheProject.setVisible(false);
                AnchorPaneAllUsers.setVisible(false);
                AnchorPaneEditUser.setVisible(false);
            }else{
                AnchorPaneShowMaterials.setVisible(false);
            }

        });
        ChoiceTableBox.setOnAction(actionEvent -> {
            try {
                ShowMaterials();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        StartButton.setOnAction(actionEvent -> {
            try {
                StartProjects();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            StartProjectName.clear();StartProjectLuxury.clear();StartProjectLuxuryPrice.clear();StartProjectBusiness.clear();StartProjectBusinessPrice.clear();StartProjectBudget.clear();StartProjectEconomyPrice.clear();StartProjectEconomy.clear();StartProjectDescription.clear();
        });

        StartTheProjectButton.setOnAction(actionEvent -> {
            if(AnchorPaneStartTheProject.visibleProperty().get() == false){
                AnchorPaneShowBudget.setVisible(false);
                AnchorPaneEditProjects.setVisible(false);
                AnchorPaneFinishProjects.setVisible(false);
                AnchorPaneShowMaterials.setVisible(false);
                AnchorPaneShowProjects.setVisible(false);
                AnchorPaneStartTheProject.setVisible(true);
                AnchorPaneAllUsers.setVisible(false);
                AnchorPaneEditUser.setVisible(false);
            }else{
                AnchorPaneStartTheProject.setVisible(false);
            }
        });

        AllUsersButton.setOnAction(actionEvent -> {
            if(AnchorPaneAllUsers.visibleProperty().get() == false){
                AnchorPaneShowBudget.setVisible(false);
                AnchorPaneEditProjects.setVisible(false);
                AnchorPaneFinishProjects.setVisible(false);
                AnchorPaneShowMaterials.setVisible(false);
                AnchorPaneShowProjects.setVisible(false);
                AnchorPaneStartTheProject.setVisible(false);
                AnchorPaneAllUsers.setVisible(true);
                AnchorPaneEditUser.setVisible(false);
            }else{
                AnchorPaneAllUsers.setVisible(false);
            }

            try {
                AllUsers();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        UsersEditButton.setOnAction(actionEvent -> {
            if(AnchorPaneEditUser.visibleProperty().get() == false){
                AnchorPaneShowBudget.setVisible(false);
                AnchorPaneEditProjects.setVisible(false);
                AnchorPaneFinishProjects.setVisible(false);
                AnchorPaneShowMaterials.setVisible(false);
                AnchorPaneShowProjects.setVisible(false);
                AnchorPaneStartTheProject.setVisible(false);
                AnchorPaneAllUsers.setVisible(false);
                AnchorPaneEditUser.setVisible(true);
            }else{
                AnchorPaneEditUser.setVisible(false);
            }

            try {
                EditUser();
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

            AnchorPaneEditUser.setVisible(false);
            AnchorPaneAllUsers.setVisible(true);
        });

        UsersRemoveButton.setOnAction(actionEvent -> {
            try {
                RemoveUsers();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void Image() {
        Image im = new Image(LoginController.image);
        image.setImage(im);
    }

    public void Budget() throws SQLException, ClassNotFoundException {
        int MonthNow = Calendar.getInstance().get(Calendar.MONTH)+1;
        switch (MonthNow) {
            case 1:
                ColumnDB = "budgetJan";
                break;
            case 2:
                ColumnDB = "budgetFeb";
                break;
            case 3:
                ColumnDB = "budgetMar";
                break;
            case 4:
                ColumnDB = "budgetApr";
                break;
            case 5:
                ColumnDB = "budgetMay";
                break;
            case 6:
                ColumnDB = "budgetJune";
                break;
            case 7:
                ColumnDB = "budgetJuly";
                break;
            case 8:
                ColumnDB = "budgetAug";
                break;
            case 9:
                ColumnDB = "budgetSep";
                break;
            case 10:
                ColumnDB = "budgetOkt";
                break;
            case 11:
                ColumnDB = "budgetNov";
                break;
            case 12:
                ColumnDB = "budgetDec";
                break;
        }

        int LastMonth = Calendar.getInstance().get(Calendar.MONTH);
        if(LastMonth==1){
            LastMonth = 12;}
        String ColumnDBLast = null;
        switch (LastMonth) {
            case 1:
                ColumnDBLast = "budgetJan";
                break;
            case 2:
                ColumnDBLast = "budgetFeb";
                break;
            case 3:
                ColumnDBLast = "budgetMar";
                break;
            case 4:
                ColumnDBLast = "budgetApr";
                break;
            case 5:
                ColumnDBLast = "budgetMay";
                break;
            case 6:
                ColumnDBLast = "budgetJune";
                break;
            case 7:
                ColumnDBLast = "budgetJuly";
                break;
            case 8:
                ColumnDBLast = "budgetAug";
                break;
            case 9:
                ColumnDBLast = "budgetSep";
                break;
            case 10:
                ColumnDBLast = "budgetOkt";
                break;
            case 11:
                ColumnDBLast = "budgetNov";
                break;
            case 12:
                ColumnDBLast = "budgetDec";
                break;
        }

        int totalexpenses = 0;
        int totalrevenues = 0;
        ResultSet result = dbHandler.Budget();
        while (result.next()) {
            budget = result.getInt(ColumnDB);
            lastBudget = result.getInt(ColumnDBLast);
        }
        result = dbHandler.Expenses();
        while (result.next()) {
            totalexpenses = result.getInt("total");
        }
        result = dbHandler.Revenues();
        while (result.next()) {
            totalrevenues = result.getInt("Total");
        }

        budget = lastBudget + (totalrevenues - totalexpenses);
        String updateBudget = "UPDATE `important` SET `" + ColumnDB + "`  = '" + budget + "'";
        PreparedStatement prStBudget = dbHandler.getDbConnection().prepareStatement(updateBudget);
        prStBudget.executeUpdate();


    }
    private void PercentageRevAndExpen() throws SQLException, ClassNotFoundException {

        ResultSet result = dbHandler.Revenues();
        while (result.next()){
            ApartmentsRevenues = result.getInt("Apartment");
            ProjectsRevenues = result.getInt("Projects");
            OtherRevenues = result.getInt("Other");
            totalrevenues = result.getInt("Apartment") + result.getInt("Projects") + result.getInt("Other");
        }

        result = dbHandler.Expenses();
        while (result.next()){
            SalaryExpenses = result.getInt("salary");
            MaterialExpenses = result.getInt("materials");
            OtherExpenses = result.getInt("Other");
            totalexpenses = result.getInt("salary") + result.getInt("materials") + result.getInt("Other");
        }


        result = dbHandler.SumExpenses();
        while (result.next()){
            sum = result.getInt(1);
        }

        String updateSalaryExpenses = "UPDATE `expenses` SET salary = '" + sum + "'  WHERE `idexpenses` = '" + 1 + "'";
        PreparedStatement prStExSal = dbHandler.getDbConnection().prepareStatement(updateSalaryExpenses);
        prStExSal.executeUpdate();

        result = dbHandler.SumMaterialsPrice();
        while (result.next()){
            sum = result.getInt(1);
        }

        String updateMaterialsExpenses = "UPDATE `expenses` SET materials = '" + sum + "' WHERE `idexpenses` = '" + 1 + "'" ;
        PreparedStatement prStExMat = dbHandler.getDbConnection().prepareStatement(updateMaterialsExpenses);
        prStExMat.executeUpdate();

        String update = "UPDATE `revenues` SET Total = '" + totalrevenues + "'";
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(update);
        prSt.executeUpdate();

        String updateExpenses = "UPDATE `expenses` SET total = '" + totalexpenses + "' WHERE idexpenses = '" + 1 + "'";
        PreparedStatement prStEx = dbHandler.getDbConnection().prepareStatement(updateExpenses);
        prStEx.executeUpdate();

    }
    public void GeneralInfo(){

        Revenues.setName("Revenues");

        Revenues.getData().add(new XYChart.Data<>("Revenues",totalrevenues));

        Expenses.setName("Expenses");

        Expenses.getData().add(new XYChart.Data<>("Expenses",totalexpenses));

        GeneralChart.getData().addAll(Revenues,Expenses);
    }
    public void RevenuesInfo(){

        RevenuesChart.setTitle("Revenues");

        RevenuesApartments.setName("Apartments");
        RevenuesProjects.setName("Projects");
        RevenuesOther.setName("Other");

        RevenuesApartments.getData().add(new XYChart.Data<>("Apartment",ApartmentsRevenues));
        RevenuesProjects.getData().add(new XYChart.Data<>("Projects",ProjectsRevenues));
        RevenuesOther.getData().add(new XYChart.Data<>("Other",OtherRevenues));

        RevenuesChart.getData().addAll(RevenuesApartments,RevenuesProjects,RevenuesOther);


    }
    public void ExpensesInfo(){

        ExpensesChart.setTitle("Expenses");
        ExpensesSalary.setName("Salary");
        ExpensesMaterial.setName("Material");
        ExpensesOther.setName("Other");
        ExpensesSalary.getData().add(new XYChart.Data<>("Salary",SalaryExpenses));
        ExpensesMaterial.getData().add(new XYChart.Data<>("Material",MaterialExpenses));
        ExpensesOther.getData().add(new XYChart.Data<>("Other",OtherExpenses));
        ExpensesChart.getData().addAll(ExpensesSalary,ExpensesMaterial,ExpensesOther);

    }
    public void BudgetInfo() throws SQLException, ClassNotFoundException {
        ResultSet result = dbHandler.Budget();
        while (result.next()) {
            BudgetJan.setName("January");
            BudgetFeb.setName("February");
            BudgetMar.setName("March");
            BudgetApr.setName("April");
            BudgetMay.setName("May");
            BudgetJune.setName("June");
            BudgetJuly.setName("July");
            BudgetAug.setName("August");
            BudgetSep.setName("September");
            BudgetOkt.setName("October");
            BudgetNov.setName("November");
            BudgetDec.setName("December");
            BudgetJan.getData().add(new XYChart.Data<>("January", result.getInt("budgetJan")));
            BudgetFeb.getData().add(new XYChart.Data<>("February",result.getInt("budgetFeb")));
            BudgetMar.getData().add(new XYChart.Data<>("March",result.getInt("budgetMar")));
            BudgetApr.getData().add(new XYChart.Data<>( "April",result.getInt("budgetApr")));
            BudgetMay.getData().add(new XYChart.Data<>("May",result.getInt("budgetMay")));
            BudgetJune.getData().add(new XYChart.Data<>("June",result.getInt("budgetJune")));
            BudgetJuly.getData().add(new XYChart.Data<>("July",result.getInt("budgetJuly")));
            BudgetAug.getData().add(new XYChart.Data<>("August",result.getInt("budgetAug")));
            BudgetSep.getData().add(new XYChart.Data<>("September",result.getInt("budgetSep")));
            BudgetOkt.getData().add(new XYChart.Data<>("October",result.getInt("budgetOkt")));
            BudgetNov.getData().add(new XYChart.Data<>("November",result.getInt("budgetNov")));
            BudgetDec.getData().add(new XYChart.Data<>("December",result.getInt("budgetDec")));
            BudgetChart.getData().addAll(BudgetJan,BudgetFeb,BudgetMar,BudgetApr,BudgetMay,BudgetJune,BudgetJuly,BudgetAug,BudgetSep,BudgetOkt,BudgetNov,BudgetDec);

        }
    }
    public void WithdrawMoney() throws SQLException, ClassNotFoundException {
        int Money = Integer.parseInt(WithdrawMoneyField.getText());
        int NewBudjet = budget - Money;
        if (NewBudjet < 0) {
            NotEnoughBalanceText1.setVisible(true);
        } else {
            NotEnoughBalanceText1.setVisible(false);
            String update = "UPDATE `important` SET `" + ColumnDB + "` = '" + NewBudjet + "'";
            PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(update);
            prSt.executeUpdate();
        }
    }

    public void ShowProjects() throws SQLException, ClassNotFoundException {
        ObservableList<ProjectsTable> ProjectsComboBox = FXCollections.observableArrayList();
        ResultSet result = dbHandler.ProjectsTable();
        while (result.next()){
            ProjectsComboBox.add(new ProjectsTable(result.getString("ProjectsName"),result.getInt("Status"),
                    result.getString("District"),result.getInt("Apartments"),result.getInt("Budget"),result.getString("Time"),result.getString("Description")));
        }
        ProjectsName.setCellValueFactory(new PropertyValueFactory<>("ProjectsName"));
        ProjectsDistrict.setCellValueFactory(new PropertyValueFactory<>("ProjectsDistrict"));
        ProjectsBudget.setCellValueFactory(new PropertyValueFactory<>("ProjectsBudget"));
        ProjectsStatus.setCellValueFactory(new PropertyValueFactory<>("ProjectsStatus"));
        ProjectsApartments.setCellValueFactory(new PropertyValueFactory<>("ProjectsApartment"));
        ProjectsTime.setCellValueFactory(new PropertyValueFactory<>("ProjectsTime"));

        FilteredList<ProjectsTable> Filtered = new FilteredList<>(ProjectsComboBox, b -> true);
        ProjectsSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            Filtered.setPredicate(projectsTable -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (projectsTable.getProjectsName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (projectsTable.getProjectsTime().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (projectsTable.getProjectsDistrict().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(projectsTable.getProjectsStatus()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(projectsTable.getProjectsBudget()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                }else if (String.valueOf(projectsTable.getProjectsApartment()).indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;

            });
        });
        SortedList<ProjectsTable> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(ProjectsTable.comparatorProperty());
        ProjectsTable.setItems(sortedList);
    }
    public void ObProjectsName() throws SQLException, ClassNotFoundException {
        ResultSet result = dbHandler.ProjectsTable();
        while (result.next()){
            ProjectsNameComboBox.add(result.getString("ProjectsName"));
        }
        ProjectsFinishComboBox.setItems(ProjectsNameComboBox);
        ProjectsEditComboBox.setItems(ProjectsNameComboBox);
    }
    public void EditProjects() throws SQLException, ClassNotFoundException {
        ResultSet result = dbHandler.ProjectsWithName(ProjectsEditComboBox.getValue());
        while (result.next()){
            EditNameField.setText(result.getString("ProjectsName"));
            EditDistrictField.setText(result.getString("District"));
            EditApartmentsField.setText(String.valueOf(result.getInt("Apartments")));
            EditBudgetField.setText(String.valueOf(result.getInt("Budget")));
            EditDescriptionArea.setText(result.getString("Description"));
        }
    }
    public void SaveEdited() throws SQLException, ClassNotFoundException {

        String update = "UPDATE `projects` SET `ProjectsName` = '" +  EditNameField.getText() + "' , `District` = '" + EditDistrictField.getText() +
                "' , `Apartments` = '" + Integer.parseInt(EditApartmentsField.getText()) + "' , `Budget` = '" + Integer.parseInt(EditBudgetField.getText()) +
                "' , `Description` = '" + EditDescriptionArea.getText() + "' WHERE `ProjectsName` = '" +EditNameField.getText() + "'" ;
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
    }

    public void FinishProjects() throws SQLException, ClassNotFoundException {
        ResultSet result = dbHandler.ProjectsWithName(ProjectsFinishComboBox.getValue());
        while (result.next()) {
            if (result.getInt("Status") > 90) {
                FinishNameField.setText(result.getString("ProjectsName"));
                FinishDistrictField.setText(result.getString("District"));
                FinishApartmentsField.setText(String.valueOf(result.getInt("Apartments")));
                FinishBudgetField.setText(String.valueOf(result.getInt("Budget")));
                FinishDescriptionArea.setText(result.getString("Description"));
                TextForProjects.setVisible(false);
            }else{
                AnchorPaneShowProjects.setVisible(true);
                AnchorPaneFinishProjects.setVisible(false);
                TextForProjects.setVisible(true);
                TextForProjects.setText("You cannot complete the project ! Status - " + result.getInt("Status"));
            }
        }
    }
    public void SaveFinished() throws SQLException, ClassNotFoundException {
        int Full = 100;
        String update = "UPDATE `projects` SET `ProjectsName` = '" +  FinishNameField.getText() + "' , `District` = '" + FinishDistrictField.getText() +
                "' , `Apartments` = '" + Integer.parseInt(FinishApartmentsField.getText()) + "' , `Budget` = '" + Integer.parseInt(FinishBudgetField.getText()) +
                "' , `Description` = '" + FinishDescriptionArea.getText() + "' , `Status` = " + Full + " , `Time` = '" + LocalDate.now(ZoneId.of("Europe/Paris"))  + "'   WHERE `ProjectsName` = '" +FinishNameField.getText() + "'" ;
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
    }

    public void ShowMaterials() throws SQLException, ClassNotFoundException {
        if(ChoiceTableBox.getValue().equals("Stock of materials")){
            StockMaterialsTable.setVisible(true);
            StatusMaterialsTable.setVisible(false);
            ObservableList<StockOfMaterials> StockMaterials = FXCollections.observableArrayList();
            ResultSet result = dbHandler.Stockofmaterials();
            while (result.next()){
                StockMaterials.add(new StockOfMaterials(result.getString("Materials"),result.getInt("Amount"),result.getString("Unit")));
            }
            StockMaterialsName.setCellValueFactory(new PropertyValueFactory<>("MatName"));
            StockMaterialsQuantity.setCellValueFactory(new PropertyValueFactory<>("Amount"));
            FilteredList<StockOfMaterials> Filtered = new FilteredList<>(StockMaterials, b -> true);
            StatusMaterialsSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
                Filtered.setPredicate(stockOfMaterials -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (stockOfMaterials.getMatName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (stockOfMaterials.getUnit().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (String.valueOf(stockOfMaterials.getAmount()).indexOf(lowerCaseFilter) != -1)
                        return true;
                    else
                        return false;
                });
            });
            SortedList<StockOfMaterials> sortedList = new SortedList<>(Filtered);
            sortedList.comparatorProperty().bind(StockMaterialsTable.comparatorProperty());
            StockMaterialsTable.setItems(sortedList);
        }else {
            StockMaterialsTable.setVisible(false);
            StatusMaterialsTable.setVisible(true);
            ResultSet result = dbHandler.Companymaterials();
            ObservableList<StatusMaterials> StatusMat = FXCollections.observableArrayList();
            while(result.next()){
                    StatusMat.add(new StatusMaterials(result.getInt("idcompanyMaterials"),
                            result.getString("Supplier name"), result.getString("NameMaterials"),
                            result.getInt("Amount"), result.getInt("Price"),
                            result.getString("unit of measurement"), result.getString("Status")));
                }
            StatusMaterialsSupplierName.setCellValueFactory(new PropertyValueFactory<>("SupplierName"));
            StatusMaterialsName.setCellValueFactory(new PropertyValueFactory<>("MaterialsName"));
            StatusMaterialsQuantity.setCellValueFactory(new PropertyValueFactory<>("Amount"));
            StatusMaterialsPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
            StatusMaterialsStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
            FilteredList<StatusMaterials> Filtered = new FilteredList<>(StatusMat, b -> true);
            StatusMaterialsSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
                Filtered.setPredicate(statusMaterials -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (statusMaterials.getSupplierName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (statusMaterials.getMaterialsName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (statusMaterials.getUnit().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (String.valueOf(statusMaterials.getAmount()).indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (String.valueOf(statusMaterials.getPrice()).indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (statusMaterials.getStatus().indexOf(lowerCaseFilter) != -1){
                        return true;
                    }else if (String.valueOf(statusMaterials.getId()).indexOf(lowerCaseFilter) != -1)
                        return true;
                    else
                        return false;

                });
            });
            SortedList<StatusMaterials> sortedList = new SortedList<>(Filtered);
            sortedList.comparatorProperty().bind(StatusMaterialsTable.comparatorProperty());
            StatusMaterialsTable.setItems(sortedList);

        }
    }

    public void StartProjects() throws SQLException, ClassNotFoundException {
        int SumApartments = Integer.parseInt(StartProjectLuxury.getText()) +Integer.parseInt(StartProjectBusiness.getText()) + Integer.parseInt(StartProjectEconomy.getText());
        com.example.ain_stroy.ProjectsTable projectsTable = new ProjectsTable(StartProjectName.getText(),0,StartProjectDistrictBox.getValue(),SumApartments,
                Integer.parseInt(StartProjectBudget.getText()),String.valueOf(CompletionDatePicker.getValue()),StartProjectDescription.getText());
        dbHandler.InsertNewProjects(projectsTable);

        Apartments apartments = new Apartments(StartProjectName.getText(),Integer.parseInt(StartProjectLuxury.getText()),
                Integer.parseInt(StartProjectBusiness.getText()),Integer.parseInt(StartProjectEconomy.getText()),
                Integer.parseInt(StartProjectLuxuryPrice.getText()),Integer.parseInt(StartProjectBusinessPrice.getText()),
                Integer.parseInt(StartProjectEconomyPrice.getText()),0,0,"Unfinished");
        dbHandler.InsertApartmentsForSale(apartments);
    }

    public void AllUsers() throws SQLException, ClassNotFoundException {
        ObservableList<User> AllUsersObList = FXCollections.observableArrayList();
        ResultSet result = dbHandler.PersonnelChange();
        while (result.next()) {
            if (!result.getString("type_account").equals("Supplier")) {
                AllUsersObList.add(new User(result.getString("firstname"), result.getString("lastname"), result.getString("user_login"),
                        result.getString("user_password"), result.getString("type_account"), result.getInt("salary"), result.getString("email")));
            }else {
                continue;
            }
        }
        UsersFirstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        UsersLastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        UsersLogin.setCellValueFactory(new PropertyValueFactory<>("user_login"));
        UsersPassword.setCellValueFactory(new PropertyValueFactory<>("user_password"));
        UsersAccount.setCellValueFactory(new PropertyValueFactory<>("type_account"));
        UsersSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        UsersEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        FilteredList<User> Filtered = new FilteredList<>(AllUsersObList, b -> true);
        UsersSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
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
                } else if (user.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }else if (String.valueOf(user.getSalary()).indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;

            });
        });
        SortedList<User> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(UsersTable.comparatorProperty());
        UsersTable.setItems(sortedList);
    }
    public void ObUsersLogin() throws SQLException, ClassNotFoundException {
        ResultSet result = dbHandler.PersonnelChange();
        while (result.next()) {
            if (!result.getString("type_account").equals("Supplier")) {
                UserLogin.add(result.getString("user_login"));
            }else {
                continue;
            }
        }
        UsersEditBox.setItems(UserLogin);
        UsersRemoveBox.setItems(UserLogin);
    }

    public void EditUser() throws SQLException, ClassNotFoundException {
        ResultSet result = dbHandler.UsersWithLogin(UsersEditBox.getValue());
        while(result.next()){
            EditUserName.setText(result.getString("firstname"));
            EditUserLastname.setText(result.getString("lastname"));
            EditUserLogin.setText(result.getString("user_login"));
            EditUserPassword.setText(result.getString("user_password"));
            EditUserEmail.setText(result.getString("email"));
            EditUserSalary.setText(String.valueOf(result.getInt("salary")));
        }
    }
    public void UpdateUsers() throws SQLException, ClassNotFoundException {
        String update = "UPDATE `users` SET `firstname` = '" + EditUserName.getText() + "' , `lastname` = '" + EditUserLastname.getText() + "' , " +
                " `user_login` = '" +  EditUserLogin.getText() + "' , `user_password` = '" + EditUserPassword.getText() + "' , `salary` = '" +
                Integer.parseInt(EditUserSalary.getText()) + "' , `type_account` = '" + EditUserPosition.getValue() + "' WHERE user_login = '" + UsersEditBox.getValue() + "'";
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
        AllUsers();
    }

    public void RemoveUsers() throws SQLException, ClassNotFoundException {
        dbHandler.RemoveUsersByLogin(UsersRemoveBox.getValue());
        AllUsers();
    }
}

