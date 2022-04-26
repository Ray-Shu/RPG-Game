import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class MainStory {
    public static Printer print = new Printer();

    String playerName; 

    public String getName() {
        Scanner in = new Scanner(System.in);
        playerName = in.nextLine(); 
        return playerName;          
    }

    //*tells the player how they got to this new world. This is pre-character creation. 
    public static void prologue() {   
        System.out.println();

        Printer.print("\"Oi! Quit makin so much noise in there!\"\n" ); 
        quickBreak();
        print.printItalizcizedColor("You continue you're hammering; it's intentional. The guard stomps to the door.\n","white");
        quickBreak();
        Printer.print("\"Are you braindead!? It's late in the night, an' I'm tryna get some sleep!\"\n");
        quickBreak();
        print.printItalizcizedColor("You ignore the guard, continuing the cacophonous, ear-shredding sound of clashing metal. \nThe guard turns red with anger.\n", "white");
        quickBreak(); 
        Printer.print("\"I had 'bout enough of your shit, you insolent bastard! Know you're place!\"" + "\033[3m \nThe guard opens your cell door, ready to beat you into submission. \033[0m\n");
        quickBreak(); 
        print.printItalizcizedColor("The moment the guard walks through the door, the plan springs to action; \nsmoke enshrouds your cell, blinding the guard. And with your specialized \neyesight, you see perfectly, swiftly knocking the guard unconcious.\n", "white");
        quickBreak(); 
        print.printItalizcizedColor("An explosion breaks the cell wall behind you, right as you've just \nfinished blockading the door. \nSirens are blaring, and confused yelling ripples throughout the prison. \nTheir confusion isn't without reason, \nas the prison where you reside is notorious for it's ruthless security: \nDonning a nigh-to-zero breakout success rate.", "white");
        quickBreak(); 
        print.printItalizcizedColor("However, the comrades breaking you out of this corrupted hell-hole are equally, if not more, ruthless. \nExperts in their respective fields and unparalleled communication ", "white");

        System.out.println();
    }

    public static void quickBreak() {
        try {
                Thread.sleep(1000);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
}
}
