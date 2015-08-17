package app.panels.text

import java.awt.Color

import scala.swing.FlowPanel

/**
 * Created by alexchou on 8/14/15.
 */
class BlankTextPanel extends TextPanel {
  val panel = new FlowPanel {
    background = Color.WHITE
  }
  contents += panel
}
