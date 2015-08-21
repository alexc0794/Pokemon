package ui.panels

import java.awt.{Dimension, Color}
import javax.swing.BorderFactory
import javax.swing.border.LineBorder

import ui.PokemonApp
import ui.dimensions.TextDimension
import user.User

import scala.swing.Label

/**
 * Created by alexchou on 8/19/15.
 */
class Text extends InteractivePanel {
  preferredSize = new Dimension(TextDimension.WIDTH, TextDimension.HEIGHT)
  maximumSize = new Dimension(TextDimension.WIDTH, TextDimension.HEIGHT)
  background = Color.WHITE

  var messageList: List[String] = List[String]()


  def up(): Unit = {}
  def down(): Unit = {}
  def left(): Unit = {}
  def right(): Unit = {}
  def select(): Unit = showNextMessage()
  def moveFocus(): Unit = {
    if (!hasMessage()) {
      PokemonApp.text.border = BorderFactory.createEmptyBorder()
      PokemonApp.screen.requestFocus()
    }
  }

  def addMessages(m: List[String]): Unit = {
    messageList = messageList ::: m
    showNextMessage()
  }

  def addMessage(m: String): Unit = {
    messageList = messageList :+ m
    showNextMessage()
  }

  def showNextMessage(): Unit = {
    contents.clear()
    if (!messageList.isEmpty) {
      val message = messageList.head
      contents += new Label(message)
      messageList = messageList.tail

      if (message.equals("WONBATTLE")) {
        PokemonApp.endBattle()
      } else if (message.equals("BLACKINGOUT")) {
        User.blackout()
      } else {
        PokemonApp.reset(PokemonApp.text)
      }

    } else {
      PokemonApp.reset(PokemonApp.menu)
    }
  }

  def hasMessage(): Boolean = {
    !messageList.isEmpty
  }

  def empty(): Unit = {
    contents.clear()
    messageList = List[String]()
  }
}
