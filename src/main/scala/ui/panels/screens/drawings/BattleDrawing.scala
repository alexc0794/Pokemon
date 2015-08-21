package ui.panels.screens.drawings

import java.awt.{Graphics2D, Color}

import scala.swing.Point

/**
 * Created by alexchou on 8/20/15.
 */
abstract class BattleDrawing {
  val WIDTH: Int
  val HEIGHT: Int
  var pixels: Array[Array[Color]]

  def initPixels(): Unit

  def fillSquare(color: Color, x1: Int, x2: Int, y1: Int, y2: Int): Unit = {
    for {
      i <- x1 until x2
      j <- y1 until y2
    } yield {
      pixels(i)(j) = color
    }
  }

  def drawPixels(g: Graphics2D, start: Point): Unit = {
    for {
      i <- 0 until WIDTH
      j <- 0 until HEIGHT
    } yield {
      pixels(i)(j) match {
        case null =>
        case c: Color => {
          g.setColor(c)
          g.fillRect(start.getX().toInt + i, start.getY().toInt + j, 1, 1)
        }
      }
    }
  }
}

class HealthBar(h: Int) extends BattleDrawing {
  val health: Int = h
  val WIDTH: Int = 100
  val HEIGHT: Int = 5
  var pixels = Array.ofDim[Color](WIDTH, HEIGHT)

  initPixels()

  def initPixels(): Unit = {
    val HEALTH = Color.GREEN
    fillSquare(HEALTH, 0,health,0,HEIGHT)
    fillSquare(Color.WHITE, health,WIDTH,0,HEIGHT)
  }

}