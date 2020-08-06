package ru.otus.counter.dao.impl

import ru.otus.counter.dao.CounterDAO
import ru.otus.counter.model.CountCall

class CounterDAOImpl extends CounterDAO {
  private var countCall: CountCall = CountCall()

  override def getCount: CountCall = countCall
  override def setCount(newCount: CountCall): CountCall = {
    countCall = newCount
    getCount
  }
}
