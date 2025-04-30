package groupdatabase;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

/* Name: Jacob Cavell
 * Course: CSC 315
 * Project: GroupDatabase
 * File Name: DBVehicle.java
 */

/*
 * This program is an options menu for the vehicle table in the database
 * In this class, the user will be provided a menu of options to choose what they want to do with the table
 * Depending on the user input, a class will be called for editing
 */
class DBVehicle {

    public void VehicleTable(int option, Scanner keypress) throws SQLException, ParseException {
        option = 0;

        while (option <= 4) {
            System.out.println("-------------------------------------");
            System.out.println("| Online Pizza Shop Database System |");
            System.out.println("-------------------------------------");
            System.out.println("1: Retreive Vehicle Data");
            System.out.println("2: Enter Vehicle");
            System.out.println("3: Delete Vehicle");
            System.out.println("4: Modify Vehicle");
            System.out.println("5: Change Data Table");
            System.out.println("6 or higher: Exit");
            System.out.print("Enter your option:");
            option = keypress.nextInt();

            if (option == 1) {
                DBRetrieval.vehicleDataview();
            } else if (option == 2) {
                DBInsertion.vehicleDataInsertion();
            } else if (option == 3) {
                DBDeletion.datadeletionVehicle();
            } else if (option == 4) {
                DBUpdate.vehicleDataModification(option);
            } else if (option == 5) {
                String[] args = null;
                GroupDatabase.main(args);
            }
        }

    }

}
