package uk.co.prscs.simulations

import uk.co.prscs.scenarios.GetUserScenario
import io.gatling.core.Predef._
import io.gatling.core.Predef.Simulation
import uk.co.prscs.config.Config._

class GetUserSimulation extends Simulation {

  private val getUserExec = GetUserScenario.getUserScenario
    .inject(atOnceUsers(users))

  setUp(getUserExec)

}
