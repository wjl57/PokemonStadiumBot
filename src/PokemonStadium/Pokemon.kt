package PokemonStadium

import PokeApiScraping.CurrentStatsDao
import PokeApiScraping.MoveDao
import PokeApiScraping.PokemonDao

/**
 * Created by william on 4/18/16.
 */
class Pokemon {
    val Level: Int
    val Name: String
    val MaxHp: Int
    var Hp: Int
    val Attack: Int
    val Defense: Int
    val SpAttack: Int
    val SpDefense: Int
    val Speed: Int
    val TypeNames: Set<Type>
    val Moves: List<MoveDao>

    constructor(level: Int, pokemonDao: PokemonDao, moves: List<MoveDao>) {
        Level = level
        Name = pokemonDao.Name
        MaxHp = pokemonDao.BaseStats.Hp
        Hp = pokemonDao.BaseStats.Hp
        Attack = pokemonDao.BaseStats.Attack
        Defense = pokemonDao.BaseStats.Defense
        SpAttack = pokemonDao.BaseStats.SpAttack
        SpDefense = pokemonDao.BaseStats.SpDefense
        Speed = pokemonDao.BaseStats.Speed
        TypeNames = pokemonDao.TypeNames
        // TODO: Get move daos from pokemonDao.LearnableMoves
        Moves = listOf()
    }

    constructor(level: Int, name: String, types: Set<Type>, moves: List<MoveDao>, stats: CurrentStatsDao) {
        Level = level
        Name = name
        MaxHp = stats.MaxHp
        Hp = stats.Hp
        Attack = stats.Attack
        Defense = stats.Defense
        SpAttack = stats.SpAttack
        SpDefense = stats.SpDefense
        Speed = stats.Speed
        TypeNames = types
        Moves = moves
    }
}