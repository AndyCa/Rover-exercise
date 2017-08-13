package test

import org.scalatest.FlatSpec
import rover._

class RoverSpec extends FlatSpec{
  val rover = Rover(
    compassDirection = North,
    position = Position(0, 0)
  )

  "rover.getDirection" should "return Forward if the user input is f" in {
      val forwardDirection = rover.userInput("f")
      assert(forwardDirection === Forward)
  }

  "rover.getDirection" should "return Backwards if the user input is d" in {
    val backwardDirection = rover.userInput("b")
    assert(backwardDirection === Backward)
  }

  "rover.getDirection" should "return Left if the user input is l" in {
    val turn = rover.userInput("l")
    assert(turn === Left)
  }

  "rover.getDirection" should "return Right if the user input is r" in {
    val rightTurn= rover.userInput("r")
    assert(rightTurn === Right)
  }

  "rover.getDirection" should "exit if the user input is e" in {
    val exitApp = rover.userInput("e")
    assert(exitApp === ExitApp)
  }

  "rover.getDirection" should "return InvalidDirection if the user input is not valid" in {
    val invalidDirection = rover.userInput("a")
    assert(invalidDirection === NoDirection)
  }

  val northFacingCompass: CompassDirection = North
  val southFacingCompass: CompassDirection = South
  val eastFacingCompass: CompassDirection = East
  val westFacingCompass: CompassDirection = West

  "updating a north facing compass after a left turn" should "return West" in {
    val turn = northFacingCompass.update(Left)
    assert(turn === West)
  }

  "updating a north facing compass after a right turn" should "return East" in {
    val turn = northFacingCompass.update(Right)
    assert(turn === East)
  }

  "updating a south facing compass after a left turn" should "return East" in {
    val turn = southFacingCompass.update(Left)
    assert(turn === East)
  }

  "updating a south facing compass after a left turn" should "return West" in {
    val turn = southFacingCompass.update(Right)
    assert(turn === West)
  }

  "updating a east facing compass after a left turn" should "return North" in {
    val turn = eastFacingCompass.update(Left)
    assert(turn === North)
  }

  "updating a east facing compass after a right turn" should "return South" in {
    val turn = eastFacingCompass.update(Right)
    assert(turn === South)
  }

  "updating a west facing compass after a left turn" should "return South" in {
    val turn = westFacingCompass.update(Left)
    assert(turn === South)
  }

  "updating a west facing compass after a right turn" should "return North" in {
    val turn = westFacingCompass.update(Right)
    assert(turn === North)
  }

  "moving the rover forward when it is facing north" should "update the rover's y location plus 1" in {
    val oldRover = rover
    val newRover = rover.move(Forward)
    assert(newRover.position.y === oldRover.position.y + 1)
    assert(newRover.position.x === oldRover.position.x)
  }

  "moving the rover backward when it is facing north" should "update the rover's y location minus 1" in {
    val oldRover = rover
    val newRover = rover.move(Backward)
    assert(newRover.position.y === oldRover.position.y - 1)
    assert(newRover.position.x === oldRover.position.x)
  }

  "moving the rover forward when it is facing south" should "update the rover's y location minus 1" in {
    val rover = Rover(position = Position(0,0), compassDirection = South)
    val oldRover = rover
    val newRover = rover.move(Forward)
    assert(newRover.position.y === oldRover.position.y - 1)
    assert(newRover.position.x === oldRover.position.x)
  }

  "moving the rover backward when it is facing south" should "update the rover's y location plus 1" in {
    val rover = Rover(position = Position(0,0), compassDirection = South)
    val oldRover = rover
    val newRover = rover.move(Backward)
    assert(newRover.position.y === oldRover.position.y + 1)
    assert(newRover.position.x === oldRover.position.x)
  }

  "moving the rover forward when it is facing east" should "update the rover's x location plus 1" in {
    val rover = Rover(position = Position(0,0), compassDirection = East)
    val oldRover = rover
    val newRover = rover.move(Forward)
    assert(newRover.position.y === oldRover.position.y)
    assert(newRover.position.x === oldRover.position.x + 1)
  }

  "moving the rover backward when it is facing east" should "update the rover's y location minus 1" in {
    val rover = Rover(position = Position(0,0), compassDirection = East)
    val oldRover = rover
    val newRover = rover.move(Backward)
    assert(newRover.position.y === oldRover.position.y)
    assert(newRover.position.x === oldRover.position.x - 1)
  }

  "moving the rover forward when it is facing west" should "update the rover's x location minus 1" in {
    val rover = Rover(position = Position(0,0), compassDirection = West)
    val oldRover = rover
    val newRover = rover.move(Forward)
    assert(newRover.position.y === oldRover.position.y)
    assert(newRover.position.x === oldRover.position.x - 1)
  }

  "moving the rover backward when it is facing west" should "update the rover's y location plus 1" in {
    val rover = Rover(position = Position(0,0), compassDirection = West)
    val oldRover = rover
    val newRover = rover.move(Backward)
    assert(newRover.position.y === oldRover.position.y)
    assert(newRover.position.x === oldRover.position.x + 1)
  }

  "turning the rover left when it is facing north" should "turns the rover to face West" in {
    val rover = Rover(position = Position(0,0), compassDirection = North)
    val oldRover = rover
    val newRover = rover.rotate(Left)
    assert(newRover.compassDirection === West)
  }

  "turning the rover right when it is facing north" should "turns the rover to face East" in {
    val rover = Rover(position = Position(0,0), compassDirection = North)
    val oldRover = rover
    val newRover = rover.rotate(Right)
    assert(newRover.compassDirection === East)
  }

  "turning the rover left when it is facing south" should "turns the rover to face East" in {
    val rover = Rover(position = Position(0,0), compassDirection = South)
    val oldRover = rover
    val newRover = rover.rotate(Left)
    assert(newRover.compassDirection === East)
  }

  "turning the rover right when it is facing north" should "turns the rover to face West" in {
    val rover = Rover(position = Position(0,0), compassDirection = South)
    val oldRover = rover
    val newRover = rover.rotate(Right)
    assert(newRover.compassDirection === West)
  }

  "turning the rover left when it is facing east" should "turns the rover to face North" in {
    val rover = Rover(position = Position(0,0), compassDirection = East)
    val oldRover = rover
    val newRover = rover.rotate(Left)
    assert(newRover.compassDirection === North)
  }

  "turning the rover right when it is facing east" should "turns the rover to face South" in {
    val rover = Rover(position = Position(0,0), compassDirection = East)
    val oldRover = rover
    val newRover = rover.rotate(Right)
    assert(newRover.compassDirection === South)
  }

  "turning the rover left when it is facing west" should "turns the rover to face South" in {
    val rover = Rover(position = Position(0,0), compassDirection = West)
    val oldRover = rover
    val newRover = rover.rotate(Left)
    assert(newRover.compassDirection === South)
  }

  "turning the rover right when it is facing west" should "turns the rover to face South" in {
    val rover = Rover(position = Position(0,0), compassDirection = West)
    val oldRover = rover
    val newRover = rover.rotate(Right)
    assert(newRover.compassDirection === North)
  }

}
