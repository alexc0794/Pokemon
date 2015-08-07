package map.maps

import java.awt.{Dimension, Color}

import map.objects.TileObject
import map.tiles._

/**
 * Created by alexchou on 8/4/15.
 */
object EmptyMap extends GameMap {
  val tiles = Array.ofDim[Tile](MapDimension.MAX_TILES_X, MapDimension.MAX_TILES_Y)
  var tileObjects = Set[TileObject]()

  var entrance = new Dimension(tiles.length/2, tiles(0).length)
  for {
    i <- 0 until tiles.length
    j <- 0 until tiles(i).length
  } tiles(i)(j) = new EmptyPath
}
