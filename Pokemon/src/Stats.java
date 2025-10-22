import java.util.concurrent.ThreadLocalRandom;

public class Stats {

    private int level;
    private double exp;
    private double nextLevelExp;
    private Nature nature;

    // Base stats
    private int atkBase;
    private int defBase;
    private int spAtkBase;
    private int spDefBase;
    private int spdBase;
    private int hpBase;

    // IV stats
    private int atkIV;
    private int defIV;
    private int spAtkIV;
    private int spDefIV;
    private int spdIV;
    private int hpIV;

    // EV stats
    private int atkEV;
    private int defEV;
    private int spAtkEV;
    private int spDefEV;
    private int spdEV;
    private int hpEV;

    //Final Stats
    private int finalHp;
    private int finalAtk;
    private int finalDef;
    private int finalSpAtk;
    private int finalSpd;
    private int finalSpDef;

    public Stats() {

        this.level = 50;
        this.nature = Nature.HARDY;

        // 1. Set Base Stats from parameters
        this.hpBase = 80;
        this.atkBase = 80;
        this.defBase = 80;
        this.spAtkBase = 80;
        this.spDefBase = 80;
        this.spdBase = 80;

        // 2. Set sensible defaults for a "new" Pokemon
        this.exp = 0;
        setNextLevelExp(); // Use your existing method to calculate this

        // 3. Default all EVs to 0 (a new Pokemon has no training)
        this.hpEV = 0;
        this.atkEV = 0;
        this.defEV = 0;
        this.spAtkEV = 0;
        this.spDefEV = 0;
        this.spdEV = 0;

        // 4. Default IVs to random values (0-31), just like in the games
        // ThreadLocalRandom.current().nextInt(min, max_exclusive)
        this.hpIV = ThreadLocalRandom.current().nextInt(0, 32);
        this.atkIV = ThreadLocalRandom.current().nextInt(0, 32);
        this.defIV = ThreadLocalRandom.current().nextInt(0, 32);
        this.spAtkIV = ThreadLocalRandom.current().nextInt(0, 32);
        this.spDefIV = ThreadLocalRandom.current().nextInt(0, 32);
        this.spdIV = ThreadLocalRandom.current().nextInt(0, 32);

        // 5. CRITICAL STEP: Calculate all final stats
        // This populates finalHp, finalAtk, etc., so the object is ready to use.
        calculateAllStats();
    }

    public Stats(int level, Nature nature,
                 int hpBase, int atkBase, int defBase,
                 int spAtkBase, int spDefBase, int spdBase) {

        this.level = level;
        this.nature = nature;

        // 1. Set Base Stats from parameters
        this.hpBase = hpBase;
        this.atkBase = atkBase;
        this.defBase = defBase;
        this.spAtkBase = spAtkBase;
        this.spDefBase = spDefBase;
        this.spdBase = spdBase;

        // 2. Set sensible defaults for a "new" Pokemon
        this.exp = 0;
        setNextLevelExp(); // Use your existing method to calculate this

        // 3. Default all EVs to 0 (a new Pokemon has no training)
        this.hpEV = 0;
        this.atkEV = 0;
        this.defEV = 0;
        this.spAtkEV = 0;
        this.spDefEV = 0;
        this.spdEV = 0;

        // 4. Default IVs to random values (0-31), just like in the games
        // ThreadLocalRandom.current().nextInt(min, max_exclusive)
        this.hpIV = ThreadLocalRandom.current().nextInt(0, 32);
        this.atkIV = ThreadLocalRandom.current().nextInt(0, 32);
        this.defIV = ThreadLocalRandom.current().nextInt(0, 32);
        this.spAtkIV = ThreadLocalRandom.current().nextInt(0, 32);
        this.spDefIV = ThreadLocalRandom.current().nextInt(0, 32);
        this.spdIV = ThreadLocalRandom.current().nextInt(0, 32);

        // 5. CRITICAL STEP: Calculate all final stats
        // This populates finalHp, finalAtk, etc., so the object is ready to use.
        calculateAllStats();
    }

    public Nature getNature() {
        return nature;
    }

    public void setNature(Nature nature) {
        this.nature = nature;
    }

    public void calculateAllStats() {
        // We must ensure nature is not null to avoid errors.
        if (this.nature == null) {
            this.nature = Nature.HARDY; // Default to a neutral nature
        }

        // 1. Calculate HP (Unique Formula)
        // Formula: (((2 * Base + IV + (EV / 4)) * Level) / 100) + 10 + Level
        double evBonusHp = Math.floor(this.hpEV / 4.0);
        double term1Hp = (2.0 * this.hpBase + this.hpIV + evBonusHp) * this.level;
        double term2Hp = Math.floor(term1Hp / 100.0);
        this.finalHp = (int) (term2Hp + 10 + this.level);

        // 2. Calculate Attack
        // Formula: ((((2 * Base + IV + (EV / 4)) * Level) / 100) + 5) * Nature
        double evBonusAtk = Math.floor(this.atkEV / 4.0);
        double term1Atk = (2.0 * this.atkBase + this.atkIV + evBonusAtk) * this.level;
        double term2Atk = Math.floor(term1Atk / 100.0) + 5;
        this.finalAtk = (int) (Math.floor(term2Atk * this.nature.getMultiplier(Stat.ATTACK)));

        // 3. Calculate Defense
        double evBonusDef = Math.floor(this.defEV / 4.0);
        double term1Def = (2.0 * this.defBase + this.defIV + evBonusDef) * this.level;
        double term2Def = Math.floor(term1Def / 100.0) + 5;
        this.finalDef = (int) (Math.floor(term2Def * this.nature.getMultiplier(Stat.DEFENSE)));

        // 4. Calculate Special Attack
        double evBonusSpAtk = Math.floor(this.spAtkEV / 4.0);
        double term1SpAtk = (2.0 * this.spAtkBase + this.spAtkIV + evBonusSpAtk) * this.level;
        double term2SpAtk = Math.floor(term1SpAtk / 100.0) + 5;
        this.finalSpAtk = (int) (Math.floor(term2SpAtk * this.nature.getMultiplier(Stat.SP_ATTACK)));

        // 5. Calculate Special Defense
        double evBonusSpDef = Math.floor(this.spDefEV / 4.0);
        double term1SpDef = (2.0 * this.spDefBase + this.spDefIV + evBonusSpDef) * this.level;
        double term2SpDef = Math.floor(term1SpDef / 100.0) + 5;
        this.finalSpDef = (int) (Math.floor(term2SpDef * this.nature.getMultiplier(Stat.SP_DEFENSE)));

        // 6. Calculate Speed
        double evBonusSpd = Math.floor(this.spdEV / 4.0);
        double term1Spd = (2.0 * this.spdBase + this.spdIV + evBonusSpd) * this.level;
        double term2Spd = Math.floor(term1Spd / 100.0) + 5;
        this.finalSpd = (int) (Math.floor(term2Spd * this.nature.getMultiplier(Stat.SPEED)));
    }



    //Level and EXP methods
    public int getLevel() {
        return level;
    }

    public void levelUp() {
        this.level++;
        calculateAllStats();
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
        this.level = (int) Math.floor(Math.cbrt(this.exp));
        setNextLevelExp();
        calculateAllStats();
    }

    public void setNextLevelExp() {
        this.nextLevelExp = (this.level+1) * (this.level+1) * (this.level+1);
    }

    public void earnExp(int expEarned) {
        if(expEarned + this.exp >= nextLevelExp) {
            exp = exp + expEarned;
            levelUp();
        }else {
            this.exp += expEarned;
        }
    }

    //Change EV Values
    public void setAtkEV(int atkEV) {
        this.atkEV = atkEV;
        calculateAllStats();
    }

    public void setDefEV(int defEV) {
        this.defEV = defEV;
        calculateAllStats();
    }

    public void setSpAtkEV(int spAtkEV) {
        this.spAtkEV = spAtkEV;
        calculateAllStats();
    }

    public void setSpDefEV(int spDefEV) {
        this.spDefEV = spDefEV;
        calculateAllStats();
    }

    public void setSpdEV(int spdEV) {
        this.spdEV = spdEV;
        calculateAllStats();
    }

    public void setHpEV(int hpEV) {
        this.hpEV = hpEV;
        calculateAllStats();
    }

    public void changeAtkEV(int EV) {
        this.atkEV += EV;
        calculateAllStats();
    }

    public void changeDefEV(int EV) {
        this.defEV += EV;
        calculateAllStats();
    }

    public void changeSpAtkEV(int EV) {
        this.spAtkEV += EV;
        calculateAllStats();
    }

    public void changeSpDefEV(int EV) {
        this.spDefEV += EV;
        calculateAllStats();
    }

    public void changeHpEV(int EV) {
        this.hpEV += EV;
        calculateAllStats();
    }

    public void changeSpdEV(int EV) {
        this.spdEV += EV;
        calculateAllStats();
    }


    public int getFinalHp() {
        return finalHp;
    }

    public int getFinalAtk() {
        return finalAtk;
    }


    public int getFinalDef() {
        return finalDef;
    }

    public int getFinalSpAtk() {
        return finalSpAtk;
    }

    public int getFinalSpd() {
        return finalSpd;
    }

    public int getFinalSpDef() {
        return finalSpDef;
    }
}
