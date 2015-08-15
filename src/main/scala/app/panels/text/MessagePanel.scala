package app.panels.text

import scala.swing.{Label, FlowPanel}

/**
 * Created by alexchou on 8/15/15.
 */
class MessagePanel(m: String) extends TextPanel {
  val message: String = m
  val panel = new FlowPanel() {
    contents += new Label(message)
  }
  contents += panel

  override def select(): Unit = {

  }
}
