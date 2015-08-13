package pokedex.types

/**
 * Created by alexchou on 8/12/15.
 */
object Water extends PokemonType {
  val strongAgainst: Set[PokemonType] = Set(Fire)
  val weakAgainst: Set[PokemonType] = Set(Thunder)
}
