package com.example.ain_stroy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Accountant {

    @FXML
    private AnchorPane AnchorPanePaymentOfWages;

    @FXML
    private TableColumn<User, String> ColumnFirstname;

    @FXML
    private TableColumn<User,String> ColumnLastName;

    @FXML
    private TableColumn<User, Integer> ColumnSalary;

    @FXML
    private ComboBox<String> NameEmployee;

    @FXML
    private Button PayButton;

    @FXML
    private TableView<User> WagesTable;


    @FXML
    private Button AboutTheProgram;

    @FXML
    private AnchorPane AnchorPaneVacation;

    @FXML
    private Button EditAccount;

    @FXML
    private Button Exit;

    @FXML
    private StackedBarChart<String, Integer> ExpensesChart;

    @FXML
    private Button ExpensesInfoButton;

    @FXML
    private DatePicker FromDays;
    @FXML
    private TextFlow AboutTheProgrammText;

    @FXML
    private AnchorPane AboutTheProgramPane;

    @FXML
    private StackedBarChart<String, Integer> GeneralChart;

    @FXML
    private Button GeneralInfoButton;

    @FXML
    private Button GiveOutBonuses;

    @FXML
    private Label LabelAccountType;

    @FXML
    private Label LabelUserName;

    @FXML
    private DatePicker LastVacation;

    @FXML
    private Button PayForMaterialButton;

    @FXML
    private Button PaymentOfWagesButton;

    @FXML
    private ImageView ProfileImage;

    @FXML
    private TextArea ReasonText;

    @FXML
    private AnchorPane RevenuesAndExpenses;

    @FXML
    private StackedBarChart<String, Integer> RevenuesChart;
    @FXML
    private Button RevenuesInfoButton;

    @FXML
    private Button RevenuesandExpensesButton;

    @FXML
    private Button SendButton;

    @FXML
    private DatePicker Todays;

    @FXML
    private Button Vacation;

    @FXML
    private AnchorPane AnchorPanePayForMaterials;

    @FXML
    private TableView<StatusMaterials> PayForMaterialTable;

    @FXML
    private TableColumn<StatusMaterials, String> UOMColumn;

    @FXML
    private TableColumn<StatusMaterials, String> StatusColumn;

    @FXML
    private TextField SalarSearchField;

    @FXML
    private TableColumn<StatusMaterials, Integer> PriceColumn;

    @FXML
    private TableColumn<StatusMaterials, String> NameColumn;

    @FXML
    private TableColumn<StatusMaterials, String> MaterialColumn;

    @FXML
    private TableColumn<StatusMaterials, Integer> AmountColumn;

    @FXML
    private TextField MaterialIfField;

    @FXML
    private TextField MaterialSearchField;

    @FXML
    private TableColumn<StatusMaterials, Integer> IdMaterials;

    @FXML
    private Button BudgetInfoButton;

    @FXML
    private StackedBarChart<String, Integer> BudgetChart;

    @FXML
    private Button ConfirmButton;


    DatebaseHandler dbHandler = new DatebaseHandler();
    DirectorMenu directorMenu = new DirectorMenu();
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

    String  SupplierName = null;
    String MaterialsName = null;
    int Amount = 0;
    int Price = 0;
    String UOM = null;






    @FXML
    void initialize() {
        try {
            PercentageRevAndExpen();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            directorMenu.Budget();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        GeneralInfo();
        ExpensesInfo();
        RevenuesInfo();
        try {
            BudgetInfo();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        LabelUserName.setText(LoginController.name);
        LabelAccountType.setText(LoginController.type_account);

        GeneralInfoButton.setOnAction(actionEvent -> {
            RevenuesChart.setVisible(false);
            ExpensesChart.setVisible(false);
            GeneralChart.setVisible(true);
            BudgetChart.setVisible(false);
        });
        PayButton.setOnAction(actionEvent -> {
            SuccessfullyDialog();


        });

        PaymentOfWagesButton.setOnAction(actionEvent -> {
            try {
                UsersSalaries();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if(AnchorPanePaymentOfWages.visibleProperty().get() == false){
                RevenuesAndExpenses.setVisible(false);
                AnchorPaneVacation.setVisible(false);
                AnchorPanePayForMaterials.setVisible(false);
                AnchorPanePaymentOfWages.setVisible(true);
                AboutTheProgramPane.setVisible(false);
            }else{
                AnchorPanePaymentOfWages.setVisible(false);
            }
        });

        BudgetInfoButton.setOnAction(actionEvent -> {
            ExpensesChart.setVisible(false);
            GeneralChart.setVisible(false);
            RevenuesChart.setVisible(false);
            BudgetChart.setVisible(true);
        });

        RevenuesandExpensesButton.setOnAction(actionEvent -> {
            if(RevenuesAndExpenses.visibleProperty().get() == false){
                RevenuesAndExpenses.setVisible(true);
                AnchorPaneVacation.setVisible(false);
                AboutTheProgramPane.setVisible(false);
                AnchorPanePayForMaterials.setVisible(false);
                AnchorPanePaymentOfWages.setVisible(false);
            }else{
                RevenuesAndExpenses.setVisible(false);
            }
        });

        ExpensesInfoButton.setOnAction(actionEvent -> {
            RevenuesChart.setVisible(false);
            GeneralChart.setVisible(false);
            ExpensesChart.setVisible(true);
            BudgetChart.setVisible(false);
        });

        RevenuesInfoButton.setOnAction(actionEvent -> {
            ExpensesChart.setVisible(false);
            GeneralChart.setVisible(false);
            RevenuesChart.setVisible(true);
            BudgetChart.setVisible(false);
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

            if (AnchorPaneVacation.visibleProperty().get() == false) {
                RevenuesAndExpenses.setVisible(false);
                AboutTheProgramPane.setVisible(false);
                AnchorPaneVacation.setVisible(true);
                AnchorPanePayForMaterials.setVisible(false);
                AnchorPanePaymentOfWages.setVisible(false);

            } else {
                AnchorPaneVacation.setVisible(false);
            }
        });
        SendButton.setOnAction(actionEvent -> {
            try {
                PermissionVacation();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        PayForMaterialButton.setOnAction(actionEvent -> {
            try {
                PayForMaterial();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            if(AnchorPanePayForMaterials.visibleProperty().get() == false){
                RevenuesAndExpenses.setVisible(false);
                AnchorPaneVacation.setVisible(false);
                AboutTheProgramPane.setVisible(false);
                AnchorPanePayForMaterials.setVisible(true);
                AnchorPanePaymentOfWages.setVisible(false);
            }else {
                AnchorPanePayForMaterials.setVisible(false);
            }
        });

        ConfirmButton.setOnAction(actionEvent -> {
            try {
                ChangeStatus();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        AboutTheProgram.setOnAction(actionEvent -> {
            if(AboutTheProgramPane.visibleProperty().get() == false){
                RevenuesAndExpenses.setVisible(false);
                AnchorPaneVacation.setVisible(false);
                AboutTheProgramPane.setVisible(true);
                AnchorPanePayForMaterials.setVisible(false);
                AnchorPanePaymentOfWages.setVisible(false);
            }else {
                AboutTheProgramPane.setVisible(false);
            }
        });

    }

    public void PermissionVacation() throws SQLException, ClassNotFoundException {
        String Name = LoginController.name + " " + LoginController.lastname;
        long difference = java.sql.Date.valueOf(Todays.getValue()).getTime() - java.sql.Date.valueOf(FromDays.getValue()).getTime();
        int days = (int) (difference / (24 * 60 * 60 * 1000));
        String LastVacations = String.valueOf(LastVacation.getValue());
        int PaidVacation = LoginController.Salary / 29 * days;
        String reason = ReasonText.getText();
        DatebaseHandler dbHandler = new DatebaseHandler();
        Vacation vacation = new Vacation(Name, LastVacations, PaidVacation, days, reason);
        System.out.println(days);
        dbHandler.VacationUpdate(vacation);
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

    public void PayForMaterial() throws SQLException, ClassNotFoundException {
        ResultSet result = dbHandler.Companymaterials();
        ObservableList<StatusMaterials> StatusMat = FXCollections.observableArrayList();
        while(result.next()){
            if(result.getString("Status").equals("Waiting")) {
                StatusMat.add(new StatusMaterials(result.getInt("idcompanyMaterials"),
                        result.getString("Supplier name"), result.getString("NameMaterials"),
                        result.getInt("Amount"), result.getInt("Price"),
                        result.getString("unit of measurement"), result.getString("Status")));
            }else {
                continue;
            }
        }
        IdMaterials.setCellValueFactory(new PropertyValueFactory<>("Id"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("SupplierName"));
        MaterialColumn.setCellValueFactory(new PropertyValueFactory<>("MaterialsName"));
        AmountColumn.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        PriceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        UOMColumn.setCellValueFactory(new PropertyValueFactory<>("Unit"));
        StatusColumn.setCellValueFactory(new PropertyValueFactory<>("Status"));
        FilteredList<StatusMaterials> Filtered = new FilteredList<>(StatusMat, b -> true);
        MaterialSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
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
        sortedList.comparatorProperty().bind(PayForMaterialTable.comparatorProperty());
        PayForMaterialTable.setItems(sortedList);
    }

    public void ChangeStatus() throws SQLException, ClassNotFoundException {
        String updateStatus = "UPDATE `companymaterials` SET Status = '" + "Ordered" + "' WHERE idcompanyMaterials = '"+ MaterialIfField.getText() + "'" ;
        PreparedStatement preparedStatement = dbHandler.getDbConnection().prepareStatement(updateStatus);
        preparedStatement.executeUpdate();
        ResultSet result = dbHandler.Companymaterials();
        while (result.next()){
            if(result.getString("status").equals("Ordered")){
                CompanyMaterials companyMaterials = new CompanyMaterials(result.getString("NameMaterials"),result.getInt("Amount"),
                        result.getInt("Price"),result.getString("unit of measurement"),result.getString("Supplier name"));
                dbHandler.InsertMaterialsForBuy(companyMaterials);
            }else if(result.getString("status").equals("Delivered")){
                StockOfMaterials stockOfMaterials = new StockOfMaterials(result.getString("NameMaterials"),result.getInt("Amount"),result.getString("unit of measurement"));
                dbHandler.StockOfMaterials(stockOfMaterials);

            }else{
                continue;
            }
        }
        OrderMaterials();
        String update = "UPDATE `companymaterials` SET status = 'Delivered' WHERE status = 'Ordered' ";
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(update);
        prSt.executeUpdate();

    }
    public void UsersSalaries() throws SQLException, ClassNotFoundException {
        ObservableList<User> dslist = FXCollections.observableArrayList();
        ObservableList<String> NameBox = FXCollections.observableArrayList();
        DatebaseHandler dbHandler = new DatebaseHandler();
        ResultSet result = dbHandler.PersonnelChange();
        ColumnFirstname.setCellValueFactory(new PropertyValueFactory<User, String>("firstname"));
        ColumnLastName.setCellValueFactory(new PropertyValueFactory<User, String>("lastname"));
        ColumnSalary.setCellValueFactory(new PropertyValueFactory<User, Integer>("salary"));
        while (result.next()) {

            if (result.getString("type_account").equals("Supplier")) {
                continue;
            } else {
                NameBox.add(result.getString("firstname") + " " +  result.getString("lastname") );
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
        sortedList.comparatorProperty().bind(WagesTable.comparatorProperty());
        WagesTable.setItems(sortedList);
        NameEmployee.setItems(NameBox);
    }
    public void OrderMaterials() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = dbHandler.OrderMaterialsWithStatus();
        while(resultSet.next()){
            SupplierName = resultSet.getString("Supplier name");
            MaterialsName = resultSet.getString("NameMaterials");
            Amount = resultSet.getInt("Amount");
            Price = resultSet.getInt("Price");
            UOM = resultSet.getString("unit of measurement");

        }
        OrderedMaterials orderedMaterials = new OrderedMaterials(MaterialsName,Amount,Price,UOM,SupplierName);
        dbHandler.OrderMaterials(orderedMaterials);

    }
    public void SuccessfullyDialog() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SuccessfullyDialog.fxml"));
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

}

