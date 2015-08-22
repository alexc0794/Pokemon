package pokedex.pokemon

import pokedex.attacks.Attack
import pokedex.attacks.general._
import pokedex.attacks.water.Watergun
import pokedex.types.{Water, PokemonType}

/**
 * Created by alexchou on 8/17/15.
 */
object Squirtle extends Pokemon {
  val id: Int = 1
  val pokemonType: PokemonType = Water
  var attacks: List[Attack] = List(Watergun)
  var name: String = "Squirtle"

  def apply = new Squirtle
}

class Squirtle extends Pokemon {
  val id: Int = Squirtle.id
  val pokemonType: PokemonType = Squirtle.pokemonType
  var attacks: List[Attack] = Squirtle.attacks
  var name: String = Squirtle.name
}