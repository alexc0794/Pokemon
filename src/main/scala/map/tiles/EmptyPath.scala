package map.tiles

import java.awt.Color

/**
 * Created by alexchou on 8/4/15.
 */
class EmptyPath extends Tile {
  initPixels()

  val isTraversable = true
  val isJumpable = false
  val hasPokemon = false

  def initPixels(): Unit = {
    val DIRT = Color.LIGHT_GRAY
    fillSquare(DIRT, 4,8,4,12)
    fillSquare(DIRT, 4,8,24,28)
    fillSquare(DIRT, 8,12,16,20)
    fillSquare(DIRT, 12,16,4,12)
    fillSquare(DIRT, 12,16,24,28)
    fillSquare(DIRT, 16,20,16,20)
    fillSquare(DIRT, 20,24,8,16)
    fillSquare(DIRT, 20,24,20,24)
    fillSquare(DIRT, 28,32,8,16)
    fillSquare(DIRT, 28,32,20,24)
  }
}
