package pokedex

import pokedex.pokemon._

import scala.util.Random

/**
 * Created by alexchou on 8/12/15.
 */
object Pokedex {
  val pokedex: List[Pokemon] = List(new Pikachu, new Charmander, new Bulbasaur, new Squirtle)

  def getRandom(pokemon: List[Pokemon]): Pokemon = {
    pokemon(Random.nextInt(pokemon.length)) match {
      case _: Charmander => (new Charmander).randomize()
      case _: Pikachu => (new Pikachu).randomize()
      case _ => pokemon(Random.nextInt(pokemon.length)).randomize()
    }
  }

}
