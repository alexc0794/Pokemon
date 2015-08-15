package app.panels.text

import java.awt.{Dimension, Color}

import app.ScreenDimension

import scala.swing.event.{Key, KeyPressed}
import scala.swing._

/**
 * Created by alexchou on 8/13/15.
 */
abstract class TextPanel extends FlowPanel {
  focusable = true
  background = Color.WHITE
  preferredSize = new Dimension(ScreenDimension.WIDTH_X, (ScreenDimension.HEIGHT_Y * .2).toInt)
  maximumSize = new Dimension(ScreenDimension.WIDTH_X, (ScreenDimension.HEIGHT_Y * .2).toInt)
  listenTo(keys)
  reactions += {
    case KeyPressed(_,Key.Up,_,_) => this.up
    case KeyPressed(_,Key.Down,_,_) => this.down
    case KeyPressed(_,Key.Left,_,_) => this.left
    case KeyPressed(_,Key.Right,_,_) => this.right
    case KeyPressed(_,Key.A,_,_) => this.select
    case KeyPressed(_,Key.Enter,_,_) => this.select
  }

  val panel: Panel

  def up(): Unit = {}
  def down(): Unit = {}
  def left(): Unit = {}
  def right(): Unit = {}
  def select(): Unit = {}

  override def paintComponent(g: Graphics2D): Unit = {
    super.paintComponent(g)
  }
}
