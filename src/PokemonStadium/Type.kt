package PokemonStadium

/**
 * Created by william on 4/18/16.
 */
enum class Type(i: Int) {
    NORMAL(1),
    FIGHTING(2),
    FLYING(3),
    POISON(4),
    GROUND(5),
    ROCK(6),
    BUG(7),
    GHOST(8),
    STEEL(9),
    FIRE(10),
    WATER(11),
    GRASS(12),
    ELECTRIC(13),
    PSYCHIC(14),
    ICE(15),
    DRAGON(16),
    DARK(17),
    FAIRY(18);

    companion object {
        fun FromName(name: String) : Type {
            return Type.valueOf(name.toUpperCase());
        }
    }
}