package gameplay.lineups

import pokedex.pokemon.Pokemon

/**
 * Created by alexchou on 8/15/15.
 */
class Lineup(l: List[Pokemon]) {
  var lineup: List[Pokemon] = l

  def getFirstPokemon(): Option[Pokemon] = {
    def getFirst(pokemon: List[Pokemon]): Option[Pokemon] = pokemon match {
      case hd::tl => {
        if (hd.health > 0) Some(hd)
        else getFirst(tl)
      }
      case _ => None
    }
    getFirst(lineup)
  }

  def hasPokemonLeft(): Boolean = getFirstPokemon().isEmpty

}
