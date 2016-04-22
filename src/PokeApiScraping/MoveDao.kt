package PokeApiScraping

import PokemonStadium.DamageClass
import PokemonStadium.Type
import PokemonStadium.AttackTarget

/**
 * Created by william on 4/21/16.
 */

data class MoveDao (
    val MoveId: Int,
    val Name: String,
    val Accuracy: Int?,
    val EffectChance: Int?,
    val Pp: Int?,
    val Priority: Int?,
    val Power: Int?,
    val Target: AttackTarget,
    val Type: Type,
    val DamageClass: DamageClass,
    val EffectEntries: String?,
    val MinHits: Int?,
    val MaxHits: Int?,
    val MinTurns: Int?,
    val MaxTurns: Int?,
    val Drain: Int?,
    val Healing: Int?,
    val CritRate: Int?,
    val AilmentChance: Int?,
    val FlinchChance: Int?,
    val StatChance: Int?
)