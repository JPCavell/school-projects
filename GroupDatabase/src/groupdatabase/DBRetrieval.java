package groupdatabase;

import java.sql.*;

/* Name: Jacob Cavell
 * Course: CSC 315
 * Project: GroupDatabase
 * File Name: DBRetrieval.java
 */

/*
 * This program is a retrieving system for the database tables
 * In this class, the user will be provided the chosen table displayed
 * This program does this by communicating with MySQL to show the table
 */
public class DBRetrieval extends GroupDatabase {

    public static Connection getDBConnection() throws SQLException {
        String connectionurl = "jdbc:mysql://127.0.0.1:3306/onlinepizzashop";
        String username = "root";
        String password = "root";
        Connection dbconn;
        try {
            //connection to a database
            dbconn = DriverManager.getConnection(connectionurl, username, password);
            //System.out.println("Database connection was successful!");
            return dbconn;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    static void customerDataview() throws SQLException {

        Connection conn = getDBConnection();
        Statement st = conn.createStatement();

        ResultSet rs = null;

        //Step 3: Run a SQL query
        rs = st.executeQuery("select * from customer");

        //Step 4: Output the retrieved data /result set
        System.out.printf("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-15s | %-20s | %-20s | %-10s | %-10s | %-11s | %-11s |  %-20s |  %-20s |%n", "ID", "PHONE NUMBER", "FIRSTNAME", "MIDDLEINITIAL", "LASTNAME", "ZIPCODE", "STATE", "CITY", "STREET");
        System.out.printf("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");

        while (rs.next()) {
            System.out.printf("| %-15s | %-20s | %-20s | %-13s | %-10s |  %-10s |  %-10s |  %-20s |  %-20s |%n", rs.getString("CustomerID"), rs.getString("PhoneNumber"), rs.getString("FirstName"), rs.getString("MiddleInitial"), rs.getString("LastName"), rs.getString("ZipCode"), rs.getString("State"), rs.getString("City"), rs.getString("Street"));

        }

        System.out.printf("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
    }

    static void drinkDataview() throws SQLException {
        Connection conn = getDBConnection();
        Statement st = conn.createStatement();

        ResultSet rs = null;

        //Step 3: Run a SQL query
        rs = st.executeQuery("select * from drink");
        //Step 4: Output the retrieved data /result set
        System.out.printf("------------------------------------------------------------------------------%n");
        System.out.printf("| %-15s | %-20s | %-20s | %-10s |%n", "ID", "NAME", "SIZE", "TYPE");
        System.out.printf("------------------------------------------------------------------------------%n");


        while (rs.next()) {
            System.out.printf("| %-15s | %-20s | %-20s | %-10s |%n", rs.getString("DrinkID"), rs.getString("NameOfDrink"), rs.getString("Size"), rs.getString("TypeOfDrink"));

        }

        System.out.printf("------------------------------------------------------------------------------%n");

    }

    static void employeeDataview() throws SQLException {

        Connection conn = getDBConnection();
        Statement st = conn.createStatement();

        ResultSet rs = null;

        //Step 3: Run a SQL query
        rs = st.executeQuery("select * from employee");

        //Step 4: Output the retrieved data /result set
        System.out.printf("------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-15s | %-20s | %-20s | %-10s | %-10s | %-11s |%n", "ID", "GENDER", "AGE", "FIRSTNAME", "MIDDLEINITIAL", "LASTNAME");
        System.out.printf("------------------------------------------------------------------------------------------------------------%n");

        while (rs.next()) {
            System.out.printf("| %-15s | %-20s | %-20s | %-10s | %-13s |  %-10s |%n", rs.getString("EmployeeID"), rs.getString("Gender"), rs.getString("Age"), rs.getString("FirstName"), rs.getString("MiddleInitial"), rs.getString("LastName"));

        }

        System.out.printf("------------------------------------------------------------------------------------------------------------%n");
    }

    static void ordersDataview() throws SQLException {

        Connection conn = getDBConnection();
        Statement st = conn.createStatement();

        ResultSet rs = null;

        //Step 3: Run a SQL query
        rs = st.executeQuery("select * from orders");

        //Step 4: Output the retrieved data /result set
        System.out.printf("------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-15s | %-20s | %-20s | %-10s | %-13s | %-11s |%n", "ID", "DELIVERYDATE", "ORDERDATE", "PRICE", "DELIVERYTIME", "ORDERTIME");
        System.out.printf("------------------------------------------------------------------------------------------------------------%n");

        while (rs.next()) {
            System.out.printf("| %-15s | %-20s | %-20s | %-10s | %-13s |  %-10s |%n", rs.getString("OrderID"), rs.getString("DeliveryDate"), rs.getString("OrderDate"), rs.getString("Price"), rs.getString("DeliveryTime"), rs.getString("OrderTime"));

        }

        System.out.printf("------------------------------------------------------------------------------------------------------------%n");
    }

    static void paymentDataview() throws SQLException {
        Connection conn = getDBConnection();
        Statement st = conn.createStatement();

        ResultSet rs = null;

        //Step 3: Run a SQL query
        rs = st.executeQuery("select * from payment");
        //Step 4: Output the retrieved data /result set
        System.out.printf("------------------------------------------------------------------------------%n");
        System.out.printf("| %-15s | %-20s | %-20s | %-10s |%n", "ID", "PAYMENTDATE", "AMOUNT", "TYPE");
        System.out.printf("------------------------------------------------------------------------------%n");

        while (rs.next()) {
            System.out.printf("| %-15s | %-20s | %-20s | %-10s |%n", rs.getString("PaymentID"), rs.getString("PaymentDate"), rs.getString("Amount"), rs.getString("TypeOfPayment"));

        }

        System.out.printf("------------------------------------------------------------------------------%n");

    }

    static void pizzaDataview() throws SQLException {
        Connection conn = getDBConnection();
        Statement st = conn.createStatement();

        ResultSet rs = null;

        //Step 3: Run a SQL query
        rs = st.executeQuery("select * from pizza");
        //Step 4: Output the retrieved data /result set
        System.out.printf("-----------------------------------------------------------------%n");
        System.out.printf("| %-15s | %-20s | %-20s |%n", "ID", "CRUST", "SIZE");
        System.out.printf("-----------------------------------------------------------------%n");

        while (rs.next()) {
            System.out.printf("| %-15s | %-20s | %-20s |%n", rs.getString("PizzaID"), rs.getString("Crust"), rs.getString("Size"));

        }

        System.out.printf("-----------------------------------------------------------------%n");

    }

    static void toppingDataview() throws SQLException {
        Connection conn = getDBConnection();
        Statement st = conn.createStatement();

        ResultSet rs = null;

        //Step 3: Run a SQL query
        rs = st.executeQuery("select * from topping");
        //Step 4: Output the retrieved data /result set
        System.out.printf("------------------------------------------%n");
        System.out.printf("| %-15s | %-20s |%n", "ID", "TYPE");
        System.out.printf("------------------------------------------%n");

        while (rs.next()) {
            System.out.printf("| %-15s | %-20s |%n", rs.getString("ToppingID"), rs.getString("TypeOfTopping"));

        }

        System.out.printf("------------------------------------------%n");

    }

    static void vehicleDataview() throws SQLException {
        Connection conn = getDBConnection();
        Statement st = conn.createStatement();

        ResultSet rs = null;

        //Step 3: Run a SQL query
        rs = st.executeQuery("select * from vehicle");
        //Step 4: Output the retrieved data /result set
        System.out.printf("-----------------------------------------------------------------%n");
        System.out.printf("| %-15s | %-20s | %-20s |%n", "ID", "DESCRIPTION", "TYPE");
        System.out.printf("-----------------------------------------------------------------%n");

        while (rs.next()) {
            System.out.printf("| %-15s | %-20s | %-20s |%n", rs.getString("VehicleID"), rs.getString("DescriptionOfVehicle"), rs.getString("TypeOfVehicle"));

        }

        System.out.printf("-----------------------------------------------------------------%n");

    }

}
