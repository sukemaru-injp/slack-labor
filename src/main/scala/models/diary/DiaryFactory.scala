package models.diary

import com.slack.api.bolt.request.builtin.ViewSubmissionRequest
import utils.slack.DiaryModalBlockId
import com.slack.api.model.view.ViewState
import scala.jdk.CollectionConverters._
import java.util.Collection
import scala.collection.Iterable

class DiaryFactory {
  def create(req: ViewSubmissionRequest): Unit = {
    val stateMap = req.getPayload.getView.getState.getValues
    val memo = stateMap.get(DiaryModalBlockId.memo).values()
    val selectedDate = stateMap.get(DiaryModalBlockId.selectDate).values().asScala
    val startDateTime = stateMap.get(DiaryModalBlockId.startDateTime).values()

    createSelectedDate(selectedDate)
  }
  private def createMemo() = {}

  private def createSelectedDate(input: Iterable[ViewState.Value]): Unit = {
    if (input.isEmpty) {
      throw new RuntimeException("required selected date")
    }

    val state = input.head
    println("CreateDate", state)
  }

  private def createStartDateTime(input: Iterable[ViewState.Value]) = {}
  private def createEndDateTime(input: Iterable[ViewState.Value]) = {}
}
