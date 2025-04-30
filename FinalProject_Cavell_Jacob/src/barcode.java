/*//////////////////////////////////////////
/                                          /
/   barcode.java    Author: Jacob Cavell   /
/                                          /
/      Program that recieves individual    /
/   ZIP code characters (or digits) from   /
/     ZIPcode.java in order to display     /
/     each numbers respective bar combo    /
/      and calculates, sends, recieves,    /
/       and finally displays the combo     /
/     for the correction Character digit   /
//////////////////////////////////////////*/
public class barcode {

    public void barDisplay(char ZIPdigit) {
        //void method named barDisplay that will display the half or whole bar combo to whatever char is retrieved from ZIPnumbers or correctionCharacter
        //retrieves each individual char from ZIPnumbers while it's in the for loop in ZIPcode.java and names it ZIPdigit respectively

        //originally formatted as an if statement chain but netbeans liked it better as a rule switch chain
        switch (ZIPdigit) { //checks which digit is provided and prints the bar combo assigned to that digit
            case '0' ->
                System.out.print("||:::");
            case '1' ->
                System.out.print(":::||");
            case '2' ->
                System.out.print("::|:|");
            case '3' ->
                System.out.print("::||:");
            case '4' ->
                System.out.print(":|::|");
            case '5' ->
                System.out.print(":|:|:");
            case '6' ->
                System.out.print(":||::");
            case '7' ->
                System.out.print("|:::|");
            case '8' ->
                System.out.print("|::|:");
            default ->
                System.out.print("|:|::");
        }

    }   //method that calculates and returns an integer that represents the correction character, ZIPnumbers keeps its name

    public int correctionCharacter(String ZIPnumbers) {
        int ZIPsum = 0;//integer ZIPsum to represent the sum of all individual ZIP code numbers
        int smaller10;//integer to represent the next smallest 10
        int next10;//integer to represent the next larger 10
        int correctCharacter;//integer to represent the correct character

        //for loop that uses the .getNumericValue command for every character retrieved from string ZIPnumbers with .charAt command, cycles 9 times for full ZIPcode
        for (int i = 0; i < 9; i++) {
            ZIPsum = ZIPsum + Character.getNumericValue(ZIPnumbers.charAt(i));
        }

        //math equation to get the closest smallest 10, assigns to smaller10
        smaller10 = (ZIPsum / 10) * 10;

        //if else statement to failsafe if a number is in the 10s (EX: 10,20,30,40,50,etc.)
        if (ZIPsum == smaller10) { //if the sum is in the 10s
            next10 = smaller10; //next10 will be assigned to smaller10 since it is the next 10 (EX: 40 is 40's next 10)
        } else { //if the sum is not in the 10s
            next10 = smaller10 + 10; //the next 10 will be assigned to next10 (EX: 60 will be 51s next 10)
        }

        //calculation to get the correctionCharacter, next10 minus ZIPsum, solution assigned to correctCharacter
        correctCharacter = next10 - ZIPsum;
        return correctCharacter;//returns the integer correctCharacter
    }

}
