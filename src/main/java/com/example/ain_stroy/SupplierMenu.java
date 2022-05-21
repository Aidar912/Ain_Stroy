package com.example.ain_stroy;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import javax.xml.transform.Result;

public class SupplierMenu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPaneListMaterials;

    @FXML
    private AnchorPane AnchorPaneMaterialsToOrdered;

    @FXML
    private TableColumn<DeliveredMaterials, String> DeliveredMaterialsNameCol;

    @FXML
    private TextField DeliveredMaterialsSearch;

    @FXML
    private TableView<DeliveredMaterials> DeliveredMaterialsTable;

    @FXML
    private TableColumn<DeliveredMaterials, Integer> DeliveredPriceMaterialsCol;

    @FXML
    private TableColumn<DeliveredMaterials, String> DeliveredTimeCol;

    @FXML
    private TableColumn<DeliveredMaterials, Integer> DeliveredQuantityCol;

    @FXML
    private TableColumn<DeliveredMaterials, String> DeliveredUOMCol;

    @FXML
    private Button Exit;

    @FXML
    private Label LabelAccountType;

    @FXML
    private Label LabelUserName;

    @FXML
    private Button AddButton;

    @FXML
    private TextArea AddDescriptionArea;

    @FXML
    private TextField AddMaterialsNameField;

    @FXML
    private TextField AddPriceField;

    @FXML
    private TextField AddQuantityField;

    @FXML
    private TextField AddUOMField;

    @FXML
    private AnchorPane AnchorPaneAddMaterials;


    @FXML
    private TextFlow AboutTheProgrammText;


    @FXML
    private AnchorPane AboutTheProgramPane;
    @FXML
    private TableView<AllMaterials> MaterialsListTable;

    @FXML
    private TableColumn<AllMaterials, String> MaterialsNameCol;

    @FXML
    private TableColumn<OrderedMaterials, String> OrderedMaterialsNameCol;

    @FXML
    private TableColumn<OrderedMaterials, Integer> OrderedMaterialsPriceCol;

    @FXML
    private TableColumn<OrderedMaterials, Integer> OrderedMaterialsQuantityCol;

    @FXML
    private TextField OrderedMaterialsSearch;

    @FXML
    private TableView<OrderedMaterials> OrderedMaterialsTable;

    @FXML
    private TableColumn<OrderedMaterials, String> OrderedMaterialsUOMCol;

    @FXML
    private TableColumn<DeliveredMaterials, Integer> PriceMaterialsCol;

    @FXML
    private TableColumn<DeliveredMaterials, Integer> QuantityCol;

    @FXML
    private TextField SearchField;

    @FXML
    private TableColumn<DeliveredMaterials, String> UOMCol;

    @FXML
    private Button btn_about;

    @FXML
    private Button btn_add_mat;

    @FXML
    private Button EditAccount;

    @FXML
    private Button btn_show_deliverd;

    @FXML
    private Button btn_show_list;

    @FXML
    private Button btn_to_order;

    @FXML
    private AnchorPane AnchorPaneDeliveredMaterials;

    @FXML
    private AnchorPane AnchorPaneMyMaterials;

    @FXML
    private TableColumn<AllMaterials, String> MyMaterialsDescription;

    @FXML
    private TextArea MyMaterialsDescriptionArea;

    @FXML
    private TableColumn<AllMaterials, String> MyMaterialsName;

    @FXML
    private TextField MyMaterialsNameField;

    @FXML
    private TableColumn<AllMaterials, Integer> MyMaterialsPrice;

    @FXML
    private Button MyMaterialsButton;

    @FXML
    private TextField MyMaterialsPriceField;

    @FXML
    private TableColumn<AllMaterials, Integer> MyMaterialsQuantity;

    @FXML
    private TextField MyMaterialsQuantityField;

    @FXML
    private Button MyMaterialsSaveButton;

    @FXML
    private TableView<AllMaterials> MyMaterialsTable;

    @FXML
    private TableColumn<AllMaterials, String> MyMaterialsUOM;

    @FXML
    private TextField MyMaterialsUOMField;

    @FXML
    private AnchorPane AnchorPaneWithdrawMoney;

    @FXML
    private Text BalanceTextField;

    @FXML
    private Text NotEnoughMoneyText;

    @FXML
    private Button DismountButton;

    @FXML
    private  Button WithdrawMoneyButton;

    @FXML
    private TextField HowMuchField;


    @FXML
    private ImageView image;
    DatebaseHandler dbHandler = new DatebaseHandler();
    String MaterialsName = null;
    String SupplierName = null;
    int PriceOrdered = 0;
    int QuantityOrdered = 0;
    String UOMOrdered = null;
    int QuantityInStock = 0;


    @FXML
    void initialize() {
        LabelUserName.setText(LoginController.name);
        LabelAccountType.setText(LoginController.type_account);

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
        btn_add_mat.setOnAction(actionEvent -> {
            if (AnchorPaneAddMaterials.visibleProperty().get() == false) {
                AnchorPaneAddMaterials.setVisible(true);
                AnchorPaneDeliveredMaterials.setVisible(false);
                AnchorPaneMaterialsToOrdered.setVisible(false);
                AnchorPaneListMaterials.setVisible(false);
                AboutTheProgramPane.setVisible(false);
                AnchorPaneMyMaterials.setVisible(false);
                AnchorPaneWithdrawMoney.setVisible(false);
            } else {
                AnchorPaneAddMaterials.setVisible(false);
            }
        });
        AddButton.setOnAction(actionEvent -> {
            try {
                AddMaterials();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            AddPriceField.clear();
            AddQuantityField.clear();
            AddUOMField.clear();
            AddMaterialsNameField.clear();
            AddDescriptionArea.clear();
        });

        btn_show_list.setOnAction(actionEvent -> {
            if (AnchorPaneListMaterials.visibleProperty().get() == false) {
                AnchorPaneListMaterials.setVisible(true);
                AnchorPaneMaterialsToOrdered.setVisible(false);
                AnchorPaneDeliveredMaterials.setVisible(false);
                AboutTheProgramPane.setVisible(false);
                AnchorPaneWithdrawMoney.setVisible(false);
                AnchorPaneMyMaterials.setVisible(false);
            } else {
                AnchorPaneListMaterials.setVisible(false);
            }

            try {
                ShowTheListOfMaterials();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
        btn_about.setOnAction(actionEvent -> {
            if (AboutTheProgramPane.visibleProperty().get() == false) {
                AnchorPaneListMaterials.setVisible(false);
                AnchorPaneMaterialsToOrdered.setVisible(false);
                AnchorPaneDeliveredMaterials.setVisible(false);
                AboutTheProgramPane.setVisible(true);
                AnchorPaneWithdrawMoney.setVisible(false);
                AnchorPaneMyMaterials.setVisible(false);

            } else {
                AboutTheProgramPane.setVisible(false);
            }
        });

        btn_to_order.setOnAction(actionEvent -> {
            if (AnchorPaneMaterialsToOrdered.visibleProperty().get() == false) {
                AnchorPaneListMaterials.setVisible(false);
                AnchorPaneMaterialsToOrdered.setVisible(true);
                AnchorPaneDeliveredMaterials.setVisible(false);
                AboutTheProgramPane.setVisible(false);
                AnchorPaneWithdrawMoney.setVisible(false);
                AnchorPaneMyMaterials.setVisible(false);

            } else {
                AnchorPaneMaterialsToOrdered.setVisible(false);
            }

            try {
                OrderedMaterials();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        btn_show_deliverd.setOnAction(actionEvent -> {
            try {
                DeliveredMaterials();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (AnchorPaneDeliveredMaterials.visibleProperty().get() == false) {
                AnchorPaneDeliveredMaterials.setVisible(true);
                AnchorPaneMaterialsToOrdered.setVisible(false);
                AnchorPaneListMaterials.setVisible(false);
                AboutTheProgramPane.setVisible(false);
                AnchorPaneWithdrawMoney.setVisible(false);
                AnchorPaneMyMaterials.setVisible(false);
            } else {
                AnchorPaneDeliveredMaterials.setVisible(false);
            }

        });

        MyMaterialsButton.setOnAction(actionEvent -> {
            if (AnchorPaneMyMaterials.visibleProperty().get() == false) {
                AnchorPaneDeliveredMaterials.setVisible(false);
                AnchorPaneMaterialsToOrdered.setVisible(false);
                AnchorPaneListMaterials.setVisible(false);
                AboutTheProgramPane.setVisible(false);
                AnchorPaneWithdrawMoney.setVisible(false);
                AnchorPaneMyMaterials.setVisible(true);
            } else {
                AnchorPaneMyMaterials.setVisible(false);
            }

            try {
                MyMaterials();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        MyMaterialsSaveButton.setOnAction(actionEvent -> {
            try {
                UpdateMaterials();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        WithdrawMoneyButton.setOnAction(actionEvent -> {
            if (AnchorPaneWithdrawMoney.visibleProperty().get() == false) {
                AnchorPaneDeliveredMaterials.setVisible(false);
                AnchorPaneMaterialsToOrdered.setVisible(false);
                AnchorPaneListMaterials.setVisible(false);
                AboutTheProgramPane.setVisible(false);
                AnchorPaneWithdrawMoney.setVisible(true);
                AnchorPaneMyMaterials.setVisible(true);
            } else {
                AnchorPaneWithdrawMoney.setVisible(false);
            }

            BalanceTextField.setText(String.valueOf(LoginController.Salary));
        });

        DismountButton.setOnAction(actionEvent -> {
            try {
                WithdrawMoney();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

    }

    public void ShowTheListOfMaterials() throws SQLException, ClassNotFoundException {
        ObservableList<AllMaterials> allMaterial = FXCollections.observableArrayList();
        ResultSet result = dbHandler.AllMaterials();
        while (result.next()) {
            QuantityInStock = result.getInt("quanity");
            allMaterial.add(new AllMaterials(result.getString("material"), result.getString("unit of measurement"),
                    result.getInt("quanity"), result.getInt("price"), result.getString("supplierName"), result.getString("DescMaterials")));
        }
        MaterialsNameCol.setCellValueFactory(new PropertyValueFactory<>("MaterialsName"));
        UOMCol.setCellValueFactory(new PropertyValueFactory<>("UOM"));
        QuantityCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        PriceMaterialsCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        FilteredList<AllMaterials> Filtered = new FilteredList<>(allMaterial, b -> true);
        SearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            Filtered.setPredicate(allMaterials -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (allMaterials.getMaterialsName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (allMaterials.getUOM().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (allMaterials.getSupplierName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(allMaterials.getPrice()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(allMaterials.getQuantity()).indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;

            });
        });
        SortedList<AllMaterials> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(MaterialsListTable.comparatorProperty());
        MaterialsListTable.setItems(sortedList);
        InfoAboutMaterial();

    }

    public void OrderedMaterials() throws SQLException, ClassNotFoundException {
        ObservableList<OrderedMaterials> ordMat = FXCollections.observableArrayList();
        ResultSet result = dbHandler.OrderedMaterials();
        while (result.next()) {
            if (!result.getString("supplier name").equals(LoginController.name)) {
                continue;
            } else {
                ordMat.add(new OrderedMaterials(result.getString("material"), result.getInt("quantity"),
                        result.getInt("price"), result.getString("measurement"), result.getString("supplier name")));
            }
        }
        OrderedMaterialsNameCol.setCellValueFactory(new PropertyValueFactory<>("MaterialsName"));
        OrderedMaterialsQuantityCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        OrderedMaterialsPriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        OrderedMaterialsUOMCol.setCellValueFactory(new PropertyValueFactory<>("UOM"));
        FilteredList<OrderedMaterials> Filtered = new FilteredList<>(ordMat, b -> true);
        OrderedMaterialsSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            Filtered.setPredicate(orderedMaterials -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (orderedMaterials.getMaterialsName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (orderedMaterials.getSupplierName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (orderedMaterials.getUOM().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(orderedMaterials.getPrice()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(orderedMaterials.getQuantity()).indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;

            });
        });
        SortedList<OrderedMaterials> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(OrderedMaterialsTable.comparatorProperty());
        OrderedMaterialsTable.setItems(sortedList);
        ClickOrderedTable();
    }

    public void ClickOrderedTable() {

        OrderedMaterialsTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {

                    TablePosition pos = OrderedMaterialsTable.getSelectionModel().getSelectedCells().get(0);
                    int row = pos.getRow();
                    com.example.ain_stroy.OrderedMaterials item = OrderedMaterialsTable.getItems().get(row);

                    TableColumn col = pos.getTableColumn();
                    String data = (String) col.getCellObservableValue(item).getValue();

                    try {
                        DeliveredMaterials(data);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    try {
                        CheckMaterialsWithName(data);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }

    public void DeliveredMaterials(String name) throws SQLException, ClassNotFoundException {
        ResultSet result = dbHandler.OrderedMaterialsWithName(name);
        while (result.next()) {
            MaterialsName = result.getString("material");
            PriceOrdered = result.getInt("price");
            UOMOrdered = result.getString("measurement");
            QuantityOrdered = result.getInt("quantity");
            SupplierName = result.getString("supplier name");
        }
        DeliveredMaterials deliveredMaterials = new DeliveredMaterials(MaterialsName, PriceOrdered, UOMOrdered, QuantityOrdered, LoginController.name, String.valueOf(LocalDate.now(ZoneId.of("Europe/Paris"))));
        dbHandler.InsertMaterials(deliveredMaterials);

    }

    public void CheckMaterialsWithName(String Material) throws SQLException, ClassNotFoundException {
        ResultSet result = dbHandler.AllMaterialsWithName(Material);
        while (result.next()) {
            QuantityInStock = result.getInt("quanity");
        }
        if (QuantityInStock - QuantityOrdered > 0) {
            String update = "UPDATE `allmaterials` SET quanity = '" + (QuantityInStock - QuantityOrdered) + "' WHERE `material` = '" + Material + "'";
            PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(update);
            prSt.executeUpdate();

            String delete = "DELETE FROM `orderedmaterials` WHERE material = '" + Material + "'";
            PreparedStatement prStD = dbHandler.getDbConnection().prepareStatement(delete);
            prStD.executeUpdate();

            OrderedMaterials();

            int SupplierProfit = 0;

            ResultSet resultSet = dbHandler.SumProfitSupplier(LoginController.name);
            while (resultSet.next()) {
                SupplierProfit = resultSet.getInt(1);
            }
            int SupplierSalary = SupplierProfit + LoginController.Salary;

            String updateSalary = "UPDATE `users` SET `salary` = '" + SupplierSalary + "' WHERE firstname = '" + LoginController.name + "'";
            PreparedStatement prStS = dbHandler.getDbConnection().prepareStatement(updateSalary);
            prStS.executeUpdate();

        } else {


        }
    }

    public void DeliveredMaterials() throws SQLException, ClassNotFoundException {
        ResultSet result = dbHandler.DeliveredMaterials();
        ObservableList<DeliveredMaterials> delMat = FXCollections.observableArrayList();
        while (result.next()) {
            delMat.add(new DeliveredMaterials(result.getString("MaterialsName"), result.getInt("Price"),
                    result.getString("UOM"), result.getInt("Quantity"), result.getString("SupplierName"), result.getString("Time")));
        }
        DeliveredMaterialsNameCol.setCellValueFactory(new PropertyValueFactory<>("MaterialsName"));
        DeliveredUOMCol.setCellValueFactory(new PropertyValueFactory<>("UOM"));
        DeliveredQuantityCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        DeliveredPriceMaterialsCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        DeliveredTimeCol.setCellValueFactory(new PropertyValueFactory<>("Time"));
        FilteredList<DeliveredMaterials> Filtered = new FilteredList<>(delMat, b -> true);
        DeliveredMaterialsSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            Filtered.setPredicate(deliveredMaterials -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (deliveredMaterials.getSupplierName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (deliveredMaterials.getMaterialsName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (deliveredMaterials.getUOM().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(deliveredMaterials.getQuantity()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(deliveredMaterials.getPrice()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (deliveredMaterials.getTime().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false;

            });
        });
        SortedList<DeliveredMaterials> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(DeliveredMaterialsTable.comparatorProperty());
        DeliveredMaterialsTable.setItems(sortedList);

    }

    public void AddMaterials() throws SQLException, ClassNotFoundException {
        int Quantity = Integer.parseInt(AddQuantityField.getText());
        int Price = Integer.parseInt(AddPriceField.getText());
        AllMaterials allMaterials = new AllMaterials(AddMaterialsNameField.getText(), AddUOMField.getText(), Quantity, Price, LoginController.name, AddDescriptionArea.getText());
        dbHandler.AddMaterials(allMaterials);

    }

    public void InfoAboutMaterial() {
        MaterialsListTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 3) {
                    AnchorPaneAddMaterials.setVisible(false);
                    AnchorPaneDeliveredMaterials.setVisible(false);
                    AnchorPaneListMaterials.setVisible(true);
                    AnchorPaneMaterialsToOrdered.setVisible(false);
                    TablePosition pos = MaterialsListTable.getSelectionModel().getSelectedCells().get(0);
                    int row = pos.getRow();
                    AllMaterials item = MaterialsListTable.getItems().get(row);

                    TableColumn col = pos.getTableColumn();
                    String data = (String) col.getCellObservableValue(item).getValue();


                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("InfoAboutMaterials.fxml"));
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
        });

    }

    public void MyMaterials() throws SQLException, ClassNotFoundException {
        ObservableList<AllMaterials> ObList = FXCollections.observableArrayList();
        ResultSet result = dbHandler.AllMaterials();
        while (result.next()) {
            if (result.getString("supplierName").equals(LoginController.name)) {
                ObList.add(new AllMaterials(result.getString("material"), result.getString("unit of measurement"), result.getInt("quanity"),
                        result.getInt("price"), result.getString("supplierName"), result.getString("DescMaterials")));
            }else{
                continue;
            }
        }
        MyMaterialsName.setCellValueFactory(new PropertyValueFactory<>("MaterialsName"));
        MyMaterialsQuantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        MyMaterialsUOM.setCellValueFactory(new PropertyValueFactory<>("UOM"));
        MyMaterialsPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        MyMaterialsDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        MyMaterialsTable.setItems(ObList);
        ClickMyMaterials();

    }

    public void ClickMyMaterials() {
        MyMaterialsTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {

                    TablePosition pos = MyMaterialsTable.getSelectionModel().getSelectedCells().get(0);
                    int row = pos.getRow();
                    AllMaterials item = MyMaterialsTable.getItems().get(row);

                    TableColumn col = pos.getTableColumn();
                    String data = (String) col.getCellObservableValue(item).getValue();

                    try {
                        FillMyMaterials(data);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    public void FillMyMaterials(String materials) throws SQLException, ClassNotFoundException {
        ResultSet result = dbHandler.AllMaterialsWithNameAndMaterial(materials,LoginController.name);
        while (result.next()){
         MyMaterialsNameField.setText(result.getString("material"));
         MyMaterialsQuantityField.setText(String.valueOf(result.getInt("quanity")));
         MyMaterialsPriceField.setText(String.valueOf(result.getInt("price")));
         MyMaterialsUOMField.setText(result.getString("unit of measurement"));
         MyMaterialsDescriptionArea.setText(result.getString("DescMaterials"));
        }
    }
    public void UpdateMaterials() throws SQLException, ClassNotFoundException {
        String update = "UPDATE `allmaterials` SET `material` = '" + MyMaterialsNameField.getText() + "', `quanity` = '"
                + Integer.parseInt(MyMaterialsQuantityField.getText()) + "' , `unit of measurement` = '" +MyMaterialsUOMField.getText() + "'," +
                " `price` = '" + Integer.parseInt(MyMaterialsPriceField.getText()) + "' , `DescMaterials` = '" + MyMaterialsDescriptionArea.getText() + "'" +
                " WHERE `supplierName` = '" + LoginController.name + "' AND `material` =  '" + MyMaterialsNameField.getText() + "'" ;
        PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
    }

    public void WithdrawMoney() throws SQLException, ClassNotFoundException {
        int NewBalance = LoginController.Salary - Integer.parseInt(HowMuchField.getText());
        if(NewBalance<0) {
            NotEnoughMoneyText.setVisible(true);
        }else{
            NotEnoughMoneyText.setVisible(false);
            String update = "UPDATE `users` SET `salary` = '" + NewBalance + "' WHERE user_login = '" + LoginController.login + "'";
            PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(update);
            prSt.executeUpdate();
        }
        ResultSet result = dbHandler.UsersWithLogin(LoginController.login);
        while (result.next()) {
            BalanceTextField.setText(String.valueOf(result.getInt("salary")));
            HowMuchField.clear();
        }
    }
}

