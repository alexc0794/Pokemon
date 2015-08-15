package pokedex.pokemon

import pokedex.attacks.Attack
import pokedex.types._

/**
 * Created by alexchou on 8/12/15.
 */
object Charmander extends Pokemon {
  val id: Int = 2
  val pokemonType: PokemonType = Fire
  var attacks: List[Attack] = List()
  var name: String = "Charmander"

  def apply = new Charmander
}

class Charmander extends Pokemon {
  val id: Int = Charmander.id
  val pokemonType: PokemonType = Charmander.pokemonType
  var attacks: List[Attack] = Charmander.attacks
  var name: String = Charmander.name
}
