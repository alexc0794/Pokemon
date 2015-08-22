package user

import gameplay.items.Item
import gameplay.items.pokeballs._
import gameplay.items.potions._

/**
 * Created by alexchou on 8/20/15.
 */
class ItemBag {
  var items: Map[Item, Int] = Map[Item, Int]()

  init()
  def init(): Unit = {
    addItem(new NormalBall)
    addItem(new NormalPotion)
  }

  def addItem(item: Item): Unit = {
    items.get(item) match {
      case None => items += (item -> 1)
      case Some(c) => items += (item -> (c + 1))
    }
  }

  def useItem(item: Item): Unit = {
    items.get(item) match {
      case None =>
      case Some(c) => {
        item.doEffect()
        if (c > 1) items += (item -> (c - 1))
        else items -= item
      }
    }
  }

  def dropItem(item: Item): Unit = {
    items.get(item) match {
      case None =>
      case Some(c) => {
        if (c > 1) items += (item -> (c - 1))
        else items -= item
      }
    }
  }

}
