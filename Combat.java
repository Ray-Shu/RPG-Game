public class Combat {
    String playerAttacks, mobAttacks;
    Stats playerStats, mobStats;
    Double playerTurnRate, mobTurnRate;
    
    Combat(Stats playerStats, String playerAttacks, Stats mobStats , String mobAttacks){
        this.playerAttacks = playerAttacks;
        this.playerStats = playerStats;
        this.mobStats = mobStats;
        this.mobAttacks = mobAttacks;
    }

    /**
     * Turns are based on speed. The player with the highest speed will get the turn. 
     */
    public boolean isPlayerTurn() {
        if (playerTurnRate> mobTurnRate){return true;}
        else{return false;}
    }
    
    /**
     * After an attack, we subtract the other player's turn rate to it and then give the other player their turn rate. 
     */
    public void playerTurnOver() {
        playerTurnRate -= mobTurnRate;
        mobTurnRate += mobStats.spd;
    }

    /**
     * Same as player turn rate, but opposite. 
     */
    public void mobTurnOver() {
        mobTurnRate -= playerTurnRate;
        playerTurnRate += playerStats.spd;
    }

    public void playerAttack() {
        
    }

    public void mobAttack() {

    }

    public void listAttacks() {

    }

    public void disabled(Stats attackerStats, Stats victimStats) {
        
    }

//* PAST THIS POINT IS ATTACKS: 

    // CYBORG ATTACKS: 
    public void laser_barrage (Stats attackerStats, Stats victimStats) {
        
    }

    public void charged_shot (Stats attackerStats, Stats victimStats) {

    }

    public void cyber_shield (Stats attackerStats, Stats victimStats) {

    }

    public void overload (Stats attackerStats, Stats victimStats) {

    }

    // HACKER ATTACKS: 
    public void drone_army (Stats attackerStats, Stats victimStats) {

    }

    public void unlucky_missile (Stats attackerStats, Stats victimStats) {

    }

    public void watchful_vulture (Stats attackerStats, Stats victimStats) {

    }

    public void in_the_system (Stats attackerStats, Stats victimStats) {

    }

    // TERMINATOR ATTACKS:
    public void machine_gun_fury (Stats attackerStats, Stats victimStats) {

    }
    public void first_impact_fists (Stats attackerStats, Stats victimStats) {

    }
    public void decieving_blast_of_cybernetic_proportions (Stats attackerStats, Stats victimStats) {

    }
    public void hunker_down (Stats attackerStats, Stats victimStats) {

    }
    
    // LAZER SWORDSMAN ATTACKS: 
    public void swift_thrust_of_the_sword (Stats attackerStats, Stats victimStats) {
        
    }
    public void fatal_erruption_of_bullets (Stats attackerStats, Stats victimStats) {

    }
    public void lightning_clone_strike (Stats attackerStats, Stats victimStats) {

    }
    public void rest (Stats attackerStats) {

    }

    // ROGUE ATTACKS: 
    public void quick_blast (Stats attackerStats, Stats victimStats) {

    }
    public void in_the_system (Stats attackerStats, Stats victimStats) {

    }
    public void in_the_system (Stats attackerStats, Stats victimStats) {

    }
    public void forbidden_smoke_of_the_holy_tree (Stats attackerStats, Stats victimStats) {

    }

    // MYSTIC ATTACKS: 
    public void in_the_system (Stats attackerStats, Stats victimStats) {

    }
    public void in_the_system (Stats attackerStats, Stats victimStats) {

    }
    public void in_the_system (Stats attackerStats, Stats victimStats) {

    }
    public void in_the_system (Stats attackerStats, Stats victimStats) {

    }

}
