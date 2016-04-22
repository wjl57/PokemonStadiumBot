package PokeApiScraping

import PokemonStadium.LearnMethod
import PokemonStadium.VersionGroup

/**
 * Created by william on 4/22/16.
 */
data class LearnableMoveDao (
    val Name: String,
    val LearnMethodVersionGroups: List<Pair<LearnMethod, VersionGroup>>
)
