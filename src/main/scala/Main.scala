import com.slack.api.bolt.App
import com.slack.api.bolt.socket_mode.SocketModeApp
import controller.HelloController
import utils.BasicIntQueue

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
