package app

import map.tiles.TileDimension

/**
 * Created by alexchou on 8/4/15.
 */
object ScreenDimension {
  val TILES_X = 24
  val TILES_Y = 16
  val proportion = 1
  val WIDTH_X = TILES_X * TileDimension.PIXEL_WIDTH * proportion
  val HEIGHT_Y = TILES_Y * TileDimension.PIXEL_HEIGHT * proportion
  val CENTER_X = TILES_X / 2
  val CENTER_Y = TILES_Y / 2
}
