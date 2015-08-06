package app

import java.awt.{BorderLayout, Color}
import javax.swing.border.Border
import scala.swing.event._
import swing._
import map.maps._


/**
 * Created by alexchou on 8/2/15.
 */
object PokemonApp extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "Pokemon"
    peer.setLocationRelativeTo(null)
    val screenPanel = new ScreenPanel(TestMap) {
      background = Color.BLACK
      preferredSize = new Dimension(ScreenDimension.WIDTH_X, ScreenDimension.HEIGHT_Y)
      maximumSize = new Dimension(ScreenDimension.WIDTH_X, ScreenDimension.HEIGHT_Y)
      focusable = true
      listenTo(keys)
      /* Key listeners */
      reactions += {
        case KeyPressed(_,Key.Up,_,_) => {
          this.moveCharacter(0,-1)
        }
        case KeyPressed(_,Key.Down,_,_) => {
          this.moveCharacter(0,1)
        }
        case KeyPressed(_,Key.Left,_,_) => {
          this.moveCharacter(-1,0)
        }
        case KeyPressed(_,Key.Right,_,_) => {
          this.moveCharacter(1,0)
        }
      }
    }
    val upButton = new Button {
      text = "U"
      enabled = true
      focusPainted = false
      reactions += {
        case ButtonClicked(b) => {
          screenPanel.moveCharacter(0,-1)
        }
      }
    }

    val downButton = new Button {
      text = "D"
      enabled = true
      focusPainted = false
      reactions += {
        case ButtonClicked(b) => {
          screenPanel.moveCharacter(0,1)
        }
      }
    }

    val leftButton = new Button {
      text = "L"
      enabled = true
      focusPainted = false
      reactions += {
        case ButtonClicked(b) => {
          screenPanel.moveCharacter(-1,0)
        }
      }
    }
    val rightButton = new Button {
      text = "R"
      enabled = true
      focusPainted = false
      reactions += {
        case ButtonClicked(b) => {
          screenPanel.moveCharacter(1,0)
        }
      }
    }

    val borderLayout = new BorderLayout()
    borderLayout.setVgap(0)
    borderLayout.setHgap(0)

    val buttonPanel = new BorderPanel {
      val directionalPanel = new BorderPanel {
        layout(upButton) = BorderPanel.Position.North
        layout(downButton) = BorderPanel.Position.South
        layout(leftButton) = BorderPanel.Position.West
        layout(rightButton) = BorderPanel.Position.East
      }
      layout(directionalPanel) = BorderPanel.Position.West
      border = Swing.LineBorder(Color.BLACK)
    }

    contents = new BorderPanel {
      layout(screenPanel) = BorderPanel.Position.Center
      layout(buttonPanel) = BorderPanel.Position.South
    }

  }
}
