package rover

trait UserInput
trait InvalidInput extends UserInput
trait Movement
trait Rotation

object ExitApp extends UserInput
object Forward extends Movement with UserInput
object Backward extends Movement with UserInput
object Left extends Rotation with UserInput
object Right extends Rotation with UserInput
object NoDirection extends InvalidInput