package ru.star.config

import ru.star.parser.json.JParser

import scala.io.Source

class ConfigWorker(private val configPath: String) extends JParser {
  private val configJson = Source.fromFile(configPath).getLines().mkString
  val config: ConfigModel = parseCamelCase[ConfigModel](configJson)
}
