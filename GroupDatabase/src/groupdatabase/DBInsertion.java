package groupdatabase;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

/* Name: Jacob Cavell
 * Course: CSC 315
 * Project: GroupDatabase
 * File Name: DBInsertion.java
 */

/*
 * This program is an insertion system for the database tables
 * In this class, the user will be provided multiple prompts for each column to fill in
 * The program will then communicate with MySQL to insert the field chosen with the user input, 
 * then displaying the table with the new information
 */
public class DBInsertion {

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

    static void customerDataInsertion() throws SQLException {
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\\n");
        int customerID, zipCode;
        String phoneNumber, customerfname, customermname, customerlname, state, city, street;
        char middleInitial;

        //input data for insertion
        System.out.print("Enter Customer ID:");
        customerID = input.nextInt();
        System.out.println("Enter Customer's Phone Number:");
        phoneNumber = input.next();
        System.out.print("Enter Customer's First Name:");
        customerfname = input.next();
        System.out.print("Enter Customer's Middle name:");
        customermname = input.next();
        middleInitial = customermname.charAt(0);
        System.out.println("Enter Customer's Last Name:");
        customerlname = input.next();
        System.out.print("Enter Customer's Zip Code:");
        zipCode = input.nextInt();
        System.out.println("Enter Customer's State (Abbreviated):");
        state = input.next();
        System.out.println("Enter Customer's City:");
        city = input.next();
        System.out.println("Enter Customer's Street:");
        street = input.next();

        try {
            //insert data into a table of a database/schema
            Connection conn = getDBConnection();
            String insertq = "insert into customer(CustomerID,PhoneNumber,FirstName,MiddleInitial,LastName,ZipCode,State,City,Street) values ('" + customerID + "','" + phoneNumber + "','" + customerfname + "','" + middleInitial + "', '" + customerlname + "', '" + zipCode + "', '" + state + "', '" + city + "', '" + street + "')";
            PreparedStatement insertst = conn.prepareStatement(insertq);
            insertst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("The record has been inserted!");

            Connection conn = getDBConnection();
            Statement st = conn.createStatement();
            DBRetrieval.customerDataview();

        }
    }

    static void drinkDataInsertion() throws SQLException {
        Scanner input = new Scanner(System.in);
        int drinkID;
        String drinkName, drinkSize, drinkType;
        char sizeAbbreviation;

        //input data for insertion
        System.out.print("Enter Drink ID:");
        drinkID = input.nextInt();
        System.out.println("Enter Drink Name:");
        drinkName = input.next();
        System.out.print("Enter Drink Size:");
        drinkSize = input.next();
        sizeAbbreviation = drinkSize.charAt(0);
        System.out.println("Enter Drink Type:");
        drinkType = input.next();

        try {
            //insert data into a table of a database/schema
            Connection conn = getDBConnection();
            String insertq = "insert into drink(DrinkID,NameOFDrink,Size,TypeOfDrink) values ('" + drinkID + "','" + drinkName + "','" + sizeAbbreviation + "','" + drinkType + "')";
            PreparedStatement insertst = conn.prepareStatement(insertq);
            insertst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("The record has been inserted!");

            Connection conn = getDBConnection();
            Statement st = conn.createStatement();
            DBRetrieval.drinkDataview();

        }

    }

    static void employeeDataInsertion() throws SQLException {
        Scanner input = new Scanner(System.in);
        int empID, empAge;
        String empGender, empfname, empmname, emplname;
        char genderAbbreviation, middleInitial;

        //input data for insertion
        System.out.print("Enter Employee ID:");
        empID = input.nextInt();
        System.out.println("Enter Employee Gender:");
        empGender = input.next();
        genderAbbreviation = empGender.charAt(0);
        System.out.print("Enter Employee's Age:");
        empAge = input.nextInt();
        System.out.print("Enter Employee's Firstname:");
        empfname = input.next();
        System.out.println("Enter Employee's Middle Name:");
        empmname = input.next();
        middleInitial = empmname.charAt(0);
        System.out.print("Enter Employee's Lastname:");
        emplname = input.next();

        try {
            //insert data into a table of a database/schema
            Connection conn = getDBConnection();
            String insertq = "insert into employee(EmployeeID,Gender,Age,FirstName,MiddleInitial,LastName) values ('" + empID + "','" + genderAbbreviation + "','" + empAge + "','" + empfname + "', '" + middleInitial + "', '" + emplname + "')";
            PreparedStatement insertst = conn.prepareStatement(insertq);
            insertst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("The record has been inserted!");

            Connection conn = getDBConnection();
            Statement st = conn.createStatement();
            DBRetrieval.employeeDataview();

        }
    }

    static void ordersDataInsertion() throws SQLException, ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
        String stringDDate, stringODate, stringDTime, stringOTime;
        Scanner input = new Scanner(System.in);
        int orderID;
        double orderPrice;

        //input data for insertion
        System.out.print("Enter Order ID:");
        orderID = input.nextInt();
        System.out.println("Enter Delivery Date (yyyy-MM-dd):");
        stringDDate = input.next();
        Date deliveryDate = dateFormatter.parse(stringDDate);
        System.out.println("Enter Order Date (yyyy-MM-dd):");
        stringODate = input.next();
        Date orderDate = dateFormatter.parse(stringODate);
        System.out.print("Enter Order Price:");
        orderPrice = input.nextDouble();
        System.out.println("Enter Delivery Time (HH:mm:ss):");
        stringDTime = input.next();
        Date deliveryTime = timeFormatter.parse(stringDTime);
        System.out.println("Enter Order Time (HH:mm:ss):");
        stringOTime = input.next();
        Date orderTime = timeFormatter.parse(stringOTime);

        try {
            //insert data into a table of a database/schema
            Connection conn = getDBConnection();
            String insertq = "insert into orders(OrderID,DeliveryDate,OrderDate,Price,DeliveryTime,OrderTime) values ('" + orderID + "','" + dateFormatter.format(deliveryDate) + "','" + dateFormatter.format(orderDate) + "','" + orderPrice + "', '" + timeFormatter.format(deliveryTime) + "', '" + timeFormatter.format(orderTime) + "')";
            PreparedStatement insertst = conn.prepareStatement(insertq);
            insertst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("The record has been inserted!");

            Connection conn = getDBConnection();
            Statement st = conn.createStatement();
            DBRetrieval.ordersDataview();

        }
    }

    static void paymentDataInsertion() throws SQLException, ParseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String stringPDate, paymentType;
        Scanner input = new Scanner(System.in);
        int paymentID;
        double paymentAmount;

        //input data for insertion
        System.out.print("Enter Payment ID:");
        paymentID = input.nextInt();
        System.out.println("Enter Payment Date (yyyy-MM-dd):");
        stringPDate = input.next();
        Date paymentDate = dateFormatter.parse(stringPDate);
        System.out.print("Enter Payment Amount:");
        paymentAmount = input.nextDouble();
        System.out.println("Enter Payment Type:");
        paymentType = input.next();

        try {
            //insert data into a table of a database/schema
            Connection conn = getDBConnection();
            String insertq = "insert into payment(PaymentID,PaymentDate,Amount,TypeOfPayment) values ('" + paymentID + "','" + dateFormatter.format(paymentDate) + "','" + paymentAmount + "','" + paymentType + "')";
            PreparedStatement insertst = conn.prepareStatement(insertq);
            insertst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("The record has been inserted!");

            Connection conn = getDBConnection();
            Statement st = conn.createStatement();
            DBRetrieval.paymentDataview();

        }
    }

    static void pizzaDataInsertion() throws SQLException {
        Scanner input = new Scanner(System.in);
        int pizzaID;
        String crustType, pizzaSize;
        char sizeAbbreviation;

        //input data for insertion
        System.out.print("Enter Pizza ID:");
        pizzaID = input.nextInt();
        System.out.println("Enter Type of Pizza Crust:");
        crustType = input.next();
        System.out.print("Enter Pizza Size:");
        pizzaSize = input.next();
        sizeAbbreviation = pizzaSize.charAt(0);

        try {
            //insert data into a table of a database/schema
            Connection conn = getDBConnection();
            String insertq = "insert into pizza(PizzaID,Crust,Size) values ('" + pizzaID + "','" + crustType + "','" + sizeAbbreviation + "')";
            PreparedStatement insertst = conn.prepareStatement(insertq);
            insertst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("The record has been inserted!");

            Connection conn = getDBConnection();
            Statement st = conn.createStatement();
            DBRetrieval.pizzaDataview();

        }

    }

    static void toppingDataInsertion() throws SQLException {
        Scanner input = new Scanner(System.in);
        int toppingID;
        String toppingType;

        //input data for insertion
        System.out.print("Enter Topping ID:");
        toppingID = input.nextInt();
        System.out.println("Enter Type of Topping:");
        toppingType = input.next();

        try {
            //insert data into a table of a database/schema
            Connection conn = getDBConnection();
            String insertq = "insert into topping(ToppingID,TypeOfTopping) values ('" + toppingID + "','" + toppingType + "')";
            PreparedStatement insertst = conn.prepareStatement(insertq);
            insertst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("The record has been inserted!");

            Connection conn = getDBConnection();
            Statement st = conn.createStatement();
            DBRetrieval.toppingDataview();

        }

    }

    static void vehicleDataInsertion() throws SQLException {
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\\n");
        int vehicleID;
        String vehicleDescription, vehicleType;

        //input data for insertion
        System.out.print("Enter Vehicle ID:");
        vehicleID = input.nextInt();
        System.out.println("Enter Description of Vehicle:");
        vehicleDescription = input.next();
        System.out.print("Enter Vehicle Type:");
        vehicleType = input.next();

        try {
            //insert data into a table of a database/schema
            Connection conn = getDBConnection();
            String insertq = "insert into vehicle(VehicleID,DescriptionOfVehicle,TypeOFVehicle) values ('" + vehicleID + "','" + vehicleDescription + "','" + vehicleType + "')";
            PreparedStatement insertst = conn.prepareStatement(insertq);
            insertst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("The record has been inserted!");

            Connection conn = getDBConnection();
            Statement st = conn.createStatement();
            DBRetrieval.vehicleDataview();

        }

    }

}
