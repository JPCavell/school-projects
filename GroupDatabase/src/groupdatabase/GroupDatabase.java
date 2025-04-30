package groupdatabase;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

/* Name: Jacob Cavell
 * Course: CSC 315
 * Project: GroupDatabase
 * File Name: GroupDatabase.java
 */

/*
 * This program is an online Pizza Database system
 * In this class, the user will be provided a menu of tables to selct from
 * Depending on the input, a certian class assigned to the table will be called
 */
public class GroupDatabase {


    public static void main(String[] args) throws SQLException, ParseException {

        int option = 0;
        Scanner keypress = new Scanner(System.in);

        while (option < 1) {
            System.out.println("-------------------------------------");
            System.out.println("| Online Pizza Shop Database System |");
            System.out.println("-------------------------------------");
            System.out.println("Please select a Data table");
            System.out.println("1: Customer");
            System.out.println("2: Drink");
            System.out.println("3: Employee");
            System.out.println("4: Orders");
            System.out.println("5: Payment");
            System.out.println("6: Pizza");
            System.out.println("7: Topping");
            System.out.println("8: Vehicle");
            System.out.println("9 or higher: Exit");
            System.out.print("Enter your option:");
            option = keypress.nextInt();

            if (option < 1) {
                System.out.println("Invalid entry, Please try again.");
            } else if (option == 1) {
                DBCustomer customer = new DBCustomer();
                customer.CustomerTable(option, keypress);

            } else if (option == 2) {
                DBDrink drink = new DBDrink();
                drink.DrinkTable(option, keypress);
            } else if (option == 3) {
                DBEmployee employee = new DBEmployee();
                employee.EmployeeTable(option, keypress);
            } else if (option == 4) {
                DBOrders orders = new DBOrders();
                orders.OrdersTable(option, keypress);
            } else if (option == 5) {
                DBPayment payment = new DBPayment();
                payment.PaymentTable(option, keypress);
            } else if (option == 6) {
                DBPizza pizza = new DBPizza();
                pizza.PizzaTable(option, keypress);

            } else if (option == 7) {
                DBTopping topping = new DBTopping();
                topping.ToppingTable(option, keypress);

            } else if (option == 8) {
                DBVehicle vehicle = new DBVehicle();
                vehicle.VehicleTable(option, keypress);

            }
        }

    }
}
