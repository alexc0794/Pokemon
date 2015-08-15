package pokedex.attacks

/**
 * Created by alexchou on 8/15/15.
 */
trait Attack {
  val name: String
  val damage: Int

  override def toString(): String = name
}
