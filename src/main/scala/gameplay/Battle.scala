package gameplay

import pokedex.pokemon.Pokemon

/**
 * Created by alexchou on 8/12/15.
 */
abstract class Battle {
  val BATTLE_PROBABILITY: Double
  val NUM_GRASS_TRIGGER: Int
  val CAN_RUN: Boolean

  def getPokemon(): List[Pokemon]
}
