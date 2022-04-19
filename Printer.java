public class Printer {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    /**
     * This method prints out a string one word at a time, in white. 
     * @param whatToPrint = the thing we print 1 word at a time. 
     */
    public void print (String whatToPrint){
        while (!whatToPrint.isEmpty()) {
            whatToPrint.split(" ", 0);
        }
        System.out.println();
    }


    /**
     * Prints the thing in color
     * @param whatToPrint = the message we want to print
     * @param color = the string version of the color we will use
     */
    public void printColor(String whatToPrint, String color){
        switch (color.toLowerCase()) {
            case "red":
                System.out.print(ANSI_RED);
                break;
            case "black":
                System.out.print(ANSI_RED);
                break;
            case "green":
                System.out.print(ANSI_RED);
                break;
            case "yellow":
                System.out.print(ANSI_RED);
                break;
            case "blue":
                System.out.print(ANSI_RED);
                break;
            case "purple":
                System.out.print(ANSI_RED);
                break;
            case "cyan":
                System.out.print(ANSI_RED);
                break;
            case "white":
                System.out.print(ANSI_RED);
                break;
        }
        print(whatToPrint);
        System.out.println(ANSI_RESET);
        }
    
    }
