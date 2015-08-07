package map.objects

import java.awt.{Graphics2D, Color}

import map.tiles.TileDimension

import scala.swing.Dimension

/**
 * Created by alexchou on 8/6/15.
 */
abstract class TileObject {
  var pixels: Array[Array[Color]] = Array.ofDim[Color](TileDimension.PIXEL_WIDTH, TileDimension.PIXEL_HEIGHT)

  var lowerDimension: Dimension
  var upperDimension: Dimension

  val isCuttable: Boolean
  val isTraversable: Boolean
  val hasPokemon: Boolean

  def initPixels(): Unit

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
        case null => g.setColor(Color.WHITE)
        case c: Color => g.setColor(c)
      }
      g.fillRect(xLowerBound + i, yLowerBound + j, 1, 1)
    }
  }
}
