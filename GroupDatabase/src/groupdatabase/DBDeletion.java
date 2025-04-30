package groupdatabase;

import java.sql.*;
import java.util.*;

/* Name: Jacob Cavell
 * Course: CSC 315
 * Project: GroupDatabase
 * File Name: DBDeletion.java
 */

/*
 * This program is a deletion system for the database tables
 * In this class, the user will be prompted to enter the ID of the row they want to delete
 * The program will then communicate with MySQL to delete the field chosen with the user input,
 * then displaying the table with the chosen row removed
 */
public class DBDeletion {

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

    static void datadeletionCustomer() throws SQLException {
        Scanner input = new Scanner(System.in);
        int customerID;

        //input data for deletion
        System.out.print("Enter the ID Number to Delete Customer's Information:");
        customerID = input.nextInt();
        int deletedata = 0;
        try {
            //delete data from a table of a database/schema
            Connection conn = getDBConnection();
            String deleteq = "delete from customer where CustomerID = '" + customerID + "'";
            PreparedStatement deletest = conn.prepareStatement(deleteq);
            deletedata = deletest.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (deletedata == 0) {
                System.out.println("No record has been deleted!");
            } else {
                System.out.println("The information has been deleted!");
            }

            Connection conn = getDBConnection();
            Statement st = conn.createStatement();
            DBRetrieval.customerDataview();

        }
    }

    static void datadeletionDrink() throws SQLException {
        Scanner input = new Scanner(System.in);
        int drinkID;

        //input data for deletion
        System.out.print("Enter the ID Number to Delete Its Drink Information:");
        drinkID = input.nextInt();
        int deletedata = 0;
        try {
            //delete data from a table of a database/schema
            Connection conn = getDBConnection();
            String deleteq = "delete from drink where DrinkID = '" + drinkID + "'";
            PreparedStatement deletest = conn.prepareStatement(deleteq);
            deletedata = deletest.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (deletedata == 0) {
                System.out.println("No record has been deleted!");
            } else {
                System.out.println("The information has been deleted!");
            }

            Connection conn = getDBConnection();
            Statement st = conn.createStatement();
            DBRetrieval.drinkDataview();

        }
    }

    static void datadeletionEmployee() throws SQLException {
        Scanner input = new Scanner(System.in);
        int employeeID;

        //input data for deletion
        System.out.print("Enter the ID Number to Delete Employee's Information:");
        employeeID = input.nextInt();
        int deletedata = 0;
        try {
            //delete data from a table of a database/schema
            Connection conn = getDBConnection();
            String deleteq = "delete from employee where EmployeeID = '" + employeeID + "'";
            PreparedStatement deletest = conn.prepareStatement(deleteq);
            deletedata = deletest.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (deletedata == 0) {
                System.out.println("No record has been deleted!");
            } else {
                System.out.println("The information has been deleted!");
            }

            Connection conn = getDBConnection();
            Statement st = conn.createStatement();
            DBRetrieval.employeeDataview();
        }

    }

    static void datadeletionOrders() throws SQLException {
        Scanner input = new Scanner(System.in);
        int orderID;

        //input data for deletion
        System.out.print("Enter the ID Number to Delete Order Information:");
        orderID = input.nextInt();
        int deletedata = 0;
        try {
            //delete data from a table of a database/schema
            Connection conn = getDBConnection();
            String deleteq = "delete from orders where OrderID = '" + orderID + "'";
            PreparedStatement deletest = conn.prepareStatement(deleteq);
            deletedata = deletest.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (deletedata == 0) {
                System.out.println("No record has been deleted!");
            } else {
                System.out.println("The information has been deleted!");
            }

            Connection conn = getDBConnection();
            Statement st = conn.createStatement();
            DBRetrieval.ordersDataview();
        }

    }

    static void datadeletionPayment() throws SQLException {
        Scanner input = new Scanner(System.in);
        int paymentID;

        //input data for deletion
        System.out.print("Enter the ID Number to Delete Payment Information:");
        paymentID = input.nextInt();
        int deletedata = 0;
        try {
            //delete data from a table of a database/schema
            Connection conn = getDBConnection();
            String deleteq = "delete from payment where PaymentID = '" + paymentID + "'";
            PreparedStatement deletest = conn.prepareStatement(deleteq);
            deletedata = deletest.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (deletedata == 0) {
                System.out.println("No record has been deleted!");
            } else {
                System.out.println("The information has been deleted!");
            }

            Connection conn = getDBConnection();
            Statement st = conn.createStatement();
            DBRetrieval.paymentDataview();
        }

    }

    static void datadeletionPizza() throws SQLException {
        Scanner input = new Scanner(System.in);
        int pizzaID;

        //input data for deletion
        System.out.print("Enter the ID Number to Delete Pizza Information:");
        pizzaID = input.nextInt();
        int deletedata = 0;
        try {
            //delete data from a table of a database/schema
            Connection conn = getDBConnection();
            String deleteq = "delete from pizza where PizzaID = '" + pizzaID + "'";
            PreparedStatement deletest = conn.prepareStatement(deleteq);
            deletedata = deletest.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (deletedata == 0) {
                System.out.println("No record has been deleted!");
            } else {
                System.out.println("The information has been deleted!");
            }

            Connection conn = getDBConnection();
            Statement st = conn.createStatement();
            DBRetrieval.pizzaDataview();
        }

    }

    static void datadeletionTopping() throws SQLException {
        Scanner input = new Scanner(System.in);
        int toppingID;

        //input data for deletion
        System.out.print("Enter the ID Number to Delete Topping Information:");
        toppingID = input.nextInt();
        int deletedata = 0;
        try {
            //delete data from a table of a database/schema
            Connection conn = getDBConnection();
            String deleteq = "delete from topping where ToppingID = '" + toppingID + "'";
            PreparedStatement deletest = conn.prepareStatement(deleteq);
            deletedata = deletest.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (deletedata == 0) {
                System.out.println("No record has been deleted!");
            } else {
                System.out.println("The information has been deleted!");
            }

            Connection conn = getDBConnection();
            Statement st = conn.createStatement();
            DBRetrieval.toppingDataview();
        }

    }

    static void datadeletionVehicle() throws SQLException {
        Scanner input = new Scanner(System.in);
        int vehicleID;

        //input data for deletion
        System.out.print("Enter the ID Number to Delete Vehicle Information:");
        vehicleID = input.nextInt();
        int deletedata = 0;
        try {
            //delete data from a table of a database/schema
            Connection conn = getDBConnection();
            String deleteq = "delete from vehicle where VehicleID = '" + vehicleID + "'";
            PreparedStatement deletest = conn.prepareStatement(deleteq);
            deletedata = deletest.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (deletedata == 0) {
                System.out.println("No record has been deleted!");
            } else {
                System.out.println("The information has been deleted!");
            }

            Connection conn = getDBConnection();
            Statement st = conn.createStatement();
            DBRetrieval.vehicleDataview();
        }

    }

}
