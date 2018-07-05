package ru.star.config

import org.scalatest.{FlatSpec, Matchers}

class ConfigWorkerTest extends FlatSpec with Matchers {
  behavior of "ConfigWorker"

  it should "validate correct config without Exceptions" in {
    noException shouldBe thrownBy(new ConfigWorker(getClass.getResource("/app_config_correct.json").getFile))
  }
}
