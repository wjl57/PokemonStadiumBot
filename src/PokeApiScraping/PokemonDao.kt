package PokeApiScraping

/**
 * Created by william on 4/21/16.
 */
data class PokemonDao(
    val PokemonId: Int,
    val Name: String,
    val LearnableMoves: List<LearnableMoveDao>,
    val TypeNames: List<String>,
    val Hp: Int,
    val Attack: Int,
    val Defense: Int,
    val SpAttack: Int,
    val SpDefense: Int,
    val Speed: Int
)