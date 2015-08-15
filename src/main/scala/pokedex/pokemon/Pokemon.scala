package pokedex.pokemon

import pokedex.attacks.Attack
import pokedex.types._

import scala.util.Random

/**
 * Created by alexchou on 8/12/15.
 */
abstract class Pokemon {
  val id: Int
  val pokemonType: PokemonType
  var attacks: List[Attack]
  var name: String
  var health: Int = 100
  var level: Int = 1

  def randomize(): Pokemon = {
    level = Random.nextInt(100)
    health = 100
    this
  }

  override def toString(): String = {
    name + " " + level + " " + health
  }
}
