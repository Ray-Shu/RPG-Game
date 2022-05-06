import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * This class does all the stuff we need to have a fight
 */
public class Combat extends Moves{
    
    private DecimalFormat df = new DecimalFormat("###.00");
    private Scanner scan = new Scanner(System.in);
    private Random random = new Random();

    private double playerTurnRate, mobTurnRate;
    private Stats  mobStats, playerStats;
    private MobSummoner mobSummoner;
    private String[] mobAttacks;
    private int[] attackCosts;
    private Player player;


    /**
     * Constructs the arena for a fight between a mob and a player. 
     * Does not call the fight method, but might make it later. 
     * 
     * @param player this is the player who is fighting the mob
     * @param playerStats this is the stats of that player
     * @param mobStats this is the stats of the mob
     * @param mobAttacks this is the list of possible mob attacks.
     * @param mobAttacksCost is the mp cost for the mobs attacks 
     * @param mobSummoner - this is the thing mobSummoner which has a lot of the information about the summoner
     */
    Combat(Player player, Stats playerStats, Stats mobStats , String[] mobAttacks, String[] mobAttacksCost, MobSummoner mobSummoner){

        this.playerStats = playerStats;
        this.player = player;
        this.mobStats = mobStats;
        this.mobAttacks = mobAttacks;
        this.attackCosts = player.chosenAttacksCost;
        this.mobSummoner = mobSummoner;

        mobTurnRate = mobStats.currentSpd;
        playerTurnRate = playerStats.currentSpd;   

    }

    /**
     * Starts a fight between the player and the mob, before 
     */
    public void fight() {

        while(playerStats.currentHP > 0 && mobStats.currentHP > 0){

            if (isPlayerTurn() && playerStats.howLongDisabled == 0){
                
                Printer.print("Mob turn Rate: "+ df.format(mobTurnRate) + " Player turn Rate: "+ df.format(playerTurnRate));
                Printer.printColor("----------------------------------------------------------", "cyan");
                Printer.printColor(" It is your turn! Current MP: "+ playerStats.currentMP + " Current HP: "+ df.format(playerStats.currentHP) + "\n", "cyan");
                playerMove();
                checkPlayerBoosts();
                Printer.printColor("----------------------------------------------------------", "cyan");
                playerTurnOver();

            }

            else if (mobStats.howLongDisabled == 0){

                Printer.print("Mob turn Rate: "+ mobTurnRate + " Player turn Rate: "+ playerTurnRate);
                Printer.printColor("----------------------------------------------------------", "red");
                Printer.printColor(" It is the opponents turn! Current MP: "+ mobStats.currentMP + " Current HP: "+ df.format(mobStats.currentHP) + "\n", "red");
                mobMove();
                checkMobBoosts();
                Printer.printColor("----------------------------------------------------------", "red");
                mobTurnOver();

            }

            isAnyoneDisabled();

        }

        whoDied();
        Printer.printColor("Fight Over", "yellow");

    }

    /**
     * Turns are based on speed. The player with the highest speed will get the turn. 
     */
    public boolean isPlayerTurn() {
        if (playerTurnRate >= mobTurnRate){return true;}
        else{return false;}
    }
    
    /**
     * After an attack, we subtract the other player's turn rate to it and then give the other player their turn rate. 
     */
    public void playerTurnOver() {
        playerTurnRate -= mobStats.currentSpd;
        mobTurnRate += mobStats.currentSpd * mobStats.speedMultiplier;
        Printer.printItalizcizedColor("Type any letter to continue...", "white");
        scan.next();
    }

    /**
     * Same as player turn rate, but opposite. 
     */
    public void mobTurnOver() {
        mobTurnRate -= playerStats.currentSpd;
        playerTurnRate += playerStats.currentSpd * playerStats.speedMultiplier;
        Printer.printItalizcizedColor("Type any letter to continue...", "white");
        scan.next();
    }

    /**
     * Checks who died. 
     */
    public void whoDied () {

        if(playerStats.currentHP <= 0){
            Printer.printColor(player.getName() + " has been defeated", "red");
        }

        else{
            Printer.printColor(mobSummoner.getMobName() + " has been defeated!", "green");
        }

    }

    /**
     * Prints out a list of the attacks of the user, along with all the options like leave and inventory. 
     * todo: Implement leave and inventory options.
     */
    public void listAttacks() {
        int i = 0;
        Printer.printColor("Here are your moves:\n", "cyan");
        while(i < player.chosenAttacks.length) {
            Printer.printColor("("+ (i + 1) + ") "+ player.chosenAttacks[i] + "\tMP COST: "+ attackCosts[i] + "\n", "white");
            i++;
        }
        Printer.print("("+(i + 1)+") Inventory\n -------------------------------------------------");

    }
    
    /**
     * Prints out the player's moves, then does the attack based on their response. 
     */
    public void playerMove() {
        listAttacks();
        
        //checks which class we are, and then prompts them to answer a thing. 
        if (player.chosenAttacks == player.CYBORG_ATTACKS){
            cyborgAttack(playerStats, mobStats);
        }
        else if (player.chosenAttacks == player.HACKER_ATTACKS){
            hackAttack(playerStats, mobStats);
        }
        else if (player.chosenAttacks == player.TERMINATOR_ATTACKS){
            terminatorAttack(playerStats, mobStats);
        }
        else if (player.chosenAttacks == player.SWORDSMAN_ATTACKS){
            swordsmanAttack(playerStats, mobStats);
        }
        else if (player.chosenAttacks == player.ROGUE_ATTACKS){
            rogueAttack(playerStats, mobStats);
        }
        else if (player.chosenAttacks == player.MYSTIC_ATTACKS){
            mysticAttack(playerStats, mobStats);
        }
        else {
            reverendAttack(playerStats, mobStats);
        }        
    }

    public void isAnyoneDisabled(){
        //Checks if the enemy is disabled. If they are, we will skip their turn and say they are disabled. 
            if(mobStats.howLongDisabled > 0){
                Printer.printColor("----------------------------------------------------------", "red");
                Printer.printColor("Mob is disabled!!!" ,"red");
                mobStats.howLongDisabled --;
                mobTurnOver();
                Printer.printColor("----------------------------------------------------------", "red");
            }

            //Checks if the player is disabled. If they are, we will skip their turn and say they are disabled. 
            if(playerStats.howLongDisabled > 0){
                Printer.printColor("----------------------------------------------------------", "red");
                Printer.printColor("Player is disabled!!!" ,"red");
                playerStats.howLongDisabled --;
                playerTurnOver();
                Printer.printColor("----------------------------------------------------------", "red");
            }
    }

    //checks if any of the player's stats are currently boosts
    public void checkPlayerBoosts(){
        //checks if the player's temp ATK multiplier is active, and then it 
            if(playerStats.howLongAtkUp > 0){
                playerStats.howLongAtkUp--;
                if(playerStats.howLongAtkUp ==0){
                    Printer.printColor("Player ATK boost over!", "cyan");
                    playerStats.applyAttackUp(1);
                }
            }

        //checks if the player's attack speed multiplier is active, and then it 
            if(playerStats.howLongSpeedUp > 0){
                playerStats.howLongSpeedUp--;
                if(playerStats.howLongSpeedUp ==0){
                    Printer.printColor("Player SPD boost over!", "cyan");
                    playerStats.applyAttackUp(1);
                }
            }
        //checks if the player's temp def multiplier is active, and then it 
            if(playerStats.howLongDefUp > 0){
                playerStats.howLongDefUp--;
                if(playerStats.howLongDefUp ==0){
                    Printer.printColor("Player ATK boost over!", "cyan");
                    playerStats.applyDefenceUp(1);
                }
            }

        //checks if the player's temp dodge multiplier is active, and then it 
            if(playerStats.howLongDodgeUp > 0){
                playerStats.howLongDodgeUp--;
                if(playerStats.howLongDodgeUp ==0){
                    Printer.printColor("Player SPD boost over!", "cyan");
                    playerStats.applyDodgeUp(1);
                }
            }



    }

    //checks if any of the mobs's stats are currently boosts
    public void checkMobBoosts(){
        //checks if the mobs's temp speed multiplier is active, and then it 
            if(mobStats.howLongSpeedUp > 0){
                mobStats.howLongSpeedUp--;
                if(mobStats.howLongSpeedUp ==0){
                    Printer.printColor("Mob SPD boost over!", "cyan");
                    mobStats.applySpeedUp(1);
                }
            }
            //checks if the mobs's temp atk multiplier is active, and then it 
            if(mobStats.howLongAtkUp>0){
                mobStats.howLongAtkUp--;
                if(mobStats.howLongAtkUp ==0){
                    Printer.printColor("Mob ATK boost over!", "cyan");
                    mobStats.applyAttackUp(1);
                }
            }

            if(mobStats.howLongDefUp > 0){
                mobStats.howLongDefUp--;
                if(mobStats.howLongDefUp ==0){
                    Printer.printColor("Mob DEF boost over!", "cyan");
                    mobStats.applyDefenceUp(1);
                }
            }
            //checks if the mobs's temp dodge multiplier is active, and then it 
            if(mobStats.howLongDodgeUp > 0){
                mobStats.howLongDodgeUp--;
                if(mobStats.howLongDodgeUp ==0){
                    Printer.printColor("Mob DODGE boost over!", "cyan");
                    mobStats.applyDodgeUp(1);
                }
            }


    }

    /**
     * Does the mobs move
     * @param playerStats2
     * @param mobStats2
     */
    public void mobMove() {

        double mp = mobStats.currentMP;
        ArrayList<Integer> movesWeCanDo = new ArrayList<Integer>();


        for (int i = 0; i < attackCosts.length; i++) {
            if(attackCosts[i] <= mp){
                movesWeCanDo.add(i);
            }
        }
        if(movesWeCanDo.isEmpty()){
            System.out.println("ENEMY HAS NO MORE MANA!");
            return;
        };
        
        int index = random.nextInt(movesWeCanDo.size());
        if(mobAttacks == mobSummoner.CYBER_PUNK_ATTACKS){
            cyberPunkAttack(mobStats, playerStats, index);
        }
    }

    
}
