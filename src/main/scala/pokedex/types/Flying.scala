package pokedex.types

/**
 * Created by alexchou on 8/12/15.
 */
object Flying extends PokemonType {
  val strongAgainst: Set[PokemonType] = Set(Ground)
  val weakAgainst: Set[PokemonType] = Set(Fire)
}
