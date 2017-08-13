package rover

import scala.io.StdIn._

object Main {
  val rover = Rover(
    compassDirection = North,
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
        println(validInputsMessage + intro)
        loop(rover)
      }
    }
  }

  val intro: String =
    """
      |Controls for the Mars rover:
      |f: move the rover 1 unit forward
      |b: move the rover 1 unit backward
      |l: rotate the rover 90 degrees left
      |r: rotate the rover 90 degrees right
      |e: exit the application
    """.stripMargin

  val validInputsMessage: String = "Please type a valid input to move the rover."

  def main(args: Array[String]): Unit = {
    println(intro)
   loop(rover)
  }

}
