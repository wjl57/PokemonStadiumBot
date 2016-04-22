package PokemonStadium

/**
 * Created by william on 4/18/16.
 */
enum class AttackTarget(i: Int) {

    // Catch all for non supported Target types
    NOT_SUPPORTED(-1),

    // Depends upon on the move being used.
    // (Counter, Mirror Coat)
    SPECIFIC_MOVE(1),

    // One other Pokemon on the field, selected by the trainer.
    // (Me First)
    SELECTED_POKEMON_ME_FIRST(2),

    // The user's ally (if any).
    // (Helping hands)
    ALLY(3),

    // The user's side of the field. Affects the user and its ally (if any).
    // (Mist, Light Screen)
    USERS_FIELD(4),

    // Either the user or its ally, selected by the trainer.
    // (Acupressure)
    USER_OR_ALLY(5),

    // The opposing side of the field. Affects opposing Pokemon.
    // (Toxic Spikes, Shadow Mist)
    OPPONENTS_FIELD(6),

    // The user.
    // (Agility, Harden)
    USER(7),

    // One opposing Pokemon, selected at random.
    // (Uproar)
    RANDOM_OPPONENT(8),

    // Every other Pokemon on the field.
    // (Surf, Self-Destruct)
    ALL_OTHER_POKEMON(9),

    // One other Pokemon on the field, selected by the trainer.
    // (Tackle, Ice Beam)
    SELECTED_POKEMON(10),

    // All opposing Pokemon.
    // (Leer, Muddy Water)
    ALL_OPPONENTS(11),

    // The entire field. Affects all Pokemon.
    // (Sunny Day, Water Sport)
    ENTIRE_FIELD(12),

    // The user and its allies.
    // (Heal Bell)
    USER_AND_ALLIES(13),

    // Every Pokemon on the field.
    // (Perish Song)
    ALL_POKEMON(14);

    companion object {
        fun FromName(name: String) : AttackTarget {
            return when(name) {
//                "specific-move" -> SPECIFIC_MOVE
//                "selected-pokemon-me-first" -> SELECTED_POKEMON_ME_FIRST
//                "ally" -> ALLY
//                "users-field" -> USERS_FIELD
//                "user-or-ally" -> USER_OR_ALLY
                "opponents-field" -> OPPONENTS_FIELD
                "user" -> USER
                "random-opponent" -> RANDOM_OPPONENT
                "all-other-pokemon" -> ALL_OTHER_POKEMON
                "all-opponents" -> ALL_OPPONENTS
                "selected-pokemon" -> SELECTED_POKEMON
//                "entire-field" -> ENTIRE_FIELD
//                "user-and-allies" -> USER_AND_ALLIES
//                "all-pokemon" -> ALL_POKEMON

                else -> NOT_SUPPORTED
            }
        }
    }

}