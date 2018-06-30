package ru.star.http

import scalaj.http._

class WikiClient(val httpRequest: HttpRequest) {

  /**
    * GET methods for getting categories from Wiki.
    *
    * @param name - name of the category
    * @return Wiki response in String
    */
  def getCategory(name: String): String = Option(httpRequest.params(Map(
    "action" -> "query",
    "format" -> "json",
    "list" -> "categorymembers",
    "cmprop" -> "title|type|ids",
    "cmlimit" -> "500",
    "cmtitle" -> s"Category:$name"
  )).asString.body).getOrElse("")

  /**
    * GET method for getting the article from Wiki.
    *
    * @param id - article's id
    * @return Wiki response in String
    */
  def getArticle(id: String): String = Option(httpRequest.params(Map(
    "action" -> "query",
    "format" -> "json",
    "prop" -> "extracts",
    "explaintext" -> "",
    "exsectionformat" -> "plain",
    "pageids" -> s"$id"
  )).asString.body).getOrElse("")
}
