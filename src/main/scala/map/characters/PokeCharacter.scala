package map.characters

import java.awt.{Dimension, Color, Graphics2D}

import gameplay.direction._

/**
 * Created by alexchou on 8/4/15.
 */
abstract class PokeCharacter {
  var name: String
  var direction: Direction = new Down()

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
