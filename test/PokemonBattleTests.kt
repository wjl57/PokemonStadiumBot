package test

import PokeApiScraping.*
import PokemonStadium.*
import org.testng.annotations.*;

class SimpleTest {

    private val _vineWhip: MoveDao = MoveDao(
        MoveId = 22,
        Name = "vine-whip",
        Accuracy = 100,
        Pp = 25,
        Priority = 0,
        Power = 45,
        Target = AttackTarget.FromName("selected-pokemon"),
        Type = Type.FromName("grass"),
        DamageClass = DamageClass.FromName("physical"),
        AilmentChance = null,
        CritRate = null,
        Drain = null,
        EffectChance = null,
        EffectEntries = null,
        FlinchChance = null,
        Healing = null,
        MaxHits = null,
        MaxTurns = null,
        MinHits = null,
        MinTurns = null,
        StatChance = null
    )
    @org.testng.annotations.BeforeClass
    fun SetUp() {
        // code that will be invoked when this test is instantiated
        println("It did work once")
    }

    @Test(groups = arrayOf("fast"))
    fun StandardBattle() {

        var attacker = Pokemon(50, "Bulbasaur", setOf(Type.FromName("grass")), listOf(_vineWhip), CurrentStatsDao(
            Hp = 100,
            MaxHp = 100,
            Attack = 10,
            Defense = 10,
            SpAttack = 10,
            SpDefense = 10,
            Speed = 10
        ))

        var defender = Pokemon(50, "Bulbasaur", setOf(Type.FromName("grass")), listOf(_vineWhip), CurrentStatsDao(
            Hp = 100,
            MaxHp = 100,
            Attack = 10,
            Defense = 10,
            SpAttack = 10,
            SpDefense = 10,
            Speed = 10
        ))

        val pokemonBattle = PokemonBattle()
        val minDamage = pokemonBattle.CalculateMinDamage(attacker, defender, _vineWhip)
        val maxDamage = pokemonBattle.CalculateMaxDamage(attacker, defender, _vineWhip)
        println(minDamage)
        println(maxDamage)
    }

    @Test(groups = arrayOf("slow"))
    fun aSlowTest() {
        println("Slow test");
    }

}