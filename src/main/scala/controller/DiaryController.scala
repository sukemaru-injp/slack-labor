package controller
import com.slack.api.bolt.handler.builtin.SlashCommandHandler


object DiaryController extends BotController {
  def handler: SlashCommandHandler = (req, ctx) => {
    ctx.ack("success :wave:")
  }
}
