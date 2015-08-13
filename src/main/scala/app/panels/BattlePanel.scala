package app.panels

import java.awt.Color

import app.ScreenDimension
import gameplay.Battle

import scala.swing._

/**
 * Created by alexchou on 8/12/15.
 */
class BattlePanel(battle: Battle) extends ScreenPanel {
  background = Color.BLACK
  preferredSize = new Dimension(ScreenDimension.WIDTH_X, ScreenDimension.HEIGHT_Y)
  maximumSize = new Dimension(ScreenDimension.WIDTH_X, ScreenDimension.HEIGHT_Y)
  focusable = true

  override def paintComponent(g: Graphics2D): Unit = {
    println("here")
    super.paintComponent(g)

    g.setColor(Color.GRAY)
    g.fillRect(0, 0, ScreenDimension.WIDTH_X, ScreenDimension.HEIGHT_Y)
    println(ScreenDimension.WIDTH_X)
    println(ScreenDimension.HEIGHT_Y)
  }
}
