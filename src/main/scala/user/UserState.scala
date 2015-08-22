package user

import java.awt.Point

import gameplay.battles.WildBattle
import gameplay.lineups.Lineup
import pokedex.pokemon._
import ui.PokemonApp

import scala.util.Random

/**
 * Created by alexchou on 8/21/15.
 */
class UserState(n: String, g: Int, l: Lineup, i: ItemBag) {
  val name: String = n
  var grassCounter: Int = g
  var lineup: Lineup = l
  var currPokemon: Pokemon = lineup.getFirstPokemon().get
  var itemBag: ItemBag = i

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
    PokemonApp.screen.currMap.center =
      new Point(PokemonApp.screen.currMap.map.entrance.getX().toInt,
        PokemonApp.screen.currMap.map.entrance.getY().toInt)
    lineup.healAll()
    PokemonApp.endBattle()
  }
}
