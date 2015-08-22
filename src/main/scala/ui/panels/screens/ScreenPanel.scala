package ui.panels.screen

import java.awt.{Color, Dimension}

import ui.dimensions.ScreenDimension

import scala.swing.FlowPanel

/**
 * Created by alexchou on 8/12/15.
 */
abstract class ScreenPanel extends FlowPanel {
  focusable = true
  background = Color.BLACK
  preferredSize = new Dimension(ScreenDimension.WIDTH_X, ScreenDimension.HEIGHT_Y)
  maximumSize = new Dimension(ScreenDimension.WIDTH_X, ScreenDimension.HEIGHT_Y)

  def up(): Unit
  def down(): Unit
  def left(): Unit
  def right(): Unit
  def select(): Unit
}
