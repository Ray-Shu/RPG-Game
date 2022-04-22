public class Stats {
    public static Double luck, hp, mp, spd, atk, pd, md, def, endurance, stamina, physRes, magicRes;

    //This class will contain information about the stats of the player and the mobs. 
    Stats(Double luck, Double hp, Double mp, Double spd, Double atk, Double pd, Double md, Double def, Double endurance, Double stamina, Double physRes, Double magicRes){
        this.luck = luck;
        this.hp = hp;
        this.mp = mp;
        this.spd = spd; 
        this.atk = atk; 
        this.pd = pd;
        this.def = def;
        this.stamina = stamina;
        this.physRes = physRes;
        this.magicRes = magicRes;
    }

}
