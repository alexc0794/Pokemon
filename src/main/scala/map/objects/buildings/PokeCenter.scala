package map.objects.buildings

import map.maps._
import map.tiles.TileDimension

import scala.swing.{Point, Color}

/**
 * Created by alexchou on 8/9/15.
 */
class PokeCenter(s: Point, to: GameMap) extends Building {
  val start = s
  val entrance = new Point(s.getX.toInt + 1, s.getY.toInt + 4)
  val toMap = to
  val WIDTH = 4
  val HEIGHT = 5
  var pixels = Array.ofDim[Color](WIDTH * TileDimension.PIXEL_WIDTH, HEIGHT * TileDimension.PIXEL_HEIGHT)
  val isCuttable = false
  val isTraversable = false
  val isJumpable = false
  val hasPokemon = false

  initPixels()

  def initPixels(): Unit = {
    val LIGHT_BROWN = new Color(184, 148, 77)
    fillSquare(LIGHT_BROWN, 0,128,0,160)
  }
}
