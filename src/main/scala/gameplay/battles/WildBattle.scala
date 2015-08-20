package gameplay.battles

import gameplay.fighting.FightDynamics
import gameplay.lineups.Lineup
import pokedex.Pokedex
import pokedex.attacks.Attack
import ui.PokemonApp
import user._


/**
 * Created by alexchou on 8/6/15.
 */
object WildBattle {
  val BATTLE_PROBABILITY: Double = 0.4
  val NUM_GRASS_TRIGGER: Int = 3
  val CAN_RUN = true

  def getPokemon(): Lineup = {
    new Lineup(List(Pokedex.getRandom(Pokedex.pokedex)))
  }

  def apply() = new WildBattle(getPokemon())
}

class WildBattle(enemy: Lineup) extends Battle(enemy: Lineup) {
  val BATTLE_PROBABILITY = WildBattle.BATTLE_PROBABILITY
  val NUM_GRASS_TRIGGER = WildBattle.NUM_GRASS_TRIGGER
  val CAN_RUN = WildBattle.CAN_RUN
  val entranceMessage: String = "A wild " + enemy.getFirstPokemon().get.name + " appeared!"

}