package ui.panels.menus.labels

import java.awt.Color

import gameplay.items.Item
import pokedex.attacks.Attack
import pokedex.pokemon.Pokemon
import ui.PokemonApp

import scala.swing.{GridPanel, Label}

/**
 * Created by alexchou on 8/19/15.
 */
abstract class MenuLabel(isHovered: Boolean) extends Label {
  if (isHovered) foreground = Color.BLUE
  def run: Unit

}

// GENERAL
case class BackLabel(isHovered: Boolean, gridPanel: GridPanel) extends MenuLabel(isHovered: Boolean) {
  text = "Back"
  def run(): Unit = PokemonApp.menu.changeCurrMenu(gridPanel)
}

// MENU
case class PokemonMenuLabel(isHovered: Boolean) extends MenuLabel(isHovered: Boolean) {
  text = "Pokemon"
  def run: Unit = PokemonApp.menu.changeCurrMenu(PokemonApp.menu.getPokemonMenuPanel())
}
case class ItemMenuLabel(isHovered: Boolean) extends MenuLabel(isHovered: Boolean) {
  text = "Item Bag"
  def run: Unit = PokemonApp.menu.changeCurrMenu(PokemonApp.menu.getItemMenuPanel())
}
case class MoneyMenuLabel(isHovered: Boolean) extends MenuLabel(isHovered: Boolean) {
  text = "Money"
  def run: Unit = {}
}
case class SaveMenuLabel(isHovered: Boolean) extends MenuLabel(isHovered: Boolean) {
  text = "Save"
  def run: Unit = {}
}
case class ExitMenuLabel(isHovered: Boolean) extends MenuLabel(isHovered: Boolean) {
  text = "Exit"
  def run: Unit = {}
}


// BATTLE
case class AttackBattleLabel(isHovered: Boolean) extends MenuLabel(isHovered: Boolean) {
  text = "Attack"
  def run: Unit = PokemonApp.menu.changeCurrMenu(PokemonApp.menu.getAttackBattlePanel())
}
case class ItemBattleLabel(isHovered: Boolean) extends MenuLabel(isHovered: Boolean) {
  text = "Item"
  def run: Unit = PokemonApp.menu.changeCurrMenu(PokemonApp.menu.getItemBattlePanel())
}
case class PokemonBattleLabel(isHovered: Boolean) extends MenuLabel(isHovered: Boolean) {
  text = "Pokemon"
  def run: Unit = PokemonApp.menu.changeCurrMenu(PokemonApp.menu.getPokemonBattlePanel())
}
case class RunBattleLabel(isHovered: Boolean) extends MenuLabel(isHovered: Boolean) {
  text = "Run"
  def run: Unit = PokemonApp.endBattle()
}


// ATTACK LIST
case class AttackListLabel(isHovered: Boolean, attack: Attack) extends MenuLabel(isHovered: Boolean) {
  text = attack.name
  def run(): Unit = {
    PokemonApp.menu.battle.get.attackEnemy(attack)
  }
}
// POKEMON LIST
case class PokemonListLabel(isHovered: Boolean, pokemon: Pokemon) extends MenuLabel(isHovered: Boolean) {
  text = pokemon.name + "  HP:" + pokemon.health
  def run(): Unit = {
    PokemonApp.menu.battle match {
      case Some(battle) => if (battle.switchPokemon(pokemon)) battle.getAttacked()
      case None =>
    }
  }
}
// ITEM LIST
case class ItemListLabel(isHovered: Boolean, item: Item, count: Int) extends MenuLabel(isHovered: Boolean) {
  text = item.name + " x" + count
  def run: Unit = {
    item.doEffect()
  }
}