package map.characters

import java.awt.{Color, Graphics2D}

import map.tiles.TileDimension
import user._

/**
 * Created by alexchou on 8/4/15.
 */
object UserCharacter extends PokeCharacter {
  var name = User.name

  var pixels = Array.ofDim[Color](TileDimension.PIXEL_WIDTH, TileDimension.PIXEL_HEIGHT)

  initPixels()

  def initPixels(): Unit = {
    fillSquare(Color.BLACK, 0,32,0,32)
  }
}
