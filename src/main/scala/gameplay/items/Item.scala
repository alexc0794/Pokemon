package gameplay.items

import pokedex.pokemon.Pokemon
import ui.PokemonApp

/**
 * Created by alexchou on 8/20/15.
 */
abstract class Item {
  val name: String

  def doEffect(): Unit
  def doEffect(pokemon: Pokemon): Unit

  def giveInvalidMessage(): Unit = {
    PokemonApp.text.addMessage("Cannot use " + name + " here.")
  }
}
