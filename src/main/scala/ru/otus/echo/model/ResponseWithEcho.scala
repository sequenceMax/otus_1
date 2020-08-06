package ru.otus.echo.model

import ru.otus.base.models.Response

case class ResponseWithEcho(value: String) extends Response {
  override def toString: String = value
}
