package user

import app.PokemonApp
import gameplay.battles.WildBattle
import gameplay.lineups.Lineup
import pokedex.pokemon._

import scala.util.Random

/**
 * Created by alexchou on 8/3/15.
 */
object User {
  val name: String = ""
  var grassCounter: Int = 0
  var lineup: Lineup = new Lineup(List(new Pikachu))

  def incrementGrassCounter(): Unit = {
    if (Random.nextDouble() < WildBattle.BATTLE_PROBABILITY) {
      grassCounter += 1
      println("Grass counter: " + grassCounter)
    }
    if (grassCounter >= WildBattle.NUM_GRASS_TRIGGER) {
      PokemonApp.engageBattle(WildBattle.apply())
      resetGrassCounter()
    }
  }
  def resetGrassCounter(): Unit = grassCounter = 0

  def blackout(): Unit = {
    println("Blacking out...")
  }

}
