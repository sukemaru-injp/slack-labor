import utils.ArrayElement
import com.slack.api.bolt.App
import com.slack.api.bolt.socket_mode.SocketModeApp
import controller.HelloController

class Point(val x: Int, val y: Int)
trait Rectangular {
  def topLeft: Point;
  def bottomRight: Point;

  def left = topLeft.x
  def right = bottomRight.y
}

object Main {
  def main(args: Array[String]): Unit = {
    val el = new ArrayElement(Array("Hello", "World"))
    val el2 = el.beside(new ArrayElement(Array("Hello", "Scala")))

    el2.contents.foreach(println(_))

    println("Hello world!")

    val app = new App()
    app.command("/hello", HelloController.handler)

    new SocketModeApp(app).start()
  }
}
