package PokemonStadium

/**
 * Created by william on 4/18/16.
 */
enum class DamageClass(i: Int) {
    STATUS(1),
    PHYSICAL(2),
    SPECIAL(3);

    companion object {
        fun FromName(name: String) : DamageClass {
            return DamageClass.valueOf(name.toUpperCase());
        }
    }
}