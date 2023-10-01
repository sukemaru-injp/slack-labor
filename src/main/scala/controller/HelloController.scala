package controller

import com.slack.api.RequestConfigurator
import com.slack.api.bolt.handler.builtin.SlashCommandHandler

import utils.slack.{DiaryModal, SlackModalHelper}

object HelloController extends BotController {
  def handler: SlashCommandHandler = (req, ctx) => {
    val payload = req.getPayload

    println("fireeee", payload)

    ctx.ack("Hello,SlackLabor:wave:")
  }
}
