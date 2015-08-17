package app

import java.awt.BorderLayout

import app.panels.screen._
import app.panels.text._
import gameplay.battles.Battle
import swing._
import map.maps._


/**
 * Created by alexchou on 8/2/15.
 */
object PokemonApp extends SimpleSwingApplication {
  val borderLayout = new BorderLayout()
  borderLayout.setVgap(0)
  borderLayout.setHgap(0)

  var mapPanel = new MapPanel(BrownMap)

  /* Set current panels */
  var currScreenPanel: ScreenPanel = mapPanel
  var currTextPanel: TextPanel = new BlankTextPanel

  var top: Frame = {
    new MainFrame {
      resizable = false
      title = "Pokemon"
      peer.setLocationRelativeTo(null)
      contents = new BorderPanel {
        layout(currScreenPanel) = BorderPanel.Position.Center
        layout(currTextPanel) = BorderPanel.Position.South
      }
    }
  }
  currTextPanel.requestFocus()

  def engageBattle(battle: Battle): Unit = {
    currScreenPanel = new BattlePanel(battle)
    currTextPanel = new BattleOptionPanel(battle)
    updateCurrentPanels()
  }

  def endBattle(): Unit = {
    currScreenPanel = mapPanel
    currTextPanel = new BlankTextPanel
    updateCurrentPanels()
  }

  def isBattleMode(): Boolean = currScreenPanel match {
    case b: BattlePanel => true
    case m: MapPanel => false
    case _ => throw new Exception("Neither battle nor map panel")
  }

  def updateCurrentPanels(): Unit = {
    top.contents = new BorderPanel {
      layout(currScreenPanel) = BorderPanel.Position.Center
      layout(currTextPanel) = BorderPanel.Position.South
    }
    currTextPanel.requestFocus()
  }

  var messages: List[String] = List[String]()

  def showNextMessage(beforeMessagePanel: TextPanel): Unit = {
    messages match {
      case hd::tl => {
        currTextPanel = new MessagePanel(hd, beforeMessagePanel)
        messages = tl
        updateCurrentPanels()
        currTextPanel.requestFocus()
      }
      case _ => {
        currTextPanel = beforeMessagePanel
        if (isBattleOver()) {
          endBattle()
          updateCurrentPanels()
        } else {
          updateCurrentPanels()
        }
      }
    }
  }

  def isBattleOver(): Boolean = currScreenPanel match {
    case battlePanel: BattlePanel => (battlePanel.battle.enemyLineup.getFirstPokemon().isEmpty)
    case _ => false
  }

}
