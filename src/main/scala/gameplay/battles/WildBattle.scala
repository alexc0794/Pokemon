package gameplay.battles

import gameplay.lineups.Lineup
import pokedex.Pokedex


/**
 * Created by alexchou on 8/6/15.
 */
object WildBattle {
  val BATTLE_PROBABILITY: Double = 0.4
  val NUM_GRASS_TRIGGER: Int = 3
  val CAN_RUN = true

  def getPokemon(): Lineup = {
    new Lineup(List(Pokedex.getRandomFromAll()))
  }

  def apply() = new WildBattle(getPokemon())
}

class WildBattle(enemy: Lineup) extends Battle(enemy: Lineup) {
  val BATTLE_PROBABILITY = WildBattle.BATTLE_PROBABILITY
  val NUM_GRASS_TRIGGER = WildBattle.NUM_GRASS_TRIGGER
  val CAN_RUN = WildBattle.CAN_RUN
}