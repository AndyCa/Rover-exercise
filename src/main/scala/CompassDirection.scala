package rover

trait CompassDirection {
  def update(rotation: Rotation): CompassDirection
  val string: String
}
object North extends CompassDirection {
  def update(rotation: Rotation): CompassDirection = {
    rotation match {
      case Left => West
      case Right => East
      case _ => this
    }
  }
  val string = "North"
}
object South extends CompassDirection {
  def update(rotation: Rotation): CompassDirection = {
    rotation match {
      case Left => East
      case Right => West
      case _ => this
    }
  }
  val string = "South"
}
object East extends CompassDirection {
  def update(rotation: Rotation): CompassDirection = {
    rotation match {
      case Left => North
      case Right => South
      case _ => this
    }
  }
  val string = "East"

}
object West extends CompassDirection {
  def update(rotation: Rotation): CompassDirection = {
    rotation match {
      case Left => South
      case Right => North
      case _ => this
    }
  }
  val string = "West"
}
