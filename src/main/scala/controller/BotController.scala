package controller

import com.slack.api.bolt.handler.builtin.SlashCommandHandler

abstract class BotController {
  def handler: SlashCommandHandler
}
