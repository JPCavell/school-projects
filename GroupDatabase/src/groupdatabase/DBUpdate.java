package groupdatabase;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/* Name: Jacob Cavell
 * Course: CSC 315
 * Project: GroupDatabase
 * File Name: DBUpdate.java
 */

/*
 * This program is an updating system for the database tables
 * In this class, the user will be provided a menu of options to choose what needs to be updated
 * The program will then communicate with MySQL to update the field chosen with the user input,
 * then displaying the table with the new information
 */
public class DBUpdate {

    public static Connection getDBConnection() throws SQLException {
        String connectionurl = "jdbc:mysql://127.0.0.1:3306/onlinepizzashop";
        String username = "root";
        String password = "root";
        Connection dbconn;
        try {
            //connection to a database
            dbconn = DriverManager.getConnection(connectionurl, username, password);
            return dbconn;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    static void customerDataModification(int option) throws SQLException {
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\\n");
        input.useDelimiter("\\n");
        int customerID, zipCode;
        String phoneNumber, customerfname, customermname, customerlname, state, city, street;
        char middleInitial;
        int updatedata = 0;
        option = 0;

        //input data for update
        System.out.print("Enter Customer ID:");

        customerID = input.nextInt();

        while (option <= 8) {
            System.out.println("\nWhat would you like to modify?");
            System.out.println("1: Phone Number");
            System.out.println("2: First Name");
            System.out.println("3: Middle Name");
            System.out.println("4: Last Name");
            System.out.println("5: Zip Code");
            System.out.println("6: State");
            System.out.println("7: City");
            System.out.println("8: Street");
            System.out.println("9: Exit Modification");
            System.out.print("Enter your option:");
            option = input.nextInt();

            Customer:
            try {
                //update data in a table of a database/schema
                String updateq = "";
                Connection conn = getDBConnection();
                if (option == 1) {
                    System.out.println("Enter Customer Number: ");
                    phoneNumber = input.next();
                    updateq = "update customer set PhoneNumber = '" + phoneNumber + "' where CustomerID = '" + customerID + "' ";
                } else if (option == 2) {
                    System.out.println("Enter First Name: ");
                    customerfname = input.next();
                    updateq = "update customer set FirstName = '" + customerfname + "' where CustomerID = '" + customerID + "' ";
                } else if (option == 3) {
                    System.out.println("Enter Middle Name: ");
                    customermname = input.next();
                    middleInitial = customermname.charAt(0);
                    updateq = "update customer set MiddleInitial = '" + middleInitial + "' where CustomerID = '" + customerID + "' ";
                } else if (option == 4) {
                    System.out.println("Enter Last Name: ");
                    customerlname = input.next();
                    updateq = "update customer set LastName = '" + customerlname + "' where CustomerID = '" + customerID + "' ";
                } else if (option == 5) {
                    System.out.println("Enter Zip Code: ");
                    zipCode = input.nextInt();
                    updateq = "update customer set ZipCode = '" + zipCode + "' where CustomerID = '" + customerID + "' ";
                } else if (option == 6) {
                    System.out.println("Enter State (abbreviated): ");
                    state = input.next();
                    updateq = "update customer set State = '" + state + "' where CustomerID = '" + customerID + "' ";
                } else if (option == 7) {
                    System.out.println("Enter City: ");
                    city = input.next();
                    updateq = "update customer set City = '" + city + "' where CustomerID = '" + customerID + "' ";
                } else if (option == 8) {
                    System.out.println("Enter Street: ");
                    street = input.next();
                    updateq = "update customer set Street = '" + street + "' where CustomerID = '" + customerID + "' ";
                } else {
                    String[] args = null;
                    GroupDatabase.main(args);
                    System.exit(0);
                }

                PreparedStatement updatest = conn.prepareStatement(updateq);
                updatedata = updatest.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                if (updatedata == 0) {
                    System.out.println("No record has been updated!");
                } else {
                    System.out.println("The information has been updated!");
                }

                Connection conn = getDBConnection();
                DBRetrieval.customerDataview();

            }
        }
    }

    static void drinkDataModification(int option) throws SQLException {
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\\n");
        int drinkID;
        String drinkName, drinkSize, drinkType;
        char sizeAbbreviation;
        int updatedata = 0;
        option = 0;

        //input data for update
        System.out.print("Enter Drink ID:");

        drinkID = input.nextInt();

        while (option <= 3) {
            System.out.println("\nWhat would you like to modify?");
            System.out.println("1: Name");
            System.out.println("2: Size");
            System.out.println("3: Type");
            System.out.println("4: Exit Modification");
            System.out.print("Enter your option:");
            option = input.nextInt();

            Drink:
            try {
                //update data in a table of a database/schema
                String updateq = "";
                Connection conn = getDBConnection();
                if (option == 1) {
                    System.out.println("Enter Drink Name: ");
                    drinkName = input.next();
                    updateq = "update drink set NameOfDrink = '" + drinkName + "' where DrinkID = '" + drinkID + "' ";
                } else if (option == 2) {
                    System.out.println("Enter Drink Size: ");
                    drinkSize = input.next();
                    sizeAbbreviation = drinkSize.charAt(0);
                    updateq = "update drink set Size = '" + sizeAbbreviation + "' where DrinkID = '" + drinkID + "' ";
                } else if (option == 3) {
                    System.out.println("Enter Drink Type: ");
                    drinkType = input.next();
                    updateq = "update drink set TypeOfDrink = '" + drinkType + "' where DrinkID = '" + drinkID + "' ";
                } else {
                    String[] args = null;
                    GroupDatabase.main(args);
                    System.exit(0);
                }

                PreparedStatement updatest = conn.prepareStatement(updateq);
                updatedata = updatest.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                if (updatedata == 0) {
                    System.out.println("No record has been updated!");
                } else {
                    System.out.println("The information has been updated!");
                }

                Connection conn = getDBConnection();
                DBRetrieval.drinkDataview();

            }
        }
    }

    static void employeeDataModification(int option) throws SQLException {
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\\n");
        String empGender, empfname, empmname, emplname;
        int empID, empAge;
        int updatedata = 0;
        char genderAbbreviation, middleInitial;
        option = 0;

        //input data for update
        System.out.print("Enter Employee ID:");

        empID = input.nextInt();

        while (option <= 5) {
            System.out.println("\nWhat would you like to modify?");
            System.out.println("1: Gender");
            System.out.println("2: Age");
            System.out.println("3: First Name");
            System.out.println("4: Middle Name");
            System.out.println("5: Last Name");
            System.out.println("6: Exit Modification");
            System.out.print("Enter your option:");
            option = input.nextInt();

            Employee:
            try {
                //update data in a table of a database/schema
                String updateq = "";
                Connection conn = getDBConnection();
                if (option == 1) {
                    System.out.println("Enter Gender: ");
                    empGender = input.next();
                    genderAbbreviation = empGender.charAt(0);
                    updateq = "update employee set Gender = '" + genderAbbreviation + "' where EmployeeID = '" + empID + "' ";
                } else if (option == 2) {
                    System.out.println("Enter Age: ");
                    empAge = input.nextInt();
                    updateq = "update employee set Age = '" + empAge + "' where EmployeeID = '" + empID + "' ";
                } else if (option == 3) {
                    System.out.println("Enter First Name: ");
                    empfname = input.next();
                    updateq = "update employee set FirstName = '" + empfname + "' where EmployeeID = '" + empID + "' ";
                } else if (option == 4) {
                    System.out.println("Enter Middle Name: ");
                    empmname = input.next();
                    middleInitial = empmname.charAt(0);
                    updateq = "update employee set MiddleInitial = '" + middleInitial + "' where EmployeeID = '" + empID + "' ";
                } else if (option == 5) {
                    System.out.println("Enter Last Name: ");
                    emplname = input.next();
                    updateq = "update employee set LastName = '" + emplname + "' where EmployeeID = '" + empID + "' ";
                } else {
                    String[] args = null;
                    GroupDatabase.main(args);
                    System.exit(0);
                }

                PreparedStatement updatest = conn.prepareStatement(updateq);
                updatedata = updatest.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                if (updatedata == 0) {
                    System.out.println("No record has been updated!");
                } else {
                    System.out.println("The information has been updated!");
                }

                Connection conn = getDBConnection();
                DBRetrieval.employeeDataview();

            }
        }
    }

    static void orderDataModification(int option) throws SQLException {
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\\n");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
        String stringDDate, stringODate, stringDTime, stringOTime;
        int orderID;
        double orderPrice;
        option = 0;
        int updatedata = 0;

        //input data for update
        System.out.print("Enter Order ID:");

        orderID = input.nextInt();

        while (option <= 5) {
            System.out.println("\nWhat would you like to modify?");
            System.out.println("1: Delivery Date");
            System.out.println("2: Order Date");
            System.out.println("3: Price");
            System.out.println("4: Delivery Time");
            System.out.println("5: Order Time");
            System.out.println("6: Exit Modification");
            System.out.print("Enter your option:");
            option = input.nextInt();

            Order:
            try {
                //update data in a table of a database/schema
                String updateq = "";
                Connection conn = getDBConnection();
                if (option == 1) {
                    System.out.println("Enter Delivery Date (yyyy-MM-dd): ");
                    stringDDate = input.next();
                    Date deliveryDate = dateFormatter.parse(stringDDate);
                    updateq = "update orders set DeliveryDate = '" + dateFormatter.format(deliveryDate) + "' where OrderID = '" + orderID + "' ";
                } else if (option == 2) {
                    System.out.println("Enter Order Date (yyyy-MM-dd): ");
                    stringODate = input.next();
                    Date orderDate = dateFormatter.parse(stringODate);
                    updateq = "update orders set OrderDate = '" + dateFormatter.format(orderDate) + "' where OrderID = '" + orderID + "' ";
                } else if (option == 3) {
                    System.out.println("Enter Price: ");
                    orderPrice = input.nextDouble();
                    updateq = "update orders set Price = '" + orderPrice + "' where OrderID = '" + orderID + "' ";
                } else if (option == 4) {
                    System.out.println("Enter Delivery Time (HH:mm:ss): ");
                    stringDTime = input.next();
                    Date deliveryTime = timeFormatter.parse(stringDTime);
                    updateq = "update orders set DeliveryTime = '" + timeFormatter.format(deliveryTime) + "' where OrderID = '" + orderID + "' ";
                } else if (option == 5) {
                    System.out.println("Enter Order Time: ");
                    stringOTime = input.next();
                    Date orderTime = timeFormatter.parse(stringOTime);
                    updateq = "update orders set OrderTime = '" + timeFormatter.format(orderTime) + "' where OrderID = '" + orderID + "' ";
                } else {
                    String[] args = null;
                    GroupDatabase.main(args);
                    System.exit(0);
                }

                PreparedStatement updatest = conn.prepareStatement(updateq);
                updatedata = updatest.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                if (updatedata == 0) {
                    System.out.println("No record has been updated!");
                } else {
                    System.out.println("The information has been updated!");
                }

                Connection conn = getDBConnection();
                DBRetrieval.ordersDataview();

            }
        }
    }

    static void paymentDataModification(int option) throws SQLException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\\n");
        String stringPDate, paymentType;
        int paymentID;
        double paymentAmount;
        option = 0;
        int updatedata = 0;

        //input data for update
        System.out.print("Enter Payment ID:");

        paymentID = input.nextInt();

        while (option <= 3) {
            System.out.println("\nWhat would you like to modify?");
            System.out.println("1: PaymentDate");
            System.out.println("2: Amount");
            System.out.println("3: Type");
            System.out.println("4: Exit Modification");
            System.out.print("Enter your option:");
            option = input.nextInt();

            Payment:
            try {
                //update data in a table of a database/schema
                String updateq = "";
                Connection conn = getDBConnection();
                if (option == 1) {
                    System.out.println("Enter Payment Date (yyyy-MM-dd): ");
                    stringPDate = input.next();
                    Date paymentDate = dateFormatter.parse(stringPDate);
                    updateq = "update payment set PaymentDate = '" + dateFormatter.format(paymentDate) + "' where PaymentID = '" + paymentID + "' ";
                } else if (option == 2) {
                    System.out.println("Enter Payment Amount: ");
                    paymentAmount = input.nextDouble();
                    updateq = "update payment set Amount = '" + paymentAmount + "' where PaymentID = '" + paymentID + "' ";
                } else if (option == 3) {
                    System.out.println("Enter Payment Type: ");
                    paymentType = input.next();
                    updateq = "update payment set TypeOfPayment = '" + paymentType + "' where PaymentID = '" + paymentID + "' ";
                } else {
                    String[] args = null;
                    GroupDatabase.main(args);
                    System.exit(0);
                }

                PreparedStatement updatest = conn.prepareStatement(updateq);
                updatedata = updatest.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                if (updatedata == 0) {
                    System.out.println("No record has been updated!");
                } else {
                    System.out.println("The information has been updated!");
                }

                Connection conn = getDBConnection();
                DBRetrieval.paymentDataview();

            }
        }
    }

    static void pizzaDataModification(int option) throws SQLException {
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\\n");
        int pizzaID;
        String crustType, pizzaSize;
        char sizeAbbreviation;
        int updatedata = 0;
        option = 0;

        //input data for update
        System.out.print("Enter Pizza ID:");

        pizzaID = input.nextInt();

        while (option <= 3) {
            System.out.println("\nWhat would you like to modify?");
            System.out.println("1: Crust");
            System.out.println("2: Size");
            System.out.println("3: Exit Modification");
            System.out.print("Enter your option:");
            option = input.nextInt();

            Pizza:
            try {
                //update data in a table of a database/schema
                String updateq = "";
                Connection conn = getDBConnection();
                if (option == 1) {
                    System.out.println("Enter Type of Pizza Crust: ");
                    crustType = input.next();
                    updateq = "update pizza set Crust = '" + crustType + "' where PizzaID = '" + pizzaID + "' ";
                } else if (option == 2) {
                    System.out.println("Enter Pizza Size: ");
                    pizzaSize = input.next();
                    sizeAbbreviation = pizzaSize.charAt(0);
                    updateq = "update pizza set Size = '" + sizeAbbreviation + "' where PizzaID = '" + pizzaID + "' ";
                } else {
                    String[] args = null;
                    GroupDatabase.main(args);
                    System.exit(0);
                }

                PreparedStatement updatest = conn.prepareStatement(updateq);
                updatedata = updatest.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                if (updatedata == 0) {
                    System.out.println("No record has been updated!");
                } else {
                    System.out.println("The information has been updated!");
                }

                Connection conn = getDBConnection();
                DBRetrieval.pizzaDataview();

            }
        }
    }

    static void toppingDataModification(int option) throws SQLException {
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\\n");
        int toppingID;
        String toppingType;
        int updatedata = 0;
        option = 0;

        //input data for update
        System.out.print("Enter Topping ID:");

        toppingID = input.nextInt();

        while (option <= 3) {
            System.out.println("\nWhat would you like to modify?");
            System.out.println("1: Type");
            System.out.println("2: Exit Modification");
            System.out.print("Enter your option:");
            option = input.nextInt();

            Topping:
            try {
                //update data in a table of a database/schema
                String updateq = "";
                Connection conn = getDBConnection();
                if (option == 1) {
                    System.out.println("Enter Type of Topping: ");
                    toppingType = input.next();
                    updateq = "update topping set TypeOfTopping = '" + toppingType + "' where ToppingID = '" + toppingID + "' ";
                } else {
                    String[] args = null;
                    GroupDatabase.main(args);
                    System.exit(0);
                }

                PreparedStatement updatest = conn.prepareStatement(updateq);
                updatedata = updatest.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                if (updatedata == 0) {
                    System.out.println("No record has been updated!");
                } else {
                    System.out.println("The information has been updated!");
                }

                Connection conn = getDBConnection();
                DBRetrieval.toppingDataview();

            }
        }
    }

    static void vehicleDataModification(int option) throws SQLException {
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\\n");
        int vehicleID;
        String vehicleDescription, vehicleType;
        int updatedata = 0;
        option = 0;

        //input data for update
        System.out.print("Enter Vehicle ID:");

        vehicleID = input.nextInt();

        while (option <= 3) {
            System.out.println("\nWhat would you like to modify?");
            System.out.println("1: Description");
            System.out.println("2: Type");
            System.out.println("3: Exit Modification");
            System.out.print("Enter your option:");
            option = input.nextInt();

            Vehicle:
            try {
                //update data in a table of a database/schema
                String updateq = "";
                Connection conn = getDBConnection();
                if (option == 1) {
                    System.out.println("Enter Description of Vehicle: ");
                    vehicleDescription = input.next();
                    updateq = "update vehicle set DescriptionOfVehicle = '" + vehicleDescription + "' where VehicleID = '" + vehicleID + "' ";
                } else if (option == 2) {
                    System.out.println("Enter Vehicle Type: ");
                    vehicleType = input.next();
                    updateq = "update vehicle set TypeOfVehicle = '" + vehicleType + "' where VehicleID = '" + vehicleID + "' ";
                } else {
                    String[] args = null;
                    GroupDatabase.main(args);
                    System.exit(0);
                }

                PreparedStatement updatest = conn.prepareStatement(updateq);
                updatedata = updatest.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                if (updatedata == 0) {
                    System.out.println("No record has been updated!");
                } else {
                    System.out.println("The information has been updated!");
                }

                Connection conn = getDBConnection();
                DBRetrieval.vehicleDataview();

            }
        }
    }

}
