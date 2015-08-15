package app.panels.text

import java.awt.Color

import app.PokemonApp
import pokedex.pokemon.Pokemon

import scala.swing.Label

/**
 * Created by alexchou on 8/14/15.
 */
class BattleOptionPanel(myPokemon: Pokemon, enemyPokemon: Pokemon) extends TextPanel {
  var index: Int = 0
  val attack = new Label("Attack") { foreground = Color.BLUE }
  val pokemonbag = new Label("Pokemon")
  val item = new Label("Item")
  val run = new Label("Run")
  val options = Array(attack, pokemonbag, item, run)
  val panel = new StyledGridPanel(4,1) {
    options.foreach(o => contents += o)
  }
  contents += panel

  override def up(): Unit = {
    if (index - 1 >= 0) {
      options.foreach(o => o.foreground = Color.BLACK)
      index -= 1
      options(index).foreground = Color.BLUE
    }
  }
  override def down(): Unit = {
    if (index + 1 < options.size) {
      options.foreach(o => o.foreground = Color.BLACK)
      index += 1
      options(index).foreground = Color.BLUE
    }
  }
  override def left(): Unit = {

  }
  override def right(): Unit = {

  }
  override def select(): Unit = {
    if (options(index).equals(attack)) {
      PokemonApp.currTextPanel = new AttackPanel(myPokemon, enemyPokemon)
      PokemonApp.updateCurrentPanels()
      PokemonApp.currTextPanel.requestFocus()
    } else if (options(index).equals(pokemonbag)) {

    } else if (options(index).equals(item)) {

    } else if (options(index).equals(run)) {
      PokemonApp.endBattle()
    }
  }

}
