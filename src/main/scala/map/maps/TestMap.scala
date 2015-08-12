package map.maps

import java.awt.Dimension

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

  var entrance = new Dimension(tiles.length/2, tiles(0).length/2)
  for {
    i <- 0 until tiles.length
    j <- 0 until tiles(i).length
  } yield {
    tiles(i)(j) = if (Math.round(Random.nextFloat()) == 0) new EmptyPath else new EmptyPath
  }
  tiles(entrance.getWidth.toInt)(entrance.getHeight.toInt) = new EmptyPath

  addTileObject(new Grass(
    new Dimension(entrance.getWidth.toInt - 1, entrance.getHeight.toInt - 1))

  )

  // Add tile objects
  addTileObject(new Bush(
    new Dimension(entrance.getWidth.toInt + 1, entrance.getHeight.toInt))
  )

  addTileObject(new Tree(
    new Dimension(entrance.getWidth.toInt + 2, entrance.getHeight.toInt))
  )

  addTileObject(new Ledge(
    new Dimension(entrance.getWidth.toInt + 3, entrance.getHeight.toInt))
  )

  addTileObject(new PokeCenter(
    new Dimension(entrance.getWidth.toInt + 4, entrance.getHeight.toInt),
    EmptyMap)
  )

}
