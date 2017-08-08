package rover

trait Vehicle {
  def userInput(consoleInput: String): UserInput

  def move(movement: Movement): Vehicle

  def rotate(rotation: Rotation): Vehicle
}