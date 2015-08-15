package app.panels.text

import java.awt.Color

import scala.swing.GridPanel

/**
 * Created by alexchou on 8/14/15.
 */
class StyledGridPanel(rows: Int, cols: Int) extends GridPanel(rows: Int, cols: Int) {
  background = Color.WHITE
  xLayoutAlignment = 0.0
}
