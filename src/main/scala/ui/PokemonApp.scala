package ui

import java.awt.Color
import javax.swing.BorderFactory

import gameplay.battles.Battle
import panels._
import ui.panels.Menu
import scala.swing._

/**
 * Created by alexchou on 8/18/15.
 */
object PokemonApp extends SimpleSwingApplication {

  var menu = new Menu() { visible = false }
  var screen = new Screen()
  var text = new Text()

  var top: Frame = {
    new MainFrame {
      resizable = false
      title = "Pokemon"
      peer.setLocationRelativeTo(null)
      contents = new BorderPanel {
        layout(screen) = BorderPanel.Position.Center
        layout(menu) = BorderPanel.Position.East
        layout(text) = BorderPanel.Position.South
      }
    }
  }
  screen.requestFocus()


  def engageBattle(battle: Battle): Unit = {
    Thread.sleep(1000)
    text.addMessage(battle.entranceMessage)
    text.requestFocus()
    screen.engageBattle(battle)
    menu.engageBattle(battle)
    reset(text)
  }

  def endBattle(): Unit = {
    screen.endBattle()
    text.empty()
    menu.endBattle()
    reset(screen)
  }

  def reset(panel: InteractivePanel): Unit = {
    screen.border = BorderFactory.createEmptyBorder()
    menu.border = BorderFactory.createEmptyBorder()
    text.border = BorderFactory.createEmptyBorder()
    top.contents = new BorderPanel {
      layout(screen) = BorderPanel.Position.Center
      layout(menu) = BorderPanel.Position.East
      layout(text) = BorderPanel.Position.South
    }
    panel.requestFocus()
  }

}
