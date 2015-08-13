package map.objects

import java.awt.Color

import map.tiles.TileDimension

import scala.swing.Point

/**
 * Created by alexchou on 8/8/15.
 */
class Ledge(s: Point) extends TileObject {
  val start = s
  val WIDTH = 1
  val HEIGHT = 1
  var pixels = Array.ofDim[Color](WIDTH * TileDimension.PIXEL_WIDTH, HEIGHT * TileDimension.PIXEL_HEIGHT)
  val isCuttable = false
  val isTraversable = false
  val isJumpable = true
  val hasPokemon = false

  initPixels()

  def initPixels(): Unit = {
    val DARK_BROWN = new Color(46, 31, 0)
    val BROWN = new Color(153, 102, 0)
    val LIGHT_BROWN = new Color(184, 148, 77)
    fillSquare(DARK_BROWN, 0,4,12,24)
    fillSquare(DARK_BROWN, 4,8,4,12)
    fillSquare(DARK_BROWN, 4,8,24,28)
    fillSquare(DARK_BROWN, 8,12,24,28)
    fillSquare(DARK_BROWN, 12,16,0,4)
    fillSquare(DARK_BROWN, 12,16,24,32)
    fillSquare(DARK_BROWN, 16,20,0,4)
    fillSquare(DARK_BROWN, 16,20,28,32)
    fillSquare(DARK_BROWN, 20,24,4,12)
    fillSquare(DARK_BROWN, 20,24,28,32)
    fillSquare(DARK_BROWN, 24,28,16,32)
    fillSquare(DARK_BROWN, 28,32,8,16)
    fillSquare(DARK_BROWN, 28,32,20,24)

    fillSquare(BROWN, 4,8,16,24)
    fillSquare(BROWN, 8,12,0,12)
    fillSquare(BROWN, 8,12,16,24)
    fillSquare(BROWN, 12,16,20,24)
    fillSquare(BROWN, 16,20,20,28)
    fillSquare(BROWN, 20,24,20,28)
    fillSquare(BROWN, 24,28,8,16)

    fillSquare(LIGHT_BROWN, 0,4,4,12)
    fillSquare(LIGHT_BROWN, 0,4,24,28)
    fillSquare(LIGHT_BROWN, 4,8,0,4)
    fillSquare(LIGHT_BROWN, 4,8,12,16)
    fillSquare(LIGHT_BROWN, 4,8,28,32)
    fillSquare(LIGHT_BROWN, 8,12,12,16)
    fillSquare(LIGHT_BROWN, 8,12,28,32)
    fillSquare(LIGHT_BROWN, 12,16,4,12)
    fillSquare(LIGHT_BROWN, 16,20,4,8)
    fillSquare(LIGHT_BROWN, 20,24,0,4)
    fillSquare(LIGHT_BROWN, 20,24,12,20)
    fillSquare(LIGHT_BROWN, 24,28,0,8)
    fillSquare(LIGHT_BROWN, 28,32,4,8)
    fillSquare(LIGHT_BROWN, 28,32,16,20)
    fillSquare(LIGHT_BROWN, 28,32,24,28)
  }

}
