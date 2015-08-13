package pokedex.types

/**
 * Created by alexchou on 8/12/15.
 */
object Ground extends PokemonType {
  val strongAgainst: Set[PokemonType] = Set(Thunder)
  val weakAgainst: Set[PokemonType] = Set(Flying)
}
