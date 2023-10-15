package controller

import com.slack.api.bolt.handler.builtin.SlashCommandHandler

object HelloController extends BotController {
  def handler: SlashCommandHandler = (req, ctx) => {
    val payload = req.getPayload

    println("fireeee", payload)

    ctx.ack("Hello,SlackLabor:wave:")
  }
}
