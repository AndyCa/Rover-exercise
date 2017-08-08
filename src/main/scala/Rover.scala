package rover

case class Position(x: Int, y: Int) {
  def update(movement: Movement, compass: Compass): Position = {
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
}

case class Rover(
  compass: Compass,
  position: Position
) extends Vehicle {

  def userInput(consoleInput: String): UserInput = consoleInput match {
    case "f" => Forward
    case "b" => Backward
    case "l" => Left
    case "r" => Right
    case "e" => ExitApp
    case _ => NoDirection
  }

  def move(movement: Movement): Rover = {
    val rover = this.copy(position = position.update(movement, compass))
    println("rover moved to mars position: ", rover.position, " facing ", rover.compass)
    rover
  }

  def rotate(rotation: Rotation): Rover = {
    val rover = this.copy(compass = compass.update(rotation))
    println("rover rotated at mars position: ", rover.position, " to face ", rover.compass)
    rover
  }

}


