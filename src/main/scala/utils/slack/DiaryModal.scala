package utils.slack

import com.slack.api.model.block.Blocks.{asBlocks, input}
import com.slack.api.model.block.composition.BlockCompositions.plainText
import com.slack.api.model.block.element.BlockElements.plainTextInput
import com.slack.api.model.view.View
import com.slack.api.model.view.Views.{view, viewClose, viewSubmit, viewTitle}
import routes.BlockActions

object DiaryModalBlocks {
  val memo = "memo"
}
class DiaryModal(val triggerId: String) extends SlackModal {
  def build(): View = {
    view(
      _.callbackId(CallbackIds.laborDiary)
        .`type`("modal")
        .notifyOnClose(true)
        .title(viewTitle(_.`type`("plain_text").text("HelloLabor").emoji(true)))
        .submit(viewSubmit(_.`type`("plain_text").text("Submit").emoji(true)))
        .close(viewClose(_.`type`("plain_text").text("Close")))
        .blocks(asBlocks(input(_.blockId(DiaryModalBlocks.memo)
          .element(plainTextInput(_.actionId(BlockActions.laborMemoActionId).multiline(true)))
          .label(plainText("メモ")))))
    )
  }
}
