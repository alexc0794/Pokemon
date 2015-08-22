package map.objects.buildings

import map.maps.GameMap
import map.objects.TileObject

import scala.swing.{Dimension, Point}

/**
 * Created by alexchou on 8/9/15.
 */
abstract class Building(s: Point, map: GameMap, mapEntrance: Point) extends TileObject {
  val start: Point = s
  val toMap: GameMap = map
  val toMapEntrance: Point = mapEntrance

  def entrance(): Point =
    new Point((start.getX().toInt + Math.floor(WIDTH/2.0).toInt - 1),
      (start.getY().toInt + HEIGHT - 1))
}
