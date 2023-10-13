package models.diary

import com.slack.api.bolt.request.builtin.ViewSubmissionRequest
import utils.slack.DiaryModalBlockId
import com.slack.api.model.view.ViewState
import scala.jdk.CollectionConverters._
import models.Diary

class DiaryFactory {
  def create(req: ViewSubmissionRequest): Diary = {
    val stateMap = req.getPayload.getView.getState.getValues
    Diary(
      selectedDate =
        createArgs(stateMap.get(DiaryModalBlockId.selectDate).values().asScala,
                   DiaryModalBlockId.selectDate),
      startTime = createArgs(
        stateMap.get(DiaryModalBlockId.startDateTime).values().asScala,
        DiaryModalBlockId.startDateTime),
      endTime =
        createArgs(stateMap.get(DiaryModalBlockId.endDateTime).values().asScala,
                   DiaryModalBlockId.endDateTime),
      memo = createArgs(stateMap.get(DiaryModalBlockId.memo).values().asScala,
                        DiaryModalBlockId.memo)
    )
  }

  private def createArgs(input: Iterable[ViewState.Value],
                         target: String): String = {
    if (input.isEmpty) {
      throw new RuntimeException("not found input")
    }
    val obj = input.head
    target match {
      case DiaryModalBlockId.selectDate    => obj.getSelectedDate
      case DiaryModalBlockId.startDateTime => obj.getSelectedTime
      case DiaryModalBlockId.endDateTime   => obj.getSelectedTime
      case DiaryModalBlockId.memo          => obj.getValue
      case _                               => throw new RuntimeException("意図しないkeyが指定されています")
    }
  }
}
