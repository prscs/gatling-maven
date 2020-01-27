package uk.co.prscs.simulations

import uk.co.prscs.config.Config._
import uk.co.prscs.scenarios.UpdateUserScenario
import io.gatling.core.Predef._

class UpdateUserSimulation extends Simulation{

  private val updateUserExec = UpdateUserScenario.updateUserScenario
    .inject(atOnceUsers(users))

  setUp(updateUserExec)
}
