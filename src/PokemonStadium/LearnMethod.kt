package PokemonStadium

/**
 * Created by william on 4/22/16.
 */
enum class LearnMethod(i: Int) {
    NOT_SUPPORTED(-1),
    LEVEL_UP(1),
    EGG(2),
    TUTOR(3),
    MACHINE(4);

    companion object {
        fun FromName(name: String) : LearnMethod {
            return when(name) {
                "level-up" -> LEVEL_UP
                "egg" -> EGG
                "tutor" -> TUTOR
                "machine" -> MACHINE
                else -> NOT_SUPPORTED
            }
        }
    }
}