package app.panels.screen

import java.awt.Color

import app.ScreenDimension
import pokedex.pokemon.Pokemon

import scala.swing._

/**
 * Created by alexchou on 8/12/15.
 */
class BattlePanel(enemy: Pokemon) extends ScreenPanel {
  var enemyPokemon = enemy

  override def paintComponent(g: Graphics2D): Unit = {
    super.paintComponent(g)

    g.setColor(Color.GRAY)
    g.fillRect(0, 0, ScreenDimension.WIDTH_X, ScreenDimension.HEIGHT_Y)
  }

  def getFirstLivePokemon(pokemon: List[Pokemon]): Option[Pokemon] = pokemon match {
    case hd::tl => {
      if (hd.health > 0) Some(hd)
      else getFirstLivePokemon(tl)
    }
    case _ => None
  }

}
