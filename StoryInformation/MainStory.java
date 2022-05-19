package StoryInformation;

import java.util.Scanner;

import PlayerAssistants.*;
import Tools.*;
import TownInfo.*;
import PlayerInformation.*;
import fightInfo.*;

public class MainStory {
    public static Printer print = new Printer();

    private String playerName; 
    private String chosenClass;
    private Stats playerStats; 
    private Armours armours; 

    private Bank playerAccount = new Bank(1000);
    private PlayerCreation playerCreator;
    private Player mainPlayer;
    private Scanner in = new Scanner(System.in);
    private TownMaker townMaker;

    private Checkpoints checkPoint = new Checkpoints();

    private MobSummoner summonMob = new MobSummoner();

    public String getName() {
        playerName = in.nextLine(); 
        return playerName;          
    }

    public void playerInfo() {
        playerCreator.printCrateInfo(); 
        mainPlayer = playerCreator.getPlayer();
        townMaker = new TownMaker(mainPlayer);
        mainPlayer.makeTownMaker(townMaker);
        this.chosenClass = playerCreator.getChosenClass();
        playerStats = mainPlayer.getPlayerStats();

        playerStats.getClassInfo(chosenClass);
         
        Armours armours = new Armours(mainPlayer, chosenClass); 
        this.armours = armours; 
        armours.equipArmour("Battered Spectral");

        playerStats.getClassInfo(chosenClass); 
    }

    public void startStory() {
        prologue(); 
    }
    //*tells the player how they got to this new world. This is pre-character creation. 
    public void prologue() {   
        System.out.println();

        // Printer.print("\"Oi! Quit makin so much noise in there!\"\n" ); 
        // Printer.quickBreak(1500);
        // Printer.printItalizcizedColor("You continue you're hammering; it's intentional. The guard stomps to the door.\n","white");
        // Printer.quickBreak(1500);
        // Printer.print("\"Are you braindead!? It's late in the night, an' I'm tryna get some sleep!\"\n");
        // Printer.quickBreak(1500);
        // Printer.printItalizcizedColor("You ignore the guard, continuing the cacophonous, ear-shredding sound of clashing metal. \nThe guard turns red with anger.\n", "white");
        // Printer.quickBreak(1500); 
        // Printer.print("\"I had 'bout enough of your shit, you insolent bastard! Know you're place!\"" + "\033[3m \nThe guard opens your cell door, ready to beat you into submission. \033[0m\n");
        // Printer.quickBreak(1500); 
        // Printer.printItalizcizedColor("The moment the guard walks through the door, the plan springs to action; \nsmoke enshrouds your cell, blinding the guard. And with your specialized \neyesight, you see perfectly, swiftly knocking the guard unconcious.\n", "white");
        // Printer.quickBreak(1500); 
        // Printer.printItalizcizedColor("An explosion breaks the cell wall behind you, right as you've just \nfinished blockading the door. Sirens are blaring, and confused yelling \nripples throughout the prison.\n", "white");
        // Printer.quickBreak(1500); 
        // Printer.printItalizcizedColor("Their confusion isn't without reason, \nas the prison where you reside in is notorious for it's ruthless security: \nDonning a nigh-to-zero breakout success rate.\n", "white");
        // Printer.quickBreak(1500); 
        // Printer.printItalizcizedColor("However, the mysterious people breaking you out of this corrupted hell-hole are \nequally, if not more, ruthless. Experts in their respective fields and \nunparalleled communication, paired with amazing teamwork shatters the prison's \nrecord. You and this unknown lot quickly escape before reinforcements are called.\n", "white");
        // Printer.quickBreak(1500); 
        // Printer.printItalizcizedColor("Four individuals lead you to a shelter; it's barren, save for a dim fire \nand some metal crates tossed to the side. The floor is slightly damp \nfrom yesterdays torrent and the neon lights just outside are flickering, \nas if their vitality is being drained away.\n", "white");
        // Printer.quickBreak(1500); 
        Printer.print("\"Hey\"! \033[3mA gruff voice calls out to you. \033[0m" + "\"Whats your name?\"");
        getName();
        playerCreator = new PlayerCreation(playerAccount, playerName);
        // Printer.printColor("\"Ahh, so the infamous \u001B[31mexecutioner\u001B[31m \u001B[37mdons the name " + playerName + " huh.\u001B[37m\"\n", "white");
        // Printer.quickBreak(1000); 
        // Printer.print("\"Well, nice to meet ya and glad that you held your promise. I trust you know what your purpose is, then?\"\n");
        // Printer.quickBreak(1500); 
        // Printer.printItalizcizedColor("I nod, and the man returns a toothy grin. He makes a motion with his hand and the \ngroup grabs the crates and drops them under your feet, in an arc around you.\n", "white");
        // Printer.quickBreak(1500);
        // Printer.print("\"We can only spare you one crate of equipment, the rest is for the other members in the Insurgence. Since it's you though, you can choose which crate you want.\" \n");
        // Printer.quickBreak(1500); 
        // Printer.printItalizcizedColor("The crates around you luminate in a cyan blue, each projecting \ntheir own hologram of information pertaining to their class.\n", "white");
        Printer.printColor("Choose the crate you desire.", "purple");
        //Printer.quickBreak(5000); 
        
        //*Account Creation Info
        playerInfo(); 

        //*Used for testing inventory
        mainPlayer.createInventory();
        mainPlayer.showInventory();

        // Printer.print("\n\"Got your choice? Alright, we'll meet up with you later at the Antarctic Domain. We've still got other people to break out.\" \n\033[3mHowever, just before he leaves, he turns back.\n\033[0m\"Oh right, I forgot to give you this, here.\" \033[3mHe hands you a map and a letter.\033[0m \n\"The letter is a referral so you dont get scammed in shops, there's also a second paper that shows useful locations here. Alright, I think that's everything, good luck!\"\n");
        // Printer.printItalizcizedColor("The group leaves; silence permeates the air and you check what you recieved. \n","white");
        // Printer.printItalizcizedColor("\"A map and a letter huh.\" You walk out of the shelter, an aura emitting scorn. \nYour countenance reeks with vengeance, and a deep-rooted hatred to those \ncurrently in power. When you were unjustly thrown in prison, you swore to get your revenge. \nNow, it is time to exact it.  \n", "white");
        // Printer.printItalizcizedColor("You've unlocked the map for: The Slums", "purple");

        System.out.println();
        chapter_One_Scene_One();
    }

    //End of Prologue -------------------------------------------------------------------------------------------------/ 


    public void chapter_One_Scene_One(){
        // Printer.printItalizcizedColor("As you walk through the most destitute floor - The Slums - you reminisce about your past. \nYou recall all of the torture, harassment and abuse you experienced.\n", "white");
        // Printer.quickBreak(1000); 

        // //*Flashback to persecution
        // Printer.printColor("You flashback to the past, moments prior to your imprisonment.\n", "red");
        // Printer.quickBreak(1000); 
        // Printer.printItalizcizedColor("Situated in the middle of the largest room of the castle, you \nforcibly kneel before a vibrant golden throne. Two guards are \nbehind you, swords at your throat. You have whip marks across \nyour face.\n", "red");
        // Printer.quickBreak(1000);
        // Printer.printItalizcizedColor("The rasp voice of the new king calls down to you, mockingly.\n\"Why have you failed in completing the executions that were required of you?\" \n", "red");
        // Printer.quickBreak(1000);
        // Printer.printItalizcizedColor("You speak in a derisive tone. \n\"Those citizens haven't done anything wrong, they're just trying to survive \non the crops they grow. Of course you wouldn't understand, you and your \nfatass goons just take from everyone and sit around all day, drinking and shit.\"\n", "red");
        // Printer.quickBreak(1000);
        // Printer.printItalizcizedColor("The king's face turns crimson red. You get whipped once more.\nThe audience of nobles snickers, whispering to each other.\nHowever, in your peripheral vision, you see one noble who \nstands ramrod straight, mouth kept in a thin line.\n", "red");
        // Printer.quickBreak(1000);
        // Printer.printItalizcizedColor("\"You dare mock us!? Understand where you stand in this hierarchy, filth. The age of the Greater Will has \njust begun, and we'll forever eradicate any traces of the Golden Order to instill new beliefs and\ntraditions.\" \n", "red");
        // Printer.quickBreak(1000);
        // Printer.printItalizcizedColor("You ignore him and his rambling, instead making a mental \nnote of the noble who caught your attention.\n ", "red");
        // Printer.quickBreak(1000); 
        // Printer.printItalizcizedColor("The king huffs. \"Bring him to the Scarlet Asylum and let him rot there. Do as you wish to him.\" \n", "red");
        // Printer.quickBreak(1000);
        // Printer.printItalizcizedColor("The guards strong-arm you out of the room as you hear \nderisive laughter behind you... \n", "red");
        // Printer.quickBreak(1500); 
        // //end of flashback

        // Printer.printItalizcizedColor("\"Haaah...\" You sigh, you make your way down a barren and \ndirtied street. Thinking about the past will always, \nwithout fail, make your head spin. \n", "white");
        // Printer.quickBreak(1000);
        // Printer.printItalizcizedColor("Right as you close your eyes, you hear the sound of \nparting dust; and one moment later, you're on your \nknees, a jagged knife to your throat: a light blue \nsheen on it.\n", "white");
        // Printer.quickBreak(1000); 
        // Printer.printItalizcizedColor("You keep calm; these things happen frequently during \nyour time serving Scarlet Rot. \n", "white");
        // Printer.quickBreak(1000); 
        // Printer.print("\"What do you want?\" \n" );
        // Printer.quickBreak(1000);
        // Printer.print("A coarse reply, \"Hand over the letter, and I'll give you a painless death.\" \n");
        // Printer.quickBreak(1000); 
        // Printer.printItalizcizedColor("Hilarity overwhelms you; this guy's a weakling! The \nknife scratches your throat as you snort at his empty \nthreat. \n", "white");
        // Printer.quickBreak(1000);
        // Printer.printItalizcizedColor("Before he can say another word, you elbow his stomach, \nand you snatch the knife right as his grip loosens. \nAs he's stumbling, you kick his legs and he falls on \nthe ground. \n", "white");
        // Printer.quickBreak(1000); 
        // Printer.printItalizcizedColor("As you're about to concuss him with your feet, he \nactivates some sort of mechanism to teleport a safe \ndistance from you. \n", "white");
        // Printer.quickBreak(1000); 
        // Printer.printItalizcizedColor("Fortunately, you've already equipped all of the gear \ngiven to you beforehand, knowing that The Slums is \nhome to the depraved and malicious: doing anything \nto survive and thrive in a resource-less floor. \n", "white");
        // Printer.quickBreak(1000);
        // Printer.printItalizcizedColor("You see the man more clearly now. He has a slim, yet\n muscular body, donning obsidian-black armour and a \ndark blue hood. He reaches into his pocket, and \ngrabs an unknown technological cube. \n", "white");
        // Printer.quickBreak(1000); 
        // Printer.printItalizcizedColor("The cube luminates, and surrounds the both of you \nin a circular dome. \n", "white");
        // Printer.quickBreak(1000); 
        // Printer.printItalizcizedColor("\"Don't try to escape; the walls are made with electric-infused chromium - it'll just liquify your body and I won't be able \nto frame your head.\"", "white");
        // Printer.quickBreak(1000); 
        // Printer.printItalizcizedColor("\"I'm already being targetted? How? Did they put a tracker on me? Oh well, lets get this over with. I'll have to be more \ncareful in the future.\" \n", "white");
        // Printer.quickBreak(1000); 

        chapter_One_Reset_Point_One();
    }   

    //reset point if the player dies to the lvl 1 assassin lmao
    public void chapter_One_Reset_Point_One() {
        checkPoint.createCheckpoint(playerStats);

        Printer.printItalizcizedColor("You get ready for combat...", "purple");
        Printer.quickBreak(1000);

        chapter_One_Fight_Scene_One();

    }

    //combat against Greater Will Assassin 
    public void chapter_One_Fight_Scene_One(){ 
    //*GETS ALL OF THE INFO OF MC'S CLASS AND STATS ------------------------------------------------------------
        // playerStats = mainPlayer.getPlayerStats();
        // Stats mobStats = summonMob.newGreaterWillAssassin(2);
        // String mobAttacks[] = summonMob.getGreaterWillAssasinAttacks();
        // int mobAttacksCost[] = summonMob.getGreaterWillAssasinAttackCosts();
        // Combat chapter_One_Fight_One = new Combat(mainPlayer, playerStats, mobStats, mobAttacks, mobAttacksCost, summonMob);
        // chapter_One_Fight_One.fight(true);

        //*END OF FIGHT 

        //resets the player to the reset point if player dies
        //continues the storyline if the player defeats the enemy
        // if(chapter_One_Fight_One.didPlayerDie()) {
        //     checkPoint.backToCheckpoint();
        //     Printer.printItalizcizedColor("How did you lose...", "yellow");
        //     chapter_One_Reset_Point_One();
        // } else {
        //     chapter_One_Scene_Two();
        // }
        // chapter_One_Scene_Two();
    }

    public void chapter_One_Scene_Two(){
        // System.out.println("old stats \n");
        // playerStats.getClassInfo(chosenClass);
        mainPlayer.levelUp();
        // System.out.println("new stats \n");
        // playerStats.getClassInfo(chosenClass);

        System.out.println();
        Printer.printItalizcizedColor("The assassin falls to the ground, defeated.\nYou stalk towards him as he lays there, face\nin the ground.\n", "white");
        Printer.printColor("\"Ahck!\" \033[3mHe coughs as you pin him with your foot.\033[0m\n","white");
        Printer.printColor("\"How'd you already track me.\" \033[3mYou demand, grinding you foot in his back.\033[0m\n", "white");
        Printer.print("\033[3mHe laughs derisively.\033[0m \"Like I'd tell you, traitorous scum.\"\n"); 
        Printer.printItalizcizedColor("\"Doesn't seem like he'll spill anything. Guess he has no use to me anymore.\"\n", "white");
        Printer.printItalizcizedColor("You stab him, quieting his annoying laughter. \n", "white");
        Printer.printItalizcizedColor("You look around the dirtied town. \"Guess I'll go check around to gather intel.\"", "white");
        Printer.printItalizcizedColor("You check the map to decide where you go...", "purple");

        TownMaker townMaker = new TownMaker(mainPlayer);
        mainPlayer.makeTownMaker(townMaker);
        //TODO: capitalize first letters of the town names
        townMaker.makeTowns();
        townMaker.runSlums();

    }   

}

