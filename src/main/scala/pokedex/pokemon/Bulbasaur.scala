package pokedex.pokemon

import pokedex.attacks.Attack
import pokedex.attacks.general._
import pokedex.types._

/**
 * Created by alexchou on 8/12/15.
 */
object Bulbasaur extends Pokemon {
  val id: Int = 1
  val pokemonType: PokemonType = Grass
  var attacks: List[Attack] = List(Tackle)
  var name: String = "Bulbasaur"

  def apply = new Bulbasaur
}

class Bulbasaur extends Pokemon {
  val id: Int = Bulbasaur.id
  val pokemonType: PokemonType = Bulbasaur.pokemonType
  var attacks: List[Attack] = Bulbasaur.attacks
  var name: String = Bulbasaur.name
}
