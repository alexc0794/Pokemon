package map.maps

import java.awt.Dimension

import map.tiles._

import scala.util.Random

/**
 * Created by alexchou on 8/3/15.
 */
object TestMap extends GameMap {
  val tiles = Array.ofDim[Tile](MapDimension.MAX_TILES_X, MapDimension.MAX_TILES_Y)
  var entrance = new Dimension(tiles.length/2, tiles(0).length/2)
  for {
    i <- 0 until tiles.length
    j <- 0 until tiles(i).length
  } yield {
    tiles(i)(j) = if (Math.round(Random.nextFloat()) == 0) new Grass else new EmptyPath
  }
  tiles(entrance.getWidth.toInt)(entrance.getHeight.toInt) = new EmptyPath
}
