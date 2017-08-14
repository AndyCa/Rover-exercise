package rover

trait Planet {
  val length: Int
}

case class Mars(length: Int) extends Planet{

}
