package rover

trait Compass {
  def update(rotation: Rotation): Compass
}
object North extends Compass {
  def update(rotation: Rotation): Compass = {
    rotation match {
      case Left => West
      case Right => East
      case _ => this
    }
  }
}
object South extends Compass {
  def update(rotation: Rotation): Compass = {
    rotation match {
      case Left => East
      case Right => West
      case _ => this
    }
  }
}
object East extends Compass {
  def update(rotation: Rotation): Compass = {
    rotation match {
      case Left => North
      case Right => South
      case _ => this
    }
  }
}
object West extends Compass {
  def update(rotation: Rotation): Compass = {
    rotation match {
      case Left => South
      case Right => North
      case _ => this
    }
  }
}
