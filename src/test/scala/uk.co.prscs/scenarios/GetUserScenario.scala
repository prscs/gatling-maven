package uk.co.prscs.scenarios

import uk.co.prscs.requests.GetUserRequest
import io.gatling.core.Predef.scenario


object GetUserScenario {

  val getUserScenario = scenario("Get user Scenario")
    .exec(GetUserRequest.get_user)

}
