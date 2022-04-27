import java.util.Scanner;

public class MainStory {
    public static Printer print = new Printer();

    String playerName; 

    Player mainPlayer = new Player();
    Scanner in = new Scanner(System.in);

    public String getName() {
        playerName = in.nextLine(); 
        return playerName;          
    }

    //*tells the player how they got to this new world. This is pre-character creation. 
    public void prologue() {   
        System.out.println();

        // Printer.print("\"Oi! Quit makin so much noise in there!\"\n" ); 
        // quickBreak();
        // Printer.printItalizcizedColor("You continue you're hammering; it's intentional. The guard stomps to the door.\n","white");
        // quickBreak();
        // Printer.print("\"Are you braindead!? It's late in the night, an' I'm tryna get some sleep!\"\n");
        // quickBreak();
        // Printer.printItalizcizedColor("You ignore the guard, continuing the cacophonous, ear-shredding sound of clashing Spectral  \nThe guard turns red with anger.\n", "white");
        // quickBreak(); 
        // Printer.print("\"I had 'bout enough of your shit, you insolent bastard! Know you're place!\"" + "\033[3m \nThe guard opens your cell door, ready to beat you into submission. \033[0m\n");
        // quickBreak(); 
        // Printer.printItalizcizedColor("The moment the guard walks through the door, the plan springs to action; \nsmoke enshrouds your cell, blinding the guard. And with your specialized \neyesight, you see perfectly, swiftly knocking the guard unconcious.\n", "white");
        // quickBreak(); 
        // Printer.printItalizcizedColor("An explosion breaks the cell wall behind you, right as you've just \nfinished blockading the door. Sirens are blaring, and confused yelling \nripples throughout the prison.\n", "white");
        // quickBreak(); 
        // Printer.printItalizcizedColor("Their confusion isn't without reason, \nas the prison where you reside in is notorious for it's ruthless security: \nDonning a nigh-to-zero breakout success rate.\n", "white");
        // quickBreak(); 
        // Printer.printItalizcizedColor("However, the mysterious people breaking you out of this corrupted hell-hole are \nequally, if not more, ruthless. Experts in their respective fields and \nunparalleled communication, paired with amazing teamwork shatters the prison's \nrecord. You and this unknown lot quickly escape before reinforcements are called.\n", "white");
        // quickBreak(); 
        // Printer.printItalizcizedColor("Four individuals lead you to a shelter; it's barren, save for a dim fire \nand some Spectral crates tossed to the side. The floor is slightly damp \nfrom yesterdays torrent and the neon lights just outside are flickering, \nas if their vitality is being drained away.\n", "white");
        // quickBreak(); 
        // Printer.print("\"Hey\"! \033[3mA gruff voice calls out to you. \033[0m" + "\"Whats your name, \u001B[31mMister Executioner?\" \u001B[31m");
        // getName();
        // in.close();
        // Printer.printColor("Ahh, so the infamous \u001B[31mexecutioner\u001B[31m \u001B[37mdons the name " + playerName + " huh.\u001B[37m \n", "white");
        // quickBreak(); 
        // Printer.print("Well, nice to meet ya and glad that you held your promise. I trust you know what your doing, then?\n");
        // quickBreak(); 
        // Printer.printItalizcizedColor("I nod, and the man returns a toothy grin. He makes a motion with his hand and the \ngroup grabs the crates and drops them under your feet, in an arc around you.\n", "white");
        // quickBreak();
        // Printer.print("\"We can only spare you one crate of equipment, the rest is for the other members in the Insurgence. Since it's you though, you can choose which crate you want.\" \n");
        // quickBreak(); 
        Printer.printItalizcizedColor("The crates around you luminate in a cyan blue, each projecting \ntheir own hologram of information pertaining to their class.\n", "white");
        Printer.printColor("Choose the crate you desire.", "purple");
        mainPlayer.printCrateInfo(); 

        System.out.println();
    }

    public void quickBreak() {
        try {
                Thread.sleep(1000);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }

    
}
