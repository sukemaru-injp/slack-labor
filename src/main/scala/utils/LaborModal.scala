package utils

import com.slack.api.model.view.View
import com.slack.api.model.block.Blocks._
import com.slack.api.model.block.composition.BlockCompositions._
import com.slack.api.model.block.element.BlockElements._
import com.slack.api.model.view.Views._

abstract class SlackModal {
  val triggerId: String
}
class LaborModal(val triggerId: String) extends SlackModal {
  def build(): View = {
    view(
      _.callbackId("labor-diary")
        .`type`("modal")
        .notifyOnClose(true)
        .title(viewTitle(_.`type`("plain_text").text("HelloLabor").emoji(true)))
        .submit(viewSubmit(_.`type`("plain_text").text("Submit").emoji(true)))
        .close(viewClose(_.`type`("plain_text").text("Close")))
        .blocks(asBlocks(input(_.blockId("memo")
          .element(plainTextInput(_.actionId("agenda-action").multiline(true)))
          .label(plainText("メモ")))))
    )
  }
}
