public class Pokemon {

    private Types[] types;
    private int id;
    private String name;
    private Stats stats;
    private Move[] moveset;
    private Pokemon evolvesInto;
    private double currentHP;
    private boolean isFainted;

    public Pokemon() {
        this.types = new Types[2];
        this.id = 0;
        this.name = "Pikachu";
        this.types[0] = Types.FLYING;
        this.types[1] = Types.FIRE;
        this.stats = new Stats();
        this.moveset = new Move[4];
        this.currentHP = 100;
        this.isFainted = false;
        this.moveset[0] = new Move("fire", Types.FIRE);
        this.moveset[1] = new Move("flying", Types.FLYING);
    }

    public Pokemon(int id) {
        this.types = new Types[2];
        this.id = id;
        this.name = "Pikachu";
        this.types[0] = Types.WATER;
        this.stats = new Stats();
        this.moveset = new Move[4];
        this.currentHP = 100;
        this.isFainted = false;
        this.moveset[0] = new Move("water", Types.WATER);
        this.moveset[1] = new Move("steel", Types.STEEL);
    }

    public void takeDamage(int damage) {
        if (damage >= currentHP) {
            currentHP = 0;
            isFainted = true;
        } else if (damage > 0) {
            this.currentHP -= damage;
        }
    }

    public Types[] getTypes() {
        return types;
    }

    public void attacks(Pokemon target, Move move) {
        double dmgMod = Pokemon.calculateDmgMod(this, target, move);





    }


    public static double calculateDmgMod(Pokemon attacker, Pokemon target, Move move) {
        Types[] targetTypes = target.getTypes();

        double mod = TypeChart.getEffectiveness(move.getType(), targetTypes[0]);
        mod = mod*TypeChart.getEffectiveness(move.getType(), targetTypes[1]);

        if(attacker.types[0] == move.getType()||attacker.types[1] == move.getType()) {
            mod = mod * 1.5;
        }

        return mod;
    }

    /**
     * Choose a move to use when attacking
     * @return Move chosen
     */
    public Move getMove(int index){
        return moveset[index];
    }
}