package pokedex.types

/**
 * Created by alexchou on 8/12/15.
 */
abstract class PokemonType {
  val strongAgainst: Set[PokemonType]
  val weakAgainst: Set[PokemonType]
}
