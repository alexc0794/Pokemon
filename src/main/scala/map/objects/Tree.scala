package map.objects

import java.awt.Color


import map.tiles.TileDimension

import scala.swing.{Dimension, Color}

/**
 * Created by alexchou on 8/6/15.
 */
class Tree(s: Dimension) extends TileObject {
  val start = s
  val WIDTH = 1
  val HEIGHT = 2
  var pixels = Array.ofDim[Color](WIDTH * TileDimension.PIXEL_WIDTH, HEIGHT * TileDimension.PIXEL_HEIGHT)
  val isCuttable = false
  val isTraversable = false
  val isJumpable = false
  val hasPokemon = false

  initPixels()

  def initPixels(): Unit = {
    val DARK_GREEN = new Color(30, 112, 45)
    val GREEN = Color.GREEN
    fillSquare(Color.BLACK, 0,4,24,36)
    fillSquare(Color.BLACK, 0,4,44,52)
    fillSquare(Color.BLACK, 4,8,16,24)
    fillSquare(Color.BLACK, 4,8,32,44)
    fillSquare(Color.BLACK, 4,8,48,52)
    fillSquare(Color.BLACK, 8,12,8,16)
    fillSquare(Color.BLACK, 8,12,20,28)
    fillSquare(Color.BLACK, 8,12,36,44)
    fillSquare(Color.BLACK, 8,12,52,60)
    fillSquare(Color.BLACK, 12,16,0,8)
    fillSquare(Color.BLACK, 12,16,20,28)
    fillSquare(Color.BLACK, 12,16,36,44)
    fillSquare(Color.BLACK, 12,16,52,56)
    fillSquare(Color.BLACK, 16,20,4,8)
    fillSquare(Color.BLACK, 16,20,24,32)
    fillSquare(Color.BLACK, 16,20,36,44)
    fillSquare(Color.BLACK, 16,20,48,56)
    fillSquare(Color.BLACK, 20,24,8,16)
    fillSquare(Color.BLACK, 20,24,24,32)
    fillSquare(Color.BLACK, 20,24,44,48)
    fillSquare(Color.BLACK, 20,24,52,60)
    fillSquare(Color.BLACK, 24,28,12,20)
    fillSquare(Color.BLACK, 24,28,28,44)
    fillSquare(Color.BLACK, 24,28,48,52)
    fillSquare(Color.BLACK, 28,32,20,32)
    fillSquare(Color.BLACK, 28,32,40,52)
    fillSquare(Color.BLACK, 4,8,60,64)
    fillSquare(Color.BLACK, 24,28,60,64)

    fillSquare(DARK_GREEN, 4,8,44,48)
    fillSquare(DARK_GREEN, 8,12,40,52)
    fillSquare(DARK_GREEN, 12,16,44,52)
    fillSquare(DARK_GREEN, 16,20,12,24)
    fillSquare(DARK_GREEN, 16,20,28,36)
    fillSquare(DARK_GREEN, 16,20,44,48)
    fillSquare(DARK_GREEN, 16,20,56,64)
    fillSquare(DARK_GREEN, 20,24,16,24)
    fillSquare(DARK_GREEN, 20,24,32,44)
    fillSquare(DARK_GREEN, 20,24,48,52)
    fillSquare(DARK_GREEN, 24,28,20,28)
    fillSquare(DARK_GREEN, 24,28,44,48)

    fillSquare(GREEN, 4,8,24,32)
    fillSquare(GREEN, 8,12,16,20)
    fillSquare(GREEN, 8,12,32,36)
    fillSquare(GREEN, 8,12,60,64)
    fillSquare(GREEN, 12,16,8,20)
    fillSquare(GREEN, 12,16,28,36)
    fillSquare(GREEN, 12,16,56,64)
    fillSquare(GREEN, 16,20,8,12)
    fillSquare(GREEN, 20,24,60,64)

  }


}
