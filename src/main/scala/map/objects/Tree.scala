package map.objects

import java.awt.Color


import scala.swing.{Dimension, Color}

/**
 * Created by alexchou on 8/6/15.
 */
class Tree(lower: Dimension, upper: Dimension) extends TileObject {
  initPixels()

  var lowerDimension = lower
  var upperDimension = upper

  val isCuttable = false
  val isTraversable = false
  val hasPokemon = false

  def initPixels(): Unit = {

  }


}
