package gameplay.battles

import pokedex.Pokedex
import pokedex.pokemon._

import scala.util.Random

/**
 * Created by alexchou on 8/6/15.
 */
object WildBattle extends Battle {
  val BATTLE_PROBABILITY: Double = 0.4
  val NUM_GRASS_TRIGGER: Int = 3
  val CAN_RUN = true

  def getPokemon(): List[Pokemon] = {
    List(Pokedex.getRandomFromAll())
  }
}
