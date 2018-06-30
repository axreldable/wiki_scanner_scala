package ru.star.config

import ru.star.parser.json.JParser

import scala.io.Source

class ConfigWorker(private val configPath: String) extends JParser {
  private val configJson = Source.fromFile(configPath).getLines().mkString
  private val config = parseCamelCase[ConfigModel](configJson)
  println(configJson)
  println(config)
}
