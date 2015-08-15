package app.panels.text

import app.PokemonApp

import scala.swing.{Label, FlowPanel}

/**
 * Created by alexchou on 8/15/15.
 */
class MessagePanel(m: String, beforeMessagePanel: TextPanel) extends TextPanel {
  var message: String = m
  val panel = new FlowPanel() {
    contents += new Label(message)
  }
  contents += panel

  override def select(): Unit = {
    PokemonApp.showNextMessage(beforeMessagePanel)
  }
}
