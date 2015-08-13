package pokedex.types

/**
 * Created by alexchou on 8/12/15.
 */
object Grass extends PokemonType {
  val strongAgainst: Set[PokemonType] = Set(Water)
  val weakAgainst: Set[PokemonType] = Set(Fire)
}
