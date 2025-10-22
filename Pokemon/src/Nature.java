// Nature.java
// The "smart" enum that holds its own calculation logic.
public enum Nature {
    HARDY(null, null),
    LONELY(Stat.ATTACK, Stat.DEFENSE),
    BRAVE(Stat.ATTACK, Stat.SPEED),
    ADAMANT(Stat.ATTACK, Stat.SP_ATTACK),
    NAUGHTY(Stat.ATTACK, Stat.SP_DEFENSE),
    BOLD(Stat.DEFENSE, Stat.ATTACK),
    DOCILE(null, null),
    RELAXED(Stat.DEFENSE, Stat.SPEED),
    IMPISH(Stat.DEFENSE, Stat.SP_ATTACK),
    LAX(Stat.DEFENSE, Stat.SP_DEFENSE),
    TIMID(Stat.SPEED, Stat.ATTACK),
    HASTY(Stat.SPEED, Stat.DEFENSE),
    SERIOUS(null, null),
    JOLLY(Stat.SPEED, Stat.SP_ATTACK),
    NAIVE(Stat.SPEED, Stat.SP_DEFENSE),
    MODEST(Stat.SP_ATTACK, Stat.ATTACK),
    MILD(Stat.SP_ATTACK, Stat.DEFENSE),
    QUIET(Stat.SP_ATTACK, Stat.SPEED),
    BASHFUL(null, null),
    RASH(Stat.SP_ATTACK, Stat.SP_DEFENSE),
    CALM(Stat.SP_DEFENSE, Stat.ATTACK),
    GENTLE(Stat.SP_DEFENSE, Stat.DEFENSE),
    SASSY(Stat.SP_DEFENSE, Stat.SPEED),
    CAREFUL(Stat.SP_DEFENSE, Stat.SP_ATTACK),
    QUIRKY(null, null);

    private final Stat increasedStat;
    private final Stat decreasedStat;

    Nature(Stat increased, Stat decreased) {
        this.increasedStat = increased;
        this.decreasedStat = decreased;
    }

    public double getMultiplier(Stat stat) {
        if (stat == this.increasedStat) {
            return 1.1;
        } else if (stat == this.decreasedStat) {
            return 0.9;
        }
        return 1.0;
    }
}