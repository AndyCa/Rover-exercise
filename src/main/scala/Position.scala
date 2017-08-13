package rover

case class Position(x: Int, y: Int) {
  def update(movement: Movement, compass: CompassDirection): Position = {
    compass match {
      case North => this.copy(y = adjust(y, movement, 1))
      case South => this.copy(y = adjust(y, movement, -1))
      case East => this.copy(x = adjust(x, movement, 1))
      case West => this.copy(x = adjust(x, movement, -1))
      case _ => this
    }

  }

  def adjust(int: Int, movement: Movement, value: Int): Int = {
    movement match {
      case Forward => int + value
      case Backward => int - value
      case _ => int
    }
  }

  def string = "x: " + this.x.toString  + ", y: " + this.y.toString
}