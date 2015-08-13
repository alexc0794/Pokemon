package map.objects.buildings

import map.maps.GameMap
import map.objects.TileObject

import scala.swing.Point

/**
 * Created by alexchou on 8/9/15.
 */
abstract class Building extends TileObject {
  val entrance: Point
  val toMap: GameMap
}
