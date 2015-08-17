package map.objects.buildings

import java.awt.Color

import map.maps._
import map.tiles.TileDimension

import scala.swing.Color
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
    val LIGHT_BROWN = new Color(171,122,42)
    val DARK_BROWN = new Color(141,101,20)
    val YELLOW = new Color(247,251,44)
    val ORANGE = new Color(243,106,13)
    val WHITE = new Color(209,248,207)
    val BLACK = Color.BLACK
    val LIGHT_GREEN = new Color(147,252,93)
    val DARK_GREEN = new Color(74,174,30)
    fillSquare(Color.WHITE, 0,128,0,160)

    /* DOOR */
    // yellow highlight
    fillSquare(YELLOW, 32,64,128,142)
    // orange highlight
    fillSquare(ORANGE, 36,60,132,136)
    // dark brown door shade
    fillSquare(DARK_BROWN, 34,62,142,160)
    // black door outline
    fillSquare(BLACK, 34,36,130,160)
    fillSquare(BLACK, 34,62,130,132)
    fillSquare(BLACK, 34,62,156,158)
    fillSquare(BLACK, 60,62,130,160)
    fillSquare(BLACK, 32,34,158,160)
    fillSquare(BLACK, 62,64,158,160)
    // black door window outline
    fillSquare(BLACK, 40,42,136,152)
    fillSquare(BLACK, 42,54,136,138)
    fillSquare(BLACK, 42,54,142,144)
    fillSquare(BLACK, 54,56,136,144)
    // light brown door window outline
    fillSquare(LIGHT_BROWN, 42,56,150,152)
    fillSquare(LIGHT_BROWN, 54,56,144,150)
    // light brown outline
    fillSquare(LIGHT_BROWN, 2,6,80,160)
    fillSquare(LIGHT_BROWN, 2,32,152,160)
    fillSquare(LIGHT_BROWN, 64,126,152,160)
    fillSquare(LIGHT_BROWN, 122,126,80,160)
    // black outline
    fillSquare(BLACK, 6,8,80,154)
    fillSquare(BLACK, 8,10,154,156)
    fillSquare(BLACK, 10,32,156,158)
    fillSquare(BLACK, 64,118,156,158)
    fillSquare(BLACK, 118,120,154,156)
    fillSquare(BLACK, 120,122,80,154)
    /* DARK BROWN OUTLINE */
    fillSquare(DARK_BROWN, 12,14,80,156)
    fillSquare(DARK_BROWN, 12,32,154,156)
    fillSquare(DARK_BROWN, 64,116,154,156)
    fillSquare(DARK_BROWN, 114,116,80,156)

    /* ROOF */
    // green background
    fillSquare(LIGHT_GREEN, 0,128,0,80)
    // dark green stripes
    fillSquare(DARK_GREEN, 4,124,74,78)
    fillSquare(DARK_GREEN, 10,122,68,72)
    // horizontal black outline
    fillSquare(BLACK, 2,126,0,4)
    fillSquare(BLACK, 0,128,72,76)
    fillSquare(BLACK, 0,128,78,80)
    // vertical black outline
    fillSquare(BLACK, 0,6,4,72)
    fillSquare(BLACK, 122,128,4,72)
    fillSquare(BLACK, 0,2,72,80)
    fillSquare(BLACK, 126,128,72,80)
  }
}
