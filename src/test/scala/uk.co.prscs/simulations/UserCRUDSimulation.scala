package uk.co.prscs.simulations

import uk.co.prscs.config.Config._
import uk.co.prscs.scenarios.{CreateUserScenario, DeleteUserScenario, GetUserScenario, UpdateUserScenario}
import io.gatling.core.Predef._

class UserCRUDSimulation extends Simulation{

  setUp(
    CreateUserScenario.createUserScenario.inject(atOnceUsers(users)),
    GetUserScenario.getUserScenario.inject(atOnceUsers(users)),
    UpdateUserScenario.updateUserScenario.inject(atOnceUsers(users)),
    DeleteUserScenario.deleteUserScenario.inject(atOnceUsers(users))
  )
}
