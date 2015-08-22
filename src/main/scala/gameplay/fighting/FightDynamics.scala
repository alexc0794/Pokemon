package gameplay.fighting

import pokedex.attacks.Attack
import pokedex.pokemon.Pokemon

/**
 * Created by alexchou on 8/15/15.
 */
object FightDynamics {

  def damageHealth(attacker: Pokemon, defender: Pokemon, attack: Attack): Int = {
    attack.damage
  }
}
