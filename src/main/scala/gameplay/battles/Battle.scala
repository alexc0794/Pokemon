package gameplay.battles

import gameplay.lineups.Lineup

/**
 * Created by alexchou on 8/12/15.
 */
abstract class Battle(enemy: Lineup) {
  val BATTLE_PROBABILITY: Double
  val NUM_GRASS_TRIGGER: Int
  val CAN_RUN: Boolean

  val enemyLineup: Lineup = enemy

}
