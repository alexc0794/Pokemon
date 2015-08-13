package gameplay

import pokedex.Pokedex
import pokedex.pokemon._

import scala.util.Random

/**
 * Created by alexchou on 8/6/15.
 */
object WildBattle extends Battle {
  val BATTLE_PROBABILITY: Double = 0.4
  val NUM_GRASS_TRIGGER: Int = 10
  val CAN_RUN = true

  def getPokemon(): List[Pokemon] = {
    List(Pokedex.pokedex(Random.nextInt(Pokedex.pokedex.length)))
  }
}
