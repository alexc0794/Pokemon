package pokedex

import pokedex.pokemon._

import scala.util.Random

/**
 * Created by alexchou on 8/12/15.
 */
object Pokedex {
  val pokedex: List[Pokemon] = List(new Pikachu, new Charmander)

  def getRandomFromAll(): Pokemon = {
    pokedex(Random.nextInt(pokedex.length)) match {
      case _: Charmander => (new Charmander).randomize()
      case _: Pikachu => (new Pikachu).randomize()
      case _ => pokedex(Random.nextInt(pokedex.length)).randomize()
    }
  }

}
