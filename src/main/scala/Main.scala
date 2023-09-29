import com.slack.api.bolt.App
import com.slack.api.bolt.socket_mode.SocketModeApp
import controller.HelloController
import controller.DiaryController
import utils.BasicIntQueue
import routes.Command
import utils.slack.CallbackIds

object Main {
  def main(args: Array[String]): Unit = {
    val test = new BasicIntQueue()

    test.put(1)
    test.put(2)
    test.put(3)

    test.print()

    println("Hello world!")

    val app = new App()

    app.command(Command.hello, HelloController.handler)
    app.command(Command.diary, DiaryController.handler)

    app.viewSubmission(CallbackIds.laborDiary, DiaryController.submissionHandler)

    new SocketModeApp(app).start()
  }
}
