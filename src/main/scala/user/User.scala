package user

import gameplay.lineups.Lineup
import pokedex.pokemon._


/**
 * Created by alexchou on 8/3/15.
 */
object User {
  val state: UserState = new UserState("Alex", 0, new Lineup(List(Pikachu)), new ItemBag)
}
