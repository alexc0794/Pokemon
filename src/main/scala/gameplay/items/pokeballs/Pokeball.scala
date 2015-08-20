package gameplay.items.pokeballs

import gameplay.items.Item
import pokedex.pokemon.Pokemon

/**
 * Created by alexchou on 8/20/15.
 */
abstract class Pokeball extends Item {
  val LIKELIHOOD: Double
  val UPPER_BOUND: Int

  def doEffect(): Unit = {
    giveInvalidMessage()
  }

  def doEffect(pokemon: Pokemon): Unit = {

  }
}

class NormalBall extends Pokeball {
  val name = "Pokeball"
  val LIKELIHOOD = 0.25
  val UPPER_BOUND = 10
}

class GreatBall extends Pokeball {
  val name = "Great Ball"
  val LIKELIHOOD = 0.25
  val UPPER_BOUND = 20
}

class UltraBall extends Pokeball {
  val name = "Ultra Ball"
  val LIKELIHOOD = 0.50
  val UPPER_BOUND = 40
}