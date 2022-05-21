package com.example.ain_stroy;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class BuilderMenu {


    @FXML
    private AnchorPane AnchorPaneVacation;

    @FXML
    private DatePicker FromDays;

    @FXML
    private DatePicker LastVacation;

    @FXML
    private TextArea ReasonText;

    @FXML
    private Button SendButton;

    @FXML
    private DatePicker Todays;

    @FXML
    private Text PriceInStockText;

    @FXML
    private Button ShowPriceButton;

    @FXML
    private TextField MaterialsNameWrite;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AboutTheProgram;

    @FXML
    private TableColumn<CompanyMaterials, Integer> AmountCol;

    @FXML
    private AnchorPane AnchorPaneOrderMaterials;

    @FXML
    private AnchorPane AnchorPaneStockOfMaterials;

    @FXML
    private AnchorPane AnchorProjects;

    @FXML
    private Button EditAccount;

    @FXML
    private Button Exit;

    @FXML
    private Label LabelAccountType;

    @FXML
    private Label LabelUserName;

    @FXML
    private TableColumn<CompanyMaterials, String> MaterialsNameCol;

    @FXML
    private TableColumn<CompanyMaterials, String> NameCol;

    @FXML
    private Button OrderMatButton;

    @FXML
    private TableView<CompanyMaterials> OrderMaterialsTable;

    @FXML
    private Button PercentageProjects;

    @FXML
    private TableColumn<CompanyMaterials, Integer> PriceCol;

    @FXML
    private ImageView ProfileImage;

    @FXML
    private TableColumn<ProjectsTable, String> ProjectsDistrict;

    @FXML
    private TableColumn<ProjectsTable, String> ProjectsName;

    @FXML
    private TableColumn<ProjectsTable, String> ProjectsStatus;

    @FXML
    private TableView<ProjectsTable> ProjectsTable;

    @FXML
    private TextField SearchField;

    @FXML
    private TextField SearchProjects;

    @FXML
    private TableColumn<CompanyMaterials, String> StatusCol;

    @FXML
    private TextField SearchStockOfMat;

    @FXML
    private Button ShowPercentage;

    @FXML
    private AnchorPane AnchorPaneOrderMaterialsNew;

    @FXML
    private Text MaterialNameText;

    @FXML
    private Button OrderButton;

    @FXML
    private Text PriceText;

    @FXML
    private Text QuantityInStockText;

    @FXML
    private TextField QuantityToOrderField;

    @FXML
    private Text SupplierNameText;


    @FXML
    private TableColumn<StockOfMaterials, Integer> StockAmount;

    @FXML
    private TableColumn<StockOfMaterials, String> StockMat;

    @FXML
    private Button StockOfMaterials;

    @FXML
    private TableView<StockOfMaterials> StockTable;

    @FXML
    private TableColumn<StockOfMaterials, String> StockUnit;

    @FXML
    private TableColumn<CompanyMaterials, String> UnitCol;

    @FXML
    private TableColumn<StatusMaterials, Integer> StatusAmount;

    @FXML
    private TableColumn<StatusMaterials, String> StatusMatName;

    @FXML
    private TableColumn<StatusMaterials, Integer> StatusPrice;

    @FXML
    private TextField StatusSearch;

    @FXML
    private TableColumn<StatusMaterials, String> StatusStatus;

    @FXML
    private TableColumn<StatusMaterials, String> StatusSupName;

    @FXML
    private TableView<StatusMaterials> StatusTable;

    @FXML
    private TableColumn<StatusMaterials, String> StatusUnit;

    @FXML
    private AnchorPane AnchorPaneStatusMaterial;

    @FXML
    private Button ShowStatusMaterial;

    @FXML
    private AnchorPane AnchorPaneChanProj;

    @FXML
    private Spinner PercentageSpinner;

    @FXML
    private Button Vacation;

    @FXML
    private TextField ProjectApartField;

    @FXML
    private Text ProjectInfoText;

    @FXML
    private TextField ProjectsDistrictField;

    @FXML
    private TextField ProjectsNameField;

    @FXML
    private Button SaveButton;

    @FXML
    private Button BackButton;


    @FXML
    private TextFlow AboutTheProgrammText;

    @FXML
    private AnchorPane AboutTheProgramPane;


    DatebaseHandler dbHandler = new DatebaseHandler();
    int PriceInStock = 0;
    String Unit = null;
    int Amount = 0;

    @FXML
    void initialize() {
        LabelUserName.setText(LoginController.name);
        LabelAccountType.setText(LoginController.type_account);
        ChangePercentage();
        PercentageProjects.setOnAction(actionEvent -> {
            if(AnchorProjects.visibleProperty().get() == false ){
                AnchorPaneVacation.setVisible(false);
                AnchorPaneChanProj.setVisible(false);
                AnchorPaneOrderMaterials.setVisible(false);
                AnchorPaneStockOfMaterials.setVisible(false);
                AnchorProjects.setVisible(true);
                AnchorPaneStatusMaterial.setVisible(false);
            }else {
                AnchorProjects.setVisible(false);
            }
        });
        AboutTheProgram.setOnAction(actionEvent -> {
            if(AboutTheProgramPane.visibleProperty().get() == false ){
                AnchorPaneVacation.setVisible(false);
                AnchorPaneChanProj.setVisible(false);
                AnchorPaneOrderMaterials.setVisible(false);
                AnchorPaneStockOfMaterials.setVisible(false);
                AnchorProjects.setVisible(false);
                AboutTheProgramPane.setVisible(true);
                AnchorPaneStatusMaterial.setVisible(false);
            }else {
                AboutTheProgramPane.setVisible(false);
            }
        });

        ShowPriceButton.setOnAction(actionEvent -> {
            ChangePrice();
        });
        OrderMatButton.setOnAction(actionEvent -> {
            if(AnchorPaneOrderMaterials.visibleProperty().get() == false ){
                AnchorPaneVacation.setVisible(false);
                AnchorPaneChanProj.setVisible(false);
                AnchorPaneOrderMaterials.setVisible(true);
                AnchorPaneStockOfMaterials.setVisible(false);
                AnchorProjects.setVisible(false);
                AnchorPaneStatusMaterial.setVisible(false);
            }else {
                AnchorPaneOrderMaterials.setVisible(false);
            }
            try {
                OrderMaterials();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        Vacation.setOnAction(actionEvent -> {
            if(AnchorPaneVacation.visibleProperty().get() == false ){
                AnchorPaneVacation.setVisible(true);
                AnchorPaneChanProj.setVisible(false);
                AnchorPaneOrderMaterials.setVisible(false);
                AnchorPaneStockOfMaterials.setVisible(false);
                AnchorProjects.setVisible(false);
                AnchorPaneStatusMaterial.setVisible(false);
            }else {
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

        BackButton.setOnAction(actionEvent -> {
            AnchorProjects.setVisible(true);
            AnchorPaneOrderMaterials.setVisible(false);
            AnchorPaneStockOfMaterials.setVisible(false);
            AnchorPaneOrderMaterials.setVisible(false);
            AnchorPaneChanProj.setVisible(false);
        });

        SaveButton.setOnAction(actionEvent -> {
            AnchorPaneChanProj.setVisible(false);
            AnchorProjects.setVisible(true);
            try {
                UpdateStatusProjects();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        OrderButton.setOnAction(actionEvent -> {
            AnchorPaneVacation.setVisible(false);
            AnchorPaneChanProj.setVisible(false);
            AnchorPaneOrderMaterials.setVisible(true);
            AnchorPaneStockOfMaterials.setVisible(false);
            AnchorProjects.setVisible(false);
            AnchorPaneStatusMaterial.setVisible(false);
            AnchorPaneOrderMaterialsNew.setVisible(false);
            
            try {
                WriteOrderMaterials();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        ShowStatusMaterial.setOnAction(actionEvent -> {
            if(AnchorPaneStatusMaterial.visibleProperty().get() == false ){
                AnchorPaneVacation.setVisible(false);
                AnchorPaneChanProj.setVisible(false);
                AnchorPaneOrderMaterials.setVisible(false);
                AnchorPaneStockOfMaterials.setVisible(false);
                AnchorProjects.setVisible(false);
                AnchorPaneStatusMaterial.setVisible(true);
            }else {
                AnchorPaneStatusMaterial.setVisible(false);
            }
            try {
                StatusOrder();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        PercentageProjects.setOnAction(actionEvent -> {
            if (AnchorProjects.visibleProperty().get() == false) {
                AnchorProjects.setVisible(true);
            } else {
                AnchorProjects.setVisible(false);
            }
            try {
                ChangeProjectsPercentage();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        StockOfMaterials.setOnAction(actionEvent -> {
            if(AnchorPaneStockOfMaterials.visibleProperty().get() == false ){
                AnchorPaneVacation.setVisible(false);
                AnchorPaneChanProj.setVisible(false);
                AnchorPaneOrderMaterials.setVisible(false);
                AnchorPaneStockOfMaterials.setVisible(true);
                AnchorProjects.setVisible(false);
                AnchorPaneStatusMaterial.setVisible(false);
            }else {
                AnchorPaneStockOfMaterials.setVisible(false);
            }
            try {
                StockMaterials();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
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


    }

    public void OrderMaterials() throws SQLException, ClassNotFoundException {
        ObservableList<CompanyMaterials> MatList = FXCollections.observableArrayList();
        ResultSet result = dbHandler.Suppliermaterials();
        while (result.next()) {
            MatList.add(new CompanyMaterials(result.getString("material"), result.getInt("quanity"),
                    result.getInt("price"), result.getString("unit of measurement"),
                    result.getString("supplierName")));
        }
        MaterialsNameCol.setCellValueFactory(new PropertyValueFactory<>("MaterialName"));
        AmountCol.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        UnitCol.setCellValueFactory(new PropertyValueFactory<>("Unit"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("Suppliername"));

        FilteredList<CompanyMaterials> Filtered = new FilteredList<>(MatList, b -> true);
        SearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            Filtered.setPredicate(companyMaterials -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (companyMaterials.getMaterialName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (companyMaterials.getUnit().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (companyMaterials.getSuppliername().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(companyMaterials.getAmount()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(companyMaterials.getPrice()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (companyMaterials.getUnit().indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;

            });
        });
        SortedList<CompanyMaterials> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(OrderMaterialsTable.comparatorProperty());
        OrderMaterialsTable.setItems(sortedList);
        FilteredList<CompanyMaterials> FilteredTwo = new FilteredList<>(MatList, b -> true);
        MaterialsNameWrite.textProperty().addListener((observable, oldValue, newValue) -> {
            FilteredTwo.setPredicate(companyMaterials -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (companyMaterials.getMaterialName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (companyMaterials.getUnit().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (companyMaterials.getSuppliername().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(companyMaterials.getAmount()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(companyMaterials.getPrice()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (companyMaterials.getUnit().indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;

            });
        });
        SortedList<CompanyMaterials> sortedListTwo = new SortedList<>(FilteredTwo);
        sortedListTwo.comparatorProperty().bind(OrderMaterialsTable.comparatorProperty());
        OrderMaterialsTable.setItems(sortedListTwo);


        OrderMat();
    }

    public void StatusOrder() throws SQLException, ClassNotFoundException {
        ObservableList<StatusMaterials> StMat = FXCollections.observableArrayList();
        ResultSet result = dbHandler.Companymaterials();
        while (result.next()) {
            StMat.add(new StatusMaterials(result.getInt("idcompanyMaterials"),result.getString("Supplier name"), result.getString("NameMaterials"),
                    result.getInt("Amount"), result.getInt("Price"), result.getString("unit of measurement"), result.getString("Status")));
            StatusSupName.setCellValueFactory(new PropertyValueFactory<>("SupplierName"));
            StatusMatName.setCellValueFactory(new PropertyValueFactory<>("MaterialsName"));
            StatusAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
            StatusPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
            StatusUnit.setCellValueFactory(new PropertyValueFactory<>("Unit"));
            StatusStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
            FilteredList<StatusMaterials> Filtered = new FilteredList<>(StMat, b -> true);
            StatusSearch.textProperty().addListener((observable, oldValue, newValue) -> {
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
                    } else if (statusMaterials.getStatus().indexOf(lowerCaseFilter) != -1)
                        return true;
                    else
                        return false;

                });
            });
            SortedList<StatusMaterials> sortedList = new SortedList<>(Filtered);
            sortedList.comparatorProperty().bind(StatusTable.comparatorProperty());
            StatusTable.setItems(sortedList);
        }

    }

    public void ChangeProjectsPercentage() throws SQLException, ClassNotFoundException {
        ObservableList<ProjectsTable> Projects = FXCollections.observableArrayList();
        ResultSet result = dbHandler.ProjectsTable();

        while (result.next()) {
            if (result.getInt("Status") == 100) {
                continue;
            } else {
                Projects.add(new ProjectsTable(result.getString("ProjectsName"), result.getInt("Status"),
                        result.getString("District"),
                        result.getInt("Apartments"), result.getInt("Budget"), result.getString("Time"),result.getString("Description")));
            }
            ProjectsName.setCellValueFactory(new PropertyValueFactory<>("ProjectsName"));
            ProjectsStatus.setCellValueFactory(new PropertyValueFactory<>("ProjectsStatus"));
            ProjectsDistrict.setCellValueFactory(new PropertyValueFactory<>("ProjectsDistrict"));
        }
        FilteredList<ProjectsTable> Filtered = new FilteredList<>(Projects, b -> true);
        SearchProjects.textProperty().addListener((observable, oldValue, newValue) -> {
            Filtered.setPredicate(projectsTable -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (projectsTable.getProjectsName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(projectsTable.getProjectsStatus()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (projectsTable.getProjectsDistrict().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(projectsTable.getProjectsApartment()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(projectsTable.getProjectsBudget()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (projectsTable.getProjectsTime().indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;

            });
        });
        SortedList<ProjectsTable> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(ProjectsTable.comparatorProperty());
        ProjectsTable.setItems(sortedList);

    }

    public void StockMaterials() throws SQLException, ClassNotFoundException {
        ObservableList<StockOfMaterials> StMat = FXCollections.observableArrayList();
        ResultSet result = dbHandler.Stockofmaterials();
        while (result.next()) {
            StMat.add(new StockOfMaterials(result.getString("Materials"),
                    result.getInt("Amount"), result.getString("Unit")));
            StockMat.setCellValueFactory(new PropertyValueFactory<>("MatName"));
            StockAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
            StockUnit.setCellValueFactory(new PropertyValueFactory<>("Unit"));
            FilteredList<StockOfMaterials> Filtered = new FilteredList<>(StMat, b -> true);
            SearchStockOfMat.textProperty().addListener((observable, oldValue, newValue) -> {
                Filtered.setPredicate(stockOfMaterials -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (stockOfMaterials.getMatName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (stockOfMaterials.getUnit().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (String.valueOf(stockOfMaterials.getAmount()).indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else
                        return false;

                });
            });
            SortedList<StockOfMaterials> sortedList = new SortedList<>(Filtered);
            sortedList.comparatorProperty().bind(StockTable.comparatorProperty());
            StockTable.setItems(sortedList);
        }

    }

    public void OrderMat() {
        OrderMaterialsTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.isPrimaryButtonDown() && mouseEvent.getClickCount() == 2) {
                    TablePosition pos = OrderMaterialsTable.getSelectionModel().getSelectedCells().get(0);
                    int row = pos.getRow();
                    CompanyMaterials item = OrderMaterialsTable.getItems().get(row);

                    TableColumn col = pos.getTableColumn();
                    String data = (String) col.getCellObservableValue(item).getValue();
                    try {
                        MaterialsOrder(data);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    AnchorPaneVacation.setVisible(false);
                    AnchorPaneChanProj.setVisible(false);
                    AnchorPaneOrderMaterials.setVisible(false);
                    AnchorPaneStockOfMaterials.setVisible(false);
                    AnchorProjects.setVisible(false);
                    AnchorPaneStatusMaterial.setVisible(false);
                    AnchorPaneOrderMaterialsNew.setVisible(true);

                }
            }
        });
    }
    public void ChangePercentage() {
        ProjectsTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    AnchorProjects.setVisible(false);
                    AnchorPaneOrderMaterials.setVisible(false);
                    AnchorPaneStockOfMaterials.setVisible(false);
                    AnchorPaneOrderMaterials.setVisible(false);
                    AnchorPaneChanProj.setVisible(true);
                    TablePosition pos = ProjectsTable.getSelectionModel().getSelectedCells().get(0);
                    int row = pos.getRow();
                    com.example.ain_stroy.ProjectsTable item = ProjectsTable.getItems().get(row);

                    TableColumn col = pos.getTableColumn();
                    String data = (String) col.getCellObservableValue(item).getValue();
                    try {
                        ChangeProjectPercentage(data);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
    public void ChangeProjectPercentage(String ProjectsName) throws SQLException, ClassNotFoundException {
        int status = 0;
        ResultSet result = dbHandler.SelectProject(ProjectsName);
        while (result.next()){
            ProjectsNameField.setText(result.getString("ProjectsName"));
            ProjectsDistrictField.setText(result.getString("District"));
            ProjectApartField.setText(String.valueOf(result.getInt("Apartments")));
            status = result.getInt("Status");
            final int initialValue = 99;

            SpinnerValueFactory<Integer> valueFactory = //
                    new SpinnerValueFactory.IntegerSpinnerValueFactory(status, initialValue);

            PercentageSpinner.setValueFactory(valueFactory);
        }

    }
    public void UpdateStatusProjects() throws SQLException, ClassNotFoundException {
        DatebaseHandler dbHandler = new DatebaseHandler();
        int status = (int) PercentageSpinner.getValue();
        String update = "UPDATE `projects` SET Status = '" + status + "' , ProjectsName = '" + ProjectsNameField.getText() +  "' , District = '" +
                ProjectsDistrictField.getText() +  "' , Apartments = '" + ProjectApartField.getText() + "' WHERE ProjectsName = '" + ProjectsNameField.getText() + "'";
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
        ChangeProjectsPercentage();
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
        dbHandler.VacationUpdate(vacation);
    }
    public void Image() {
        Image im = new Image(LoginController.image);
        ProfileImage.setImage(im);
    }
    public void MaterialsOrder(String name) throws SQLException, ClassNotFoundException {
        ResultSet result = dbHandler.ChoiceSuppliermaterials(name , MaterialsNameWrite.getText());
        while (result.next()){
            PriceInStock = result.getInt("price");
            MaterialNameText.setText(result.getString("material"));
            PriceInStockText.setText(String.valueOf(result.getInt("price")));
            QuantityInStockText.setText(result.getString("quanity"));
            SupplierNameText.setText(result.getString("supplierName"));
            Unit = result.getString("unit of measurement");
            Amount = result.getInt("quanity");

        }
    }
    public void ChangePrice(){
            if(QuantityToOrderField.getText().equals("")){
                PriceText.setFont(Font.font(16));
                PriceText.setText("Write the quantity of the product");
            }else {
                PriceText.setFont(Font.font(18));
                int Quantitty = Integer.parseInt(QuantityToOrderField.getText());
                PriceText.setText(String.valueOf(Quantitty * PriceInStock));
            }
    }
    public void WriteOrderMaterials() throws SQLException, ClassNotFoundException {
        int Quantitty = Integer.parseInt(QuantityToOrderField.getText());
        StatusMaterials statusMaterials = new StatusMaterials(0,SupplierNameText.getText(),MaterialNameText.getText(),Quantitty,
                Quantitty*PriceInStock,Unit,"Waiting");
        dbHandler.InsertMaterials(statusMaterials);

        int NewAmount = Amount - Quantitty;
        String update = "UPDATE `suppliermaterials` SET `Amount` = '" + NewAmount + "' WHERE `Supplier name` = '" + SupplierNameText.getText() + "'" ;
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
    }

}
