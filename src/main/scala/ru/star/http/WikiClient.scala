package ru.star.http
import scalaj.http._
import ru.star.Constants.WIKI_API_URL

class WikiClient {
  def getCategory(name: String): String = {
    Option(Http(WIKI_API_URL).params(Map(
      "action" -> "query",
      "format" -> "json",
      "list" -> "categorymembers",
      "cmprop" -> "title|type|ids",
      "cmlimit" -> "500",
      "cmtitle" -> s"Category:$name"
    )).asString.body).getOrElse("")
  }

  def getArticle(id: String): String = {
    Option(Http(WIKI_API_URL).params(Map(
      "action" -> "query",
      "format" -> "json",
      "prop" -> "extracts",
      "explaintext" -> "",
      "exsectionformat" -> "plain",
      "pageids" -> s"$id"
    )).asString.body).getOrElse("")
  }
}
