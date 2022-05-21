package com.example.ain_stroy;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class SalesDepartament {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPaneSellApartments;

    @FXML
    private AnchorPane AnchorPaneSoldApartments;

    @FXML
    private AnchorPane AnchorPaneApartmentsForSale;

    @FXML
    private ComboBox ApartmentsType;

    @FXML
    private CheckBox Caption;

    @FXML
    private CheckBox CoupleCaption;

    @FXML
    private TextField Couple_sName;

    @FXML
    private TextField Couple_sPassport;

    @FXML
    private Button EditAccount;

    @FXML
    private Button Exit;

    @FXML
    private Text InfoText;

    @FXML
    private Label LabelAccountType;

    @FXML
    private Label LabelUserName;

    @FXML
    private ComboBox MaritalStatus;

    @FXML
    private TextField NameFiled;

    @FXML
    private TextField PassportNumber;

    @FXML
    private ComboBox ProjectsName;

    @FXML
    private TableColumn<Apartments, String> SaleBusiness;

    @FXML
    private TableColumn<Apartments, String> SaleEconomy;

    @FXML
    private ComboBox SaleInfo;

    @FXML
    private TableColumn<Apartments, String> SaleLuxury;

    @FXML
    private TableColumn<Apartments, String> SaleProjectsName;

    @FXML
    private TextField SaleSearch;

    @FXML
    private TableView<Apartments> SaleTable;

    @FXML
    private Text SaleTextInfo;

    @FXML
    private Button UnfinishedApartments;

    @FXML
    private Button SoldApartments;

    @FXML
    private Button SellApartments;

    @FXML
    private Button ApartmentsForSale;

    @FXML
    private Button AboutTheProgram;

    @FXML
    private DatePicker SellDate;

    @FXML
    private ComboBox SexStatus;

    @FXML
    private Button ShowContractButton;

    @FXML
    private TableColumn<SoldApartments, String> SoldBusiness;

    @FXML
    private TableColumn<SoldApartments, String> SoldEconomy;

    @FXML
    private TableColumn<SoldApartments, String> SoldLuxury;

    @FXML
    private TableColumn<SoldApartments, String> SoldProjectsName;

    @FXML
    private TextField SoldSearch;

    @FXML
    private TableView<SoldApartments> SoldTable;

    @FXML
    private TextFlow AboutTheProgrammText;

    @FXML
    private AnchorPane AboutTheProgramPane;

    @FXML
    private AnchorPane AnchorPaneUnfinishedApartments;

    @FXML
    private TableColumn<Apartments, Integer> UnfinishedBusPrice;

    @FXML
    private TableColumn<Apartments, Integer> UnfinishedEcoPrice;

    @FXML
    private TableColumn<Apartments, Integer> UnfinishedLuxPrice;

    @FXML
    private TableColumn<Apartments, String> UnfinishedProjectsName;

    @FXML
    private TextField UnfinishedSearchField;

    @FXML
    private TableColumn<Apartments, Integer> UnfinishedSoldApartments;

    @FXML
    private TableView<Apartments> UnfinishedTable;


    ObservableList<String> ProjectsNameComboBox = FXCollections.observableArrayList();
    ObservableList<String> TypeApartmentsComboBox = FXCollections.observableArrayList("luxury Apartments","business apartments","economy apartments");
    ObservableList<String> SexComboBox = FXCollections.observableArrayList("Male","Female");
    ObservableList<String> MaritialStatusComboBox = FXCollections.observableArrayList("married","not marriage");
    int Apart = 0;
    int Sold = 0;
    String priceApartments = null;
    int price = 0;
    int p ;
    int profit = 0;

    DatebaseHandler dbHandler = new DatebaseHandler();

    @FXML
    void initialize() {
        LabelUserName.setText(LoginController.name);
        LabelAccountType.setText(LoginController.type_account);


        try {
            ALlComboBox();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        SellApartments.setOnAction(actionEvent -> {
            if(AnchorPaneSellApartments.visibleProperty().get() == false){
                AnchorPaneSellApartments.setVisible(true);
                AnchorPaneApartmentsForSale.setVisible(false);
                AnchorPaneSoldApartments.setVisible(false);
                AboutTheProgramPane.setVisible(false);
                AnchorPaneUnfinishedApartments.setVisible(false);
            }else {
                AnchorPaneSellApartments.setVisible(false);
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

        SoldApartments.setOnAction(actionEvent -> {
            try {
                SoldApartments();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if(AnchorPaneSoldApartments.visibleProperty().get() == false){
                AnchorPaneSellApartments.setVisible(false);
                AnchorPaneApartmentsForSale.setVisible(false);
                AnchorPaneUnfinishedApartments.setVisible(false);
                AnchorPaneSoldApartments.setVisible(true);
                AboutTheProgramPane.setVisible(false);
            }else{
                AnchorPaneSoldApartments.setVisible(false);
            }
        });

        ApartmentsForSale.setOnAction(actionEvent -> {
            try {
                ApartmentsForSale();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if(AnchorPaneApartmentsForSale.visibleProperty().get() == false){
                AnchorPaneSellApartments.setVisible(false);
                AnchorPaneApartmentsForSale.setVisible(true);
                AboutTheProgramPane.setVisible(false);
                AnchorPaneUnfinishedApartments.setVisible(false);
                AnchorPaneSoldApartments.setVisible(false);
            }else{
                AnchorPaneApartmentsForSale.setVisible(false);
            }
        });

        ApartmentsType.setOnAction(actionEvent -> {
            try {
                SellApartments();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        MaritalStatus.setOnAction(actionEvent -> {
            MartialStatus();
        });

        Caption.setOnAction(actionEvent -> {
            Caption();
        });
        CoupleCaption.setOnAction(actionEvent -> {
            Caption();
        });

        ShowContractButton.setOnAction(actionEvent -> {
            try {
                ShowContract();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        AboutTheProgram.setOnAction(actionEvent -> {
            if(AboutTheProgramPane.visibleProperty().get() == false){
                AnchorPaneSellApartments.setVisible(false);
                AnchorPaneApartmentsForSale.setVisible(false);
                AboutTheProgramPane.setVisible(true);
                AnchorPaneUnfinishedApartments.setVisible(false);
                AnchorPaneSoldApartments.setVisible(false);
            }else{
                AboutTheProgramPane.setVisible(false);
            }
        });
        UnfinishedApartments.setOnAction(actionEvent -> {
            if(AnchorPaneUnfinishedApartments.visibleProperty().get() == false){
                AnchorPaneSellApartments.setVisible(false);
                AnchorPaneApartmentsForSale.setVisible(false);
                AboutTheProgramPane.setVisible(false);
                AnchorPaneUnfinishedApartments.setVisible(true);
                AnchorPaneSoldApartments.setVisible(false);
            }else{
                AnchorPaneUnfinishedApartments.setVisible(false);
            }

            try {
                UnfinishedApartments();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        SaleInfo.setOnAction(actionEvent -> {
            if (SaleInfo.getValue().equals("luxury Apartments")) {
                SaleTextInfo.setText("Apartments in this segment have an average area of 80-90 square meters, and the layout " +
                        "is often free. The ceiling height is 3 meters, and the common areas are finished with quality materials. " +
                        "Vestibules, staircases, elevators - all finished in the latest fashion and technology");
            } else {
                if (SaleInfo.getValue().equals("business apartments")) {
                    SaleTextInfo.setText("Business class has 1, 2 and 3 bedroom apartments with individual layout, ranging from 37.11m ² to 96.28m ², commercial space and underground parking for 47 cars.\n" +
                            "\n" +
                            "Gas central heating\n" +
                            "24/7 video surveillance\n" +
                            "Playground\n" +
                            "High speed internet TV/WiFi\n" +
                            "Enclosed yard without cars\n" +
                            "Landscaping");
                } else {
                    if (SaleInfo.getValue().equals("economy apartments")) {
                        SaleTextInfo.setText("Apartment sizes range from 30 to 70 square meters. All of them are transferred to buyers with finishing work. Energy-efficient seamless technology of facade finishing was used in the construction of the houses, which allowed to significantly reduce the heat loss of the house. \n" +
                                "There can be up to 12 apartments per floor, each of them will have a standard layout: without any specially designed storage areas, such as separate dressing rooms, laundry rooms, etc.\n" +
                                "\n" +
                                "A complex of landscaping and gardening works was implemented on the territory around the house. ");
                    }
                }
            }
        });

    }
    public void ALlComboBox() throws SQLException, ClassNotFoundException {
        ResultSet result = dbHandler.ProjectsTable();
        while (result.next()) {
            if ((result.getString("ProjectsName").startsWith("Residential"))){
                ProjectsNameComboBox.add(result.getString("ProjectsName"));

                ProjectsName.setItems(ProjectsNameComboBox);
            }else{
                continue;
            }
        }
        ApartmentsType.setItems(TypeApartmentsComboBox);
        SexStatus.setItems(SexComboBox);
        MaritalStatus.setItems(MaritialStatusComboBox);

    }
    public void SellApartments() throws SQLException,ClassNotFoundException {
        try {
            String projectsName = ProjectsName.getValue().toString();
            String InfoTypeApartments = "";
            String InfoAboutProjects = "";
            ResultSet result = dbHandler.SelectInfoAboutProjects(projectsName);
            while(result.next()){
                InfoAboutProjects =  result.getString("Description");
            }
            // Info about apartments
            if (ApartmentsType.getValue().equals("luxury Apartments")) {
                InfoTypeApartments = "Apartments in this segment have an average area of 80-90 square meters, and the layout is often free. " +
                        "The ceiling height is 3 meters, and the common areas are finished with " +
                        "quality materials. Vestibules, staircases, elevators - all finished in the latest fashion and technology";
            } else {
                if (ApartmentsType.getValue().equals("business apartments")) {
                    InfoTypeApartments = "Business class has 1, 2 and 3 bedroom apartments with individual layout, ranging from 37.11m ² to 96.28m ², commercial space and underground parking for 47 cars.\n" +
                            "\n" +
                            "Gas central heating\n" +
                            "24/7 video surveillance\n" +
                            "Playground\n" +
                            "High speed internet TV/WiFi\n" +
                            "Enclosed yard without cars\n" +
                            "Landscaping";
                } else {
                    if (ApartmentsType.getValue().equals("economy apartments")) {
                        InfoTypeApartments = "Apartment sizes range from 30 to 70 square meters. All of them are transferred to buyers with finishing work. Energy-efficient seamless technology of facade finishing was used in the construction of the houses, which allowed to significantly reduce the heat loss of the house. \n" +
                                "There can be up to 12 apartments per floor, each of them will have a standard layout: without any specially designed storage areas, such as separate dressing rooms, laundry rooms, etc.\n" +
                                "\n" +
                                "A complex of landscaping and gardening works was implemented on the territory around the house. ";
                    }
                }
            }
            InfoText.setText("Info about projects !!" + "\n" + InfoAboutProjects + " " + "\n" + "Info about apartments!!!" + "\n" + InfoTypeApartments);
        } catch (NullPointerException e) {
            System.out.println("null");
        }
    }
    // To select marital status
    public void MartialStatus(){
        if(MaritalStatus.getValue().equals("not marriage")){
            CoupleCaption.setVisible(false); Couple_sName.setVisible(false);Couple_sPassport.setVisible(false);
        }else{
            Couple_sName.setVisible(true); CoupleCaption.setVisible(true); Couple_sPassport.setVisible(true);
        }
    }
    // Signature verification
    public void Caption() {
        if (Caption.isSelected()) {
            if (CoupleCaption.visibleProperty().get() == false) {
                ShowContractButton.setVisible(true);
            } else {
                if (CoupleCaption.visibleProperty().get() == true) {
                    if (CoupleCaption.isSelected() && Caption.isSelected()) {
                        ShowContractButton.setVisible(true);
                    } else {
                        if (CoupleCaption.isSelected() && (!Caption.isSelected())) {
                            ShowContractButton.setVisible(false);
                        } else {
                            if ((!CoupleCaption.isSelected()) && Caption.isSelected()) {
                                ShowContractButton.setVisible(false);
                            } else {
                                if ((!CoupleCaption.isSelected()) && (!Caption.isSelected())) {
                                    ShowContractButton.setVisible(false);
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if ((!Caption.isSelected())) {
                if (CoupleCaption.visibleProperty().get() == false) {
                    ShowContractButton.setVisible(false);
                } else {
                    if (CoupleCaption.visibleProperty().get() == true) {
                        if (CoupleCaption.isSelected() && Caption.isSelected()) {
                            ShowContractButton.setVisible(true);
                        } else {
                            if (CoupleCaption.isSelected() && (!Caption.isSelected())) {
                                ShowContractButton.setVisible(false);
                            } else {
                                if ((!CoupleCaption.isSelected()) && Caption.isSelected()) {
                                    ShowContractButton.setVisible(false);
                                } else {
                                    if ((!CoupleCaption.isSelected()) && (!Caption.isSelected())) {
                                        ShowContractButton.setVisible(false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    // Check the price of the selected apartment
    public void ShowContract() throws SQLException, ClassNotFoundException {
        String ProjectName = ProjectsName.getValue().toString();
        String ApartType = ApartmentsType.getValue().toString();
        if (ApartType.equals("luxury Apartments")) {
            priceApartments = "luxury price";
        } else {
            if (ApartType.equals("business apartments")) {
                priceApartments = "business price";
            } else {
                if (ApartType.equals("economy apartments")) {
                    priceApartments = "economy price";
                }
            }
        }
        ResultSet result = dbHandler.ApartmentsType(ProjectName);
        while (result.next()) {
            Apart = result.getInt(ApartType);
            price = result.getInt(priceApartments);
            profit = result.getInt("profit");
            Sold = result.getInt("sold apartments");
        }
        dbHandler.UpdateProfit(profit + price, ProjectName);
        dbHandler.UpdateApartments(ApartType, ProjectName, Apart - 1, Sold + 1);
        ResultSet res = dbHandler.SoldApartmentsType(ProjectName);
        while (res.next()) {
            Apart = res.getInt(ApartType);

        }
        dbHandler.UpdateSoldApartments(ApartType, ProjectName, Apart + 1);
        ResultSet resRev = dbHandler.Revenues();
        while (resRev.next()) {
            p = resRev.getInt("Apartment");
        }
        dbHandler.UpdateRevenues(p + price);

        NameFiled.clear();
        PassportNumber.clear();
        InfoText.setText("");


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
    public void ApartmentsForSale() throws SQLException, ClassNotFoundException {
        ObservableList<Apartments> forsale = FXCollections.observableArrayList();
        ResultSet result = dbHandler.Apartments();
        while(result.next()){
            if(result.getString("status").equals("Completed")){
                forsale.add(new Apartments(result.getString("projectsName"),result.getInt("luxury Apartments"),result.getInt("business apartments"),
                        result.getInt("economy apartments"),result.getInt("luxury price"),result.getInt("business price"),result.getInt("economy price"),
                        result.getInt("profit"),result.getInt("sold apartments"),result.getString("status")));
               SaleProjectsName.setCellValueFactory(new PropertyValueFactory<>("ProjectsName"));
               SaleLuxury.setCellValueFactory(new PropertyValueFactory<>("LuxApartments"));
               SaleBusiness.setCellValueFactory(new PropertyValueFactory<>("BusApartments"));
               SaleEconomy.setCellValueFactory(new PropertyValueFactory<>("EcoApartments"));
            }
            FilteredList<Apartments> Filtered = new FilteredList<>(forsale, b -> true);
            SaleSearch.textProperty().addListener((observable, oldValue, newValue) -> {
                Filtered.setPredicate(apartments -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (apartments.getProjectsName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (String.valueOf(apartments.getLuxApartments()).indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (String.valueOf(apartments.getBusApartments()).indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (String.valueOf(apartments.getEcoApartments()).indexOf(lowerCaseFilter) != -1) {
                        return true;}
                    else
                        return false;

                });
            });
            SortedList<Apartments> sortedList = new SortedList<>(Filtered);
            sortedList.comparatorProperty().bind(SaleTable.comparatorProperty());
            SaleTable.setItems(sortedList);
            SaleInfo.setItems(TypeApartmentsComboBox);

        }

    }
    public void SoldApartments() throws SQLException, ClassNotFoundException {
        ObservableList<SoldApartments> sold = FXCollections.observableArrayList();
        ResultSet result = dbHandler.SoldApartments();
        while(result.next()){
            sold.add(new SoldApartments(result.getString("project"),result.getInt("luxury Apartments"),result.getInt("business apartments"),result.getInt("economy apartments")));
        }
        SoldProjectsName.setCellValueFactory(new PropertyValueFactory<>("ProjectsName"));
        SoldLuxury.setCellValueFactory(new PropertyValueFactory<>("LuxApartments"));
        SoldBusiness.setCellValueFactory(new PropertyValueFactory<>("BusApartments"));
        SoldEconomy.setCellValueFactory(new PropertyValueFactory<>("EcoApartments"));
        FilteredList<SoldApartments> Filtered = new FilteredList<>(sold, b -> true);
        SoldSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            Filtered.setPredicate(soldApartments -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (soldApartments.getProjectsName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(soldApartments.getLuxApartments()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(soldApartments.getBusApartments()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(soldApartments.getEcoApartments()).indexOf(lowerCaseFilter) != -1) {
                    return true;}
                else
                    return false;

            });
        });
        SortedList<SoldApartments> sortedList = new SortedList<>(Filtered);
        sortedList.comparatorProperty().bind(SoldTable.comparatorProperty());
        SoldTable.setItems(sortedList);


    }
    public void UnfinishedApartments() throws SQLException, ClassNotFoundException {
        ObservableList<Apartments> unfap = FXCollections.observableArrayList();
        ResultSet result = dbHandler.Apartments();
        while(result.next()){
            if(result.getString("status").equals("Unfinished")){
                unfap.add(new Apartments(result.getString("projectsName"),result.getInt("luxury Apartments"),result.getInt("business apartments"),
                        result.getInt("economy apartments"),result.getInt("luxury price"),result.getInt("business price"),result.getInt("economy price"),
                        result.getInt("profit"),result.getInt("sold apartments"),result.getString("status")));
                UnfinishedProjectsName.setCellValueFactory(new PropertyValueFactory<>("ProjectsName"));
                UnfinishedLuxPrice.setCellValueFactory(new PropertyValueFactory<>("LuxApartments"));
                UnfinishedBusPrice.setCellValueFactory(new PropertyValueFactory<>("BusApartments"));
                UnfinishedEcoPrice.setCellValueFactory(new PropertyValueFactory<>("EcoApartments"));
                UnfinishedSoldApartments.setCellValueFactory(new PropertyValueFactory<>("SoldApartments"));
            }
            FilteredList<Apartments> Filtered = new FilteredList<>(unfap, b -> true);
            UnfinishedSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
                Filtered.setPredicate(apartments -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (apartments.getProjectsName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (String.valueOf(apartments.getLuxApartments()).indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (String.valueOf(apartments.getBusApartments()).indexOf(lowerCaseFilter) != -1) {
                        return true;
                    } else if (String.valueOf(apartments.getEcoApartments()).indexOf(lowerCaseFilter) != -1) {
                        return true;
                    }else if (String.valueOf(apartments.getSoldApartments()).indexOf(lowerCaseFilter) != -1)
                        return true;
                    else
                        return false;

                });
            });
            SortedList<Apartments> sortedList = new SortedList<>(Filtered);
            sortedList.comparatorProperty().bind(UnfinishedTable.comparatorProperty());
            UnfinishedTable.setItems(sortedList);
        }
    }

}
