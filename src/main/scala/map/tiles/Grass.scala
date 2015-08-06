package map.tiles

import java.awt.{Color, Graphics2D}

/**
 * Created by alexchou on 8/3/15.
 */
class Grass extends Tile {
  initPixels()

  val isTraversable = true
  val hasPokemon = true

  def initPixels(): Unit = {
    val SHADOW = new Color(159,248,171)
    fillSquare(Color.GREEN, 0,4,4,20)
    fillSquare(Color.GREEN, 4,8,4,16)
    fillSquare(Color.GREEN, 4,8,20,24)
    fillSquare(Color.GREEN, 8,12,8,16)
    fillSquare(Color.GREEN, 8,12,24,28)
    fillSquare(Color.GREEN, 12,16,16,20)
    fillSquare(Color.GREEN, 12,16,24,28)
    fillSquare(Color.GREEN, 16,20,8,32)
    fillSquare(Color.GREEN, 20,24,4,8)
    fillSquare(Color.GREEN, 20,24,16,28)
    fillSquare(Color.GREEN, 24,28,0,4)
    fillSquare(Color.GREEN, 24,28,12,20)
    fillSquare(Color.GREEN, 28,32,4,16)

    fillSquare(SHADOW, 0,4,24,28)
    fillSquare(SHADOW, 4,8,24,32)
    fillSquare(SHADOW, 8,12,16,20)
    fillSquare(SHADOW, 8,12,28,32)
    fillSquare(SHADOW, 12,16,28,32)
    fillSquare(SHADOW, 20,24,8,16)
    fillSquare(SHADOW, 20,24,28,32)
    fillSquare(SHADOW, 24,28,8,12)
    fillSquare(SHADOW, 24,28,20,24)
    fillSquare(SHADOW, 28,32,0,4)
    fillSquare(SHADOW, 28,32,16,20)
  }

}
