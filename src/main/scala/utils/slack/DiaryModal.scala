package utils.slack

import com.slack.api.model.block.Blocks.{asBlocks, input}
import com.slack.api.model.block.composition.BlockCompositions.plainText
import com.slack.api.model.block.element.BlockElements.{
  plainTextInput,
  timePicker,
  datePicker
}
import com.slack.api.model.view.View
import com.slack.api.model.view.Views.{view, viewClose, viewSubmit, viewTitle}
import routes.BlockActions

object DiaryModalBlockId {
  val selectDate = "select_date"
  val startDateTime = "start_datetime"
  val endDateTime = "end_datetime"
  val memo = "memo"
}
trait IDiaryModal {
  val triggerId: String
}
class DiaryModal(val triggerId: String) extends IDiaryModal {
  def build(): View = {
    view(
      _.callbackId(CallbackIds.laborDiary)
        .`type`("modal")
        .notifyOnClose(true)
        .title(viewTitle(_.`type`("plain_text").text("労働記録:dog:").emoji(true)))
        .submit(viewSubmit(_.`type`("plain_text").text("Submit").emoji(true)))
        .close(viewClose(_.`type`("plain_text").text("Close")))
        .blocks(asBlocks(
          input(
            _.blockId(DiaryModalBlockId.selectDate)
              .element(datePicker(_.actionId(BlockActions.laborSelectDate)))
              .label(plainText("日付"))),
          input(
            _.blockId(DiaryModalBlockId.startDateTime)
              .element(timePicker(_.actionId(BlockActions.laborStartDateTime)
                .placeholder(plainText("開始時刻を入力"))))
              .label(plainText("開始時間"))),
          input(
            _.blockId(DiaryModalBlockId.endDateTime)
              .element(timePicker(_.actionId(BlockActions.laborEndDateTime)
                .placeholder(plainText("終了時刻を入力"))))
              .label(plainText("終了時間"))),
          input(
            _.blockId(DiaryModalBlockId.memo)
              .element(plainTextInput(
                _.actionId(BlockActions.laborMemoActionId).multiline(true)))
              .label(plainText("メモ")))
        ))
    )
  }
}
