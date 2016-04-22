package PokemonStadium

/**
 * Created by william on 4/22/16.
 */
enum class VersionGroup(i: Int) {
    NOT_SUPPORTED(0),
    RED_BLUE(1),
    YELLOW(2),
    GOLD_SILVER(3),
    CRYSTAL(4),
    RUBY_SAPPHIRE(5),
    EMERALD(6),
    FIRERED_LEAFGREEN(7),
//    DIAMOND_PEARL(8),
//    PLATINUM(9),
//    HEARTGOLD_SOULSILVER(10),
//    BLACK_WHITE(11),
//    COLOSSEUM(12),
//    XD(13),
//    BLACK2_WHITE2(14),
//    X_Y(15),
//    OMEGA_RUBY_ALPHA_SAPPHIRE(16)
    ;

    companion object {
        fun FromName(name: String) : VersionGroup {
            return when(name) {
                "red-blue" -> RED_BLUE
                "yellow" -> YELLOW
                "gold-silver" -> GOLD_SILVER
                "crystal" -> CRYSTAL
                "ruby-sapphire" -> RUBY_SAPPHIRE
                "emerald" -> EMERALD
                "firered-leafgreen" ->FIRERED_LEAFGREEN
                else -> NOT_SUPPORTED
            }
        }
    }
}