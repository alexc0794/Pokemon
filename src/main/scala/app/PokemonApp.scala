package app

import java.awt.BorderLayout

import app.panels.screen._
import app.panels.text._
import pokedex.pokemon.Pokemon
import user.User

import scala.collection.mutable.Stack
import swing._
import map.maps._


/**
 * Created by alexchou on 8/2/15.
 */
object PokemonApp extends SimpleSwingApplication {
  val borderLayout = new BorderLayout()
  borderLayout.setVgap(0)
  borderLayout.setHgap(0)

  var mapPanel = new MapPanel(TestMap)

  /* Set current panels */
  var currScreenPanel: ScreenPanel = mapPanel
  var currTextPanel: TextPanel = new BlankTextPanel

  var messageStack: Stack[MessagePanel] = Stack[MessagePanel]()


  var top: Frame = {
    new MainFrame {
      title = "Pokemon"
      peer.setLocationRelativeTo(null)
      contents = new BorderPanel {
        layout(currScreenPanel) = BorderPanel.Position.Center
        layout(currTextPanel) = BorderPanel.Position.South
      }
    }
  }

  def engageBattle(myPokemon: Pokemon, enemyPokemon: Pokemon): Unit = {
    currScreenPanel = new BattlePanel(enemyPokemon)
    currTextPanel = new BattleOptionPanel(myPokemon, enemyPokemon)
    updateCurrentPanels()
    currTextPanel.requestFocus()
  }

  def endBattle(): Unit = {
    currScreenPanel = mapPanel
    currTextPanel = new BlankTextPanel
    updateCurrentPanels()
    currScreenPanel.requestFocus()
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
  }

}
