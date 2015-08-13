package map.objects

import java.awt.{Graphics2D, Color}

import scala.swing.Point

/**
 * Created by alexchou on 8/6/15.
 */
abstract class TileObject {
  val start: Point
  val WIDTH: Int    // width in tiles
  val HEIGHT: Int   // height in tiles

  var pixels: Array[Array[Color]]

  val isCuttable: Boolean
  val isTraversable: Boolean
  val isJumpable: Boolean
  val hasPokemon: Boolean

  def initPixels(): Unit

  def getEnd(): Point = {
      new Point(start.getX.toInt + WIDTH, start.getY.toInt + HEIGHT)
  }

  def fillSquare(color: Color, x1: Int, x2: Int, y1: Int, y2: Int): Unit = {
    for {
      i <- x1 until x2
      j <- y1 until y2
    } yield {
      pixels(i)(j) = color
    }
  }

  def drawPixels(g: Graphics2D, xLowerBound: Int, yLowerBound: Int, xUpperBound: Int, yUpperBound: Int): Unit = {
    for {
      i <- 0 until pixels.length
      j <- 0 until pixels(i).length
    } yield {
      pixels(i)(j) match {
        case null =>
        case c: Color => {
          g.setColor(c)
          g.fillRect((xLowerBound + i), (yLowerBound + j), 1, 1)
        }
      }
    }
  }
}
