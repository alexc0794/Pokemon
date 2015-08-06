package map.tiles

import java.awt.{Color, Graphics2D}
import characters._

/**
 * Created by alexchou on 8/3/15.
 */
abstract class Tile {
  var pixels: Array[Array[Color]] = Array.ofDim[Color](TileDimension.PIXEL_WIDTH, TileDimension.PIXEL_HEIGHT)

  var hasCharacter: Option[PokeCharacter] = None
  var isCenter: Boolean = false

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
      if (isCenter) g.setColor(Color.BLUE)
      g.fillRect(xLowerBound + i, yLowerBound + j, 1, 1)
    }
  }
}
