package groupdatabase;

import java.util.Scanner;
import java.sql.SQLException;
import java.text.ParseException;

/* Name: Jacob Cavell
 * Course: CSC 315
 * Project: GroupDatabase
 * File Name: DBEmployee.java
 */

/*
 * This program is an options menu for the employee table in the database
 * In this class, the user will be provided a menu of options to choose what they want to do with the table
 * Depending on the user input, a class will be called for editing
 */
public class DBEmployee {

    public void EmployeeTable(int option, Scanner keypress) throws SQLException, ParseException {
        option = 0;

        while (option <= 4) {
            System.out.println("-------------------------------------");
            System.out.println("| Online Pizza Shop Database System |");
            System.out.println("-------------------------------------");
            System.out.println("1: Retreive Employee Data");
            System.out.println("2: Enter Employee");
            System.out.println("3: Delete Employee");
            System.out.println("4: Modify Employee");
            System.out.println("5: Change Data Table");
            System.out.println("6 or higher: Exit");
            System.out.print("Enter your option:");
            option = keypress.nextInt();

            if (option == 1) {
                DBRetrieval.employeeDataview();
            } else if (option == 2) {
                DBInsertion.employeeDataInsertion();
            } else if (option == 3) {
                DBDeletion.datadeletionEmployee();
            } else if (option == 4) {
                DBUpdate.employeeDataModification(option);
            } else if (option == 5) {
                String[] args = null;
                GroupDatabase.main(args);
            }
        }

    }

}
