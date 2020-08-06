package ru.otus.counter.service.impl

import ru.otus.counter.dao.impl.CounterDAOImpl
import ru.otus.counter.model.CountCall
import ru.otus.counter.service.CounterService

class CounterServiceImpl(
  val dao: CounterDAOImpl
) extends CounterService {
  def getCount(): CountCall = {
    val newCount = dao.getCount.plus(1)
    dao.setCount(newCount)
  }
}
