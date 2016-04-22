package PokeApiScraping

import PokemonStadium.*
import com.jaunt.*
import java.awt.List

/**
 * Created by william on 4/21/16.
 */
class PokemonApiScraper {

    private val _userAgent : UserAgent = UserAgent()

    @Throws(ResponseException::class, NotFound::class)
    fun ScrapePokemon(pokemonId: Int): PokemonDao {
        try {
            val baseUrl = "http://pokeapi.co/api/v2/pokemon/"
            _userAgent.sendGET("$baseUrl$pokemonId")
            println(_userAgent.json)
            return JsonToPokemonDao(_userAgent.json)
        } catch (e: JauntException) {
            System.err.println(e)
            throw e
        }

    }

    @Throws(ResponseException::class, NotFound::class)
    fun ScrapeMove(moveId: Int): MoveDao {
        try {
            val baseUrl = "http://pokeapi.co/api/v2/move/"
            _userAgent.sendGET("$baseUrl$moveId")
            println(_userAgent.json)
            return JsonToMoveDao(_userAgent.json)
        } catch (e: JauntException) {
            System.err.println(e)
            throw e
        }

    }

    @Throws(NotFound::class)
    fun JsonToPokemonDao(jnode: JNode): PokemonDao {
        val movesJNode = jnode.getFirst("moves")
        var learnableMoves = arrayListOf<LearnableMoveDao>()

        for (move in movesJNode.iterator()) {
            val moveName = move.getFirst("move").toString()
            val versionGroupDetailsJNode = move.getFirst("version_group_details")
            val learnMethodVersionGroups = versionGroupDetailsJNode.map {
                Pair(
                    LearnMethod.FromName(it.get("move_learn_method").get("name").toString()),
                    VersionGroup.FromName(it.get("version_group").get("name").toString())
                )
            }.filter { it.first != LearnMethod.NOT_SUPPORTED && it.second != VersionGroup.NOT_SUPPORTED }

            learnableMoves.add(LearnableMoveDao(moveName, learnMethodVersionGroups))
        }

        val typesJNode = jnode.getFirst("types")
        val typeNames = typesJNode.findEach("type").map { it.get("name").toString() }
        val statsJNode = jnode.getFirst("stats")

        val stats = statsJNode.map {
            it.get("stat").get("name").toString() to it.get("base_stat").toInt()
        }
        var statsDict = stats.toMap()

        val pd = PokemonDao(
            PokemonId = GetJNodeInt(jnode, "id"),
            Name = GetJNodeString(jnode, "name"),
            LearnableMoves = learnableMoves,
            TypeNames = typeNames,
            Hp = statsDict["hp"]!!.toInt(),
            Attack = statsDict["attack"]!!.toInt(),
            Defense = statsDict["defense"]!!.toInt(),
            SpAttack = statsDict["special-attack"]!!.toInt(),
            SpDefense = statsDict["special-defense"]!!.toInt(),
            Speed = statsDict["speed"]!!.toInt()
        )

        return pd;
    }

    @Throws(NotFound::class)
    fun JsonToMoveDao(jnode: JNode): MoveDao {
        val metaJNode = jnode.getFirst("meta")
        val md = MoveDao(
            MoveId = GetJNodeInt(jnode, "id"),
            Name = GetJNodeString(jnode, "name"),
            Accuracy = GetJNodeIntMaybe(jnode, "accuracy"),
            EffectChance = GetJNodeIntMaybe(jnode, "effect_chance"),
            Pp = GetJNodeIntMaybe(jnode, "pp"),
            Priority = GetJNodeIntMaybe(jnode, "priority"),
            Power = GetJNodeInt(jnode, "power"),
            DamageClass = DamageClass.FromName(GetJNodeString(jnode.get("damage_class"), "name")),
            EffectEntries = GetJNodeString(jnode, "effect_entries"),
            Target = AttackTarget.FromName(GetJNodeString(jnode.get("target"), "name")),
            Type = Type.FromName(GetJNodeString(jnode.get("type"), "name")),

            MinHits = GetJNodeIntMaybe(metaJNode, "min_hits"),
            MaxHits = GetJNodeIntMaybe(metaJNode, "max_hits"),
            MinTurns = GetJNodeIntMaybe(metaJNode, "min_turns"),
            MaxTurns = GetJNodeIntMaybe(metaJNode, "max_turns"),
            Drain = GetJNodeIntMaybe(metaJNode, "drain"),
            Healing = GetJNodeIntMaybe(metaJNode, "healing"),
            CritRate = GetJNodeIntMaybe(metaJNode, "crit_rate"),
            AilmentChance = GetJNodeIntMaybe(metaJNode, "ailment_chance"),
            FlinchChance = GetJNodeIntMaybe(metaJNode, "flinch_chance"),
            StatChance = GetJNodeIntMaybe(metaJNode, "stat_chance")
        )

        return md
    }

    @Throws(NotFound::class)
    fun GetJNodeIntMaybe(jnode: JNode, nodeName: String?): Int? {
        return if (jnode.get(nodeName).type == JNode.Type.NUMBER)
            jnode.get(nodeName).toInt()
        else
            null
    }

    @Throws(NotFound::class)
    fun GetJNodeInt(jnode: JNode, nodeName: String?): Int {
        return jnode.get(nodeName).toInt()
    }

    @Throws(NotFound::class)
    fun GetJNodeStringMaybe(jnode: JNode, nodeName: String?): String? {
        return if (jnode.get(nodeName).type == JNode.Type.STRING)
            jnode.get(nodeName).toString()
        else
            null
    }

    @Throws(NotFound::class)
    fun GetJNodeString(jnode: JNode, nodeName: String?): String {
        return jnode.get(nodeName).toString()
    }
}
