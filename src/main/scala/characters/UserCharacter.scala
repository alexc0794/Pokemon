package characters

import java.awt.{Color, Graphics2D}

import user._

/**
 * Created by alexchou on 8/4/15.
 */
object UserCharacter extends PokeCharacter {
  var name = User.name

  def initDrawing(): Unit = {
    fillSquare(Color.BLACK, 0,16,0,8)

  }
}
