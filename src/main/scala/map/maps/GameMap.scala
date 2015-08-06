package map.maps

import map.tiles.{TileDimension, Tile}

import scala.swing.Dimension

/**
 * Created by alexchou on 8/4/15.
 */
abstract class GameMap {
  val tiles: Array[Array[Tile]]
  var entrance: Dimension
}
