package map.maps

import scala.swing.Point

import map.objects._
import map.objects.buildings.PokeCenter
import map.tiles._

import scala.util.Random

/**
 * Created by alexchou on 8/3/15.
 */
object TestMap extends GameMap {
  val tiles = Array.ofDim[Tile](MapDimension.MAX_TILES_X, MapDimension.MAX_TILES_Y)
  var tileObjects = Set[TileObject]()

  var entrance = new Point(tiles.length/2, tiles(0).length/2)
  for {
    i <- 0 until tiles.length
    j <- 0 until tiles(i).length
  } yield {
    tiles(i)(j) = if (Math.round(Random.nextFloat()) == 0) new EmptyPath else new EmptyPath
  }
  tiles(entrance.getX.toInt)(entrance.getY.toInt) = new EmptyPath

  addGrass(new Point(entrance.getX.toInt - 10, entrance.getY.toInt - 10),
            new Point(entrance.getX.toInt - 2, entrance.getY.toInt - 2))

  // Add tile objects
  addTileObject(new Bush(
    new Point(entrance.getX.toInt + 1, entrance.getY.toInt))
  )

  addTileObject(new Tree(
    new Point(entrance.getX.toInt + 2, entrance.getY.toInt))
  )

  addTileObject(new Ledge(
    new Point(entrance.getX.toInt + 3, entrance.getY.toInt))
  )

  addTileObject(new PokeCenter(
    new Point(entrance.getX.toInt + 4, entrance.getY.toInt),
    EmptyMap, new Point(51,36))
  )

}
