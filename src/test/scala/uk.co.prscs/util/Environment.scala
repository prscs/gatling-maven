package uk.co.prscs.util

import com.typesafe.config.{Config, ConfigFactory}


object Environment {

  val environment: String = System.getProperty("env")
  private val config: Config = ConfigFactory.load(s"$environment.application.properties")
  lazy val apiURL: String = config.getString("api.url")

}
