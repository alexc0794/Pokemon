package map.maps

import map.objects.TileObject
import map.tiles.{TileDimension, Tile}

import scala.swing.Dimension

/**
 * Created by alexchou on 8/4/15.
 */
abstract class GameMap {
  val tiles: Array[Array[Tile]]
  var tileObjects: Set[TileObject]
  var entrance: Dimension

  def addTileObject(tileObject: TileObject): Boolean = {
    val x1 = tileObject.lowerDimension.getWidth.toInt
    val y1 = tileObject.lowerDimension.getHeight.toInt
    val x2 = tileObject.upperDimension.getWidth.toInt
    val y2 = tileObject.upperDimension.getHeight.toInt

    for {
      i <- x1 until x2
      j <- y1 until y2
    } yield {
      tiles(i)(j) match {
        case tile: Tile => {
          tile.addTileObject(tileObject)
        }
        case _ => return false
      }
    }

    tileObjects += tileObject
    true
  }
}
