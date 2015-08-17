package map.objects

import java.awt.Color

import map.tiles.{TileDimension, Tile}

import scala.swing.Point

/**
 * Created by alexchou on 8/3/15.
 */
class Grass(s: Point) extends TileObject {
  val start = s
  val WIDTH = 1
  val HEIGHT = 1
  var pixels = Array.ofDim[Color](WIDTH * TileDimension.PIXEL_WIDTH, HEIGHT * TileDimension.PIXEL_HEIGHT)
  val isCuttable = true
  val isTraversable = true
  val isJumpable = false
  val hasPokemon = true

  initPixels()

  def initPixels(): Unit = {
    fillSquare(new Color(164,251,63), 0,32,0,32)
    val DARK_GREEN = new Color(39,94,0)
    val SHADOW = Color.GREEN
    fillSquare(DARK_GREEN, 0,4,4,20)
    fillSquare(DARK_GREEN, 4,8,4,16)
    fillSquare(DARK_GREEN, 4,8,20,24)
    fillSquare(DARK_GREEN, 8,12,8,16)
    fillSquare(DARK_GREEN, 8,12,24,28)
    fillSquare(DARK_GREEN, 12,16,16,20)
    fillSquare(DARK_GREEN, 12,16,24,28)
    fillSquare(DARK_GREEN, 16,20,8,32)
    fillSquare(DARK_GREEN, 20,24,4,8)
    fillSquare(DARK_GREEN, 20,24,16,28)
    fillSquare(DARK_GREEN, 24,28,0,4)
    fillSquare(DARK_GREEN, 24,28,12,20)
    fillSquare(DARK_GREEN, 28,32,4,16)

    fillSquare(SHADOW, 0,4,24,28)
    fillSquare(SHADOW, 4,8,24,32)
    fillSquare(SHADOW, 8,12,16,20)
    fillSquare(SHADOW, 8,12,28,32)
    fillSquare(SHADOW, 12,16,28,32)
    fillSquare(SHADOW, 20,24,8,16)
    fillSquare(SHADOW, 20,24,28,32)
    fillSquare(SHADOW, 24,28,8,12)
    fillSquare(SHADOW, 24,28,20,24)
    fillSquare(SHADOW, 28,32,0,4)
    fillSquare(SHADOW, 28,32,16,20)
  }

}
