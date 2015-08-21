package ui.panels.screen

import java.awt.Color
import gameplay.battles.Battle
import ui.dimensions.ScreenDimension
import ui.panels.screens.drawings.HealthBar
import user.User

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
    // draw health bars
    val userHealthBar = new HealthBar(User.currPokemon.health)
    val enemyHealthBar = new HealthBar(battle.currEnemy.health)

    userHealthBar.drawPixels(g, new Point(ScreenDimension.WIDTH_X * 1/4, ScreenDimension.HEIGHT_Y * 3/4))
    enemyHealthBar.drawPixels(g, new Point(ScreenDimension.WIDTH_X * 3/4, ScreenDimension.HEIGHT_Y * 1/4))
  }


  def up(): Unit = {}
  def down(): Unit = {}
  def left(): Unit = {}
  def right(): Unit = {}
  def select(): Unit = {}
}
