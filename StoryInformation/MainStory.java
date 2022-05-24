package StoryInformation;

import java.util.Scanner;


import Tools.*;
import TownInfo.*;
import PlayerInformation.*;
import fightInfo.*;

public class MainStory {
    public final String merchantColor = "green";

    //*SLUMS MERCHANT 
    String[] slumsItemsForSale = {"Weak Healing Pots", "Weak Mana Pots"};
    double[] slumsPriceOfItem2 = {150, 150}; 
    String[] slumsArmour = {"Superior Spectral Armour"};
    double[] slumsArmourPrice = {5500}; 
    String slumsShopName = "Common Shack"; 
    String[] slumsThingsToDo = {"Show common goods", "Show armour", "Leave"}; 
    String slumsGreeting = "Welcome to the Common Shack! What can I do for you?"; 
    String slumsFarewell = "Thanks for coming!"; 
    String slumsErrorMessage = "Looks like that isn't in the store, pick something else yeah?"; 
    Merchant slumsMerchant;

    //*ANTARCTIC DOMAIN MERCHANT
    String[] antarcticItemsForSale = {"Healing Pots", "Mana Pots"}; 
    double[] antarcticPriceOfItem2 = {300, 300}; 
    String[] antarcticArmour = {"Battered Chromium Armour", "Superior Chromium Armour"};
    double[] antarcticArmourPrice = {6000, 9000}; 
    String antarcticShopName = "Frozen Anvil"; 
    String[] antarcticThingsToDo = { "Show common goods", "Show armour", "Leave" };
    String antarcticGreeting = "Ugh... Another customer? What do you want?"; 
    String antarcticFarewell = "Thanks for your money."; 
    String antarcticErrorMessage = "Are you blind? That ain't in the store."; 
    Merchant antarcticMerchant; 

    
   

    public static Printer print = new Printer();

    private String playerName; 
    private String chosenClass;
    private Stats playerStats; 
    private Armours armours; 
    private Inventory inventory; 

    private Bank playerAccount = new Bank(1000);
    private PlayerCreation playerCreator;
    private Player mainPlayer;
    private Scanner in = new Scanner(System.in);
    private TownMaker townMaker;

    private Checkpoints checkPoint = new Checkpoints();

    private MobSummoner summonMob = new MobSummoner();

    //gets the players name 
    public String getName() {
        playerName = in.nextLine(); 
        return playerName;          
    }

    //instantiates all of the information needed currently for the story 

    public void playerInfo() {
        //class choice
        playerCreator.printCrateInfo(); 

        //creates the object player
        mainPlayer = playerCreator.getPlayer();
        this.chosenClass = playerCreator.getChosenClass();
        playerStats = mainPlayer.getPlayerStats();

        //instantiates some town info
        townMaker = new TownMaker(mainPlayer);
        mainPlayer.makeTownMaker(townMaker);
        this.playerAccount = mainPlayer.getBank();
        
        //creates the players inventory 
        this.inventory = mainPlayer.getInventory();

        //equips the basic armour for your chosen class
        this.armours = mainPlayer.getArmour(); 
        this.armours.equipArmour("Battered Spectral Armour");
    }

    public void startStory() {
        prologue(); 
    }

    //*tells the player how they got to this new world. This is pre-character creation. 
    public void prologue() {   
        System.out.println();

        Printer.printColor("\"Oi! Quit makin so much noise in there!\"\n", "white"); 
        Printer.quickBreak(1500);
        Printer.printItalizcizedColor("You continue you're hammering; it's intentional. The guard stomps to the door.\n","white");
        Printer.quickBreak(1500);
        Printer.print("\"Are you braindead!? It's late in the night, an' I'm tryna get some sleep!\"\n");
        Printer.quickBreak(1500);
        Printer.printItalizcizedColor("You ignore the guard, continuing the cacophonous, ear-shredding sound of clashing metal. \nThe guard turns red with anger.\n", "white");
        Printer.quickBreak(1500); 
        Printer.print("\"I had 'bout enough of your shit, you insolent bastard! Know you're place!\"" + "\033[3m \nThe guard opens your cell door, ready to beat you into submission. \033[0m\n");
        Printer.quickBreak(1500); 
        Printer.printItalizcizedColor("The moment the guard walks through the door, the plan springs to action; \nsmoke enshrouds your cell, blinding the guard. And with your specialized \neyesight, you see perfectly, swiftly knocking the guard unconcious.\n", "white");
        Printer.quickBreak(1500); 
        Printer.printItalizcizedColor("An explosion breaks the cell wall behind you, right as you've just \nfinished blockading the door. Sirens are blaring, and confused yelling \nripples throughout the prison.\n", "white");
        Printer.quickBreak(1500); 
        Printer.printItalizcizedColor("Their confusion isn't without reason, \nas the prison where you reside in is notorious for it's ruthless security: \nDonning a nigh-to-zero breakout success rate.\n", "white");
        Printer.quickBreak(1500); 
        Printer.printItalizcizedColor("However, the mysterious people breaking you out of this corrupted penitentiary are \nequally, if not more, ruthless. Experts in their respective fields and \nunparalleled communication, paired with amazing teamwork shatters the prison's \nrecord. You and this unknown lot quickly escape before reinforcements are called.\n", "white");
        Printer.quickBreak(1500); 
        Printer.printItalizcizedColor("Four individuals lead you to a shelter; it's barren, save for a dim fire \nand some metal crates tossed to the side. The floor is slightly damp \nfrom yesterdays torrent and the neon lights just outside are flickering, \nas if their vitality is being drained away.\n", "white");
        Printer.quickBreak(1500); 
        Printer.print("\"Hey\"! \033[3mA gruff voice calls out to you. \033[0m" + "\"Whats your name?\"");
        getName();
        playerCreator = new PlayerCreation(playerAccount, playerName);
        Printer.printColor("\"Ahh, so the infamous \u001B[31mexecutioner\u001B[31m \u001B[37mdons the name " + playerName + " huh.\u001B[37m\"\n", "white");
        Printer.quickBreak(1000); 
        Printer.print("\"Well, nice to meet ya and glad that you held your promise. I trust you know what your purpose is, then?\"\n");
        Printer.quickBreak(1500); 
        Printer.printItalizcizedColor("You nod, and the man returns a toothy grin. He makes a motion with his hand and the \ngroup grabs the crates and drops them under your feet, in an arc around you.\n", "white");
        Printer.quickBreak(1500);
        Printer.print("\"We can only spare you one crate of equipment, the rest is for the other members in the Insurgence. Since it's you though, you can choose whichever crate you want.\" \n");
        Printer.quickBreak(1500); 
        Printer.printItalizcizedColor("The crates around you luminate in a cyan blue, each projecting \ntheir own hologram of information pertaining to their class.\n", "white");
        Printer.printColor("Choose the crate you desire.", "purple");
        Printer.quickBreak(3000); 
        
        //*Account Creation Info
        playerInfo(); 

        Printer.print("\n\"Got your choice? Alright, we'll meet up with you later at the Antarctic Domain. We've still got other people to break out.\" \n\033[3mHowever, just before he leaves, he turns back.\n\033[0m\"Oh right, I forgot to give you this, here.\" \033[3mHe hands you a map and a letter.\033[0m \n\"The letter is a referral so you dont get scammed in shops, there's also a second paper that shows useful locations here. Alright, I think that's everything, good luck!\"\n");
        Printer.printItalizcizedColor("The group leaves; silence permeates the air and you check what you recieved. \n","white");
        Printer.printItalizcizedColor("\"A map and a letter huh.\" You walk out of the shelter, an aura emitting scorn. \nYour countenance reeks with vengeance, and a deep-rooted hatred to those \ncurrently in power. When you were unjustly thrown in prison, you swore to get your revenge. \nNow, it is time to exact it.  \n", "white");
        Printer.printItalizcizedColor("You've unlocked the map for: The Slums", "purple");

        System.out.println();
        chapter_One_Scene_One();
    }

    //End of Prologue -------------------------------------------------------------------------------------------------/ 


    public void chapter_One_Scene_One(){
        Printer.printItalizcizedColor("As you walk through the most destitute floor - The Slums - you reminisce about your past. \nYou recall all of the torture, harassment and abuse you experienced.\n", "white");
        Printer.quickBreak(1000); 

        //*Flashback to persecution
        Printer.printColor("You flashback to the past, moments prior to your imprisonment.\n", "red");
        Printer.quickBreak(1000); 
        Printer.printItalizcizedColor("Situated in the middle of the largest room of the castle, you \nforcibly kneel before a vibrant golden throne. Two guards are \nbehind you, swords at your throat. Whip marks adorn \nyour already marred face.\n", "red");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor("The rasp voice of the new king calls down to you, mockingly.\n\"Why have you failed in completing the executions that were required of you?\" \n", "red");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor("You speak in a derisive tone. \n\"Those citizens haven't done anything wrong, they're just trying to survive \non the crops they grow. Of course you wouldn't understand, you and your \nfatass goons just take from everyone and sit around all day, drinking and shit.\"\n", "red");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor("The king's face turns crimson red. You get whipped once more.\nThe audience of nobles snickers, whispering to each other.\nHowever, in your peripheral vision, you see one noble who \nstands ramrod straight, mouth kept in a thin line.\n", "red");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor("\"You dare mock us!? Understand where you stand in this hierarchy, filth. The age of the Greater Will has \njust begun, and we'll forever eradicate any traces of the Golden Order to instill new beliefs and\ntraditions.\" \n", "red");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor("You ignore him and his rambling, instead making a mental \nnote of the noble who caught your attention.\n ", "red");
        Printer.quickBreak(1000); 
        Printer.printItalizcizedColor("The king huffs. \"Bring him to the Scarlet Asylum and let him rot there. Do as you wish to him.\" \n", "red");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor("The guards strong-arm you out of the room as you hear \nderisive laughter behind you... \n", "red");
        Printer.quickBreak(1500); 
        //end of flashback

        Printer.printItalizcizedColor("\"Haaah...\" You sigh, you make your way down a barren and \ndirtied street. Thinking about the past will always, \nwithout fail, make your head spin. \n", "white");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor("Right as you close your eyes, you hear the sound of \nparting dust; and one moment later, you're on your \nknees, a jagged knife to your throat: a light blue \nsheen on it.\n", "white");
        Printer.quickBreak(1000); 
        Printer.printItalizcizedColor("You keep calm; these things happen frequently during \nyour time serving Scarlet Rot. \n", "white");
        Printer.quickBreak(1000); 
        Printer.print("\"What do you want?\" \n" );
        Printer.quickBreak(1000);
        Printer.print("A coarse reply, \"Hand over the letter, and I'll give you a painless death.\" \n");
        Printer.quickBreak(1000); 
        Printer.printItalizcizedColor("Hilarity overwhelms you; this guy's a weakling! The \nknife scratches your throat as you snort at his empty \nthreat. \n", "white");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor("Before he can say another word, you elbow his stomach, \nand you snatch the knife right as his grip loosens. \nAs he's stumbling, you sidesweep his legs and he falls on \nthe ground. \n", "white");
        Printer.quickBreak(1000); 
        Printer.printItalizcizedColor("As you're about to concuss him with your feet, he \nactivates some sort of mechanism to teleport a safe \ndistance from you. \n", "white");
        Printer.quickBreak(1000); 
        Printer.printItalizcizedColor("Fortunately, you've already equipped all of the gear \ngiven to you beforehand, knowing that The Slums is \nhome to the depraved and malicious: doing anything \nto survive and thrive in a resource-less floor. \n", "white");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor("You see the man more clearly now. He has a slim, yet\nmuscular body, donning obsidian-black armour and a \ndark blue hood. He reaches into his pocket, and \ngrabs an unknown technological cube. \n", "white");
        Printer.quickBreak(1000); 
        Printer.printItalizcizedColor("The cube luminates, and surrounds the both of you \nin a circular dome. \n", "white");
        Printer.quickBreak(1000); 
        Printer.printItalizcizedColor("\"Don't try to escape; the walls are made with electric-infused chromium - it'll just liquify your body and I won't be able \nto frame your head.\"\n", "white");
        Printer.quickBreak(1000); 
        Printer.printItalizcizedColor("You ignore him. \"I'm already being targetted? How? Did they put a tracker on me? Oh well, lets get this over with. I'll have to be more \ncareful in the future.\" \n", "white");
        Printer.quickBreak(1000); 

        chapter_One_Reset_Point_One();
    }   

    //reset point if the player dies to the lvl 1 assassin lmao
    public void chapter_One_Reset_Point_One() {
        checkPoint.createCheckpoint(playerStats);

        Printer.printItalizcizedColor("You get ready for combat...", "purple");
        Printer.quickBreak(1000);

        chapter_One_Fight_Scene_One();
    }

    public void chapter_One_Fight_Scene_One(){ 
        
    //*GETS ALL OF THE INFO OF MC'S CLASS AND STATS ------------------------------------------------------------
        playerStats = mainPlayer.getPlayerStats();
        Stats mobStats = summonMob.newGreaterWillAssassin(2);
        String mobAttacks[] = summonMob.getGreaterWillAssasinAttacks();
        int mobAttacksCost[] = summonMob.getGreaterWillAssasinAttackCosts();
        Combat chapter_One_Fight_One = new Combat(mainPlayer, playerStats, mobStats, mobAttacks, mobAttacksCost, summonMob);
        chapter_One_Fight_One.fight(true);
    // *END OF FIGHT 

        // resets the player to the reset point if player dies
        // continues the storyline if the player defeats the enemy
        if(chapter_One_Fight_One.didPlayerDie()) {
            checkPoint.backToCheckpoint();
            Printer.printItalizcizedColor("How did you lose...", "yellow");
            chapter_One_Reset_Point_One();
        } else {
            chapter_One_Scene_Two();
        }

    }

    public void chapter_One_Scene_Two(){
        
        mainPlayer.levelUp();
        
        System.out.println();
        Printer.printItalizcizedColor("The assassin falls to the ground, defeated.\nYou stalk towards him as he lays there, face\nin the muddied dirt\n", "white");
        Printer.quickBreak(1000);
        Printer.printColor("\"Ahck!\" \033[3mHe coughs as you pin him down.\033[0m\n","white");
        Printer.quickBreak(1000); 
        Printer.printColor("\"How'd you already track me.\" \033[3mYou demand, grinding your foot in his back.\033[0m\n", "white");
        Printer.quickBreak(1000);
        Printer.print("\033[3mHe laughs derisively.\033[0m \"Like I'd tell you, traitorous scum.\"\n"); 
        Printer.quickBreak(1000); 
        Printer.printItalizcizedColor("\"Doesn't seem like he'll spill anything. Guess he has no use to me anymore.\"\n", "white");
        Printer.quickBreak(1000); 
        Printer.printItalizcizedColor("You stab him, quieting his annoying laughter. \n", "white");
        Printer.quickBreak(1000); 
        Printer.printItalizcizedColor("You look around the dirtied town. \"Guess I'll go check around to gather intel.\"\n", "white");
        Printer.quickBreak(1000); 
        Printer.printItalizcizedColor("You check the map to decide where you go. Though your heart still yearns for the thrill of battle...\n", "purple");
        Printer.quickBreak(1000); 

        mainPlayer.makeTownMaker(townMaker);
        townMaker.makeTowns();
        mainPlayer.getCurrentTown().characterEnteringTown(true);
        

        Printer.printItalizcizedColor(
                "As you hand in the completion report to the Guildmaster,\nyou ask him about how to advance the floors. \n",
                "white");
        Printer.quickBreak(1000);
        Printer.printColor(
                "\"Ya want outta this wretched place heh? I don't blame ya, I'd prolly make a run for it too, if was strong enough to do so...\" \n",
                "white");
        Printer.quickBreak(1000);
        Printer.printColor("\"Strong enough? What does that mean?\" \n", "white");
        Printer.quickBreak(1000);
        Printer.print(
                "\"Well aren'tcha livin' under a rock!\" \033[3mThe man bellows.\033[0m \"You oughta defeat the warden of this floor. Once you prove your \nstrength, your given a medallion that you collect. Don't worry about losing it, theres a curse imbued into it, so it \nwill always teleport to you.\"\n");
        Printer.quickBreak(1000);
        Printer.print(
                "\033[3mHe continues\033[0m, \"There's a floor teleporter in the middle of each floor, the Sensory Mech will scan your medallion \nand will teleport you to the floor you have earned the medallion floor.\" \n");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor(
                "\"However.\" \033[3mhe warns.\033[0m \"You aren't able to teleport to floors that you haven't earned medallions for. If you're \nwondering about why many people can collect medallions, it's because the wardens of each floor don't actually \ndie. They are mysterious creatures whose souls are chained to their floor, so each time they're defeated, \nthey regenerate themselves.\" \n",
                "white");
        Printer.print("\"Where do I go to fight this warden?\"\n");
        Printer.printColor(
                "\"I wouldn't be so hasty if I were you, these wardens have been reigning over these lands for centuries, even their \nhistorical origins are unknown! But if you still wish to fight them, the warden occupying The Slums is the \u001B[31mWarden of Dirt\u001B[31m\u001B[37m.\"\u001B[37m\n",
                "white");
        Printer.printColor(
                "\"You can face it by entering the town's dungeon. But the door only unlocks if it deems the participants worthy.\"\n",
                "white"); 


        Printer.printItalizcizedColor("You walk out of the guild, deep in thought. \"So the dungeon must deem me worthy, huh. I guess the only thing I can do is find ways to get stronger.\" \n", "white");
        Printer.printItalizcizedColor("With that thought in mind, you make your way \nto the merchants shop. \n", "white");    
        
        Printer.printItalizcizedColor(
                "A faint, dying bell chimes as you open the door \nto what you presume is said shop. \nAfter all, the neon sign outside shows no life, \nand its words are barely readable.\n",
                "white");
        Printer.quickBreak(1000);
        Printer.print(
                "\033[3mA kind voice greets you.\033[0m \"Welcome to the humble shack that is the Common Shack! What goods are you looking for today?\n");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor("You look around unimpressed, seeing nothing \nbut a barebones \"shack\". \n",
                "white");
        Printer.quickBreak(1000);
        Printer.print("\"Uh... What exactly can you even offer?\"\n");
        Printer.quickBreak(1000);
        Printer.print(
                "The man behind the counter laughs. \"Well! All my valuables are kept in a storage, to prevent any thievery you see. I \nshow my offers to my customers through hologram.\"\n");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor(
                "He grabs a tablet out from behind the \ncounter, and a blue projection appears.\n",
                "white");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor("Your eyes wander towards the armoury.\n", "purple");
        
        Merchant slumsMerchant = new Merchant(mainPlayer, mainPlayer.getCurrentTown(), slumsItemsForSale,
                slumsPriceOfItem2, slumsShopName, slumsThingsToDo, slumsGreeting, slumsFarewell, slumsErrorMessage,
                merchantColor);
        townMaker.addBuildingToTown(townMaker.getCurrentTown(), slumsMerchant);
        slumsMerchant.addArmour(slumsArmour, slumsArmourPrice);
        slumsMerchant.shop(false, true); 
        this.slumsMerchant = slumsMerchant; 

        
        chapter_One_Scene_Three();
    }  
    
    public void chapter_One_Scene_Three() {
        Printer.printItalizcizedColor(
                "\"Looks like I've got to complete more missions to earn myself some more money. Then I'll be able to purchase that Superior Spectral Gear.\" \n",
                "white");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor("Your mind, once again, gravitates towards the thrill of battle... \n", "purple");

        do {
            mainPlayer.getCurrentTown().characterEnteringTown(true);
            if(mainPlayer.getLevel() < 8) {
                Printer.printItalizcizedColor(
                        "There isn't much to do in such a destitute floor besides occupying your mind with the sounds of clashing metal.\n",
                        "purple");
            }
            
        } while (mainPlayer.getLevel() < 8);

        chapter_One_Buying_Armour(); 
        
    }

    public void chapter_One_Buying_Armour() {
        Printer.printItalizcizedColor("Before you make your way to the dungeon's \ndoor, you decide to pay heed to the \nmerchant once more, looking to purchase \nthe \u001B[31mSuperior Spectral Armour\u001B[31m\u001B[0m.\n", "white");
        slumsMerchant.shop(false, true);
        System.out.println();
        Printer.printItalizcizedColor("You walk out of the merchants shop donning\nsomewhat lustrous armour, confidence \nplastered through your face as you trudge \nthrough the dirtied streets, one last time. \n", "white");
        Printer.quickBreak(1000);
        chapter_One_Dungeon_Fight();
    }

    public void chapter_One_Dungeon_Fight() {
        
        Printer.printItalizcizedColor("\"Alright, time to see if this dungeon deems me worthy.\"\n", "white");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor("You make your way to the dungeon, \ntaking in the height of the seemingly \nunrealistic gargantuan door. As you get\ncloser, you feel a strange, indescribable \nsensation pulse through your soul which \nyour mind registers as: \u001B[31mWorthy.\u001B[31m \n", "white");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor("You gaze into the open door, seing nothing \nbut pitch black. Your heart shakes ever so \nslightly, but you steel your resolve and walk \ninto the dungeon with the conviction of \nkilling the new king.", "white");
        Printer.quickBreak(1000);
        
        
        mainPlayer.getCurrentTown().enterDungeon(true);
        townMaker.increaseCurrentTownLevel();

        chapter_Two_Scene_One();

    }

    public void chapter_Two_Scene_One(){ 
        System.out.println();
        Printer.printItalizcizedColor(
                "\"Wow.\" You say, in a tone of derisive self-mockery. \"It took all of that to kill the warden of the lowest floor...\"\n",
                "white");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor(
                "You lean over to catch your breath, beads \nof sweat rolling off of your dirtied body.\n", "white");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor(
                "With the medallion safely secured, you get \nteleported to the next floor: \u001B[35mThe Antarctic Domain\u001B[35m\u001B[0m.\n",
                "white");
        Printer.quickBreak(1000);
        mainPlayer.levelUp();
        mainPlayer.levelUp();
        System.out.println();
        Printer.printItalizcizedColor(
                "The bright glow dissipates as you are \nsafely teleported. You look around and \ntake in the change of scenery. \n",
                "white");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor(
                "To your surprise, there's no snow to be \nseen in the town. Not a single drop. \n", "white");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor(
                "However, as you look up, you see that \nsnow quickly accumulates to form a roof \non top of an invisible dome - that you \nassume is encompassing the entire town,\nresponsible for your initial confusion\n- only to be melted away in an instant.\n",
                "white");
        Printer.quickBreak(1000);
        Printer.print(
                "\"Hey!\" \033[3mA familiar gruff voice wakes you up from your stupor.\033[0m \"Took you damn long enough.\"\n");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor(
                "You make a face of exasperation and a \nhint of amusement; surprised by how \nquickly the man was able to find you \nagain.\n",
                "white");
        Printer.quickBreak(1000);
        Printer.print(
                "\"Me and my team mostly finished our work here, we're just relaxin' a bit before heading out again. Although there's no surprise \nthat you were victorious against the Warden of Dirt, congratulations regardless. Here.\" \n");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor("The man opens his palm: 2000 fusion coins.\n", "white");
        playerAccount.deposit(2000);
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor(
                "You quickly pocket the money while he gives an amused look. You ignore it and ask, \"I'm assuming there's nobody here that would pique my interest?\" \n",
                "white");
        Printer.quickBreak(1000);
        Printer.print(
                "\"Nah.\" \033[3mHe replies.\033[0m \"This floor's only a ladder to our true goal: the assassination of the new king.\"\n");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor(
                "You scowl. Another neccessary yet\nwasteful endeavour that you must\ntrudge through.\n", "white");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor(
                "Before you head off to the adventurer's\nguild, the man yells, catching \nthe attention of some bystanders.\n",
                "white");
        Printer.quickBreak(1000);
        Printer.print("\"You can get a map from the admin building! See ya and don't die!\"\n");
        Printer.quickBreak(1000);
       
        chapter_Two_Scene_Two();
    }

    public void chapter_Two_Scene_Two() {
        Printer.printItalizcizedColor(
                "Heeding his advice, you walk towards \na modern, sleek building, designed \npurely with the intention to look \n\"fashionable\".\n",
                "white");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor(
                "Constructed primarily with some sort \nof technological glass, and an ironic \nsnowy white metal, many curved shapes\nportrude out of the building to \nseemingly give it \"depth\".\n",
                "white");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor(
                "\"Well.\" You think optimistically. \"At least the roads don't remind you of a vulture's carcass.\" \n",
                "white");
        Printer.printItalizcizedColor(
                "Now that you think back to The Slums, \nyou find yourself grateful for the \nconstant upkeep and maintenance in \nthis floor: the roads aren't deformed,\nand the majority of the buildings \nlook some-what polished.\n",
                "white");
        Printer.quickBreak(1000);
        Printer.printItalizcizedColor(
                "You open the door to the \"Administrations Building of the Antarctic Domain\", \nmaking sardonic remarks of the absurdly \nlong name, and quickly take the map. ",
                "white");
        Printer.printItalizcizedColor("You unlocked the map for: The Antarctic Domain", "purple");
        
        
        
        Merchant antarcticMerchant = new Merchant(mainPlayer, mainPlayer.getCurrentTown(), antarcticItemsForSale,
                antarcticPriceOfItem2, antarcticShopName, antarcticThingsToDo, antarcticGreeting, antarcticFarewell, antarcticErrorMessage,
                merchantColor);
        townMaker.addBuildingToTown(townMaker.getCurrentTown(), antarcticMerchant);
        antarcticMerchant.addArmour(antarcticArmour, antarcticArmourPrice);
        this.antarcticMerchant = antarcticMerchant;

        Printer.printItalizcizedColor("You seek strength. The strength to be able to ruthlessly terminate whoever this floor's warden is into an infinite pile of ashes.", "purple");

        do {
        mainPlayer.getCurrentTown().characterEnteringTown(true);
        if(mainPlayer.getLevel() < 16) {
        Printer.printItalizcizedColor(
        "Nothing occupies your minds besides the malevolent laughter echoing through your skull, your burning hatred only growing brighter.\n",
        "purple");
        }

        } while (mainPlayer.getLevel() < 16);

        antarcticMerchant.shop(false, true);

        mainPlayer.getCurrentTown().enterDungeon(true);

        Printer.printItalizcizedColor("\nAs you get teleported to the next floor, you bask in the realization that you're one step closer to retribution.", "red");
    }
}



