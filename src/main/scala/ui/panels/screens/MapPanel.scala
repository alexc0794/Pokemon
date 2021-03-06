package ui.panels.screen

import java.awt.Color
import gameplay.direction._
import map.characters._
import map.maps._
import map.tiles._
import ui.dimensions.ScreenDimension
import user.User

import scala.swing._

/**
 * Created by alexchou on 8/3/15.
 */
class MapPanel(m: GameMap) extends ScreenPanel {
  var map = m
  // centerX and centerY are indices for the map dimensions
  var center: Point = new Point(map.entrance.getX.toInt, map.entrance.getY.toInt)
  def getCenterX(): Int = center.getX().toInt
  def getCenterY(): Int = center.getY().toInt

  def getMinScreenX(): Int = getCenterX - ScreenDimension.CENTER_X
  def getMaxScreenX(): Int = getCenterX + ScreenDimension.CENTER_X
  def getMinScreenY(): Int = getCenterY - ScreenDimension.CENTER_Y
  def getMaxScreenY(): Int = getCenterY + ScreenDimension.CENTER_Y

  // currX and currY are indices for where the character is currently on the screen
  var currScreenX = ScreenDimension.CENTER_X
  var currScreenY = ScreenDimension.CENTER_Y


  def up(): Unit = {
    UserCharacter.direction = new Up()
    UserCharacter.initPixels()
    moveCharacter(0,-1)
  }
  def down(): Unit = {
    UserCharacter.direction = new Down()
    UserCharacter.initPixels()
    moveCharacter(0,1)
  }
  def left(): Unit = {
    UserCharacter.direction = new Left()
    UserCharacter.initPixels()
    moveCharacter(-1,0)
  }
  def right(): Unit = {
    UserCharacter.direction = new Right()
    UserCharacter.initPixels()
    moveCharacter(1,0)
  }
  def select(): Unit = {}


  def toScreenDimension(x: Int, y: Int): Option[(Int, Int)] = {
    val newX = x - getMinScreenX()
    val newY = y - getMinScreenY()
    if (newX < 0 || newY < 0) None
    else Some(newX, newY)
  }

  def movePoint(p: Point, changeX: Int, changeY: Int): Point = {
    new Point((p.getX().toInt + changeX), (p.getY().toInt + changeY))
  }

  def getTile(p: Point): Option[Tile] = {
    if (isInMap(p.getX().toInt, p.getY().toInt)) Some(map.tiles(p.getX().toInt)(p.getY().toInt))
    else None
  }

  def traverseTile(tile: Tile): Unit = {
    if (tile.checkHasPokemon()) User.state.incrementGrassCounter()
  }

  def moveCharacter(changeX: Int, changeY: Int): Unit = {
    var newCenter: Point = movePoint(center, changeX, changeY)
    if (map.isInBounds(newCenter)) {
      getTile(newCenter) match {
        case Some(tile) => {
          if (tile.checkIsTraversable()) {
            traverseTile(tile)
            center = newCenter
          } else if (tile.checkIsJumpable()) {
            newCenter = movePoint(center, changeX*2, changeY*2)
            center = newCenter
          } else if (!tile.checkIsEntrance(newCenter).isEmpty) {
            val building = tile.checkIsEntrance(newCenter).get
            map = building.toMap
            newCenter = building.toMapEntrance
            center = newCenter
          }
        }
        case None => println("at the edge of the map")
      }
    }
    repaint()
  }

  override def paintComponent(g: Graphics2D): Unit = {
    super.paintComponent(g)
    map.tiles(getCenterX())(getCenterY()).isCenter = true
    // Paint tiles
    var i = 0
    for {
      tile_x <- 0 until ScreenDimension.TILES_X
      tile_y <- 0 until ScreenDimension.TILES_Y
      x1 = (tile_x * TileDimension.PIXEL_WIDTH)
      y1 = (tile_y * TileDimension.PIXEL_HEIGHT)
      x2 = ((tile_x + 1) * TileDimension.PIXEL_WIDTH)
      y2 = ((tile_y + 1) * TileDimension.PIXEL_HEIGHT)
    } yield {
      if (isInMap(tile_x + getMinScreenX(), tile_y + getMinScreenY())) {
        map.tiles(tile_x + getMinScreenX())(tile_y + getMinScreenY()) match {
          case tile: Tile => {
            i += 1
            tile.drawPixels(g, x1, y1, x2, y2)
          }
          case _ => {
            g.setColor(Color.WHITE)
            g.fillRect(x1, y1, x2 - x1, y2 - y1)
          }
        }
      } else {
        g.setColor(Color.BLACK)
        g.fillRect(x1, y1, x2 - x1, y2 - y1)
      }
    }

    // Paint tile objects
    for {
      tileObject <- map.tileObjects
      lower = toScreenDimension(tileObject.start.getX.toInt, tileObject.start.getY.toInt)
      higher = toScreenDimension(tileObject.getEnd.getX.toInt, tileObject.getEnd.getY.toInt)
    } yield {
      (lower, higher) match {
        case (Some(l), Some(h)) => tileObject.drawPixels(g, l._1 * TileDimension.PIXEL_WIDTH, l._2 * TileDimension.PIXEL_HEIGHT, h._1 * TileDimension.PIXEL_WIDTH, h._2 * TileDimension.PIXEL_HEIGHT)
        case _ =>
      }
    }
    // Paint user character
    UserCharacter.drawPixels(g, currScreenX * TileDimension.PIXEL_WIDTH, currScreenY * TileDimension.PIXEL_HEIGHT, (currScreenX + 1) * TileDimension.PIXEL_WIDTH, (currScreenY + 1) * TileDimension.PIXEL_HEIGHT)
  }

  // input is a map dimension
  def isInMap(x: Int, y: Int): Boolean = {
    val mapWidth = map.tiles.length
    val mapHeight = map.tiles.map(_.length).max
    (x >= 0 && x < mapWidth && y >= 0 && y < mapHeight)
  }


}
