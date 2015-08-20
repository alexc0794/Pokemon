package map.characters

import java.awt.Color

import gameplay.direction._
import map.tiles.TileDimension
import user._

/**
 * Created by alexchou on 8/4/15.
 */
object UserCharacter extends PokeCharacter {
  var name = User.name
  direction = new Down()

  var pixels = Array.ofDim[Color](TileDimension.PIXEL_WIDTH, TileDimension.PIXEL_HEIGHT)

  initPixels()

  def initPixels(): Unit = {
    pixels = Array.ofDim[Color](TileDimension.PIXEL_WIDTH, TileDimension.PIXEL_HEIGHT)
    val RED = new Color(243,31,12)
    val SKIN = new Color(244,133,63)

    direction match {
      case _: Down => {
        /* COLOR SKIN */
        fillSquare(SKIN, 4,28,12,16)
        fillSquare(SKIN, 8,24,16,22)
        fillSquare(SKIN, 2,30,22,26)

        /* BODY OUTLINE */
        fillSquare(Color.BLACK, 0,2,22,26)
        fillSquare(Color.BLACK, 2,4,12,16)
        fillSquare(Color.BLACK, 2,4,20,22)
        fillSquare(Color.BLACK, 2,4,26,28)
        fillSquare(Color.BLACK, 4,6,8,12)
        fillSquare(Color.BLACK, 4,6,16,18)
        fillSquare(Color.BLACK, 4,6,20,22)
        fillSquare(Color.BLACK, 4,6,26,28)
        fillSquare(Color.BLACK, 6,8,4,14)
        fillSquare(Color.BLACK, 6,8,16,22)
        fillSquare(Color.BLACK, 6,8,26,30)
        fillSquare(Color.BLACK, 8,10,2,4)
        fillSquare(Color.BLACK, 8,10,10,12)
        fillSquare(Color.BLACK, 8,10,22,28)
        fillSquare(Color.BLACK, 8,10,30,32)
        fillSquare(Color.BLACK, 10,12,0,2)
        fillSquare(Color.BLACK, 10,12,10,12)
        fillSquare(Color.BLACK, 10,12,26,28)
        fillSquare(Color.BLACK, 10,12,30,32)
        fillSquare(Color.BLACK, 12,14,0,2)
        fillSquare(Color.BLACK, 12,14,8,10)
        fillSquare(Color.BLACK, 12,14,14,18)
        fillSquare(Color.BLACK, 12,14,22,24)
        fillSquare(Color.BLACK, 12,14,26,30)
        fillSquare(Color.BLACK, 14,16,0,2)
        fillSquare(Color.BLACK, 14,16,6,10)
        fillSquare(Color.BLACK, 14,16,22,24)
        fillSquare(Color.BLACK, 14,16,26,30)
        fillSquare(Color.BLACK, 16,18,0,2)
        fillSquare(Color.BLACK, 16,18,6,10)
        fillSquare(Color.BLACK, 16,18,22,24)
        fillSquare(Color.BLACK, 16,18,26,30)
        fillSquare(Color.BLACK, 18,20,0,2)
        fillSquare(Color.BLACK, 18,20,8,10)
        fillSquare(Color.BLACK, 18,20,14,18)
        fillSquare(Color.BLACK, 18,20,22,24)
        fillSquare(Color.BLACK, 18,20,26,30)
        fillSquare(Color.BLACK, 20,22,0,2)
        fillSquare(Color.BLACK, 20,22,10,12)
        fillSquare(Color.BLACK, 20,22,26,28)
        fillSquare(Color.BLACK, 20,22,30,32)
        fillSquare(Color.BLACK, 22,24,2,4)
        fillSquare(Color.BLACK, 22,24,10,12)
        fillSquare(Color.BLACK, 22,24,22,28)
        fillSquare(Color.BLACK, 22,24,30,32)
        fillSquare(Color.BLACK, 24,26,4,14)
        fillSquare(Color.BLACK, 24,26,16,22)
        fillSquare(Color.BLACK, 24,26,26,30)
        fillSquare(Color.BLACK, 26,28,8,12)
        fillSquare(Color.BLACK, 26,28,16,18)
        fillSquare(Color.BLACK, 26,28,20,22)
        fillSquare(Color.BLACK, 26,28,26,28)
        fillSquare(Color.BLACK, 28,30,12,16)
        fillSquare(Color.BLACK, 28,30,20,22)
        fillSquare(Color.BLACK, 28,30,26,28)
        fillSquare(Color.BLACK, 30,32,22,26)

        /* COLOR HAT */
        fillSquare(RED, 10,22,2,4)
        fillSquare(RED, 8,24,4,6)
        fillSquare(RED, 8,14,6,8)
        fillSquare(RED, 18,24,6,8)
        fillSquare(RED, 8,12,8,10)
        fillSquare(RED, 20,24,8,10)
        fillSquare(RED, 12,20,10,12)

        /* COLOR SHOES */
        fillSquare(RED, 8,12,28,30)
        fillSquare(RED, 20,24,28,30)

        /* COLOR SHIRT */
        fillSquare(RED, 14,18,20,22)
        fillSquare(RED, 14,18,24,25)
        fillSquare(RED, 12,14,25,26)
        fillSquare(RED, 18,20,25,26)
      }
      case _: Up => {
        fillSquare(SKIN, 4,28,12,16)
        fillSquare(SKIN, 12,20,18,20)
        fillSquare(SKIN, 2,30,22,26)

        fillSquare(RED, 8,24,2,10)
        fillSquare(RED, 8,24,16,18)
        fillSquare(RED, 8,24,20,22)
        fillSquare(RED, 8,24,28,30)

        fillSquare(Color.BLACK, 10,22,0,2)
        fillSquare(Color.BLACK, 8,10,2,4)
        fillSquare(Color.BLACK, 22,24,2,4)
        fillSquare(Color.BLACK, 6,8,4,14)
        fillSquare(Color.BLACK, 24,26,4,14)
        fillSquare(Color.BLACK, 8,10,8,10)
        fillSquare(Color.BLACK, 22,24,8,10)
        fillSquare(Color.BLACK, 4,28,10,12)
        fillSquare(Color.BLACK, 6,26,12,14)
        fillSquare(Color.BLACK, 8,24,14,16)
        fillSquare(Color.BLACK, 12,20,16,18)
        fillSquare(Color.BLACK, 2,4,12,16)
        fillSquare(Color.BLACK, 28,30,12,16)
        fillSquare(Color.BLACK, 4,8,16,18)
        fillSquare(Color.BLACK, 24,28,16,18)
        fillSquare(Color.BLACK, 6,12,18,20)
        fillSquare(Color.BLACK, 20,26,18,20)
        fillSquare(Color.BLACK, 2,8,20,22)
        fillSquare(Color.BLACK, 24,30,20,22)
        fillSquare(Color.BLACK, 10,12,20,22)
        fillSquare(Color.BLACK, 20,22,20,22)
        fillSquare(Color.BLACK, 0,2,22,26)
        fillSquare(Color.BLACK, 30,32,22,26)
        fillSquare(Color.BLACK, 8,12,22,26)
        fillSquare(Color.BLACK, 20,24,22,26)
        fillSquare(Color.BLACK, 2,30,26,28)
        fillSquare(Color.BLACK, 6,8,28,30)
        fillSquare(Color.BLACK, 12,20,28,30)
        fillSquare(Color.BLACK, 24,26,28,30)
        fillSquare(Color.BLACK, 8,12,30,32)
        fillSquare(Color.BLACK, 20,24,30,32)

      }
      case _: Left => {
        fillSquare(RED, 2,8,8,10)
        fillSquare(RED, 8,28,2,10)

        fillSquare(RED, 22,26,20,26)
        fillSquare(RED, 12,20,26,30)

        fillSquare(SKIN, 8,26,10,20)
        fillSquare(SKIN, 16,20,22,26)

        fillSquare(Color.BLACK, 10,26,0,2)
        fillSquare(Color.BLACK, 8,10,2,4)
        fillSquare(Color.BLACK, 26,28,2,4)
        fillSquare(Color.BLACK, 6,8,4,6)
        fillSquare(Color.BLACK, 28,30,4,16)
        fillSquare(Color.BLACK, 2,8,6,8)
        fillSquare(Color.BLACK, 0,2,8,10)
        fillSquare(Color.BLACK, 2,8,10,12)
        fillSquare(Color.BLACK, 18,32,10,12)
        fillSquare(Color.BLACK, 6,8,12,18)
        fillSquare(Color.BLACK, 12,14,12,16)
        fillSquare(Color.BLACK, 20,22,12,16)
        fillSquare(Color.BLACK, 22,30,12,14)
        fillSquare(Color.BLACK, 26,30,14,16)
        fillSquare(Color.BLACK, 26,28,16,18)
        fillSquare(Color.BLACK, 8,10,18,20)
        fillSquare(Color.BLACK, 22,26,18,20)
        fillSquare(Color.BLACK, 10,22,20,22)
        fillSquare(Color.BLACK, 26,28,20,26)
        fillSquare(Color.BLACK, 12,16,22,26)
        fillSquare(Color.BLACK, 20,22,22,30)
        fillSquare(Color.BLACK, 10,12,26,30)
        fillSquare(Color.BLACK, 16,26,26,28)
        fillSquare(Color.BLACK, 12,20,30,32)

      }
      case _: Right => {
        fillSquare(RED, 4,24,2,10)
        fillSquare(RED, 24,30,8,10)

        fillSquare(RED, 6,10,20,26)
        fillSquare(RED, 12,20,26,30)

        fillSquare(SKIN, 6,24,10,20)
        fillSquare(SKIN, 12,16,22,26)

        fillSquare(Color.BLACK, 6,22,0,2)
        fillSquare(Color.BLACK, 4,6,2,4)
        fillSquare(Color.BLACK, 22,24,2,4)
        fillSquare(Color.BLACK, 2,4,4,16)
        fillSquare(Color.BLACK, 24,26,4,8)
        fillSquare(Color.BLACK, 0,14,10,12)
        fillSquare(Color.BLACK, 24,26,4,8)
        fillSquare(Color.BLACK, 26,30,6,8)
        fillSquare(Color.BLACK, 30,32,8,10)
        fillSquare(Color.BLACK, 4,12,12,14)
        fillSquare(Color.BLACK, 4,6,14,18)
        fillSquare(Color.BLACK, 10,12,14,16)
        fillSquare(Color.BLACK, 10,12,20,22)
        fillSquare(Color.BLACK, 18,20,12,16)
        fillSquare(Color.BLACK, 24,30,10,12)
        fillSquare(Color.BLACK, 24,26,12,18)
        fillSquare(Color.BLACK, 6,10,18,20)
        fillSquare(Color.BLACK, 22,24,18,20)
        fillSquare(Color.BLACK, 4,6,20,26)
        fillSquare(Color.BLACK, 12,22,20,22)
        fillSquare(Color.BLACK, 10,12,22,30)
        fillSquare(Color.BLACK, 6,16,26,28)
        fillSquare(Color.BLACK, 16,20,22,26)
        fillSquare(Color.BLACK, 12,20,30,32)
        fillSquare(Color.BLACK, 20,22,26,30)
      }
      case _ =>
    }

  }
}
