package controller
import com.slack.api.bolt.handler.builtin.SlashCommandHandler
import com.slack.api.bolt.handler.builtin.ViewSubmissionHandler
import utils.slack.{DiaryModal, SlackModalHelper}
import com.slack.api.bolt.request.builtin.ViewSubmissionRequest
import models.diary.DiaryFactory
object DiaryController extends BotController {
  private val diaryFactory = new DiaryFactory()
  def handler: SlashCommandHandler = (req, ctx) => {
    val ctxClient = ctx.client()
    val triggerId = ctx.getTriggerId
    val payload = req.getPayload

    val modal = new DiaryModal(triggerId).build()

    val result =
      ctxClient.viewsOpen(new SlackModalHelper(triggerId, modal).open);

    ctx.ack("success :wave:")
  }

  def submissionHandler: ViewSubmissionHandler = (req, ctx) => {
    diaryFactory.create(req)
    ctx.ack()
  }
}
