package user

import gameplay.WildBattle

import scala.util.Random

/**
 * Created by alexchou on 8/3/15.
 */
object User {
  val name = ""
  var grassCounter = 0


  def incrementGrassCounter(): Unit = {
    if (Random.nextDouble() < WildBattle.BATTLE_PROBABILITY) grassCounter += 1
    if (grassCounter >= WildBattle.NUM_GRASS_TRIGGER) {
      println("IMPLEMENT BATTLE")
      resetGrassCounter()
    }
  }
  def resetGrassCounter(): Unit = grassCounter = 0

}
