package PokemonStadium

import PokeApiScraping.MoveDao
import java.util.*

/**
 * Created by william on 5/21/16.
 */
class PokemonBattle {

    fun CalculateDamage(attacker: Pokemon, defender: Pokemon, move: MoveDao, z: Int) : Int {
        if (move.Power == null)
            return 0

        val physicalAttack = move.DamageClass == DamageClass.PHYSICAL
        val a = attacker.Level
        val b = if (physicalAttack) attacker.Attack else attacker.SpAttack
        val c = move.Power
        val d = if (physicalAttack) defender.Defense else defender.SpDefense
        val x = if (attacker.TypeNames.contains(move.Type)) 1.5 else 1.0
        val y = CalculateTypeModifier(move.Type, defender.TypeNames)

        val basePortion = ((((2*a/5+2)*b*c/d)/50)+2)
        return (basePortion*x*y/10*z/255).toInt()
    }

    fun CalculateDamage(attacker: Pokemon, defender: Pokemon, move: MoveDao) : Int {
        return CalculateDamage(attacker, defender, move, Random().nextInt() % (255-217+1) + 255)
    }

    fun CalculateTypeModifier(attackType: Type, defenderTypes: Set<Type>) : Double {
        // TODO: Implement type modifiers
        return 10.0;
    }

    fun CalculateMaxDamage(attacker: Pokemon, defender: Pokemon, move: MoveDao) : Int {
        return CalculateDamage(attacker, defender, move, 255)
    }

    fun CalculateMinDamage(attacker: Pokemon, defender: Pokemon, move: MoveDao) : Int {
        return CalculateDamage(attacker, defender, move, 217)
    }
}