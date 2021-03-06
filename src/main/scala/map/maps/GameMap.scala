package map.maps

import map.objects._
import map.objects.buildings.Building
import map.tiles._

import scala.swing.Point

/**
 * Created by alexchou on 8/4/15.
 */
abstract class GameMap {
  val tiles: Array[Array[Tile]]
  var tileObjects: Set[TileObject]
  var entrance: Point

  def getRows(): Int = tiles.length

  def getCols(): Int = tiles(0).length

  def isInBounds(p: Point): Boolean = {
    (p.getX().toInt >= 0
      && p.getX().toInt < getCols()
      && p.getY().toInt >= 0
      && p.getY().toInt < getRows())
  }

  def addTileObject(tileObject: TileObject): Boolean = {
    val x1 = tileObject.start.getX.toInt
    val y1 = tileObject.start.getY.toInt
    val x2 = tileObject.getEnd.getX.toInt
    val y2 = tileObject.getEnd.getY.toInt

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

  def getBuildings(): List[Building] = {
    var buildings = List[Building]()
    for {
      tileObject <- tileObjects
    } yield {
      tileObject match {
        case b: Building => buildings = buildings :+ b
        case _ =>
      }
    }
    buildings
  }

  def addGrass(start: Point, end: Point): Boolean = {
    for {
      x <- Math.min(start.getX.toInt, end.getX.toInt) to Math.max(start.getX.toInt, end.getX.toInt)
      y <- Math.min(start.getY.toInt, end.getY.toInt) to Math.max(start.getY.toInt, end.getY.toInt)
    } yield {
      if (!addTileObject(new Grass(new Point(x,y)))) return false
    }
    true
  }

  def addLedge(start: Point, end: Point): Boolean = {
    for {
      x <- Math.min(start.getX.toInt, end.getX.toInt) to Math.max(start.getX.toInt, end.getX.toInt)
      y <- Math.min(start.getY.toInt, end.getY.toInt) to Math.max(start.getY.toInt, end.getY.toInt)
    } yield {
      if (!addTileObject(new Ledge(new Point(x,y)))) return false
    }
    true
  }

  def addBush(start: Point, end: Point): Boolean = {
    for {
      x <- Math.min(start.getX.toInt, end.getX.toInt) to Math.max(start.getX.toInt, end.getX.toInt)
      y <- Math.min(start.getY.toInt, end.getY.toInt) to Math.max(start.getY.toInt, end.getY.toInt)
    } yield {
      if (!addTileObject(new Bush(new Point(x,y)))) return false
    }
    true
  }

}
