package models.diary

import com.slack.api.bolt.request.builtin.ViewSubmissionRequest
import utils.slack.DiaryModalBlockId
object DiaryFactory {
  def create(req: ViewSubmissionRequest): Unit = {
    val stateMap = req.getPayload.getView.getState.getValues
    val memo = stateMap.get(DiaryModalBlockId.memo).values()
    val startDateTime = stateMap.get(DiaryModalBlockId.startDateTime).values()

    println("fireeeee", memo, startDateTime)
  }
  private def createMemo() = {}
  private def createStartDateTime() = {}
  private def createEndDateTime() = {}
}
