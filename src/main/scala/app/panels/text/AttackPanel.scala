package app.panels.text

import java.awt.Color

import app.PokemonApp
import app.panels.screen.BattlePanel
import gameplay.fighting.FightDynamics
import pokedex.pokemon.Pokemon

import scala.swing.Label

/**
 * Created by alexchou on 8/14/15.
 */
class AttackPanel(myPokemon: Pokemon, enemyPokemon: Pokemon) extends TextPanel {
  var index: Int = 0
  val back = new Label("Back")
  var options = Array[Label]()
  val panel = new StyledGridPanel(5,1) {
    var c = 0
    myPokemon.attacks.foreach(attack => {
      val label = if (c == 0) new Label(attack.name) { foreground = Color.BLUE } else new Label(attack.name)
      contents += label
      options = options :+ label
      c += 1
    })
    contents += back
    options = options :+ back
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
    def goBack(): Unit = {
      PokemonApp.currTextPanel = new BattleOptionPanel(myPokemon, enemyPokemon)
      PokemonApp.updateCurrentPanels()
      PokemonApp.currTextPanel.requestFocus()
    }
    if (options(index).equals(back)) {
      goBack()
    } else {
      PokemonApp.currScreenPanel match {
        case battlePanel: BattlePanel => {
          enemyPokemon.health = FightDynamics.damageHealth(myPokemon, enemyPokemon, myPokemon.attacks(index))
          if (enemyPokemon.health <= 0) {
            println(enemyPokemon.name + " has fainted")
            PokemonApp.endBattle()
          } else {
            println(enemyPokemon)
            goBack()
          }
        }
      }
    }
  }
}
