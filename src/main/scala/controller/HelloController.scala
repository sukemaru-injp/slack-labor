package controller

import com.slack.api.RequestConfigurator
import com.slack.api.bolt.handler.builtin.SlashCommandHandler

import utils.LaborModal
import utils.SlackModalHelper
object HelloController extends BotController {
  def handler: SlashCommandHandler = (req, ctx) => {
    val ctxClient = ctx.client()
    val triggerId = ctx.getTriggerId
    val payload = req.getPayload

    val modal = new LaborModal(triggerId).build()

    val result =
      ctx.client().viewsOpen(new SlackModalHelper(triggerId, modal).open);
    if (result.isOk) ctx.ack(":wave:やったぜ")
    println("fireeee", payload)

    ctx.ack(":wave: pong")
  }
}
