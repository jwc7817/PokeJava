import java.util.Random;

public class BattleUtilities {


    public static double calculateDmgMod(Pokemon attacker, Pokemon target, Move move) {
        Random rand = new Random(System.currentTimeMillis());
        Types[] attackerTypes = attacker.getTypes();
        Types[] targetTypes = target.getTypes();

        //Type Effectiveness mod
        double mod = TypeChart.getEffectiveness(move.getType(), targetTypes[0]);
        mod = mod*TypeChart.getEffectiveness(move.getType(), targetTypes[1]);

        //Stab Modifier
        if(attackerTypes[0] == move.getType()||attackerTypes[1] == move.getType()) {
            mod = mod * 1.5;
        }

        //Variability modifier
        mod = mod * (100 - rand.nextInt(15))*0.01;

        return mod;
    }

    public static double calculateDmg(Pokemon attacker, Pokemon target, Move move) {
        Stats attackerStats = attacker.getStats();
        Stats targetStats = target.getStats();
        int level = attackerStats.getLevel();
        int power = move.getPower();
        double atk, def;

        //Physical or Special Atk
        if(move.getMoveType() == MoveType.PHYSICAL){
            atk = attackerStats.getFinalAtk();
            def = targetStats.getFinalDef();
        }else if(move.getMoveType() == MoveType.SPECIAL){
            atk = attackerStats.getFinalSpAtk();
            def = targetStats.getFinalSpDef();
        }else {
            atk =1;
            def = 1;
        }



        return (((((2.0*level)/5.0)+2.0)*power*(atk/def)/50.0)+2.0)*calculateDmgMod(attacker, target, move);
    }

}
