public class Printer {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String START_ITALICIZED = "\033[3m";
    private static final String END_ITALICIZED = "\033[0m";
    
    /**
     * This method prints out a string one word at a time, in white. 
     * @param whatToPrint = the thing we print 1 word at a time. 
     */
    public static void print (String whatToPrint){
        //splits the words at all the spaces
        String words[] = whatToPrint.split(" ");

        //prints out each word from the array of words
        for (String word : words) {
            try {
                Thread.sleep(90);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(word+ " ");

            //waits a few seconds. In try catch bc VS code told me too. Something about an error
        }
        System.out.println();
    }


    /**
     * Prints the thing in color
     * @param whatToPrint = the message we want to print
     * @param color = the string version of the color we will use
     */
    public static void printColor(String whatToPrint, String color){
        //sets the color to one of our colors which was found here: https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
        switch (color.toLowerCase()) {
            case "red":
                System.out.print(ANSI_RED);
                break;
            case "black":
                System.out.print(ANSI_BLACK);
                break;
            case "green":
                System.out.print(ANSI_GREEN);
                break;
            case "yellow":
                System.out.print(ANSI_YELLOW);
                break;
            case "blue":
                System.out.print(ANSI_BLUE);
                break;
            case "purple":
                System.out.print(ANSI_PURPLE);
                break;
            case "cyan":
                System.out.print(ANSI_CYAN);
                break;
            case "white":
                System.out.print(ANSI_WHITE);
                break;
        }
        print(whatToPrint);
        System.out.print(ANSI_RESET);
        //prints out the color and sets it to white. 
    
        }

        /**
         * Prints out the string italicized. 
         */
        public void printItalizcizedColor (String whatToPrint, String color){
           printColor(START_ITALICIZED + whatToPrint + END_ITALICIZED , color);
        }
    }


