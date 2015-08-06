package app

import java.awt.Color

import map.maps._
import map.tiles._
import user.User

import scala.swing._

/**
 * Created by alexchou on 8/3/15.
 */
class ScreenPanel(map: GameMap) extends FlowPanel {
  // centerX and centerY are indices for the map dimensions
  var centerX = map.entrance.getWidth.toInt
  var centerY = map.entrance.getHeight.toInt

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

  def moveCharacter(changeX: Int, changeY: Int): Unit = {
    val newX = centerX + changeX
    val newY = centerY + changeY
    if (isInMap(newX, newY)) {
      val newCenterTile = map.tiles(newX)(newY)
      if (newCenterTile.isTraversable) {
        if (newCenterTile.hasPokemon) User.incrementGrassCounter()
        map.tiles(centerX)(centerY).isCenter = false
        centerX = newX
        centerY = newY
        println("User grass counter: " + User.grassCounter)
        repaint()
      }
    }
  }

  override def paintComponent(g: Graphics2D): Unit = {
    super.paintComponent(g)
    map.tiles(centerX)(centerY).isCenter = true
    // Iterates through every tile and paints it
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
  }




  def isCenterOfScreen(x: Int, y: Int): Boolean = {
    ((x <= ScreenDimension.CENTER_X && x >= ScreenDimension.CENTER_X - 1)
      && (y <= ScreenDimension.CENTER_Y && y >= ScreenDimension.CENTER_Y - 1))
  }

  // input is a map dimension
  def isInMap(x: Int, y: Int): Boolean = {
    val mapWidth = map.tiles.length
    val mapHeight = map.tiles.map(_.length).max
    (x >= 0 && x < mapWidth && y >= 0 && y < mapHeight)
  }
}
