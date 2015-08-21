package gameplay.battles

import gameplay.fighting.FightDynamics
import gameplay.lineups.Lineup
import pokedex.attacks.Attack
import pokedex.pokemon.Pokemon
import ui.PokemonApp
import user.User

import scala.util.Random

/**
 * Created by alexchou on 8/12/15.
 */
abstract class Battle(enemy: Lineup) {
  val BATTLE_PROBABILITY: Double
  val NUM_GRASS_TRIGGER: Int
  val CAN_RUN: Boolean

  val enemyLineup: Lineup = enemy
  val entranceMessage: String
  var currEnemy: Pokemon = enemyLineup.getFirstPokemon().get

  def switchPokemon(pokemon: Pokemon): Boolean = {
    if (pokemon.equals(User.currPokemon) || pokemon.health <= 0) false
    else {
      val switchedPokemon = User.currPokemon
      User.currPokemon = pokemon
      PokemonApp.text.addMessage("User has called back " + switchedPokemon.name + " and summoned " + User.currPokemon.name)
      true
    }
  }

  def attackEnemy(attack: Attack): Unit = {
    val damage = FightDynamics.damageHealth(User.currPokemon, currEnemy, attack)
    currEnemy.health -= damage
    PokemonApp.text.addMessages(
      List(
        "test",
        User.currPokemon.name + " used " + attack.name,
        "Enemy " + currEnemy.name + " was damaged by " + damage
      )
    )
    if (currEnemy.health <= 0) {
      currEnemy.health = 0
      val faintedEnemy = currEnemy
      if (enemyLineup.hasPokemonLeft()) {
        currEnemy = enemyLineup.getFirstPokemon().get
        PokemonApp.text.addMessages(
          List(
            faintedEnemy.name + " has fainted!",
            "Opponent has summoned " + currEnemy.name
          )
        )
      } else {
        PokemonApp.text.addMessages(
          List(
            faintedEnemy.name + " has fainted!",
            "WONBATTLE"
          )
        )
      }
    } else getAttacked()
  }

  def getAttacked(): Unit = {
    val attack: Attack = currEnemy.attacks(Random.nextInt(currEnemy.attacks.length))
    val damage = FightDynamics.damageHealth(currEnemy, User.currPokemon, attack)
    User.currPokemon.health -= damage
    PokemonApp.text.addMessages(
      List(
        "Enemy " + currEnemy.name + " used " + attack.name,
        User.currPokemon.name + " was damaged by " + damage
      )
    )
    if (User.currPokemon.health <= 0) {
      User.currPokemon.health = 0
      val faintedPokemon = User.currPokemon
      if (User.lineup.hasPokemonLeft()) {
        User.currPokemon = User.lineup.getFirstPokemon().get
        PokemonApp.text.addMessages(
          List(
            faintedPokemon.name + " has fainted!",
            "You have summoned " + User.currPokemon.name
          )
        )
      } else {
        // no pokemon left
        PokemonApp.text.addMessages(
          List(
            "You are out of Pokemon! Blacking out...",
            "BLACKINGOUT"
          )
        )
      }
    }
  }

}
