
import java.util.Scanner;

public class errorChecker {


    /**
     * Does some error checking to make sure that an inputted value is greater than a min. 
     * @param min = the minimum value possible
     * @param whatToSayAtStart is the thing we say before we do our error checking. 
     */
    public static int intWithMinNoMax(int min, String whatToSayAtStart) {
        Scanner scan = new Scanner(System.in);
        boolean restart = true;
        int value;
        System.out.print(whatToSayAtStart);
        do {
            //makes sure its an integer
            while (!scan.hasNextInt()) {
                System.out.print("Error: Please enter an number greater than " + (min-1) + ": ");
                scan.next();
            }
            value = scan.nextInt();
            
            //makes sure that the value is greater than the min
            if(value < min){
                System.out.print("Error: Please enter an number greater than " + (min-1) + ": ");
            }
            else{
                return value;
            }
        } while (restart);
        return -1;
    }


    /**
     * Gets a value within a range on min and max(Inclusive)
     * @param min = the min value
     * @param max = the max value
     * @param whatToSayAtStart = The thing we start by saying
     * @return my value taken in if it is acceptable. 
     */
    public static int intWithMinAndMax(int min, int max, String whatToSayAtStart) {
        Scanner scan = new Scanner(System.in);
        System.out.print(whatToSayAtStart);
        //Repeats until we fet a nice number
        while (true) {
            //makes sure its an int
            while (!scan.hasNextInt()) {
                System.out.print("Error: Please enter an number greater than " + min + " and less than " + max + ": ");
                scan.next();
            }
            int value = scan.nextInt();
            //makes sure its in range. Loops if it is not
            if(value < min || value > max){
                System.out.print("Error: Please enter an number greater than " + min + " and less than " + max + ": ");
            }
            else{
                return value;
            }
        }
    }
    

    /**
     * Gets user to input one of the values in the array of possibleInputs, and then we will pass out the number which it is in. 
     * @param possibleInputs = The possible answers we want. 
     * @param whatToSayAtStart = What we say at the start of running the code. 
     * @return the value in the array that the user inputted. 
     */
    public static int compareArrayOfStrings(String[] possibleInputs, String whatToSayAtStart){
        Scanner scan = new Scanner(System.in);
        System.out.print(whatToSayAtStart);
        while (true) {
            String input = scan.nextLine().toLowerCase(); 
            //for each element in the array, we will check if the user inputted that word. If not any of them, we will loop. 
            for (int i = 0; i < possibleInputs.length; i++) {
                    if(input.equalsIgnoreCase(possibleInputs[i]) ){
                            System.out.println();
                            return i;
                        }
                    }
        System.out.print("Error: Please enter a valid input: ");
        }
    }

}
