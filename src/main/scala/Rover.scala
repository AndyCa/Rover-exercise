package rover

case class Rover(
                  compassDirection: CompassDirection,
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
    val rover = this.copy(position = position.update(movement, compassDirection))
    println("rover moved to mars position: " + rover.position.string + " facing " + rover.compassDirection.string)
    rover
  }

  def rotate(rotation: Rotation): Rover = {
    val rover = this.copy(compassDirection = compassDirection.update(rotation))
    println("rover rotated at mars position: " + rover.position.string + " to face " + rover.compassDirection.string)
    rover
  }

}


