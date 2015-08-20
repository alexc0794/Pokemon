package ui.panels

import java.awt.{Dimension, Color}
import javax.swing.BorderFactory
import javax.swing.border.LineBorder

import gameplay.battles.Battle
import ui.PokemonApp
import ui.dimensions.MenuDimension
import ui.panels.menus.labels._
import user._

import scala.swing.{Label, GridPanel}

/**
 * Created by alexchou on 8/19/15.
 */
class Menu extends InteractivePanel {
  preferredSize = new Dimension(MenuDimension.WIDTH, MenuDimension.HEIGHT)
  maximumSize = new Dimension(MenuDimension.WIDTH, MenuDimension.HEIGHT)

  var index: Int = 0
  var battle: Option[Battle] = None
  var currMenu: GridPanel = getMenuPanel()
  contents += currMenu

  def up(): Unit = {
    if (index > 0) index -= 1
    incrementCurrMenu()
  }
  def down(): Unit = {
    if (index < currMenu.contents.size - 1) index += 1
    incrementCurrMenu()
  }
  def left(): Unit = {}
  def right(): Unit = {}
  def select(): Unit = {
    currMenu.contents(index) match {
      case ml: MenuLabel => ml.run
    }
  }
  def moveFocus(): Unit = {
    PokemonApp.menu.border = BorderFactory.createEmptyBorder()
    PokemonApp.text.border = LineBorder.createGrayLineBorder()
    PokemonApp.text.requestFocus()
  }


  /* MENU PANELS */
  def getMenuPanel(): GridPanel = {
    new GridPanel(8,1) {
      contents += new PokemonMenuLabel((index == 0))
      contents += new ItemMenuLabel((index == 1))
      contents += new MoneyMenuLabel((index == 2))
      contents += new SaveMenuLabel((index == 3))
      contents += new ExitMenuLabel((index == 4))
    }
  }
  def getPokemonMenuPanel(): GridPanel = {
    new GridPanel(7,1) {
      var i = 0
      User.lineup.lineup.foreach(p => {
        contents += new PokemonListLabel((index == i), p)
        i += 1
      })
      contents += new BackLabel(index == i, getMenuPanel())
    }
  }
  def getItemMenuPanel(): GridPanel = {
    new GridPanel(10,1) {
      var i = 0
      ItemBag.items.foreach( itemBag  => {
        contents += new ItemListLabel((index == i), itemBag._1, itemBag._2)
        i += 1
      })
      contents += new BackLabel((index == i), getMenuPanel())
    }
  }

  /* BATTLE PANELS */
  def getBattlePanel(): GridPanel = {
    new GridPanel(4, 1) {
      contents += new AttackBattleLabel((index == 0))
      contents += new ItemBattleLabel((index == 1))
      contents += new PokemonBattleLabel((index == 2))
      contents += new RunBattleLabel((index == 3))
    }
  }
  def getAttackBattlePanel(): GridPanel = {
    new GridPanel(5,1) {
      var i = 0
      User.currPokemon.attacks.foreach(a => {
        contents += new AttackListLabel((index == i), a)
        i += 1
      })
      contents += new BackLabel(index == i, getBattlePanel())
    }
  }
  def getItemBattlePanel(): GridPanel = {
    new GridPanel(10,1) {
      var i = 0
      ItemBag.items.foreach( itemBag  => {
        contents += new ItemListLabel((index == i), itemBag._1, itemBag._2)
        i += 1
      })
      contents += new BackLabel((index == i), getBattlePanel())
    }
  }
  def getPokemonBattlePanel(): GridPanel = {
    new GridPanel(7,1) {
      var i = 0
      User.lineup.lineup.foreach(p => {
        contents += new PokemonListLabel((index == i), p)
        i += 1
      })
      contents += new BackLabel(index == i, getBattlePanel())
    }
  }

  def run(): Unit = {

  }

  def incrementCurrMenu(): Unit = {
    currMenu.contents.foreach(c => c.foreground = Color.BLACK)
    currMenu.contents(index).foreground = Color.BLUE
    contents.clear()
    contents += currMenu
    PokemonApp.menu = this
    PokemonApp.reset(PokemonApp.menu)
  }

  def changeCurrMenu(gridPanel: GridPanel): Unit = {
    index = 0
    gridPanel.contents.foreach(x => x match {
      case ml: MenuLabel => ml.foreground = Color.BLACK
    })
    gridPanel.contents(0) match {
      case ml: MenuLabel => ml.foreground = Color.BLUE
    }
    currMenu = gridPanel
    contents.clear()
    contents += currMenu
    PokemonApp.menu = this
    PokemonApp.reset(PokemonApp.menu)
  }

  def engageBattle(b: Battle): Unit = {
    battle = Some(b)
    changeCurrMenu(getBattlePanel())
  }

  def endBattle(): Unit = {
    changeCurrMenu(getMenuPanel())
  }
}
