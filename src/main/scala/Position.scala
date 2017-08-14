package rover

case class Position(x: Int, y: Int, planet: Planet) {

  def update(movement: Movement, compass: CompassDirection): Position = {
    compass match {
      case North => this.copy(y = this.adjust(y, movement, 1))
      case South => this.copy(y = this.adjust(y, movement, -1))
      case East => this.copy(x = this.adjust(x, movement, 1))
      case West => this.copy(x = this.adjust(x, movement, -1))
      case _ => this
    }
  }

  def adjust(int: Int, movement: Movement, value: Int): Int = {
    movement match {
      case Forward => {
        val newInt = int + value
        this.checkWrap(newInt)
      }
      case Backward => {
        val newInt = int - value
        this.checkWrap(newInt)
      }
      case _ => int
    }
  }

  def checkWrap(i: Int): Int = {
    i match {
      case i if i > this.planet.length => 0
      case i if i < 0 => this.planet.length
      case _ => i
    }
  }

  def string = "x: " + this.x.toString  + ", y: " + this.y.toString

}
