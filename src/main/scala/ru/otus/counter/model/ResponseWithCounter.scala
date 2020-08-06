package ru.otus.counter.model

import ru.otus.base.models.Response

case class ResponseWithCounter(counter: CountCall) extends Response {
  override def toString: String = counter.count.toString
}
