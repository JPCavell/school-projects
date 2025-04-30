/*//////////////////////////////////////////
/                                          /
/   ZIPcode.java    Author: Jacob Cavell   /
/                                          /
/      Program that takes a ZIP code       /
/   a user provides and sends/retrieves    /
/     info to barcode.java in order to     /
/        print the bar code that is        /
/        associated to the ZIP code.       /
//////////////////////////////////////////*/

import java.util.Scanner; //importing scanner to scan

public class ZIPcode {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in); //creating a new scanner named scnr

        int correctionCharacter; //integer for the correction Character of the bar code
        boolean loopCheck = true; //boolean variable named loopCheck that will check if the program should run again

        //while loop that will loop most of the program again if loopCheck stays true
        while (loopCheck == true) {

            //variables declared inside of loop so most of them are wiped/rewritten when a new loop begins    
            int ZIPcode = 0;//integer named ZIPcode that will store the ZIP code the user enters
            boolean ZIPcheck = false;//boolean variable named ZIPcheck that will check if the ZIP code entered is valid or not
            boolean oneDigit = false;//boolean variable named oneDigit that will check if the user entered one digit
            String ZIPnumbers = "";//string named ZIPnumbers that will store the valid ZIP code, then have each character extracted into barcode.java

            //while loop to check if ZIP code entered is valid or not, loops if ZIPcheck stays false
            while (ZIPcheck == false) {
                //prompting user to enter a nine or five digit digit ZIP code, one digit for an example of its bar combo
                System.out.println("\nPlease enter a nine or five digit ZIP code, or type one digit for an example of its bar combo.");
                ZIPcode = scnr.nextInt();//taking the input and assigning it to ZIPcode

                //if statement chain that will decide whether or not the ZIP code provided is valid, three cases for validity
                if (ZIPcode <= 100000 && ZIPcode > 9999) { //five digit zip code is provided, rubric says this will also be a valid input, code below adjusts to such
                    ZIPcheck = true;//assigns ZIPcheck to true to stop loop
                    ZIPnumbers = Integer.toString(ZIPcode);//changes integer ZIPcode to string ZIPnumbers for character extraction, see next line for more info
                    ZIPnumbers = ZIPnumbers + "0000";//there are three different cases where ZIPcode changes to ZIPnumbers, in this case we need to add the +4 digits in this case to have a nine digit ZIP code
                    System.out.println("Five digit ZIP code entered. +4 code will default to 0000.");//rubric says to default +4 digits to 0000 on a five digit ZIP code, informs user of this
                } else if (ZIPcode >= 0 && ZIPcode < 10) {//one digit is provided, rubric says program should be able to take one digit and return correct bars, this will act as an example path
                    ZIPcheck = true;//assigns ZIPcheck to true to stop loop
                    oneDigit = true;//assigns oneDigit to true to use the one digit path of code
                    ZIPnumbers = Integer.toString(ZIPcode);//changes integer ZIPcode to string ZIPnumbers for character extraction
                    System.out.println("One number entered. Bar combo example for one digit will display.");//informs the user that they entered one digit and the program will show an example of that digit's bar combo
                } else if (ZIPcode >= 1000000000 || ZIPcode <= 99999999) { //invalid ZIP code is provided
                    System.out.println("\nInvalid ZIP code. Please try again.\n");//informs user that what they've entered is Invalid and to try again, ZIPcheck stays false and loop will restart
                } else { //nine digit ZIP code is provided
                    ZIPcheck = true;//assigns ZIPcheck to true to stop loop
                    ZIPnumbers = Integer.toString(ZIPcode);//changes integer ZIPcode to string ZIPnumbers for character extraction
                }
            }

            //if else statement to break up the one digit example path and the nine/five digit path
            if (oneDigit != true) { //nine/five digit path

                //now we have a valid nine digit zip code stored in string ZIPnumbers ready for character extraction
                System.out.println("\nYour bar code is:\n");//begins bar code display
                System.out.print("|"); //starting frame bar
                barcode barcode = new barcode();//creates new call to class named barcode
                for (int i = 0; i < 9; i++) {//for loop that cycles nine times for each character in the ZIPnumbers string
                    barcode.barDisplay(ZIPnumbers.charAt(i));//every loop will send each individual character (or ZIP code number) to barcode.java inside the barDisplay method
                }//now would be a good time to look over at barcode.java to follow whats happening in the barDisplay method

                //now that we have all of the ZIP code stored and its barcode printed, we need to send the ZIPcode to the method correctionCharacter in barcode.java
                //sends ZIPnumbers to correctionCharacter where it will return an integer that gets assigned to the integer of the same name
                //go to correctionCharacter method in barcode.java to follow what happens next
                correctionCharacter = barcode.correctionCharacter(ZIPnumbers);

                //now that we have the correctionCharacter, we need to display its barcombo so we call barDisplay again, declaring correctionCharacter as a char
                barcode.barDisplay((char) (correctionCharacter + '0'));
                System.out.print("|\n"); //ending frame bar 
                loopCheck = reDO(scnr, loopCheck);//sends scnr and loopCheck for use in reDo mthod
                //assigning loopCheck to what boolean value is returned In the reDo method

            } else {//one digit path

                System.out.print("\nThe bar combo for " + ZIPnumbers + " is ");//beginning example display for one digit
                barcode barcode = new barcode();//creates new call to class named barcode
                barcode.barDisplay(ZIPnumbers.charAt(0));//sends the one digit to barDisplay method in barcode.java, now would be a good time to look at that class to follow the next step
                //the char will always be at 0 since we've established that this is only one digit (or a singular character string)

                //now that we have given the example of what the bar combo would look like for the one digit, we ask if the program should repeat
                loopCheck = reDO(scnr, loopCheck);//sends scnr and loopCheck for use in reDo mthod
                //assigning loopCheck to what boolean value is returned In the reDo method

                //doing this is necessary in both cases so the program will end when its told to
            }

        }
    }

    //reDO method that will ask and return the boolean value loopCheck to decide if the program will repeat or not
    public static boolean reDO(Scanner scnr, boolean loopCheck) {
        String userTyped; //string named userTyped that is associated with loopCheck and will be used as the user input on if they want to repeat or not
        //do while loop to check if the user entered a valid answer, loops as long as reDocheck is set to true
        boolean reDocheck = true;//boolean variable reDocheck set to true
        do {
            //prompts user to either repeat or exit the program by entering Yes or No
            System.out.println("\nWould you like to enter another ZIP Code? (Enter \"Yes\" to generate another bar code, or \"No\" to exit.)");
            userTyped = scnr.next();//scans what the user types and stores it in string userTyped

            //rule switch chain to decide if what the user entered was valid and to either exit or repeat the program
            switch (userTyped) {
                case "No" -> {//case No sets both boolean variables to false as it is a valid input and ends the program
                    loopCheck = false;
                    reDocheck = false;
                }
                case "Yes" ->
                    reDocheck = false;//case Yes is a valid input so reDocheck is set to false, but loopCheck stays true
                default ->
                    System.out.println("\nInvalid input. Please try again.");
            }//default case is any other input, informs the user that input is invalid and to try again, reDocheck loops as no variables are changed

        } while (reDocheck == true);
        return loopCheck; //returns the loopCheck variable to either repeat or end the program
    }

}
