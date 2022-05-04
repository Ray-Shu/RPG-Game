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

        Printer.print("\"Oi! Quit makin so much noise in there!\"\n" ); 
        quickBreak(1500);
        Printer.printItalizcizedColor("You continue you're hammering; it's intentional. The guard stomps to the door.\n","white");
        quickBreak(1500);
        Printer.print("\"Are you braindead!? It's late in the night, an' I'm tryna get some sleep!\"\n");
        quickBreak(1500);
        Printer.printItalizcizedColor("You ignore the guard, continuing the cacophonous, ear-shredding sound of clashing metal. \nThe guard turns red with anger.\n", "white");
        quickBreak(1500); 
        Printer.print("\"I had 'bout enough of your shit, you insolent bastard! Know you're place!\"" + "\033[3m \nThe guard opens your cell door, ready to beat you into submission. \033[0m\n");
        quickBreak(1500); 
        Printer.printItalizcizedColor("The moment the guard walks through the door, the plan springs to action; \nsmoke enshrouds your cell, blinding the guard. And with your specialized \neyesight, you see perfectly, swiftly knocking the guard unconcious.\n", "white");
        quickBreak(1500); 
        Printer.printItalizcizedColor("An explosion breaks the cell wall behind you, right as you've just \nfinished blockading the door. Sirens are blaring, and confused yelling \nripples throughout the prison.\n", "white");
        quickBreak(1500); 
        Printer.printItalizcizedColor("Their confusion isn't without reason, \nas the prison where you reside in is notorious for it's ruthless security: \nDonning a nigh-to-zero breakout success rate.\n", "white");
        quickBreak(1500); 
        Printer.printItalizcizedColor("However, the mysterious people breaking you out of this corrupted hell-hole are \nequally, if not more, ruthless. Experts in their respective fields and \nunparalleled communication, paired with amazing teamwork shatters the prison's \nrecord. You and this unknown lot quickly escape before reinforcements are called.\n", "white");
        quickBreak(1500); 
        Printer.printItalizcizedColor("Four individuals lead you to a shelter; it's barren, save for a dim fire \nand some metal crates tossed to the side. The floor is slightly damp \nfrom yesterdays torrent and the neon lights just outside are flickering, \nas if their vitality is being drained away.\n", "white");
        quickBreak(1500); 
        Printer.print("\"Hey\"! \033[3mA gruff voice calls out to you. \033[0m" + "\"Whats your name, \u001B[31mMister Executioner?\" \u001B[31m");
        getName();
        Printer.printColor("\"Ahh, so the infamous \u001B[31mexecutioner\u001B[31m \u001B[37mdons the name " + playerName + " huh.\u001B[37m\"\n", "white");
        quickBreak(1000); 
        Printer.print("\"Well, nice to meet ya and glad that you held your promise. I trust you know what your purpose is, then?\"\n");
        quickBreak(1500); 
        Printer.printItalizcizedColor("I nod, and the man returns a toothy grin. He makes a motion with his hand and the \ngroup grabs the crates and drops them under your feet, in an arc around you.\n", "white");
        quickBreak(1500);
        Printer.print("\"We can only spare you one crate of equipment, the rest is for the other members in the Insurgence. Since it's you though, you can choose which crate you want.\" \n");
        quickBreak(1500); 
        Printer.printItalizcizedColor("The crates around you luminate in a cyan blue, each projecting \ntheir own hologram of information pertaining to their class.\n", "white");
        Printer.printColor("Choose the crate you desire.", "purple");
        quickBreak(5000); 
        mainPlayer.printCrateInfo(); 

        Printer.print("\n\"Got your choice? Alright, we'll meet up with you later at the Antarctic Domain. We've still got other people to break out.\" \n\033[3mHowever, just before he leaves, he turns back.\n\033[0m\"Oh right, I forgot to give you this, here.\" \033[3mHe hands you a map and a letter.\033[0m \n\"The letter is a referral so you dont get scammed in shops, there's also a second paper that shows useful locations here. Alright, I think that's everything, good luck!\"\n");
        Printer.printItalizcizedColor("The group leaves; silence permeates the air and you check what you recieved. \n","white");
        Printer.printItalizcizedColor("\"A map and a letter huh.\" You walk out of the shelter, an aura emitting scorn. \nYour countenance reeks with vengeance, and a deep-rooted hatred to those \ncurrently in power. When you were unjustly thrown in prison, you swore to get your revenge. \nNow, it is time to exact it.  \n", "white");
        Printer.printItalizcizedColor("You've unlocked the map for: The Slums", "purple");

        System.out.println();
    }

    //End of Prologue -------------------------------------------------------------------------------------------------/ 


    public void chapterOne(){
        Printer.printItalizcizedColor("As you walk through the most destitute floor - The Slums - you reminisce about your past. \nYou recall all of the torture, harassment and abuse you experienced.\n", "white");
        quickBreak(1000); 

        //*Flashback to persecution
        Printer.printColor("You flashback to the past, moments prior to your imprisonment.\n", "red");
        quickBreak(1000); 
        Printer.printItalizcizedColor("Situated in the middle of the largest room of the castle, you \nforcibly kneel before a vibrant golden throne. Two guards are \nbehind you, swords at your throat. You have whip marks across \nyour face.\n", "red");
        quickBreak(1000);
        Printer.printItalizcizedColor("The rasp voice of the new king calls down to you, mockingly.\n\"Why have you failed in completing the executions that were required of you?\" \n", "red");
        quickBreak(1000);
        Printer.printItalizcizedColor("You speak in a derisive tone. \n\"Those citizens haven't done anything wrong, they're just trying to survive \non the crops they grow. Of course you wouldn't understand, you and your \nfatass goons just take from everyone and sit around all day, drinking and shit.\"\n", "red");
        quickBreak(1000);
        Printer.printItalizcizedColor("The king's face turns crimson red. You get whipped once more.\nThe audience of nobles snickers, whispering to each other.\nHowever, in your peripheral vision, you see one noble who \nstands ramrod straight, mouth kept in a thin line.\n", "red");
        quickBreak(1000);
        Printer.printItalizcizedColor("\"You dare mock us!? Understand where you stand in this hierarchy, filth. The age of the Greater Will has \njust begun, and we'll forever eradicate any traces of the Golden Order to instill new beliefs and\ntraditions.\" \n", "red");
        quickBreak(1000);
        Printer.printItalizcizedColor("You ignore him and his rambling, instead making a mental \nnote of the noble who caught your attention.\n ", "red");
        quickBreak(1000); 
        Printer.printItalizcizedColor("The king huffs. \"Bring him to the Scarlet Asylum and let him rot there. Do as you wish to him.\" \n", "red");
        quickBreak(1000);
        Printer.printItalizcizedColor("The guards strong-arm you out of the room as you hear \nderisive laughter behind you... \n", "red");
        quickBreak(1500); 
        //end of flashback

        Printer.printItalizcizedColor("\"Haaah...\" You sigh, you make your way down a barren and \ndirtied street. Thinking about the past will always, \nwithout fail, give you migraines. ", "white");
    
    }

    /**
     * input the time in milliseconds 
     * @param t - time in milliseconds
     */
    public void quickBreak(int t) {
        try {
                Thread.sleep(t);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }

    
}
