public class Stats {

    private int level;
    private double exp;

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

    public int getAtkBase() {
        return atkBase;
    }

    public int getDefBase() {
        return defBase;
    }

    public int getSpAtkBase() {
        return spAtkBase;
    }

    public int getSpDefBase() {
        return spDefBase;
    }

    public int getSpdBase() {
        return spdBase;
    }

    public int getHpBase() {
        return hpBase;
    }

    public int getAtkIV() {
        return atkIV;
    }

    public void setAtkIV(int atkIV) {
        this.atkIV = atkIV;
    }

    public int getDefIV() {
        return defIV;
    }

    public void setDefIV(int defIV) {
        this.defIV = defIV;
    }

    public int getSpAtkIV() {
        return spAtkIV;
    }

    public void setSpAtkIV(int spAtkIV) {
        this.spAtkIV = spAtkIV;
    }

    public int getSpDefIV() {
        return spDefIV;
    }

    public void setSpDefIV(int spDefIV) {
        this.spDefIV = spDefIV;
    }

    public int getSpdIV() {
        return spdIV;
    }

    public void setSpdIV(int spdIV) {
        this.spdIV = spdIV;
    }

    public int getHpIV() {
        return hpIV;
    }

    public void setHpIV(int hpIV) {
        this.hpIV = hpIV;
    }

    public int getAtkEV() {
        return atkEV;
    }

    public void setAtkEV(int atkEV) {
        this.atkEV = atkEV;
    }

    public int getDefEV() {
        return defEV;
    }

    public void setDefEV(int defEV) {
        this.defEV = defEV;
    }

    public int getSpAtkEV() {
        return spAtkEV;
    }

    public void setSpAtkEV(int spAtkEV) {
        this.spAtkEV = spAtkEV;
    }

    public int getSpDefEV() {
        return spDefEV;
    }

    public void setSpDefEV(int spDefEV) {
        this.spDefEV = spDefEV;
    }

    public int getSpdEV() {
        return spdEV;
    }

    public void setSpdEV(int spdEV) {
        this.spdEV = spdEV;
    }

    public int getHpEV() {
        return hpEV;
    }

    public void setHpEV(int hpEV) {
        this.hpEV = hpEV;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp(int level) {
        this.level++;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }
}
