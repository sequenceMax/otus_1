package ru.otus.greet.service

import ru.otus.base.service.BaseService
import ru.otus.greet.model.{GreetRequest, GreetResponse}

trait GreetingService extends BaseService{
  def greet(request: GreetRequest): GreetResponse
}
