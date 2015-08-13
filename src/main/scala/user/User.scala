package user

import app.PokemonApp
import gameplay.WildBattle
import pokedex.pokemon._

import scala.util.Random

/**
 * Created by alexchou on 8/3/15.
 */
object User {
  val name: String = ""
  var grassCounter: Int = 0
  var pokemon: List[Pokemon] = List(new Pikachu)

  def incrementGrassCounter(): Unit = {
    if (Random.nextDouble() < WildBattle.BATTLE_PROBABILITY) {
      grassCounter += 1
      println("Grass counter: " + grassCounter)
    }
    if (grassCounter >= WildBattle.NUM_GRASS_TRIGGER) {
      val pokemon: List[Pokemon] = WildBattle.getPokemon()
      pokemon.foreach(println)
      PokemonApp.engageBattle(WildBattle)
      resetGrassCounter()
    }
  }
  def resetGrassCounter(): Unit = grassCounter = 0

}
