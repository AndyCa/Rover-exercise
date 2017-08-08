package rover

import scala.io.StdIn._

object RoverApp extends App {
  val rover = Rover(
    compass = North,
    position = Position(0, 0)
  )

  def loop(rover: Rover): Rover = {
    val userInput = readLine()
    val roverDirection = rover.userInput(userInput)
    roverDirection match {
      case movement: Movement => loop(rover.move(movement))
      case rotation: Rotation => loop(rover.rotate(rotation))
      case ExitApp => {
        println("exiting app")
        rover
      }
      case _  => {
        println("please type a valid input to move the rover.")
        loop(rover)
      }
    }
  }

  loop(rover)

}
