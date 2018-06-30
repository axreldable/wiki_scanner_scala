package ru.star

import ru.star.Constants.WIKI_API_URL
import ru.star.http.WikiClient
import scalaj.http.Http

object Main extends App {
  println("Start")

  val client = new WikiClient(Http(WIKI_API_URL))

  println(client.getCategory("Политика"))
  println("----------------------------")
  println(client.getArticle("701840"))

  println("end")
}
