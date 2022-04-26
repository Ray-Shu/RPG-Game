public class Combat {
    String playerAttacks;
    Stats playerStats;
    Stats mobStats;
    String mobAttacks;


    Combat(Stats playerStats, String playerAttacks, Stats mobStats , String mobAttacks){
        this.playerAttacks = playerAttacks;
        this.playerStats = playerStats;
        this.mobStats = mobStats;
        this.mobAttacks = mobAttacks;
    }

    public void playerTurn() {

    }

    
    public boolean isPlayerTurn() {
        Double playerSpeed = playerStats.spd;
        Double mobSpeed = mobStats.spd;

        if (playerSpeed >  mobSpeed){return true;}
        else{return false;}
    }


}
