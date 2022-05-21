package com.example.ain_stroy;

import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.zip.CheckedOutputStream;

public class DatebaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;


        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(User user) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_FIRSTNAME + "," + Const.USER_LASTNAME + "," +
                Const.USER_LOGIN + "," + Const.USER_PASSWORD + "," + Const.TYPE_ACCOUNT + ")" + "VALUES(?,?,?,?,?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);

        prSt.setString(1, user.getFirstname());
        prSt.setString(2, user.getLastname());
        prSt.setString(3, user.getUser_login());
        prSt.setString(4, user.getUser_password());
        prSt.setString(5, user.getType_account());

        prSt.executeUpdate();

    }

    public ResultSet getUser(User user) throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;


        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=?";

        PreparedStatement prSt = getDbConnection().prepareStatement(select);

        prSt.setString(1, user.getUser_login());
        prSt.setString(2, user.getUser_password());


        resSet = prSt.executeQuery();
        return resSet;
    }


    public void UpdateInformation(String firstname, String lastname, String password, String userlogin) throws SQLException, ClassNotFoundException {
        String update = "UPDATE users set firstname = '" + firstname + "', lastname = '" + lastname + "' , user_password = '" + password + "' WHERE user_login = '" + userlogin + "'";

        PreparedStatement prSt = getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
    }


    public void UpdatePath(String path, String user) throws SQLException, ClassNotFoundException {
        String update = "UPDATE users SET Image = '" + path + "'" + " WHERE user_login = '" + user + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
    }

    public ResultSet PersonnelChange() throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE;

        PreparedStatement prSt = getDbConnection().prepareStatement(select);


        resSet = prSt.executeQuery();

        return resSet;

    }

    public void UpdatePersonnel(String account, String firstname, String lastname) throws SQLException, ClassNotFoundException {
        String update = "UPDATE users SET type_account = '" + account + "'" + " WHERE firstname = '" + firstname + "'" + " AND lastname = " + "'" + lastname + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
    }

    public void UpdateSalary(String salary, String firstname, String lastname) throws SQLException, ClassNotFoundException {
        String update = "UPDATE users SET salary = '" + salary + "'" + " WHERE firstname = '" + firstname + "'" + " AND lastname = " + "'" + lastname + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
    }

    public ResultSet Vacation() throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM " + Const.VacationTable;
        PreparedStatement prSt = getDbConnection().prepareStatement(select);

        result = prSt.executeQuery();

        return result;

    }

    public void VacationUpdate(Vacation vacation) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.VacationTable + "(" + Const.NameVacation + "," + Const.LastVacation + "," + Const.PaidVacation + "," + Const.VacationDays + ")" + "VALUES(?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, vacation.getNameUser());
        prSt.setString(2, vacation.getLastVacation());
        prSt.setInt(3, vacation.getPaidVacation());
        prSt.setInt(4, vacation.getVacationDays());
        prSt.executeUpdate();
    }

    public void VacationStatus(String status, String name) throws SQLException, ClassNotFoundException {
        String update = "UPDATE vacation SET status = '" + status + "'" + " WHERE UserName = '" + name + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
    }

    public void DeleteUser(String firstname, String lastname) throws SQLException, ClassNotFoundException {
        String delete = "DELETE FROM `users` WHERE `firstname` = '" + firstname + "' AND `lastname` = '" + lastname + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(delete);
        prSt.executeUpdate();
    }

    public ResultSet ProjectsTable() throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.ProjectsTable;
        PreparedStatement prSt = getDbConnection().prepareStatement(select);

        resSet = prSt.executeQuery();

        return resSet;
    }

    public void InsertResume(ResumeConstructor resumeConstructor) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.ResumeTable + "(" + Const.ResumeName + "," + Const.ResumeLastname + "," + Const.ResumeNumber + "," + Const.ResumePosition + "," + Const.ResumeInfo + ")" + "VALUES(?,?,?,?,?) ";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, resumeConstructor.getFirstname());
        prSt.setString(2, resumeConstructor.getLastname());
        prSt.setString(3, resumeConstructor.getNumber());
        prSt.setString(4, resumeConstructor.getPosition());
        prSt.setString(5, resumeConstructor.getInfo());
        prSt.executeUpdate();
    }

    public ResultSet ResumeUsers() throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM " + Const.ResumeTable;
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }

    public ResultSet SelectProject(String Name) throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM " + Const.ProjectsTable + " WHERE ProjectsName = '" + Name + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }

    public void UpdateProjectsTable(String name, String time, String status) throws SQLException, ClassNotFoundException {
        String update = "UPDATE projects set Status = '" + status + "', Time = '" + time + "' WHERE ProjectsName = '" + name + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
    }

    public ResultSet ResumeView(String name) throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM " + Const.ResumeTable + " WHERE firstname = '" + name + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;

    }

    public ResultSet Apartments() throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM " + Const.ApartmentTable;
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }

    public ResultSet Revenues() throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM " + Const.Revenues;
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }

    public ResultSet Expenses() throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM " + Const.Expenses;
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }

    public ResultSet Suppliermaterials() throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM " + Const.AllMaterialsTable;
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }

    public ResultSet Stockofmaterials() throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM " + Const.stockofmaterials;
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }

    public ResultSet Companymaterials() throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM " + Const.companymaterials;
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }

    public void InsertMaterials(StatusMaterials statusMaterials) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.companymaterials + "( `" + Const.Supplie_name + "` , `" + Const.NameMaterials + "` , `" + Const.Amount + "` , `" +
                Const.Price + "` , `" + Const.Unit + "` , `" + Const.Status + "` )" + "VALUES(?,?,?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, statusMaterials.getSupplierName());
        prSt.setString(2, statusMaterials.getMaterialsName());
        prSt.setInt(3, statusMaterials.getAmount());
        prSt.setInt(4, statusMaterials.getPrice());
        prSt.setString(5, statusMaterials.getUnit());
        prSt.setString(6, statusMaterials.getStatus());
        prSt.executeUpdate();


    }
    public ResultSet SelectInfoAboutProjects(String name) throws SQLException,ClassNotFoundException{
        ResultSet result = null;
        String select = "SELECT * FROM " + Const.ProjectsTable + " WHERE ProjectsName = '" + name + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }
    public void UpdateApartments(String type,String projects,int apart, int sold) throws SQLException, ClassNotFoundException {
        String update = "UPDATE apartments set `" + type +  "` = '" + apart + "' , `sold apartments` = '" + sold  + "' WHERE `projectsName` = '" + projects + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
    }
    public ResultSet ApartmentsType(String projectsName) throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM " + Const.ApartmentTable + " WHERE projectsName = '" + projectsName + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }
    public void UpdateSoldApartments(String type,String projects,int apart) throws SQLException, ClassNotFoundException {
        String update = "UPDATE `soldapartments` set `" + type +  "` = '" + apart  + "' WHERE `project` = '" + projects + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
    }
    public ResultSet SoldApartmentsType(String projectsName) throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM " + Const.SoldApartments + " WHERE project = '" + projectsName + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }
    public void UpdateRevenues(int ApartmentsPrice) throws SQLException, ClassNotFoundException {
        String update = "UPDATE `revenues` set Apartment = '"+ ApartmentsPrice + "' WHERE  `idRevenues` = '" + 1 + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
    }
    public void UpdateProfit(int profit,String projectsName) throws SQLException, ClassNotFoundException {
        String update = "UPDATE `apartments` set profit = '"+ profit + "' WHERE  `projectsName` = '" + projectsName + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(update);
        prSt.executeUpdate();
    }
    public ResultSet SoldApartments() throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM " + Const.SoldApartments;
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }
    public ResultSet SumExpenses() throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT SUM(salary) as summ from " +Const.USER_TABLE;
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }
    public void InsertMaterialsForBuy(CompanyMaterials companyMaterials) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO `" + Const.OrderedMaterialsTable + "` ( `" + Const.OrderedMaterialsName + "` , `" + Const.OrderedMaterialsQuantity + "` , `" + Const.OrderedMaterialsPrice +
                "` , `" + Const.OrderedMaterialsMeasurement + "` , `" + Const.OrderedMaterialsSupplierName + "` )" + " VALUES(?,?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1,companyMaterials.getMaterialName());
        prSt.setInt(2,companyMaterials.getAmount());
        prSt.setInt(3,companyMaterials.getPrice());
        prSt.setString(4,companyMaterials.getUnit());
        prSt.setString(5,companyMaterials.getSuppliername());
        prSt.executeUpdate();
    }
    public ResultSet SumMaterialsPrice() throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT SUM(Price) as summ  from `" +Const.companymaterials + "` as a where Status = '" + "Delivered" + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }
    public ResultSet Budget() throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM `important`";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }

    public ResultSet ChoiceSuppliermaterials(String Name,String Materials) throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM `" + Const.AllMaterialsTable + "` WHERE `supplierName` = '" + Name + "' AND `material` = '" + Materials + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }

    public ResultSet AllMaterials() throws  SQLException, ClassNotFoundException{
        ResultSet result = null;
        String select = "SELECT * FROM " + Const.AllMaterialsTable;
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }
    public ResultSet OrderedMaterials() throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM " + Const.OrderedMaterialsTable;
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }

    public ResultSet OrderedMaterialsWithName(String Materials) throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM `" + Const.OrderedMaterialsTable + "` WHERE material = '" + Materials + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }
    public void InsertMaterials(DeliveredMaterials deliveredMaterials) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO `" + Const.DeliveredMaterialsTable + "` ( `" + Const.DeliveredMaterialsName + "` , `" + Const.DeliveredMaterialsPrice + "` , `" + Const.DeliveredMaterialsUOM +
                "` , `" + Const.DeliveredMaterialsQuantity + "` , `" + Const.DeliveredMaterialsSupplierName + "` , `" + Const.DeliveredMaterialsTime + "` )" + " VALUES(?,?,?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1,deliveredMaterials.getMaterialsName());
        prSt.setInt(2,deliveredMaterials.getPrice());
        prSt.setString(3,deliveredMaterials.getUOM());
        prSt.setInt(4,deliveredMaterials.getQuantity());
        prSt.setString(5,deliveredMaterials.getSupplierName());
        prSt.setString(6,deliveredMaterials.getTime());
        prSt.executeUpdate();
    }
    public ResultSet AllMaterialsWithName(String Mat) throws  SQLException, ClassNotFoundException{
        ResultSet result = null;
        String select = "SELECT * FROM `" + Const.AllMaterialsTable + "` WHERE `material` = '" + Mat + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }
    public ResultSet SumProfitSupplier(String Name) throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT SUM(Price) as summ  from `" +Const.DeliveredMaterialsTable + "` as a where SupplierName = '" + Name + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }
    public void OrderMaterials(OrderedMaterials orderedMaterials) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO `" + Const.OrderedMaterialsTable + "` ( `" + Const.OrderedMaterialsName + "` , `" + Const.OrderedMaterialsQuantity + "` , `" + Const.OrderedMaterialsPrice +
                "` , `" + Const.OrderedMaterialsMeasurement + "` , `" + Const.OrderedMaterialsSupplierName + "` )" + " VALUES(?,?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1,orderedMaterials.getMaterialsName());
        prSt.setInt(2,orderedMaterials.getQuantity());
        prSt.setInt(3,orderedMaterials.getPrice());
        prSt.setString(4,orderedMaterials.getUOM());
        prSt.setString(5,orderedMaterials.getSupplierName());
        prSt.executeUpdate();
    }
    public ResultSet OrderMaterialsWithStatus() throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM `companymaterials` WHERE `Status` = 'Ordered'";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }
    public ResultSet DeliveredMaterials() throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM " + Const.DeliveredMaterialsTable + " WHERE `SupplierName` = '" + LoginController.name + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return  result;
    }
    public void AddMaterials(AllMaterials allMaterials) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO `" + Const.AllMaterialsTable + "` ( `" + Const.AllMaterialsName + "` , `" + Const.AllMaterialsUOM + "` , `" + Const.AllMaterialsQuantity +
                "` , `" + Const.AllMaterialsPrice + "` , `" + Const.AllMaterialsSupplierName + "` )" + " VALUES(?,?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1,allMaterials.getMaterialsName());
        prSt.setString(2,allMaterials.getUOM());
        prSt.setInt(3,allMaterials.getQuantity());
        prSt.setInt(4,allMaterials.getPrice());
        prSt.setString(5,allMaterials.getSupplierName());
        prSt.executeUpdate();
    }
    public void StockOfMaterials(StockOfMaterials stockOfMaterials) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO `stockofmaterials` ( `Materials` ,`Amount` , `Unit` ) VALUES(?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1,stockOfMaterials.getMatName());
        prSt.setInt(2,stockOfMaterials.getAmount());
        prSt.setString(3,stockOfMaterials.getUnit());
        prSt.executeUpdate();

    }
    public ResultSet ProjectsWithName(String name) throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM `" + Const.ProjectsTable + "` WHERE `ProjectsName` = '" + name + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }
    public void InsertNewProjects(ProjectsTable projectsTable) throws  SQLException,ClassNotFoundException{
        String insert = "INSERT INTO `" +Const.ProjectsTable + "` ( `" + Const.ProjectsName + "` , `" + Const.ProjectsStatus + "` , `"
                + Const.ProjectsDistrict + "` , `" + Const.ProjectsApartment + "` , `" + Const.ProjectsBudget + "` , `" + Const.ProjectsTime + "` , `"
                + Const.ProjectsDescription + "` )" + "VALUES(?,?,?,?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1,projectsTable.getProjectsName());
        prSt.setInt(2,projectsTable.getProjectsStatus());
        prSt.setString(3,projectsTable.getProjectsDistrict());
        prSt.setInt(4,projectsTable.getProjectsApartment());
        prSt.setInt(5,projectsTable.getProjectsBudget());
        prSt.setString(6,projectsTable.getProjectsTime());
        prSt.setString(7,projectsTable.getDescription());
        prSt.executeUpdate();
    }
    public void InsertApartmentsForSale(Apartments apartments) throws SQLException,ClassNotFoundException {
        String insert = "INSERT INTO `" + Const.ApartmentTable + "` ( `" + Const.ApartmentName + "` , `" +
                Const.ApartmentLux + "` , `" + Const.ApartmentBus +"` , `" + Const.ApartmentEco + "` , `" +
                Const.ApartmentLuxPrice + "` , `" + Const.ApartmentBusPrice + "` , `" + Const.ApartmentEcoPrice + "` , `" +
                Const.ApartmentProfit + "` , `" + Const.ApartmentSold + "` , `" + Const.ApartmentStatus +"` )" + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1,apartments.getProjectsName());
        prSt.setInt(2,apartments.getLuxApartments());
        prSt.setInt(3,apartments.getBusApartments());
        prSt.setInt(4,apartments.getEcoApartments());
        prSt.setInt(5,apartments.getLuxPrice());
        prSt.setInt(6,apartments.getBusPrice());
        prSt.setInt(7,apartments.getEcoPrice());
        prSt.setInt(8,apartments.getProfit());
        prSt.setInt(9,apartments.getSoldApartments());
        prSt.setString(10,apartments.getStatus());

        prSt.executeUpdate();
    }
    public ResultSet AllMaterialsWithNameAndMaterial(String Mat, String name) throws  SQLException, ClassNotFoundException{
        ResultSet result = null;
        String select = "SELECT * FROM `" + Const.AllMaterialsTable + "` WHERE `material` = '" + Mat + "' AND `supplierName` = '" + name + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }
    public ResultSet UsersWithLogin(String login) throws SQLException, ClassNotFoundException {
        ResultSet result = null;
        String select = "SELECT * FROM `users` WHERE `user_login` = '" + login + "'" ;
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        result = prSt.executeQuery();
        return result;
    }
    public void RemoveUsersByLogin(String login) throws SQLException, ClassNotFoundException {
        String delete = "DELETE FROM `users` WHERE `user_login` = '" + login + "'";
        PreparedStatement prSt = getDbConnection().prepareStatement(delete);
        prSt.executeUpdate();
    }
}
