import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Combat extends Moves{
    String[] mobAttacks;
    Stats  mobStats, playerStats;
    double playerTurnRate, mobTurnRate;
    Player player;
    Random random = new Random();
    Scanner scan = new Scanner(System.in);
    int[] attackCosts;
    DecimalFormat df = new DecimalFormat("###.00");

    /**
     * Constructs a fight between a player and a mob. 
     * @param player this is the player who is fighting the mob
     * @param playerStats this is the stats of that player
     * @param mobStats this is the stats of the mob
     * @param mobAttacks this is the list of possible mob attacks. 
     */
    Combat(Player player, Stats playerStats, Stats mobStats , String[] mobAttacks){
        this.playerStats = playerStats;
        this.player = player;
        this.mobStats = mobStats;
        this.mobAttacks = mobAttacks;
        this.attackCosts = player.chosenAttacksCost;

        mobTurnRate = mobStats.currentSpd;
        playerTurnRate = playerStats.currentSpd;    }

    public void fight() {
        while(playerStats.currentHP > 0 && mobStats.currentHP > 0){
            if (isPlayerTurn() && playerStats.howLongDisabled == 0){
                
                Printer.print("Mob turn Rate: "+ mobTurnRate + " Player turn Rate: "+ playerTurnRate);
                Printer.printColor("----------------------------------------------------------", "cyan");
                Printer.printColor(" It is your turn! Current MP: "+ playerStats.currentMP + " Current HP: "+ df.format(playerStats.currentHP) + "\n", "cyan");
                playerMove(playerStats, mobStats);
                checkPlayerBoosts();
                playerTurnOver();
            }
            else if (mobStats.howLongDisabled == 0){
                Printer.print("Mob turn Rate: "+ mobTurnRate + " Player turn Rate: "+ playerTurnRate);
                Printer.printColor("----------------------------------------------------------", "red");
                Printer.printColor(" It is the opponents turn! Current MP: "+ mobStats.currentMP + " Current HP: "+ df.format(mobStats.currentHP) + "\n", "red");
                mobMove(mobStats, playerStats);
                checkMobBoosts();
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


    public void whoDied () {
        if(playerStats.currentHP <= 0){
            Printer.printColor("Player has been defeated", "red");
        }
        else{
            Printer.printColor("Mob has been defeated!", "green");
        }
    }
    /**
     * Prints out a list of the attacks of the user, along with all the options like leave and inventory. 
     * todo: Implement leave and inventory options. 
     * todo: Implement mp costs
     */
    public void listAttacks() {
        int i = 0;
        Printer.printColor("Here are your moves:\n", "cyan");
        while(i < player.chosenAttacks.length) {
            Printer.printColor("("+ (i + 1) + ") "+ player.chosenAttacks[i], "white");
            i++;
        }
        Printer.print("("+(i + 1)+") Inventory\n -------------------------------------------------");

    }
    
    /**
     * Prints out the player's moves, then does the attack based on their response. 
     */
    public void playerMove( Stats attackerStats, Stats victimStats) {
        listAttacks();
        
        //checks which class we are, and then prompts them to answer a thing. 
        if (player.chosenAttacks == player.CYBORG_ATTACKS){
            cyborgAttack(attackerStats, victimStats);
        }
        else if (player.chosenAttacks == player.HACKER_ATTACKS){
            hackAttack(attackerStats, victimStats);
        }
        else if (player.chosenAttacks == player.TERMINATOR_ATTACKS){
            terminatorAttack(attackerStats, victimStats);
        }
        else if (player.chosenAttacks == player.SWORDSMAN_ATTACKS){
            swordsmanAttack(attackerStats, victimStats);
        }
        else if (player.chosenAttacks == player.ROGUE_ATTACKS){
            rogueAttack(attackerStats, victimStats);
        }
        else if (player.chosenAttacks == player.MYSTIC_ATTACKS){
            mysticAttack(attackerStats, victimStats);
        }
        else {
            reverendAttack(attackerStats, victimStats);
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
    public void mobMove(Stats mobStats2, Stats playerStats2) {
        
    }

    
}
