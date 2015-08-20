package ui.panels

import java.awt.Dimension
import javax.swing.BorderFactory
import javax.swing.border.{LineBorder, EmptyBorder}

import gameplay.battles.Battle
import map.maps._
import ui.PokemonApp
import ui.dimensions.ScreenDimension
import ui.panels.screen._


/**
 * Created by alexchou on 8/19/15.
 */
class Screen extends InteractivePanel {
  preferredSize = new Dimension(ScreenDimension.WIDTH_X, ScreenDimension.HEIGHT_Y)
  maximumSize = new Dimension(ScreenDimension.WIDTH_X, ScreenDimension.HEIGHT_Y)

  var currMap: MapPanel = new MapPanel(BrownMap)
  var currScreen: ScreenPanel = currMap

  reset()

  def up(): Unit = currScreen.up()
  def down(): Unit = currScreen.down()
  def left(): Unit = currScreen.left()
  def right(): Unit = currScreen.right()
  def select(): Unit = currScreen.select()
  def moveFocus(): Unit = {
    PokemonApp.screen.border = BorderFactory.createEmptyBorder()
    PokemonApp.menu.border = LineBorder.createGrayLineBorder()
    PokemonApp.menu.requestFocus()
  }

  def engageBattle(battle: Battle): Unit = {
    currScreen = new BattlePanel(battle)
    reset()
  }

  def endBattle(): Unit = {
    currScreen = currMap
    reset()
  }

  def changeMap(map: GameMap): Unit = {
    currMap = new MapPanel(map)
    currScreen = currMap
    reset()
  }

  def reset(): Unit = {
    contents.clear()
    contents += currScreen
  }
}
