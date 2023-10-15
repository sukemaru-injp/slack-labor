package models.modal

import com.slack.api.RequestConfigurator
import com.slack.api.methods.request.views.ViewsOpenRequest
import com.slack.api.model.view.View

trait SlackModal {
  val triggerId: String
}

class ModalFactory(val triggerId: String)
  extends SlackModal {
  def create(view: View): RequestConfigurator[ViewsOpenRequest.ViewsOpenRequestBuilder] =
    (req) => req.triggerId(this.triggerId).view(view)
}
