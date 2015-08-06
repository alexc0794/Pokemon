package characters

import java.awt.{Color, Graphics2D}

import map.tiles.TileDimension

/**
 * Created by alexchou on 8/4/15.
 */
abstract class PokeCharacter {
  var name: String
  var drawing: Array[Array[Color]] = Array.ofDim[Color](TileDimension.PIXEL_WIDTH, TileDimension.PIXEL_HEIGHT)

  def initDrawing(): Unit

  def fillSquare(color: Color, x1: Int, x2: Int, y1: Int, y2: Int): Unit = {
    for {
      i <- x1 until x2
      j <- y1 until y2
    } yield {
      drawing(i)(j) = color
      println(i + " " + j)
    }
  }

  def drawDrawing(g: Graphics2D, xLowerBound: Int, yLowerBound: Int, xUpperBound: Int, yUpperBound: Int): Unit = {
    for {
      i <- 1 until drawing.length
      j <- 1 until drawing(i).length
    } yield {
      g.setColor(drawing(i)(j))
      g.fillRect(xLowerBound + i, yLowerBound + j, 1, 1)
    }
  }}
