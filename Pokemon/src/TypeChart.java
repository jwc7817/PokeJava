// 2. Create a class to manage the type chart.

import java.util.Map;
import java.util.HashMap;

public class TypeChart {

    // Using a Map where the key is the attacking type,
    // and the value is another Map. The inner Map's key is the defending type
    // and its value is the effectiveness multiplier.
    private static final Map<Types, Map<Types, Double>> effectivenessChart = new HashMap<>();

    // A static initializer block to populate the chart when the class is loaded.
    static {
        // --- NORMAL ---
        Map<Types, Double> normalMap = new HashMap<>();
        normalMap.put(Types.ROCK, 0.5);
        normalMap.put(Types.GHOST, 0.0);
        normalMap.put(Types.STEEL, 0.5);
        effectivenessChart.put(Types.NORMAL, normalMap);

        // --- FIRE ---
        Map<Types, Double> fireMap = new HashMap<>();
        fireMap.put(Types.FIRE, 0.5);
        fireMap.put(Types.WATER, 0.5);
        fireMap.put(Types.GRASS, 2.0);
        fireMap.put(Types.ICE, 2.0);
        fireMap.put(Types.BUG, 2.0);
        fireMap.put(Types.ROCK, 0.5);
        fireMap.put(Types.DRAGON, 0.5);
        fireMap.put(Types.STEEL, 2.0);
        effectivenessChart.put(Types.FIRE, fireMap);

        // --- WATER ---
        Map<Types, Double> waterMap = new HashMap<>();
        waterMap.put(Types.FIRE, 2.0);
        waterMap.put(Types.WATER, 0.5);
        waterMap.put(Types.GRASS, 0.5);
        waterMap.put(Types.GROUND, 2.0);
        waterMap.put(Types.ROCK, 2.0);
        waterMap.put(Types.DRAGON, 0.5);
        effectivenessChart.put(Types.WATER, waterMap);

        // --- GRASS ---
        Map<Types, Double> grassMap = new HashMap<>();
        grassMap.put(Types.FIRE, 0.5);
        grassMap.put(Types.WATER, 2.0);
        grassMap.put(Types.GRASS, 0.5);
        grassMap.put(Types.POISON, 0.5);
        grassMap.put(Types.GROUND, 2.0);
        grassMap.put(Types.FLYING, 0.5);
        grassMap.put(Types.BUG, 0.5);
        grassMap.put(Types.ROCK, 2.0);
        grassMap.put(Types.DRAGON, 0.5);
        grassMap.put(Types.STEEL, 0.5);
        effectivenessChart.put(Types.GRASS, grassMap);

        // --- ELECTRIC ---
        Map<Types, Double> electricMap = new HashMap<>();
        electricMap.put(Types.WATER, 2.0);
        electricMap.put(Types.GRASS, 0.5);
        electricMap.put(Types.ELECTRIC, 0.5);
        electricMap.put(Types.GROUND, 0.0);
        electricMap.put(Types.FLYING, 2.0);
        electricMap.put(Types.DRAGON, 0.5);
        effectivenessChart.put(Types.ELECTRIC, electricMap);

        // --- ICE ---
        Map<Types, Double> iceMap = new HashMap<>();
        iceMap.put(Types.FIRE, 0.5);
        iceMap.put(Types.WATER, 0.5);
        iceMap.put(Types.GRASS, 2.0);
        iceMap.put(Types.ICE, 0.5);
        iceMap.put(Types.GROUND, 2.0);
        iceMap.put(Types.FLYING, 2.0);
        iceMap.put(Types.DRAGON, 2.0);
        iceMap.put(Types.STEEL, 0.5);
        effectivenessChart.put(Types.ICE, iceMap);

        // --- FIGHTING ---
        Map<Types, Double> fightingMap = new HashMap<>();
        fightingMap.put(Types.NORMAL, 2.0);
        fightingMap.put(Types.ICE, 2.0);
        fightingMap.put(Types.POISON, 0.5);
        fightingMap.put(Types.FLYING, 0.5);
        fightingMap.put(Types.PSYCHIC, 0.5);
        fightingMap.put(Types.BUG, 0.5);
        fightingMap.put(Types.ROCK, 2.0);
        fightingMap.put(Types.GHOST, 0.0);
        fightingMap.put(Types.DARK, 2.0);
        fightingMap.put(Types.STEEL, 2.0);
        fightingMap.put(Types.FAIRY, 0.5);
        effectivenessChart.put(Types.FIGHTING, fightingMap);

        // --- POISON ---
        Map<Types, Double> poisonMap = new HashMap<>();
        poisonMap.put(Types.GRASS, 2.0);
        poisonMap.put(Types.POISON, 0.5);
        poisonMap.put(Types.GROUND, 0.5);
        poisonMap.put(Types.ROCK, 0.5);
        poisonMap.put(Types.GHOST, 0.5);
        poisonMap.put(Types.STEEL, 0.0);
        poisonMap.put(Types.FAIRY, 2.0);
        effectivenessChart.put(Types.POISON, poisonMap);

        // --- GROUND ---
        Map<Types, Double> groundMap = new HashMap<>();
        groundMap.put(Types.FIRE, 2.0);
        groundMap.put(Types.GRASS, 0.5);
        groundMap.put(Types.ELECTRIC, 2.0);
        groundMap.put(Types.POISON, 2.0);
        groundMap.put(Types.FLYING, 0.0);
        groundMap.put(Types.BUG, 0.5);
        groundMap.put(Types.ROCK, 2.0);
        groundMap.put(Types.STEEL, 2.0);
        effectivenessChart.put(Types.GROUND, groundMap);

        // --- FLYING ---
        Map<Types, Double> flyingMap = new HashMap<>();
        flyingMap.put(Types.GRASS, 2.0);
        flyingMap.put(Types.ELECTRIC, 0.5);
        flyingMap.put(Types.FIGHTING, 2.0);
        flyingMap.put(Types.BUG, 2.0);
        flyingMap.put(Types.ROCK, 0.5);
        flyingMap.put(Types.STEEL, 0.5);
        effectivenessChart.put(Types.FLYING, flyingMap);

        // --- PSYCHIC ---
        Map<Types, Double> psychicMap = new HashMap<>();
        psychicMap.put(Types.FIGHTING, 2.0);
        psychicMap.put(Types.POISON, 2.0);
        psychicMap.put(Types.PSYCHIC, 0.5);
        psychicMap.put(Types.DARK, 0.0);
        psychicMap.put(Types.STEEL, 0.5);
        effectivenessChart.put(Types.PSYCHIC, psychicMap);

        // --- BUG ---
        Map<Types, Double> bugMap = new HashMap<>();
        bugMap.put(Types.FIRE, 0.5);
        bugMap.put(Types.GRASS, 2.0);
        bugMap.put(Types.FIGHTING, 0.5);
        bugMap.put(Types.POISON, 0.5);
        bugMap.put(Types.FLYING, 0.5);
        bugMap.put(Types.PSYCHIC, 2.0);
        bugMap.put(Types.GHOST, 0.5);
        bugMap.put(Types.DARK, 2.0);
        bugMap.put(Types.STEEL, 0.5);
        bugMap.put(Types.FAIRY, 0.5);
        effectivenessChart.put(Types.BUG, bugMap);

        // --- ROCK ---
        Map<Types, Double> rockMap = new HashMap<>();
        rockMap.put(Types.FIRE, 2.0);
        rockMap.put(Types.ICE, 2.0);
        rockMap.put(Types.FIGHTING, 0.5);
        rockMap.put(Types.GROUND, 0.5);
        rockMap.put(Types.FLYING, 2.0);
        rockMap.put(Types.BUG, 2.0);
        rockMap.put(Types.STEEL, 0.5);
        effectivenessChart.put(Types.ROCK, rockMap);

        // --- GHOST ---
        Map<Types, Double> ghostMap = new HashMap<>();
        ghostMap.put(Types.NORMAL, 0.0);
        ghostMap.put(Types.PSYCHIC, 2.0);
        ghostMap.put(Types.GHOST, 2.0);
        ghostMap.put(Types.DARK, 0.5);
        effectivenessChart.put(Types.GHOST, ghostMap);

        // --- DRAGON ---
        Map<Types, Double> dragonMap = new HashMap<>();
        dragonMap.put(Types.DRAGON, 2.0);
        dragonMap.put(Types.STEEL, 0.5);
        dragonMap.put(Types.FAIRY, 0.0);
        effectivenessChart.put(Types.DRAGON, dragonMap);

        // --- DARK ---
        Map<Types, Double> darkMap = new HashMap<>();
        darkMap.put(Types.FIGHTING, 0.5);
        darkMap.put(Types.PSYCHIC, 2.0);
        darkMap.put(Types.GHOST, 2.0);
        darkMap.put(Types.DARK, 0.5);
        darkMap.put(Types.FAIRY, 0.5);
        effectivenessChart.put(Types.DARK, darkMap);

        // --- STEEL ---
        Map<Types, Double> steelMap = new HashMap<>();
        steelMap.put(Types.FIRE, 0.5);
        steelMap.put(Types.WATER, 0.5);
        steelMap.put(Types.ELECTRIC, 0.5);
        steelMap.put(Types.ICE, 2.0);
        steelMap.put(Types.ROCK, 2.0);
        steelMap.put(Types.STEEL, 0.5);
        steelMap.put(Types.FAIRY, 2.0);
        effectivenessChart.put(Types.STEEL, steelMap);

        // --- FAIRY ---
        Map<Types, Double> fairyMap = new HashMap<>();
        fairyMap.put(Types.FIRE, 0.5);
        fairyMap.put(Types.FIGHTING, 2.0);
        fairyMap.put(Types.POISON, 0.5);
        fairyMap.put(Types.DRAGON, 2.0);
        fairyMap.put(Types.DARK, 2.0);
        fairyMap.put(Types.STEEL, 0.5);
        effectivenessChart.put(Types.FAIRY, fairyMap);
    }

    /**
     * Calculates the damage multiplier for an attack.
     * @param attacker The type of the move being used.
     * @param defender The type of the Pokémon being hit.
     * @return The damage multiplier (e.g., 2.0, 1.0, 0.5).
     */
    public static double getEffectiveness(Types attacker, Types defender) {
        // First, check if the attacker type is even in our chart.
        Map<Types, Double> attackerMap = effectivenessChart.get(attacker);

        if (attackerMap == null) {
            return 1.0; // Default to neutral damage if attacker type has no special interactions.
        }

        // If the attacker map exists, get the defender's multiplier.
        // The .getOrDefault() method is great here: if the defending type isn't
        // in the map, it means the interaction is neutral, so we return 1.0.
        return attackerMap.getOrDefault(defender, 1.0);
    }
}