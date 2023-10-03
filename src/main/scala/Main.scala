import com.slack.api.bolt.App
import com.slack.api.bolt.socket_mode.SocketModeApp
import controller.HelloController
import controller.DiaryController
import routes.Command
import utils.slack.CallbackIds

object Main {
  def main(args: Array[String]): Unit = {
    println("App Start")

    val app = new App()

    app.command(Command.hello, HelloController.handler)
    app.command(Command.diary, DiaryController.handler)

    app.viewSubmission(CallbackIds.laborDiary, DiaryController.submissionHandler)

    new SocketModeApp(app).start()
  }
}
