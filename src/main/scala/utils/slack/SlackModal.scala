package utils.slack

import com.slack.api.RequestConfigurator
import com.slack.api.methods.request.views.ViewsOpenRequest
import com.slack.api.model.view.View

trait SlackModal {
  val triggerId: String
}

class SlackModalHelper(val triggerId: String, val view: View)
  extends SlackModal {
  def open: RequestConfigurator[ViewsOpenRequest.ViewsOpenRequestBuilder] =
    (req) => req.triggerId(this.triggerId).view(this.view)
}
