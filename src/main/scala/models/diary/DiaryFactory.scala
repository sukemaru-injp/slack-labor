package models.diary

import com.slack.api.bolt.request.builtin.ViewSubmissionRequest

object DiaryFactory {
  def create(req: ViewSubmissionRequest): Unit = {
    val stateValues = req.getPayload.getView.getState.getValues
    println("fireeeee", stateValues)
  }
}
