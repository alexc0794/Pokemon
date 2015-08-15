package app.panels.screen

import java.awt.Color

import app.ScreenDimension
import gameplay.battles.Battle
import pokedex.pokemon.Pokemon

import scala.swing._

/**
 * Created by alexchou on 8/12/15.
 */
class BattlePanel(b: Battle) extends ScreenPanel {
  val battle = b

  override def paintComponent(g: Graphics2D): Unit = {
    super.paintComponent(g)

    g.setColor(Color.GRAY)
    g.fillRect(0, 0, ScreenDimension.WIDTH_X, ScreenDimension.HEIGHT_Y)
  }

}
