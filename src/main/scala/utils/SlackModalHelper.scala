package utils

import utils.SlackModal
import com.slack.api.RequestConfigurator
import com.slack.api.methods.request.views.ViewsOpenRequest
import com.slack.api.model.view.View

class SlackModalHelper(val triggerId: String, val view: View)
  extends SlackModal {
  val open: RequestConfigurator[ViewsOpenRequest.ViewsOpenRequestBuilder] =
    (req) => req.triggerId(this.triggerId).view(this.view)
}
