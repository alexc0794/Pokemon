package pokedex.types

/**
 * Created by alexchou on 8/12/15.
 */
object Fire extends PokemonType {
  val strongAgainst: Set[PokemonType] = Set(Grass)
  val weakAgainst: Set[PokemonType] = Set(Water)
}
