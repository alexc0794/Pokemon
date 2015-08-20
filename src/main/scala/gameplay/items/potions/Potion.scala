package gameplay.items.potions

import gameplay.items.Item
import pokedex.pokemon.Pokemon

/**
 * Created by alexchou on 8/20/15.
 */
abstract class Potion extends Item {
  val EFFECT: Int

  def doEffect(): Unit = {
    giveInvalidMessage()
  }

  def doEffect(pokemon: Pokemon): Unit = {
    if (pokemon.health == 100 || pokemon.health == 0) giveInvalidMessage()
    else {
      pokemon.health += EFFECT
      if (pokemon.health > 100) pokemon.health = 100
    }
  }
}

class NormalPotion extends Potion {
  val name = "Potion"
  val EFFECT = 10
}

class SuperPotion extends Potion {
  val name = "Super Potion"
  val EFFECT = 20
}

class HyperPotion extends Potion {
  val name = "Hyper Potion"
  val EFFECT = 40
}