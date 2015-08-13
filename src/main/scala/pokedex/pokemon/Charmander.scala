package pokedex.pokemon

import pokedex.types._

/**
 * Created by alexchou on 8/12/15.
 */
object Charmander extends Pokemon {
  val id: Int = 2
  val pokemonType: PokemonType = Fire

  def apply = new Charmander

  override def toString(): String = "Charmander"
}

class Charmander extends Pokemon {
  val id: Int = Charmander.id
  val pokemonType: PokemonType = Charmander.pokemonType
  var name: String = "Charmander"
  var level: Int = 1
}
