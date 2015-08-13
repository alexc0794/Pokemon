package pokedex.pokemon

import pokedex.types._

/**
 * Created by alexchou on 8/12/15.
 */
object Pikachu extends Pokemon {
  val id: Int = 1
  val pokemonType: PokemonType = Thunder

  def apply = new Pikachu

  override def toString(): String = "Pikachu"
}

class Pikachu extends Pokemon {
  val id: Int = Pikachu.id
  val pokemonType: PokemonType = Pikachu.pokemonType
  var name: String = "Pikachu"
  var level: Int = 1
}
