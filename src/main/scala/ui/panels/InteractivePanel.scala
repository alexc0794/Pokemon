package ui.panels

import scala.swing.FlowPanel
import scala.swing.event.{Key, KeyPressed}

/**
 * Created by alexchou on 8/20/15.
 */
abstract class InteractivePanel extends FlowPanel {
  var processing: Boolean = false
  listenTo(keys)
  reactions += {
    case KeyPressed(_, Key.Up, _, _) => {
      if (!processing) {
        processing = true
        up()
        processing = false
      }
    }
    case KeyPressed(_, Key.Down, _, _) => {
      if (!processing) {
        processing = true
        down()
        processing = false
      }
    }
    case KeyPressed(_, Key.Left, _, _) => {
      if (!processing) {
        processing = true
        left()
        processing = false
      }
    }
    case KeyPressed(_, Key.Right, _, _) => {
      if (!processing) {
        processing = true
        right()
        processing = false
      }
    }
    case KeyPressed(_, Key.A, _, _) => {
      if (!processing) {
        processing = true
        select()
        processing = false
      }
    }
    case KeyPressed(_, Key.Enter, _, _) => {
      if (!processing) {
        processing = true
        select()
        processing = false
      }
    }
    case KeyPressed(_, Key.Q, _, _) => {
      if (!processing) {
        processing = true
        moveFocus()
        processing = false
      }
    }
  }

  def up(): Unit
  def down(): Unit
  def left(): Unit
  def right(): Unit
  def select(): Unit
  def moveFocus(): Unit
}
