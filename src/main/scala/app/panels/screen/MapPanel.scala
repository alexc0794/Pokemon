package app.panels.screen

import java.awt.Color

import app.ScreenDimension
import map.characters._
import map.maps._
import map.objects.buildings._
import map.tiles._
import user.User

import scala.swing._
import scala.swing.event.{Key, KeyPressed}

/**
 * Created by alexchou on 8/3/15.
 */
class MapPanel(m: GameMap) extends ScreenPanel {
  reactions += {
    case KeyPressed(_,Key.Up,_,_) => this.moveCharacter(0,-1)
    case KeyPressed(_,Key.Down,_,_) => this.moveCharacter(0,1)
    case KeyPressed(_,Key.Left,_,_) => this.moveCharacter(-1,0)
    case KeyPressed(_,Key.Right,_,_) => this.moveCharacter(1,0)
  }


  var map = m
  // centerX and centerY are indices for the map dimensions
  var centerX: Int = map.entrance.getX.toInt
  var centerY: Int = map.entrance.getY.toInt

  def getMinScreenX(): Int = centerX - ScreenDimension.CENTER_X
  def getMaxScreenX(): Int = centerX + ScreenDimension.CENTER_X
  def getMinScreenY(): Int = centerY - ScreenDimension.CENTER_Y
  def getMaxScreenY(): Int = centerY + ScreenDimension.CENTER_Y


  // currX and currY are indices for where the character is currently on the screen
  var currScreenX = ScreenDimension.CENTER_X
  var currScreenY = ScreenDimension.CENTER_Y

  def toScreenDimension(x: Int, y: Int): Option[(Int, Int)] = {
    val newX = x - getMinScreenX()
    val newY = y - getMinScreenY()
    if (newX < 0 || newY < 0) None
    else Some(newX, newY)
  }

  def getTile(x: Int, y: Int): Option[Tile] = {
    if (isInMap(x,y)) Some(map.tiles(x)(y))
    else None
  }

  def moveCharacter(changeX: Int, changeY: Int): Unit = {
    getTile(centerX + changeX, centerY + changeY) match {
      case Some(tile: Tile) => {
        if (tile.checkIsTraversable()) {
          if (tile.checkHasPokemon()) {
            User.incrementGrassCounter()
          }
          centerX += changeX
          centerY += changeY
        } else if (tile.checkIsJumpable()) {
          println("Jump!")
          centerX += (changeX * 2)
          centerY += (changeY * 2)
        } else {
          tile.checkIsEntrance(new Point(centerX + changeX, centerY + changeY)) match {
            case Some(toMap: GameMap) => {
              println("change map to " + toMap)
              for (tileObject <- toMap.tileObjects) {
                tileObject match {
                  case building: Building => {
                    if (building.toMap.equals(map))
                    centerX = building.entrance.getX.toInt
                    centerY = building.entrance.getY.toInt
                    map = toMap
                    val neighbor1 = getTile(centerX + 1, centerY)
                    val neighbor2 = getTile(centerX - 1, centerY)
                    val neighbor3 = getTile(centerX, centerY + 1)
                    val neighbor4 = getTile(centerX, centerY - 1)
                    if (!neighbor1.isEmpty && neighbor1.get.checkIsTraversable()) {
                      println("neighbor1")
                      centerX += 1
                    }
                    else if (!neighbor2.isEmpty && neighbor2.get.checkIsTraversable()) {
                      println("neighbor2")
                      centerX -= 1
                    }
                    else if (!neighbor3.isEmpty && neighbor3.get.checkIsTraversable()) {
                       println("neighbor3")
                      centerY += 1
                    }
                    else if (!neighbor4.isEmpty && neighbor4.get.checkIsTraversable()) centerY -= 1
                  }
                  case _ =>
                }
              }
              map = toMap
            }
            case None =>
          }
        }
      }
      case None =>
    }
    repaint
  }

  override def paintComponent(g: Graphics2D): Unit = {
    super.paintComponent(g)
    map.tiles(centerX)(centerY).isCenter = true
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



  def save(): Unit = {
    println("Saving")
  }
}
