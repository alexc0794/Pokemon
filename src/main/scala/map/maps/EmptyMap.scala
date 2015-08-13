package map.maps


import scala.swing.Point
import map.objects.{Ledge, TileObject}
import map.objects.buildings.PokeCenter
import map.tiles._

/**
 * Created by alexchou on 8/4/15.
 */
object EmptyMap extends GameMap {
  val tiles = Array.ofDim[Tile](MapDimension.MAX_TILES_X, MapDimension.MAX_TILES_Y)
  var tileObjects = Set[TileObject]()

  var entrance = new Point(tiles.length/2, tiles(0).length/2)
  for {
    i <- 0 until tiles.length
    j <- 0 until tiles(i).length
  } yield {
    tiles(i)(j) = new EmptyPath
  }

  addTileObject(new Ledge(
    new Point(entrance.getX.toInt - 1, entrance.getY.toInt))
  )

  addTileObject(new PokeCenter(
    new Point(entrance.getX.toInt + 2, entrance.getY.toInt),
    TestMap)
  )
}
