package user

import app.PokemonApp
import gameplay.battles.WildBattle
import pokedex.pokemon._

import scala.util.Random

/**
 * Created by alexchou on 8/3/15.
 */
object User {
  val name: String = ""
  var grassCounter: Int = 0
  var userPokemon: List[Pokemon] = List(new Pikachu)

  def incrementGrassCounter(): Unit = {
    if (Random.nextDouble() < WildBattle.BATTLE_PROBABILITY) {
      grassCounter += 1
      println("Grass counter: " + grassCounter)
    }
    if (grassCounter >= WildBattle.NUM_GRASS_TRIGGER) {
      getFirstLivePokemon(userPokemon) match {
        case Some(myPokemon: Pokemon) => {
          PokemonApp.engageBattle(myPokemon, WildBattle.getPokemon().head)
        }
        case None => blackout()
      }
      resetGrassCounter()
    }
  }
  def resetGrassCounter(): Unit = grassCounter = 0

  def getFirstLivePokemon(pokemon: List[Pokemon]): Option[Pokemon] = pokemon match {
    case hd::tl => {
      if (hd.health > 0) Some(hd)
      else getFirstLivePokemon(tl)
    }
    case _ => None
  }

  def blackout(): Unit = {
    println("Blacking out...")
  }

}
