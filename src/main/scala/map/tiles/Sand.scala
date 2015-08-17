package map.tiles

import java.awt.Color

/**
 * Created by alexchou on 8/4/15.
 */
class Sand extends Tile {
  initPixels()

  val isTraversable = true
  val isJumpable = false
  val hasPokemon = false

  def initPixels(): Unit = {
    fillSquare(new Color(209,248,207), 0,32,0,32)
    val DIRT = Color.LIGHT_GRAY
    fillSquare(DIRT, 4,8,8,12)
    fillSquare(DIRT, 16,20,4,8)
    fillSquare(DIRT, 16,20,20,24)
    fillSquare(DIRT, 20,24,16,20)
    fillSquare(DIRT, 24,28,4,8)
    fillSquare(DIRT, 24,28,28,32)
  }
}
