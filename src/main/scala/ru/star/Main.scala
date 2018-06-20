package ru.star

import ru.star.http.WikiClient

object Main extends App {
  println("Start")

  val client = new WikiClient

  println(client.getCategory("Политика"))
  println("----------------------------")
  println(client.getArticle("701840"))

  println("end")
}
