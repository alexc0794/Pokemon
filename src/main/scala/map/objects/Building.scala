package map.objects

import scala.swing.Dimension

/**
 * Created by alexchou on 8/9/15.
 */
abstract class Building extends TileObject {
  val entrance: Dimension
}
