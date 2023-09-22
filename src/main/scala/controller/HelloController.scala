package controller

import com.slack.api.bolt.handler.builtin.SlashCommandHandler

object HelloController extends BotController {
  def handler: SlashCommandHandler = (req, ctx) => {
    ctx.ack("Ok")
  }
}
