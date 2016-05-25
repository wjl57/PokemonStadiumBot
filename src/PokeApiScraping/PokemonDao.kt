package PokeApiScraping

import PokemonStadium.*

/**
 * Created by william on 4/21/16.
 */
data class PokemonDao(
    val PokemonId: Int,
    val Name: String,
    val LearnableMoves: List<LearnableMoveDao>,
    val TypeNames: Set<Type>,
    val BaseStats: BaseStatsDao
)