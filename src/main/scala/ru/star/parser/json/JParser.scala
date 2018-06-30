package ru.star.parser.json

import org.json4s._
import org.json4s.native.JsonMethods._

trait JParser {
  implicit val formats: DefaultFormats.type = DefaultFormats

  /**
    * Parses json string to case class.
    * In json _ expected between words.
    * In the case class camel case is used for fields naming.
    *
    * @param json input json
    * @tparam A parsed case class
    * @return parsed case class
    */
  def parseCamelCase[A: Manifest](json: String): A = {
    parse(json).camelizeKeys.extract[A]
  }
}
