package map.maps

import java.awt.Point

import map.objects._
import map.tiles._

import scala.util.Random

/**
 * Created by alexchou on 8/16/15.
 */
object BrownMap extends GameMap {
  val tiles = Array.ofDim[Tile](MapDimension.MAX_TILES_X, MapDimension.MAX_TILES_Y)
  var tileObjects = Set[TileObject]()

  var entrance = new Point(tiles.length/2, tiles(0).length-1)
  for {
    i <- 0 until tiles.length
    j <- 0 until tiles(i).length
  } yield {
    tiles(i)(j) = new Sand
  }

  addBush(new Point(4,28), new Point(4,32))
  addBush(new Point(4,35), new Point(4,44))
  addBush(new Point(4,49), new Point(4,58))
  addBush(new Point(4,58), new Point(46,58))
  addBush(new Point(50,58), new Point(72,58))

  addGrass(new Point(36,40), new Point(46,57))
  addGrass(new Point(50,40), new Point(60,57))

}
