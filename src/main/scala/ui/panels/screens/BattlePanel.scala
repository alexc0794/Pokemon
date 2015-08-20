package ui.panels.screen

import java.awt.Color
import gameplay.battles.Battle
import ui.dimensions.ScreenDimension

import scala.swing._

/**
 * Created by alexchou on 8/12/15.
 */
class BattlePanel(b: Battle) extends ScreenPanel {
  val battle = b
  var isUsersTurn = true

  override def paintComponent(g: Graphics2D): Unit = {
    super.paintComponent(g)

    g.setColor(Color.GRAY)
    g.fillRect(0, 0, ScreenDimension.WIDTH_X, ScreenDimension.HEIGHT_Y)
  }


  def up(): Unit = {}
  def down(): Unit = {}
  def left(): Unit = {}
  def right(): Unit = {}
  def select(): Unit = {}
}
