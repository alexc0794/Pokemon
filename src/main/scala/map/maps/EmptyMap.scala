package map.maps

import java.awt.{Dimension, Color}

import map.maps.TestMap._
import map.objects.{Ledge, TileObject}
import map.objects.buildings.PokeCenter
import map.tiles._

/**
 * Created by alexchou on 8/4/15.
 */
object EmptyMap extends GameMap {
  val tiles = Array.ofDim[Tile](MapDimension.MAX_TILES_X, MapDimension.MAX_TILES_Y)
  var tileObjects = Set[TileObject]()

  var entrance = new Dimension(tiles.length/2, tiles(0).length/2)
  for {
    i <- 0 until tiles.length
    j <- 0 until tiles(i).length
  } yield {
    tiles(i)(j) = new EmptyPath
  }

  addTileObject(new Ledge(
    new Dimension(entrance.getWidth.toInt - 1, entrance.getHeight.toInt))
  )

  addTileObject(new PokeCenter(
    new Dimension(entrance.getWidth.toInt + 2, entrance.getHeight.toInt),
    TestMap)
  )
}
