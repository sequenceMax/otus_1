package ru.otus.greet.model

import ru.otus.base.models.Request

case class GreetRequest(name: String, isHuman: Boolean = true) extends Request
