package pokedex.pokemon

import pokedex.attacks.Attack
import pokedex.attacks.general._
import pokedex.attacks.thunder._
import pokedex.types._

/**
 * Created by alexchou on 8/12/15.
 */
object Pikachu extends Pokemon {
  val id: Int = 1
  val pokemonType: PokemonType = Thunder
  var attacks: List[Attack] = List(Thundershock)
  var name: String = "Pikachu"

  def apply = new Pikachu
}

class Pikachu extends Pokemon {
  val id: Int = Pikachu.id
  val pokemonType: PokemonType = Pikachu.pokemonType
  var attacks: List[Attack] = Pikachu.attacks
  var name: String = Pikachu.name
}
