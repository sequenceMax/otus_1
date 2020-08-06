package ru.otus.greet.service.impl

import ru.otus.greet.dao.GreetingDao
import ru.otus.greet.model.{GreetRequest, GreetResponse}
import ru.otus.greet.service.GreetingService

class GreetingServiceImpl(val dao: GreetingDao) extends GreetingService {
  def greet(request: GreetRequest): GreetResponse =
    if (request.isHuman)
      GreetResponse(s"${dao.greetingPrefix} ${request.name} ${dao.greetingPostfix}")
    else GreetResponse("AAAAAAAAAA!!!!!!")
}
