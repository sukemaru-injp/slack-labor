package controller

import com.slack.api.bolt.handler.builtin.SlashCommandHandler

object HelloController extends BotController {
  def handler: SlashCommandHandler = (req, ctx) => {
    val ctxClient = ctx.client()
    val triggerId = ctx.getTriggerId

    println(triggerId)
    ctx.ack(":wave: pong")
  }
}
