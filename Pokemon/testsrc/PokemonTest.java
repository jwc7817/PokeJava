import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {
    Pokemon firetype = new Pokemon();
    Pokemon watertype = new Pokemon(1);



    @Test
    void calculateTypeEffectiveness() {
        double damage = Pokemon.calculateDmgMod(firetype, watertype, firetype.getMove(0));
        assertEquals(0.50, damage, 0.001);

        damage = Pokemon.calculateDmgMod(firetype,watertype, firetype.getMove(0));
        assertEquals(0.50, damage, 0.001);

        damage = Pokemon.calculateDmgMod(watertype, firetype, watertype.getMove(0));
        assertEquals(2.0, damage, 0.001);
    }

    @Test
    void calculateTypeEffectiveness2() {
        System.out.println(BattleUtilities.calculateDmg(watertype, firetype, watertype.getMove(0)));



    }

}