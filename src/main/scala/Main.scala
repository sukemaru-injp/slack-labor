import com.slack.api.bolt.App
import com.slack.api.bolt.socket_mode.SocketModeApp
import controller.HelloController
import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int
  def put(x: Int): Unit
  def print(): Unit
}
class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) = { buf += x }

  def print() = println(this.buf)
}

object Main {
  def main(args: Array[String]): Unit = {
    val test = new BasicIntQueue()
    test.put(1)
    test.put(2)
    test.put(3)

    test.print()

    println("Hello world!")

    val app = new App()
    app.command("/hello", HelloController.handler)

    new SocketModeApp(app).start()
  }
}
