package app.panels.text

import java.awt.{Dimension, Color}

import app.panels.screen._
import app._
import gameplay.direction._
import map.characters.UserCharacter

import scala.swing.event.{Key, KeyPressed}
import scala.swing._

/**
 * Created by alexchou on 8/13/15.
 */
abstract class TextPanel extends FlowPanel {
  focusable = true
  background = Color.WHITE
  border = Swing.LineBorder(Color.BLACK)
  preferredSize = new Dimension(ScreenDimension.WIDTH_X, (ScreenDimension.HEIGHT_Y * .2).toInt)
  maximumSize = new Dimension(ScreenDimension.WIDTH_X, (ScreenDimension.HEIGHT_Y * .2).toInt)
  listenTo(keys)
  var processing: Boolean = false
  reactions += {
    case KeyPressed(_,Key.Up,_,_) => {
      if (!processing) {
        processing = true
        PokemonApp.currScreenPanel match {
          case battlePanel: BattlePanel => this.up
          case mapPanel: MapPanel => {
            UserCharacter.direction = new Up

            UserCharacter.initPixels()
            mapPanel.moveCharacter(0,-1)
          }
          case _ =>
        }
        processing = false
      }
    }
    case KeyPressed(_,Key.Down,_,_) => {
      if (!processing) {
        processing = true
        PokemonApp.currScreenPanel match {
          case battlePanel: BattlePanel => this.down
          case mapPanel: MapPanel => {
            UserCharacter.direction = new Down
            UserCharacter.initPixels()
            mapPanel.moveCharacter(0,1)
          }
          case _ =>
        }
        processing = false
      }
    }
    case KeyPressed(_,Key.Left,_,_) => {
      if (!processing) {
        processing = true
        PokemonApp.currScreenPanel match {
          case battlePanel: BattlePanel => this.left
          case mapPanel: MapPanel => {
            UserCharacter.direction = new Left
            UserCharacter.initPixels()
            mapPanel.moveCharacter(-1,0)
          }
          case _ =>
        }
        processing = false
      }
    }
    case KeyPressed(_,Key.Right,_,_) => {
      if (!processing) {
        processing = true
        PokemonApp.currScreenPanel match {
          case battlePanel: BattlePanel => this.right
          case mapPanel: MapPanel => {
            UserCharacter.direction = new Right
            UserCharacter.initPixels()
            mapPanel.moveCharacter(1,0)
          }
          case _ =>
        }
        processing = false
      }
    }
    case KeyPressed(_,Key.A,_,_) => {
      if (!processing) {
        processing = true
        PokemonApp.currScreenPanel match {
          case battlePanel: BattlePanel => this.select
          case mapPanel: MapPanel =>
          case _ =>
        }
        processing = false
      }
    }
    case KeyPressed(_,Key.Enter,_,_) => {
      if (!processing) {
        processing = true
        PokemonApp.currScreenPanel match {
          case battlePanel: BattlePanel => this.select
          case mapPanel: MapPanel =>
          case _ =>
        }
        processing = false
      }
    }
  }
  val panel: Panel

  def up(): Unit = {}
  def down(): Unit = {}
  def left(): Unit = {}
  def right(): Unit = {}
  def select(): Unit = {}

  override def paintComponent(g: Graphics2D): Unit = {
    super.paintComponent(g)
  }
}
