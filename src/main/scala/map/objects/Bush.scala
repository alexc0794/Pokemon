package map.objects

import java.awt.Color

import map.tiles.TileDimension

import scala.swing.{Dimension, Color}

/**
 * Created by alexchou on 8/6/15.
 */
class Bush(s: Dimension) extends TileObject {
  val start = s
  val WIDTH = 1
  val HEIGHT = 1
  var pixels = Array.ofDim[Color](WIDTH * TileDimension.PIXEL_WIDTH, HEIGHT * TileDimension.PIXEL_HEIGHT)
  val isCuttable = false
  val isTraversable = false
  val isJumpable = false
  val hasPokemon = false
  initPixels()

  def initPixels(): Unit = {
    val COLOR = new Color(26,122,23)
    val SHADOW = Color.GREEN
    fillSquare(COLOR, 0,4,8,16)
    fillSquare(COLOR, 0,4,20,24)
    fillSquare(COLOR, 4,8,4,8)
    fillSquare(COLOR, 4,8,12,20)
    fillSquare(COLOR, 4,8,24,28)
    fillSquare(COLOR, 8,12,0,4)
    fillSquare(COLOR, 8,12,16,28)
    fillSquare(COLOR, 12,16,0,4)
    fillSquare(COLOR, 12,16,24,32)
    fillSquare(COLOR, 16,20,0,4)
    fillSquare(COLOR, 16,20,16,20)
    fillSquare(COLOR, 16,20,24,32)
    fillSquare(COLOR, 20,24,0,4)
    fillSquare(COLOR, 20,24,12,32)
    fillSquare(COLOR, 24,28,4,8)
    fillSquare(COLOR, 24,28,16,28)
    fillSquare(COLOR, 28,32,8,24)

    fillSquare(SHADOW, 0,4,16,20)
    fillSquare(SHADOW, 4,8,8,12)
    fillSquare(SHADOW, 4,8,20,24)
    fillSquare(SHADOW, 8,12,4,16)
    fillSquare(SHADOW, 12,16,12,24)
    fillSquare(SHADOW, 16,20,8,12)
    fillSquare(SHADOW, 16,20,20,24)
    fillSquare(SHADOW, 20,24,4,8)
    fillSquare(SHADOW, 24,28,12,16)
  }


}
